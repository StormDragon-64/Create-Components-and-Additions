package net.stormdragon_64.item;
import com.simibubi.create.content.contraptions.itemAssembly.SequencedAssemblyItem;
import com.tterrag.registrate.util.entry.ItemEntry;

import static net.stormdragon_64.create_plus.CreatePlus.REGISTRATE;

public class ModItems {
    //stuff to actually register the items
    public static final ItemEntry<SequencedAssemblyItem>
            INCOMPLETE_COGWHEEL = REGISTRATE.item("incomplete_cogwheel", SequencedAssemblyItem::new)
            .register();

    public static void register() {}

    }
