package net.stormdragon_64.item;

import com.simibubi.create.content.contraptions.relays.gearbox.VerticalGearboxItem;
import net.stormdragon_64.block.ModBlocks;

public class CustomVerticalGearboxItem extends VerticalGearboxItem {

    public CustomVerticalGearboxItem(Properties builder) {
        super(builder);
        ModBlocks.BRASS_GEARBOX.get();
    }
    @Override
    public String getDescriptionId() {
        return "item.create_plus.vertical_brass_gearbox";
    }
}
