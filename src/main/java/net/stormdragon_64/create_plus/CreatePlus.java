package net.stormdragon_64.create_plus;

import com.mojang.logging.LogUtils;
import com.tterrag.registrate.Registrate;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.stormdragon_64.block.ModTileEntities;
import net.stormdragon_64.block.ModBlocks;
import net.stormdragon_64.item.ModItems;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CreatePlus.MOD_ID)
public class CreatePlus {
    public static final String MOD_ID = "create_plus";
    public static final Registrate REGISTRATE = Registrate.create(MOD_ID);

    private static final Logger LOGGER = LogUtils.getLogger();

    public CreatePlus() {
//forge stuff
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::commonSetup);
//registrate stuff; Probably more here in the future
        ModItems.register();
        ModBlocks.register();
        ModTileEntities.register();
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }
}