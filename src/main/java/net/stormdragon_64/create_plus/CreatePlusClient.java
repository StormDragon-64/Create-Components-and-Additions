package net.stormdragon_64.create_plus;


import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.stormdragon_64.ponder.PonderAssigner;

public class CreatePlusClient {


    public CreatePlusClient() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.register(this);
    }

    @SubscribeEvent
    public void setup(final FMLClientSetupEvent event) {
        PonderAssigner.register();
        PonderAssigner.registerTags();
    }
}
