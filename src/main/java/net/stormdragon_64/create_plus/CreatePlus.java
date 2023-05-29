package net.stormdragon_64.create_plus;

import com.mojang.logging.LogUtils;
import com.tterrag.registrate.Registrate;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.stormdragon_64.create_plus.block.ModBlocks;
import net.stormdragon_64.create_plus.block_entity.ModBlockEntities;
import net.stormdragon_64.create_plus.item.ModItems;
import org.slf4j.Logger;

@Mod(CreatePlus.MOD_ID)
public class CreatePlus {
    public static final String MOD_ID = "create_plus";
    public static final Registrate REGISTRATE = Registrate.create(MOD_ID);

    public CreatePlus() {
//forge stuff
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::commonSetup);

        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> CreatePlusClient::new);
//registrate stuff
        ModItems.register();
        ModBlocks.register();
        ModBlockEntities.register();
    }

    private void commonSetup(final FMLCommonSetupEvent event) {}

}