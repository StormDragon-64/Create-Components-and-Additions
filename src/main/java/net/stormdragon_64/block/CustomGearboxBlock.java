package net.stormdragon_64.block;

import com.simibubi.create.content.contraptions.relays.gearbox.GearboxBlock;
import com.simibubi.create.content.contraptions.relays.gearbox.GearboxTileEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class CustomGearboxBlock extends GearboxBlock {
    public CustomGearboxBlock(Properties properties) {
        super(properties);
    }
@Override
public BlockEntityType<? extends GearboxTileEntity> getTileEntityType() {
    return ModTileEntities.CUSTOM_GEARBOX.get();
}
    }
