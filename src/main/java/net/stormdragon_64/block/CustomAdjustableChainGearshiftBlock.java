package net.stormdragon_64.block;

import com.simibubi.create.content.contraptions.base.KineticTileEntity;
import com.simibubi.create.content.contraptions.relays.encased.AdjustablePulleyBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.stormdragon_64.block.tile_entity.ModTileEntities;

public class CustomAdjustableChainGearshiftBlock extends AdjustablePulleyBlock  {
    public CustomAdjustableChainGearshiftBlock(Properties properties) {
        super(properties);
    }
    @Override
    public BlockEntityType<? extends KineticTileEntity> getTileEntityType() {
        return ModTileEntities.CUSTOM_ADJUSTABLE_PULLEY.get();
    }
}
