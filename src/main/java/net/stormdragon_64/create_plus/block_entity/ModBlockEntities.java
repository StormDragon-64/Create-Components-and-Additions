package net.stormdragon_64.create_plus.block_entity;


import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.content.kinetics.base.ShaftInstance;
import com.simibubi.create.content.kinetics.base.ShaftRenderer;
import com.simibubi.create.content.kinetics.chainDrive.ChainGearshiftBlockEntity;
import com.simibubi.create.content.kinetics.gearbox.GearboxBlockEntity;
import com.simibubi.create.content.kinetics.gearbox.GearboxRenderer;
import com.simibubi.create.content.kinetics.transmission.ClutchBlockEntity;
import com.simibubi.create.content.kinetics.transmission.GearshiftBlockEntity;
import com.simibubi.create.content.kinetics.transmission.SplitShaftInstance;
import com.simibubi.create.content.kinetics.transmission.SplitShaftRenderer;
import com.simibubi.create.content.processing.basin.BasinBlockEntity;
import com.simibubi.create.content.processing.basin.BasinRenderer;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import net.stormdragon_64.create_plus.block.ModBlocks;
import net.stormdragon_64.instance.BrassGearboxInstance;

import static net.stormdragon_64.create_plus.CreatePlus.REGISTRATE;


public class ModBlockEntities {

    public static final BlockEntityEntry<KineticBlockEntity> BRASS_CHAIN_DRIVE = REGISTRATE
            .blockEntity("brass_chain_drive", KineticBlockEntity::new)
            .instance(() -> ShaftInstance::new, false)
            .validBlocks(ModBlocks.BRASS_CHAIN_DRIVE)
            .renderer(() -> ShaftRenderer::new)
            .register();

    public static final BlockEntityEntry<ChainGearshiftBlockEntity> BRASS_ADJUSTABLE_CHAIN_GEARSHIFT = REGISTRATE
            .blockEntity("brass_adjustable_chain_gearshift", ChainGearshiftBlockEntity::new)
            .instance(() -> ShaftInstance::new, false)
            .validBlocks(ModBlocks.ADJUSTABLE_BRASS_CHAIN_GEARSHIFT)
            .renderer(() -> ShaftRenderer::new)
            .register();

    public static final BlockEntityEntry<GearboxBlockEntity> BRASS_GEARBOX = REGISTRATE
            .blockEntity("custom_gearbox", GearboxBlockEntity::new)
            .instance(() -> BrassGearboxInstance::new, false)
            .validBlocks(ModBlocks.BRASS_GEARBOX)
            .renderer(() -> GearboxRenderer::new)
            .register();

    public static final BlockEntityEntry<GearshiftBlockEntity> INVERTED_GEARSHIFT = REGISTRATE
            .blockEntity("inverted_gearshift", GearshiftBlockEntity::new)
            .instance(() -> SplitShaftInstance::new, false)
            .validBlocks(ModBlocks.INVERTED_GEARSHIFT)
            .renderer(() -> SplitShaftRenderer::new)
            .register();

    public static final BlockEntityEntry<ClutchBlockEntity> INVERTED_CLUTCH = REGISTRATE
            .blockEntity("inverted_clutch", ClutchBlockEntity::new)
            .instance(() -> SplitShaftInstance::new, false)
            .validBlocks(ModBlocks.INVERTED_CLUTCH)
            .renderer(() -> SplitShaftRenderer::new)
            .register();

    public static final BlockEntityEntry<BasinBlockEntity> BRASS_BASIN = REGISTRATE
            .blockEntity("brass_basin", BasinBlockEntity::new)
            .validBlocks(ModBlocks.BRASS_BASIN)
            .renderer(() -> BasinRenderer::new)
            .register();


    public static void register() {}
}
