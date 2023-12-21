package net.stormdragon_64.create_ca.events;

import com.simibubi.create.foundation.ModFilePackResources;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forgespi.language.IModFileInfo;
import net.minecraftforge.forgespi.locating.IModFile;
import net.stormdragon_64.create_ca.CreateCA;

@Mod.EventBusSubscriber(modid = CreateCA.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {

    @SubscribeEvent
    public static void addPackFinders(AddPackFindersEvent event) {
        if (event.getPackType() == PackType.CLIENT_RESOURCES /*&& ClientConfigs.BuiltInResourcePack.get()*/) {
            IModFileInfo modFileInfo = ModList.get().getModFileById(CreateCA.MOD_ID);
            if (modFileInfo == null) {
                CreateCA.LOGGER.error("Error loading Built-in resourcepack");
                return;
            }

            IModFile modFile = modFileInfo.getFile();
            event.addRepositorySource((consumer, constructor) -> consumer.accept(Pack.create(CreateCA.asResource("test_pack").toString(), false, () -> new ModFilePackResources("Test Pack", modFile, "resourcepacks/test_pack"), constructor, Pack.Position.TOP, PackSource.DEFAULT)));
        }
    }
}
