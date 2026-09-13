package net.sshmoob.create_ca;

import com.simibubi.create.AllSpriteShifts;
import com.simibubi.create.content.decoration.encasing.EncasedCTBehaviour;
import com.simibubi.create.content.kinetics.chainDrive.ChainDriveGenerator;
import com.simibubi.create.content.kinetics.chainDrive.ChainGearshiftBlock;
import com.simibubi.create.content.processing.basin.BasinGenerator;
import com.simibubi.create.content.processing.basin.BasinMovementBehaviour;
import com.simibubi.create.foundation.data.AssetLookup;
import com.simibubi.create.foundation.data.BlockStateGen;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;
import net.sshmoob.create_ca.config.CCAStress;
import net.sshmoob.create_ca.content.brass_gearbox.BrassGearboxBlock;
import net.sshmoob.create_ca.content.inverted.InvertedClutchBlock;
import net.sshmoob.create_ca.content.inverted.InvertedGearshiftBlock;
import net.sshmoob.create_ca.content.variants.BrassAdjustableChainGearshiftBlock;
import net.sshmoob.create_ca.content.variants.BrassBasinBlock;
import net.sshmoob.create_ca.content.variants.BrassChainDriveBlock;

import static com.simibubi.create.api.behaviour.movement.MovementBehaviour.movementBehaviour;
import static com.simibubi.create.foundation.data.ModelGen.customItemModel;
import static com.simibubi.create.foundation.data.TagGen.axeOrPickaxe;
import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;
import static net.sshmoob.create_ca.CreateCA.REGISTRATE;

public class ModBlocks {
    //add to my creative tab
    static {
        REGISTRATE.setCreativeTab(ModCreativeTab.CREATIVE_MODE_TAB);
    }
    //The Items themselves

    public static final BlockEntry<BrassChainDriveBlock> BRASS_CHAIN_DRIVE = REGISTRATE
    .block("brass_chain_drive", BrassChainDriveBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.noOcclusion()
                    .mapColor(MapColor.TERRACOTTA_BROWN))
            .transform(axeOrPickaxe())
            .transform(CCAStress.setNoImpact())
            .blockstate((c, p) -> new ChainDriveGenerator((state, suffix) -> p.models()
                    .getExistingFile(p.modLoc("block/" + c.getName() + "/" + suffix))).generate(c, p))
            .item()
            .transform(customItemModel())
            .register();

    public static final BlockEntry<BrassGearboxBlock> BRASS_GEARBOX = REGISTRATE
    .block("brass_gearbox", BrassGearboxBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.noOcclusion()
                    .mapColor(MapColor.TERRACOTTA_BROWN))
            .transform(CCAStress.setNoImpact())
            .transform(axeOrPickaxe())
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCTBehaviour(AllSpriteShifts.BRASS_CASING)))
            .onRegister(CreateRegistrate.casingConnectivity((block, cc) -> cc.make(block, AllSpriteShifts.BRASS_CASING,
                    (s, f) -> f.getAxis() == s.getValue(BrassGearboxBlock.AXIS))))
            .blockstate((c, p) -> {
                // Brass gearbox uses a multi-part, so we do empty datagen for it. (No blockstate file will be generated)
            })
            .item()
            .transform(customItemModel())
            .register();

     public static final BlockEntry<InvertedGearshiftBlock> INVERTED_GEARSHIFT = REGISTRATE.block("inverted_gearshift", InvertedGearshiftBlock::new)
             .initialProperties(SharedProperties::stone)
             .properties(p -> p.noOcclusion().mapColor(MapColor.TERRACOTTA_BROWN))
             .transform(CCAStress.setNoImpact())
             .transform(axeOrPickaxe())
             .blockstate((c, p) -> BlockStateGen.axisBlock(c, p, AssetLookup.forPowered(c, p)))
             .item()
             .transform(customItemModel())
             .register();

        public static final BlockEntry<InvertedClutchBlock> INVERTED_CLUTCH = REGISTRATE.block("inverted_clutch", InvertedClutchBlock::new)
                .initialProperties(SharedProperties::stone)
                .properties(p -> p.noOcclusion().mapColor(MapColor.PODZOL))
                .transform(CCAStress.setNoImpact())
                .transform(axeOrPickaxe())
                .blockstate((c, p) -> BlockStateGen.axisBlock(c, p, AssetLookup.forPowered(c, p)))
                .item()
                .transform(customItemModel())
                .register();

    public static final BlockEntry<BrassAdjustableChainGearshiftBlock> ADJUSTABLE_BRASS_CHAIN_GEARSHIFT =
            REGISTRATE.block("adjustable_brass_chain_gearshift", BrassAdjustableChainGearshiftBlock::new)
                    .initialProperties(SharedProperties::softMetal)
                    .properties(p -> p.noOcclusion().mapColor(MapColor.TERRACOTTA_BROWN))
                    .transform(CCAStress.setNoImpact())
                    .transform(axeOrPickaxe())
                    .blockstate((c, p) -> new ChainDriveGenerator((state, suffix) -> {
                        String powered = state.getValue(ChainGearshiftBlock.POWERED) ? "_powered" : "";
                        return p.models()
                                .withExistingParent(c.getName() + "_" + suffix + powered,
                                        p.modLoc("block/brass_chain_drive/" + suffix))
                                .texture("side", p.modLoc("block/" + c.getName() + powered));
                    }).generate(c, p))
                    .item()
                    .model((c, p) -> p.withExistingParent(c.getName(), p.modLoc("block/brass_chain_drive/item"))
                            .texture("side", p.modLoc("block/" + c.getName())))
                    .build()
                    .register();

    public static final BlockEntry<BrassBasinBlock> BRASS_BASIN = REGISTRATE.block("brass_basin", BrassBasinBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_YELLOW))
            .properties(p -> p.sound(SoundType.NETHERITE_BLOCK))
            .transform(pickaxeOnly())
            .blockstate(new BasinGenerator()::generate)
            .onRegister(movementBehaviour(new BasinMovementBehaviour()))
            .item()
            .transform(customItemModel("_", "block"))
            .register();


    public static void register() {}
    }
