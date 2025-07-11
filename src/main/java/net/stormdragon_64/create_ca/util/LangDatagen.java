package net.stormdragon_64.create_ca.util;

import com.tterrag.registrate.providers.ProviderType;
import net.createmod.ponder.foundation.PonderIndex;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.stormdragon_64.create_ca.CreateCA;
import net.stormdragon_64.create_ca.ponder.CreateCAPonderPlugin;

import java.util.function.BiConsumer;

import static net.stormdragon_64.create_ca.CreateCA.REGISTRATE;

@Mod.EventBusSubscriber(modid = CreateCA.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class LangDatagen {
    @SubscribeEvent
    public static void onGatherDataEvent(GatherDataEvent evt) {
        REGISTRATE.addDataGenerator(ProviderType.LANG, prov -> {
            ponderLangProvider(prov::add);
        });

        addCustomLangEntries();
    }
    private static void ponderLangProvider(BiConsumer<String, String> cons) {
        PonderIndex.addPlugin(new CreateCAPonderPlugin());
        PonderIndex.getLangAccess().provideLang(CreateCA.MOD_ID, cons);
    }

    public static void addCustomLangEntries() {
        REGISTRATE.addRawLang("itemGroup.create_ca", "Create: Components and Additions");
    }
}
