package net.stormdragon_64.create_ca;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static com.simibubi.create.AllCreativeModeTabs.PALETTES_CREATIVE_TAB;
import static net.minecraft.network.chat.Component.translatable;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeTab {

    private static final DeferredRegister<CreativeModeTab> REGISTER =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateCA.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CREATIVE_MODE_TAB = REGISTER.register("create_ca",
            () -> CreativeModeTab.builder()
                    .title(translatable("itemGroup.create_ca"))
                    .withTabsBefore(PALETTES_CREATIVE_TAB.getKey())
                    .icon(ModBlocks.BRASS_GEARBOX::asStack)
                    .displayItems((params, output) -> {
                        output.accept(ModBlocks.BRASS_BASIN);
                        output.accept(ModBlocks.BRASS_GEARBOX);
                        output.accept(ModItems.VERTICAL_BRASS_GEARBOX);
                        output.accept(ModBlocks.BRASS_CHAIN_DRIVE);
                        output.accept(ModBlocks.ADJUSTABLE_BRASS_CHAIN_GEARSHIFT);
                        output.accept(ModBlocks.INVERTED_CLUTCH);
                        output.accept(ModBlocks.INVERTED_GEARSHIFT);
                    })
                    .build());

    public static void register(IEventBus modEventBus) {
        REGISTER.register(modEventBus);
    }

}

