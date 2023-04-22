package net.stormdragon_64.block;

import com.simibubi.create.content.contraptions.base.KineticTileEntity;
import com.simibubi.create.content.contraptions.relays.encased.EncasedBeltBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class CustomChainDriveBlock extends EncasedBeltBlock {
    public CustomChainDriveBlock(Properties properties) {
        super(properties);
    }


    @Override
    public BlockEntityType<? extends KineticTileEntity> getTileEntityType() {
        return ModTileEntities.CUSTOM_CHAIN_DRIVE.get();
    }

}
