package net.stormdragon_64.create_plus.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;
import net.stormdragon_64.create_plus.CreatePlus;

@Mod.EventBusSubscriber(modid = CreatePlus.MOD_ID)

public class CreatePlusClientConfigs {
    /*public static class CLIENT {
        public final ConfigValue<Boolean> EndermoshReplacement;

        Client(ForgeConfigSpec.Builder builder) {
            builder.push("secrets");
            builder.push("endermosh_to_tall_remix");
            EndermoshReplacement = builder.comment("Whether or not to replace Quark's Endermosh music disc. This is more of a test of how configs work than anything.")
                    .define("Endermosh Replacement", false);
            builder.pop();
        }
    }

    public static final ForgeConfigSpec CLIENT_SPEC;
    public static final ForgeConfig.Client CLIENT;

    static {
        final Pair<ForgeConfig.Client, ForgeConfigSpec> clientForgeConfigSpecPair = new ForgeConfigSpec.Builder().configure(ForgeConfig.Client::new);
        CLIENT_SPEC = clientForgeConfigSpecPair.getRight();
        CLIENT = clientForgeConfigSpecPair.getLeft();
    }*/

    public static final ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> EndermoshReplacement;


    static {
        builder.push("Configs for Create: Components and Additions");

        EndermoshReplacement = builder.comment("Whether or not to replace Quark's Endermosh music disc. This is more of a test of how configs work than anything.")
                        .define("Endermosh Replacement", false);

        builder.pop();
        SPEC = builder.build();
    }
}
