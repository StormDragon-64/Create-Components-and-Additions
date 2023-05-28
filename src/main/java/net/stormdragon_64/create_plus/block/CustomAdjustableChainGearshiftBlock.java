package net.stormdragon_64.create_plus.block;

import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.content.kinetics.chainDrive.ChainGearshiftBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.stormdragon_64.create_plus.block_entity.ModBlockEntities;

public class CustomAdjustableChainGearshiftBlock extends ChainGearshiftBlock {
    public CustomAdjustableChainGearshiftBlock(Properties properties) {
        super(properties);
    }
    @Override
    public BlockEntityType<? extends KineticBlockEntity> getBlockEntityType() {
        return ModBlockEntities.CUSTOM_ADJUSTABLE_CHAIN_GEARSHIFT.get();
    }
}
