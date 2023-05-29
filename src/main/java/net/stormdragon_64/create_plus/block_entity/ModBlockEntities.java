package net.stormdragon_64.create_plus.block_entity;


import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.content.kinetics.base.ShaftInstance;
import com.simibubi.create.content.kinetics.base.ShaftRenderer;
import com.simibubi.create.content.kinetics.chainDrive.ChainGearshiftBlockEntity;
import com.simibubi.create.content.kinetics.gearbox.GearboxBlockEntity;
import com.simibubi.create.content.kinetics.gearbox.GearboxInstance;
import com.simibubi.create.content.kinetics.gearbox.GearboxRenderer;
import com.simibubi.create.content.kinetics.transmission.ClutchBlockEntity;
import com.simibubi.create.content.kinetics.transmission.GearshiftBlockEntity;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import net.stormdragon_64.create_plus.block.ModBlocks;

import static com.simibubi.create.Create.REGISTRATE;


public class ModBlockEntities {

    public static final BlockEntityEntry<KineticBlockEntity> CUSTOM_CHAIN_DRIVE = REGISTRATE
            .blockEntity("custom_chain_drive_block_entity", KineticBlockEntity::new)
            .instance(() -> ShaftInstance::new, false)
            .validBlocks(ModBlocks.BRASS_CHAIN_DRIVE)
            .renderer(() -> ShaftRenderer::new)
            .register();

    public static final BlockEntityEntry<GearboxBlockEntity> CUSTOM_GEARBOX = REGISTRATE
            .blockEntity("custom_gearbox_block_entity", GearboxBlockEntity::new)
            .instance(() -> GearboxInstance::new, false)
            .validBlocks(ModBlocks.BRASS_GEARBOX)
            .renderer(() -> GearboxRenderer::new)
            .register();

    public static final BlockEntityEntry<GearshiftBlockEntity> INVERTED_GEARSHIFT = REGISTRATE
            .blockEntity("inverted_gearshift_block_entity", GearshiftBlockEntity::new)
            .instance(() -> ShaftInstance::new, false)
            .validBlocks(ModBlocks.INVERTED_GEARSHIFT)
            .renderer(() -> ShaftRenderer::new)
            .register();

    public static final BlockEntityEntry<ClutchBlockEntity> INVERTED_CLUTCH = REGISTRATE
            .blockEntity("inverted_clutch_block_entity", ClutchBlockEntity::new)
            .instance(() -> ShaftInstance::new, false)
            .validBlocks(ModBlocks.INVERTED_CLUTCH)
            .renderer(() -> ShaftRenderer::new)
            .register();



    public static final BlockEntityEntry<ChainGearshiftBlockEntity> CUSTOM_ADJUSTABLE_CHAIN_GEARSHIFT = REGISTRATE
            .blockEntity("custom_adjustable_chain_gearshift_block_entity", ChainGearshiftBlockEntity::new)
            .instance(() -> ShaftInstance::new, false)
            .validBlocks(ModBlocks.ADJUSTABLE_BRASS_CHAIN_GEARSHIFT)
            .renderer(() -> ShaftRenderer::new)
            .register();



    //Register method - Important!
    public static void register() {}
}
