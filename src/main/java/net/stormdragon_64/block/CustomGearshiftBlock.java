package net.stormdragon_64.block;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.contraptions.relays.encased.GearshiftBlock;
import com.simibubi.create.content.contraptions.relays.encased.SplitShaftTileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.stormdragon_64.block.tile_entity.ModTileEntities;

public class CustomGearshiftBlock extends GearshiftBlock  {
    public CustomGearshiftBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos blockPos,
                                 Player player, InteractionHand hand, BlockHitResult result) {
        ItemStack item = player.getMainHandItem();
        if (item.getItem() == Items.REDSTONE_TORCH) {
            if (!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
                level.setBlockAndUpdate(blockPos, AllBlocks.GEARSHIFT
                        .getDefaultState()
                        .setValue(POWERED, !state.getValue(POWERED))
                        .setValue(AXIS, state.getValue(AXIS)));
                return InteractionResult.SUCCESS;

            } else {return InteractionResult.CONSUME_PARTIAL;}
        } else {return InteractionResult.FAIL;}
    }
    //Self explanatory, makes sure that it isn't powered by default
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
    //makes gearshift inverted; Changes the if to be == instead of !=
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


//Tile entity does have changed code, not just allowing use for this block
    public BlockEntityType<? extends SplitShaftTileEntity> getTileEntityType() {
        return ModTileEntities.CUSTOM_GEARSHIFT.get();
    }



}
