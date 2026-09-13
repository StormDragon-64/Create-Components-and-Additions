package net.sshmoob.create_ca;

import com.mojang.logging.LogUtils;
import com.simibubi.create.foundation.data.CreateRegistrate;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.sshmoob.create_ca.util.LangDatagen;
import org.slf4j.Logger;


@Mod(CreateCA.MOD_ID)
public class CreateCA {
    public static final String MOD_ID = "create_ca";
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MOD_ID);
    public static final Logger LOGGER = LogUtils.getLogger();

    public CreateCA(IEventBus modEventBus) {
      //register with registrate
        REGISTRATE.registerEventListeners(modEventBus);
        ModItems.register();
        ModBlocks.register();
        ModBlockEntities.register();
        ModCreativeTab.register(modEventBus);

        //Datagen ponder Lang entries
        modEventBus.addListener(EventPriority.HIGHEST, LangDatagen::onGatherDataEvent);
    }

    public static ResourceLocation asResource(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

}
