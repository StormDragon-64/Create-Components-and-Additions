package net.sudopos.create_ca.util;

import com.tterrag.registrate.providers.ProviderType;
import net.createmod.ponder.foundation.PonderIndex;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.sudopos.create_ca.CreateCA;
import net.sudopos.create_ca.ponder.CreateCAPonderPlugin;

import java.util.function.BiConsumer;

import static net.sudopos.create_ca.CreateCA.REGISTRATE;

public class LangDatagen {
    public static void onGatherDataEvent(GatherDataEvent event) {
        if (event.getMods().contains(CreateCA.MOD_ID)) {
            REGISTRATE.addDataGenerator(ProviderType.LANG, prov -> ponderLangProvider(prov::add));
            addCustomLangEntries();
        }
    }
    private static void ponderLangProvider(BiConsumer<String, String> consumer) {
        PonderIndex.addPlugin(new CreateCAPonderPlugin());
        PonderIndex.getLangAccess().provideLang(CreateCA.MOD_ID, consumer);
    }

    public static void addCustomLangEntries() {
        REGISTRATE.addRawLang("itemGroup.create_ca", "Create: Components and Additions");
    }
}
