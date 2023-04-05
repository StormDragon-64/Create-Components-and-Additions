package net.stormdragon_64.item;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;
import static net.stormdragon_64.create_plus.CreatePlus.REGISTRATE;

public class ModItems {
    //stuff to actually register the items
    public static ItemEntry<Item> INCOMPLETE_COGWHEEL = REGISTRATE
            .item("incomplete_cogwheel", Item::new)
            .register();

    public static void register() {}

    }
