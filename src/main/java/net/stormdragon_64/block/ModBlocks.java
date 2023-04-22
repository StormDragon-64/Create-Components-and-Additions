package net.stormdragon_64.block;

import com.simibubi.create.AllSpriteShifts;
import com.simibubi.create.content.contraptions.relays.encased.EncasedBeltGenerator;
import com.simibubi.create.content.contraptions.relays.encased.EncasedCTBehaviour;
import com.simibubi.create.foundation.block.BlockStressDefaults;
import com.simibubi.create.foundation.data.AssetLookup;
import com.simibubi.create.foundation.data.BlockStateGen;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.stormdragon_64.create_plus.ModGroup;

import static com.simibubi.create.foundation.data.BlockStateGen.axisBlock;
import static com.simibubi.create.foundation.data.ModelGen.customItemModel;
import static com.simibubi.create.foundation.data.TagGen.axeOrPickaxe;
import static net.stormdragon_64.create_plus.CreatePlus.REGISTRATE;

public class ModBlocks {
    //add to my creative tab
    static {
        REGISTRATE.creativeModeTab(() -> ModGroup.MAIN_TAB);
    }
    //The Items themselves

    public static final BlockEntry<CustomChainDriveBlock> BRASS_CHAIN_DRIVE = REGISTRATE
    .block("brass_chain_drive", CustomChainDriveBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(BlockBehaviour.Properties::noOcclusion)
            .transform(BlockStressDefaults.setNoImpact())
            .transform(axeOrPickaxe())
            .blockstate((c, p) -> new EncasedBeltGenerator((state, suffix) -> p.models()
            .getExistingFile(p.modLoc("block/" + c.getName() + "/" + suffix))).generate(c, p))
            .item()
            .transform(customItemModel())
            .register();

    public static final BlockEntry<CustomGearboxBlock> BRASS_GEARBOX = REGISTRATE
    .block("brass_gearbox", CustomGearboxBlock::new)
            .initialProperties(SharedProperties::stone)
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

    public static final BlockEntry<CustomGearshiftBlock> INVERTED_GEARSHIFT = REGISTRATE.block("inverted_gearshift", CustomGearshiftBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(BlockBehaviour.Properties::noOcclusion)
            .transform(BlockStressDefaults.setNoImpact())
            .transform(axeOrPickaxe())
            .blockstate((c, p) -> BlockStateGen.axisBlock(c, p, AssetLookup.forPowered(c, p)))
            .item()
            .transform(customItemModel())
            .register();

    public static final BlockEntry<CustomClutchBlock> INVERTED_CLUTCH = REGISTRATE.block("inverted_clutch", CustomClutchBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(BlockBehaviour.Properties::noOcclusion)
            .transform(BlockStressDefaults.setNoImpact())
            .transform(axeOrPickaxe())
            .blockstate((c, p) -> BlockStateGen.axisBlock(c, p, AssetLookup.forPowered(c, p)))
            .item()
            .transform(customItemModel())
            .register();

    //Register Method - Don't touch!
    public static void register() {}

    }
