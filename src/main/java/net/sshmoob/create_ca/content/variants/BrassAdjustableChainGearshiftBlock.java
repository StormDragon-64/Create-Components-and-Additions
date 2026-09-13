package net.sshmoob.create_ca.content.variants;

import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.content.kinetics.chainDrive.ChainGearshiftBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.sshmoob.create_ca.ModBlockEntities;

public class BrassAdjustableChainGearshiftBlock extends ChainGearshiftBlock {
    public BrassAdjustableChainGearshiftBlock(Properties properties) {
        super(properties);
    }
    @Override
    public BlockEntityType<? extends KineticBlockEntity> getBlockEntityType() {
        return ModBlockEntities.BRASS_ADJUSTABLE_CHAIN_GEARSHIFT.get();
    }
}
