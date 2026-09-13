package net.sshmoob.create_ca.content.variants;

import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.content.kinetics.chainDrive.ChainDriveBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.sshmoob.create_ca.ModBlockEntities;


public class BrassChainDriveBlock extends ChainDriveBlock {
    public BrassChainDriveBlock(Properties properties) {
        super(properties);
    }


    @Override
    public BlockEntityType<? extends KineticBlockEntity> getBlockEntityType() {
        return ModBlockEntities.BRASS_CHAIN_DRIVE.get();
    }

}
