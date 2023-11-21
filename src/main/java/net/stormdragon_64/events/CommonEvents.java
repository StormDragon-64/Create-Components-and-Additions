package net.stormdragon_64.events;

import com.simibubi.create.foundation.ModFilePackResources;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.forgespi.language.IModFileInfo;
import net.minecraftforge.forgespi.locating.IModFile;
import net.stormdragon_64.create_plus.CreatePlus;
import net.stormdragon_64.create_plus.config.CreatePlusClientConfigs;

public class CommonEvents {
    //attempt at having a built-in resource pack

    @SubscribeEvent
    public static void addPackFinders(AddPackFindersEvent event) {
        if (event.getPackType() == PackType.CLIENT_RESOURCES) {
            IModFileInfo modFileInfo = ModList.get().getModFileById(CreatePlus.MOD_ID);
            if (modFileInfo == null) {
                CreatePlus.LOGGER.error("Unable to load built-in resource pack for Create: Components and Additions.");
                return;
            }
            IModFile modFile = modFileInfo.getFile();
            event.addRepositorySource((consumer, constructor) -> {
                consumer.accept(Pack.create(CreatePlus.asResource("twockx_tall_remix").toString(), false, () -> new ModFilePackResources("Replace Endermosh", modFile, "resourcepacks/twockx_tall_remix"), constructor, Pack.Position.TOP, PackSource.DEFAULT));
            });
        }
    }
}
