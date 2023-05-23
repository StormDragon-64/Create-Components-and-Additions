package net.stormdragon_64.block;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.contraptions.relays.encased.SplitShaftTileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.stormdragon_64.tile_entity.ModTileEntities;

public class CustomClutchBlock extends CustomGearshiftBlock {
    public CustomClutchBlock(Properties properties) {
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
    public BlockEntityType<? extends SplitShaftTileEntity> getTileEntityType() {
        return ModTileEntities.CUSTOM_CLUTCH.get();
    }

}