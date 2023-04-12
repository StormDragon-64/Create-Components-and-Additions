package net.stormdragon_64.block;

import com.simibubi.create.content.contraptions.base.KineticTileEntity;
import com.simibubi.create.content.contraptions.relays.encased.EncasedBeltBlock;
import com.simibubi.create.foundation.utility.Iterate;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class CustomChainDriveBlock extends EncasedBeltBlock {
    public CustomChainDriveBlock(Properties properties) {
        super(properties);
    }


    @Override
    public BlockEntityType<? extends KineticTileEntity> getTileEntityType() {
        return ModTileEntities.CUSTOM_CHAIN_DRIVE.get();
    }

}
