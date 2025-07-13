package net.stormdragon_64.create_ca;


import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.content.kinetics.base.ShaftRenderer;
import com.simibubi.create.content.kinetics.base.SingleAxisRotatingVisual;
import com.simibubi.create.content.kinetics.chainDrive.ChainGearshiftBlockEntity;
import com.simibubi.create.content.kinetics.gearbox.GearboxBlockEntity;
import com.simibubi.create.content.kinetics.transmission.ClutchBlockEntity;
import com.simibubi.create.content.kinetics.transmission.GearshiftBlockEntity;
import com.simibubi.create.content.kinetics.transmission.SplitShaftRenderer;
import com.simibubi.create.content.kinetics.transmission.SplitShaftVisual;
import com.simibubi.create.content.processing.basin.BasinBlockEntity;
import com.simibubi.create.content.processing.basin.BasinRenderer;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import net.stormdragon_64.create_ca.features.brass_gearbox.BrassGearboxRenderer;
import net.stormdragon_64.create_ca.features.brass_gearbox.BrassGearboxVisual;

import static net.stormdragon_64.create_ca.CreateCA.REGISTRATE;


public class ModBlockEntities {

    public static final BlockEntityEntry<KineticBlockEntity> BRASS_CHAIN_DRIVE = REGISTRATE
            .blockEntity("brass_chain_drive", KineticBlockEntity::new)
            .visual(() -> SingleAxisRotatingVisual::shaft, false)
            .validBlocks(ModBlocks.BRASS_CHAIN_DRIVE)
            .renderer(() -> ShaftRenderer::new)
            .register();

    public static final BlockEntityEntry<ChainGearshiftBlockEntity> BRASS_ADJUSTABLE_CHAIN_GEARSHIFT = REGISTRATE
            .blockEntity("brass_adjustable_chain_gearshift", ChainGearshiftBlockEntity::new)
            .visual(() -> SingleAxisRotatingVisual::shaft, false)
            .validBlocks(ModBlocks.ADJUSTABLE_BRASS_CHAIN_GEARSHIFT)
            .renderer(() -> ShaftRenderer::new)
            .register();

    public static final BlockEntityEntry<GearboxBlockEntity> BRASS_GEARBOX = REGISTRATE
            .blockEntity("custom_gearbox", GearboxBlockEntity::new)
            .visual(() -> BrassGearboxVisual::new, false)
            .validBlocks(ModBlocks.BRASS_GEARBOX)
            .renderer(() -> BrassGearboxRenderer::new)
            .register();

    public static final BlockEntityEntry<GearshiftBlockEntity> INVERTED_GEARSHIFT = REGISTRATE
            .blockEntity("inverted_gearshift", GearshiftBlockEntity::new)
            .visual(() -> SplitShaftVisual::new, false)
            .validBlocks(ModBlocks.INVERTED_GEARSHIFT)
            .renderer(() -> SplitShaftRenderer::new)
            .register();

    public static final BlockEntityEntry<ClutchBlockEntity> INVERTED_CLUTCH = REGISTRATE
            .blockEntity("inverted_clutch", ClutchBlockEntity::new)
            .visual(() -> SplitShaftVisual::new, false)
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
