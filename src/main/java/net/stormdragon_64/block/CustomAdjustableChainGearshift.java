package net.stormdragon_64.block;

import com.simibubi.create.content.contraptions.base.KineticTileEntity;
import com.simibubi.create.content.contraptions.relays.encased.AdjustablePulleyBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class CustomAdjustableChainGearshift extends AdjustablePulleyBlock  {
    public CustomAdjustableChainGearshift(Properties properties) {
        super(properties);
    }
    @Override
    public BlockEntityType<? extends KineticTileEntity> getTileEntityType() {
        return ModTileEntities.CUSTOM_ADJUSTABLE_PULLEY.get();
    }
}
