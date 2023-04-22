package net.stormdragon_64.block;

import com.simibubi.create.content.contraptions.relays.encased.GearshiftBlock;
import com.simibubi.create.content.contraptions.relays.encased.SplitShaftTileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class CustomGearshiftBlock extends GearshiftBlock  {
    public CustomGearshiftBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        if (context.getLevel().hasNeighborSignal(context.getClickedPos())) {
            return super.getStateForPlacement(context)
                    .setValue(POWERED, false);
        } else {
            return super.getStateForPlacement(context)
                    .setValue(POWERED, true);
        }
    }


    @Override
    public void neighborChanged(BlockState state, Level worldIn, BlockPos pos, Block blockIn, BlockPos fromPos,
                                boolean isMoving) {
        if (worldIn.isClientSide)
            return;

        boolean previouslyPowered = state.getValue(POWERED);
        if (previouslyPowered == worldIn.hasNeighborSignal(pos)) {
            detachKinetics(worldIn, pos, true);
            worldIn.setBlock(pos, state.cycle(POWERED), 2);
        }
    }

    public BlockEntityType<? extends SplitShaftTileEntity> getTileEntityType() {
        return ModTileEntities.CUSTOM_GEARSHIFT.get();
    }

}
