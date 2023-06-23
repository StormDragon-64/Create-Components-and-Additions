package net.stormdragon_64.create_plus.block;

import com.simibubi.create.AllSpriteShifts;
import com.simibubi.create.content.decoration.encasing.EncasedCTBehaviour;
import com.simibubi.create.content.kinetics.BlockStressDefaults;
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
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MaterialColor;
import net.stormdragon_64.create_plus.ModGroup;

import static com.simibubi.create.AllMovementBehaviours.movementBehaviour;
import static com.simibubi.create.foundation.data.BlockStateGen.axisBlock;
import static com.simibubi.create.foundation.data.ModelGen.customItemModel;
import static com.simibubi.create.foundation.data.TagGen.axeOrPickaxe;
import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;
import static net.stormdragon_64.create_plus.CreatePlus.REGISTRATE;

public class ModBlocks {
    //add to my creative tab
    static {
        REGISTRATE.creativeModeTab(() -> ModGroup.MAIN_TAB);
    }
    //The Items themselves

    public static final BlockEntry<CustomChainDriveBlock> BRASS_CHAIN_DRIVE = REGISTRATE
    .block("brass_chain_drive", CustomChainDriveBlock::new)
            .initialProperties(SharedProperties::softMetal)
            .properties(BlockBehaviour.Properties::noOcclusion)
            .transform(BlockStressDefaults.setNoImpact())
            .transform(axeOrPickaxe())
            .blockstate((c, p) -> new ChainDriveGenerator((state, suffix) -> p.models()
            .getExistingFile(p.modLoc("block/" + c.getName() + "/" + suffix))).generate(c, p))
            .item()
            .transform(customItemModel())
            .register();

    public static final BlockEntry<CustomGearboxBlock> BRASS_GEARBOX = REGISTRATE
    .block("brass_gearbox", CustomGearboxBlock::new)
            .initialProperties(SharedProperties::softMetal)
            .properties(BlockBehaviour.Properties::noOcclusion)
            .transform(BlockStressDefaults.setNoImpact())
            .transform(axeOrPickaxe())
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCTBehaviour(AllSpriteShifts.BRASS_CASING)))
            .onRegister(CreateRegistrate.casingConnectivity((block, cc) -> cc.make(block, AllSpriteShifts.BRASS_CASING,
                    (s, f) -> f.getAxis() == s.getValue(CustomGearboxBlock.AXIS))))
            .blockstate((c, p) -> axisBlock(c, p, $ -> AssetLookup.partialBaseModel(c, p), true))
            .item()
            .transform(customItemModel())
            .register();

     public static final BlockEntry<InvertedGearshiftBlock> INVERTED_GEARSHIFT = REGISTRATE.block("inverted_gearshift", InvertedGearshiftBlock::new)
             .initialProperties(SharedProperties::stone)
             .properties(BlockBehaviour.Properties::noOcclusion)
             .transform(BlockStressDefaults.setNoImpact())
             .transform(axeOrPickaxe())
             .blockstate((c, p) -> BlockStateGen.axisBlock(c, p, AssetLookup.forPowered(c, p)))
             .item()
             .transform(customItemModel())
             .register();

        public static final BlockEntry<InvertedClutchBlock> INVERTED_CLUTCH = REGISTRATE.block("inverted_clutch", InvertedClutchBlock::new)
                .initialProperties(SharedProperties::stone)
                .properties(BlockBehaviour.Properties::noOcclusion)
                .transform(BlockStressDefaults.setNoImpact())
                .transform(axeOrPickaxe())
                .blockstate((c, p) -> BlockStateGen.axisBlock(c, p, AssetLookup.forPowered(c, p)))
                .item()
                .transform(customItemModel())
                .register();

    public static final BlockEntry<CustomAdjustableChainGearshiftBlock> ADJUSTABLE_BRASS_CHAIN_GEARSHIFT =
            REGISTRATE.block("adjustable_brass_chain_gearshift", CustomAdjustableChainGearshiftBlock::new)
                    .initialProperties(SharedProperties::softMetal)
                    .properties(BlockBehaviour.Properties::noOcclusion)
                    .transform(BlockStressDefaults.setNoImpact())
                    .transform(axeOrPickaxe())
                    .blockstate((c, p) -> new ChainDriveGenerator((state, suffix) -> {
                        String powered = state.getValue(ChainGearshiftBlock.POWERED) ? "_powered" : "";
                        return p.models()
                                .withExistingParent(c.getName() + "_" + suffix + powered,
                                        p.modLoc("block/encased_chain_drive/" + suffix))
                                .texture("side", p.modLoc("block/" + c.getName() + powered));
                    }).generate(c, p))
                    .item()
                    .model((c, p) -> p.withExistingParent(c.getName(), p.modLoc("block/encased_chain_drive/item"))
                            .texture("side", p.modLoc("block/" + c.getName())))
                    .build()
                    .register();

    public static final BlockEntry<BrassBasinBlock> BRASS_BASIN = REGISTRATE.block("brass_basin", BrassBasinBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.color(MaterialColor.COLOR_GRAY))
            .properties(p -> p.sound(SoundType.NETHERITE_BLOCK))
            .transform(pickaxeOnly())
            .blockstate(new BasinGenerator()::generate)
            .onRegister(movementBehaviour(new BasinMovementBehaviour()))
            .item()
            .transform(customItemModel("_", "block"))
            .register();


    public static void register() {}
    }
