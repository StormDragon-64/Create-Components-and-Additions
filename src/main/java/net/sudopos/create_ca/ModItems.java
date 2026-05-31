package net.sudopos.create_ca;
import com.simibubi.create.foundation.data.AssetLookup;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.sudopos.create_ca.features.brass_gearbox.BrassVerticalGearboxItem;

import static net.sudopos.create_ca.CreateCA.REGISTRATE;

public class ModItems {

    public static final ItemEntry<BrassVerticalGearboxItem> VERTICAL_BRASS_GEARBOX = REGISTRATE
                    .item("vertical_brass_gearbox", BrassVerticalGearboxItem::new)
                    .model(AssetLookup.customBlockItemModel("brass_gearbox", "item_vertical"))
                    .register();

    public static void register() {}
    }
