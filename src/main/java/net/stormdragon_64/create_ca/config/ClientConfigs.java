package net.stormdragon_64.create_ca.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;
import net.stormdragon_64.create_ca.CreateCA;

@Mod.EventBusSubscriber(modid = CreateCA.MOD_ID)

public class ClientConfigs {

    public static final ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> BuiltInResourcePack;


    static {
        builder.push("Configs for Create: Components and Additions");

        BuiltInResourcePack = builder.comment("Whether or not to enable the built-in resourcepack")
                        .define("Test Pack", false);

        builder.pop();
        SPEC = builder.build();
    }
}
