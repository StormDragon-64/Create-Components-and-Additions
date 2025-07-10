package net.stormdragon_64.create_ca;


import net.createmod.ponder.foundation.PonderIndex;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.stormdragon_64.create_ca.ponder.CreateCAPonderPlugin;

public class CreateCAClient {


    public CreateCAClient() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.register(this);
    }

    @SubscribeEvent
    public void setup(final FMLClientSetupEvent event) {
        PonderIndex.addPlugin(new CreateCAPonderPlugin());
    }
}
