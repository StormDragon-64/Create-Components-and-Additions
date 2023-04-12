package net.stormdragon_64.item;
import com.simibubi.create.content.contraptions.itemAssembly.SequencedAssemblyItem;
import com.simibubi.create.foundation.data.AssetLookup;
import com.tterrag.registrate.util.entry.ItemEntry;

import static net.stormdragon_64.create_plus.CreatePlus.REGISTRATE;

public class ModItems {

    //The items
    public static final ItemEntry<SequencedAssemblyItem> INCOMPLETE_COGWHEEL = REGISTRATE
            .item("incomplete_cogwheel", SequencedAssemblyItem::new)
            .register();

    public static final ItemEntry<CustomVerticalGearboxItem> VERTICAL_BRASS_GEARBOX = REGISTRATE
                    .item("vertical_brass_gearbox", CustomVerticalGearboxItem::new)
                    .model(AssetLookup.customBlockItemModel("brass_gearbox", "item_vertical"))
                    .register();

    //Register method - important, don't touch!
    public static void register() {}

    }
