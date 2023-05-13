package net.stormdragon_64.block;

public class CustomClutchBlock extends CustomGearshiftBlock {
    public CustomClutchBlock(Properties properties) {
        super(properties);
    }

    /* Disabled for Mixins
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
    } */

}