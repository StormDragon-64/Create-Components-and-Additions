package net.sshmoob.create_ca;
import com.simibubi.create.foundation.data.AssetLookup;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.sshmoob.create_ca.content.brass_gearbox.BrassVerticalGearboxItem;

import static net.sshmoob.create_ca.CreateCA.REGISTRATE;

public class ModItems {

    public static final ItemEntry<BrassVerticalGearboxItem> VERTICAL_BRASS_GEARBOX = REGISTRATE
                    .item("vertical_brass_gearbox", BrassVerticalGearboxItem::new)
                    .model(AssetLookup.customBlockItemModel("brass_gearbox", "item_vertical"))
                    .register();

    public static void register() {}
    }
