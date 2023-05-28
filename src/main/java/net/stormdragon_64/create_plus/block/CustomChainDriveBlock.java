package net.stormdragon_64.create_plus.block;

import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.content.kinetics.chainDrive.ChainDriveBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.stormdragon_64.create_plus.block_entity.ModBlockEntities;


public class CustomChainDriveBlock extends ChainDriveBlock {
    public CustomChainDriveBlock(Properties properties) {
        super(properties);
    }


    @Override
    public BlockEntityType<? extends KineticBlockEntity> getBlockEntityType() {
        return ModBlockEntities.CUSTOM_CHAIN_DRIVE.get();
    }

}
