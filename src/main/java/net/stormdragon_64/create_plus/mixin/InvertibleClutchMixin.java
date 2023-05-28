package net.stormdragon_64.create_plus.mixin;


import com.simibubi.create.content.kinetics.transmission.ClutchBlock;
import com.simibubi.create.content.kinetics.transmission.GearshiftBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.stormdragon_64.create_plus.block.ModBlocks;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ClutchBlock.class)
public class InvertibleClutchMixin extends GearshiftBlock {

    public InvertibleClutchMixin(Properties properties) {
        super(properties);
    }

    //I know it would be better to swap the item check and serverside/mainhand check, but I'm too lazy and this already works.
    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos blockPos,
                                 Player player, InteractionHand hand, BlockHitResult result) {
        ItemStack item = player.getMainHandItem();
        if (item.getItem() == Items.REDSTONE_TORCH) {
            if (!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
                level.setBlockAndUpdate(blockPos, ModBlocks.INVERTED_CLUTCH
                        .getDefaultState()
                        .setValue(POWERED, !state.getValue(POWERED))
                        .setValue(AXIS, state.getValue(AXIS)));
                return InteractionResult.SUCCESS;

            } else {return InteractionResult.CONSUME_PARTIAL;}
        } else {return InteractionResult.FAIL;}
    }

}
