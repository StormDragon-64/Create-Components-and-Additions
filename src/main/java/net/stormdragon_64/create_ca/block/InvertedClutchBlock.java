package net.stormdragon_64.create_ca.block;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.kinetics.transmission.SplitShaftBlockEntity;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.stormdragon_64.create_ca.block_entity.ModBlockEntities;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class InvertedClutchBlock extends InvertedGearshiftBlock {
    public InvertedClutchBlock(Properties properties) {
        super(properties);
    }

@Override
    public InteractionResult use(BlockState state, Level level, BlockPos blockPos,
                                 Player player, InteractionHand hand, BlockHitResult result) {
    ItemStack item = player.getMainHandItem();
    if (item.getItem() == Items.REDSTONE_TORCH) {
        if (!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            level.setBlockAndUpdate(blockPos, AllBlocks.CLUTCH
                    .getDefaultState()
                    .setValue(POWERED, !state.getValue(POWERED))
                    .setValue(AXIS, state.getValue(AXIS)));
            return InteractionResult.SUCCESS;

        } else {return InteractionResult.CONSUME_PARTIAL;}
    } else {return InteractionResult.FAIL;}
}

    @Override
    public void neighborChanged(BlockState state, Level worldIn, BlockPos pos, Block blockIn, BlockPos fromPos,
                                boolean isMoving) {
        if (worldIn.isClientSide)
            return;

        boolean previouslyPowered = state.getValue(POWERED);
        if (previouslyPowered == worldIn.hasNeighborSignal(pos)) {
            worldIn.setBlock(pos, state.cycle(POWERED), 2 | 16);
            detachKinetics(worldIn, pos, previouslyPowered);
        }
    }

    @Override
    public BlockEntityType<? extends SplitShaftBlockEntity> getBlockEntityType() {
        return ModBlockEntities.INVERTED_CLUTCH.get();
    }
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        if (Screen.hasShiftDown()) {
            pTooltip.add(Component.literal("While a normal clutch prevents rotational transfer when it's powered with redstone, an Inverted Clutch does so when it's unpowered, and acts like a shaft when it is powered.").withStyle(ChatFormatting.YELLOW));
            //prevent gearshift tooltip from showing
        } //no default line because it's already there from inverted gearshift.

        super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
        pTooltip.remove(Component.literal("The Inverted Gearshift does exactly what you think. Instead of changing the direction of rotation when powered with redstone like a normal gearshift, it does so when it's unpowered, and acts like a shaft when it is powered.").withStyle(ChatFormatting.YELLOW));
    }

}