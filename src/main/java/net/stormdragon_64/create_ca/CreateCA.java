package net.stormdragon_64.create_ca;

import com.mojang.logging.LogUtils;
import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.stormdragon_64.create_ca.block.ModBlocks;
import net.stormdragon_64.create_ca.block_entity.ModBlockEntities;
import net.stormdragon_64.create_ca.config.ClientConfigs;
import net.stormdragon_64.create_ca.item.ModItems;
import org.slf4j.Logger;

@Mod(CreateCA.MOD_ID)
public class CreateCA {
    public static final String MOD_ID = "create_ca";
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MOD_ID);
    public static final Logger LOGGER = LogUtils.getLogger();

    public CreateCA() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ClientConfigs.SPEC, "createplus-client.toml");
    //forge stuff
        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> CreateCAClient::new);
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::commonSetup);
    //registrate stuff
        REGISTRATE.registerEventListeners(modEventBus);
        ModItems.register();
        ModBlocks.register();
        ModBlockEntities.register();

    }

    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
    private void commonSetup(final FMLCommonSetupEvent event) {}
}
