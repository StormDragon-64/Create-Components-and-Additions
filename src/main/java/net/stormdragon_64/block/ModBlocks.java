package net.stormdragon_64.block;

import com.simibubi.create.Create;
import com.simibubi.create.content.contraptions.relays.encased.EncasedBeltBlock;
import com.simibubi.create.content.contraptions.relays.encased.EncasedBeltGenerator;
import com.simibubi.create.foundation.block.BlockStressDefaults;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MaterialColor;

import static com.simibubi.create.foundation.data.ModelGen.customItemModel;
import static com.simibubi.create.foundation.data.TagGen.axeOrPickaxe;
import static net.stormdragon_64.create_plus.CreatePlus.REGISTRATE;

public class ModBlocks {
    //stuff to actually register the items
    public static final BlockEntry<EncasedBeltBlock> BRASS_CHAIN_DRIVE = REGISTRATE
    .block("brass_chain_drive", EncasedBeltBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(BlockBehaviour.Properties::noOcclusion)
            .transform(BlockStressDefaults.setNoImpact())
            .transform(axeOrPickaxe())
            .blockstate((c, p) -> new EncasedBeltGenerator((state, suffix) -> p.models()
                    .getExistingFile(p.modLoc("block/" + c.getName() + "/" + suffix))).generate(c, p))
            .item()
            .transform(customItemModel())
            .register();

    public static void register() {}

    }
