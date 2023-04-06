package net.stormdragon_64.item;
import com.simibubi.create.content.contraptions.relays.gearbox.VerticalGearboxItem;

public class CustomVerticalGearboxItem extends VerticalGearboxItem {
    public CustomVerticalGearboxItem(Properties builder) {
        super(builder);
    }

    @Override
    public String getDescriptionId() {
        return "item.create_plus.vertical_brass_gearbox";
    }

}
