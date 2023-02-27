package net.stormdragon_64.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.stormdragon_64.create_plus.CreatePlus;

public class ModItems {
    //stuff to actually register the items
    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, CreatePlus.MOD_ID);

    //Actual Items go below here
    public static final RegistryObject<Item> INCOMPLETE_COGWHEEL =
            ITEMS.register("incomplete_cogwheel",
                    () -> new Item(new Item.Properties()));


    //more stuff to register the items
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
