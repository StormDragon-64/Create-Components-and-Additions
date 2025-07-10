package net.stormdragon_64.create_ca;
import com.simibubi.create.content.processing.sequenced.SequencedAssemblyItem;
import com.simibubi.create.foundation.data.AssetLookup;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.stormdragon_64.create_ca.features.brass_gearbox.BrassVerticalGearboxItem;

import static net.stormdragon_64.create_ca.CreateCA.REGISTRATE;

public class ModItems {

    public static final ItemEntry<SequencedAssemblyItem> INCOMPLETE_COGWHEEL = REGISTRATE
            .item("incomplete_cogwheel", SequencedAssemblyItem::new)
            .model(AssetLookup.existingItemModel())
            .register();

    public static final ItemEntry<BrassVerticalGearboxItem> VERTICAL_BRASS_GEARBOX = REGISTRATE
                    .item("vertical_brass_gearbox", BrassVerticalGearboxItem::new)
                    .model(AssetLookup.customBlockItemModel("brass_gearbox", "item_vertical"))
                    .register();

    public static void register() {}
    }
