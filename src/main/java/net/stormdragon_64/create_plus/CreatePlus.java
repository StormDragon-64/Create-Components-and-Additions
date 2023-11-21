package net.stormdragon_64.create_plus;

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
import net.stormdragon_64.create_plus.block.ModBlocks;
import net.stormdragon_64.create_plus.block_entity.ModBlockEntities;
import net.stormdragon_64.create_plus.config.CreatePlusClientConfigs;
import net.stormdragon_64.create_plus.item.ModItems;
import org.slf4j.Logger;

@Mod(CreatePlus.MOD_ID)
public class CreatePlus {
    public static final String MOD_ID = "create_plus";
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MOD_ID);
    public static final Logger LOGGER = LogUtils.getLogger();

    public CreatePlus() {
//forge stuff
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::commonSetup);

        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> CreatePlusClient::new);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, CreatePlusClientConfigs.SPEC, "createplus-client.toml");

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