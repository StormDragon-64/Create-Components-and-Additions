package net.sudopos.create_ca;


import net.createmod.ponder.foundation.PonderIndex;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.sudopos.create_ca.ponder.CreateCAPonderPlugin;

@Mod(value = CreateCA.MOD_ID, dist = Dist.CLIENT)
public class CreateCAClient {

    public CreateCAClient(IEventBus modEventBus) {
        modEventBus.addListener(CreateCAClient::setup);
    }

    public static void setup(final FMLClientSetupEvent event) {
        PonderIndex.addPlugin(new CreateCAPonderPlugin());
    }
}
