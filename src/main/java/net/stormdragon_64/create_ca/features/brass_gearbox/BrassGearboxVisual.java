package net.stormdragon_64.create_ca.features.brass_gearbox;

import com.simibubi.create.AllPartialModels;
import com.simibubi.create.content.kinetics.base.KineticBlockEntityVisual;
import com.simibubi.create.content.kinetics.base.RotatingInstance;
import com.simibubi.create.content.kinetics.gearbox.GearboxBlockEntity;
import com.simibubi.create.foundation.render.AllInstanceTypes;
import dev.engine_room.flywheel.api.instance.Instance;
import dev.engine_room.flywheel.api.visualization.VisualizationContext;
import dev.engine_room.flywheel.lib.model.Models;
import net.createmod.catnip.data.Iterate;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import javax.annotation.Nullable;
import java.util.function.Consumer;

public class BrassGearboxVisual extends KineticBlockEntityVisual<GearboxBlockEntity> {
    protected Direction sourceFacing;

    @Nullable
    protected final RotatingInstance northShaft;
    @Nullable
    protected final RotatingInstance eastShaft;
    @Nullable
    protected final RotatingInstance southShaft;
    @Nullable
    protected final RotatingInstance westShaft;

    public BrassGearboxVisual(VisualizationContext context, GearboxBlockEntity blockEntity, float partialTick) {
        super(context, blockEntity, partialTick);

        final Direction.Axis boxAxis = blockState.getValue(BlockStateProperties.AXIS);

        updateSourceFacing();

        var instancer = instancerProvider().instancer(AllInstanceTypes.ROTATING, Models.partial(AllPartialModels.SHAFT_HALF));

        RotatingInstance northShaft = null;
        RotatingInstance eastShaft = null;
        RotatingInstance southShaft = null;
        RotatingInstance westShaft = null;

        for (Direction direction : Iterate.directions) {
            final Direction.Axis axis = direction.getAxis();
            if (boxAxis == axis) {
                continue;
            }

            RotatingInstance instance = instancer.createInstance();


            instance.setup(blockEntity, axis, getSpeed(direction))
                    .setPosition(getVisualPosition())
                    .rotateToFace(Direction.SOUTH, direction)
                    .setChanged();

            //Depending on which direction we are on right now, we check a shaft to see if it is blocked.
            // If it isn't, then we assign the shaft an instance.
            // Otherwise, we delete the instance and set the shaft to null to stop rendering it.
            // Since which shaft corrosponds to which direction changes based on the axis of the gearbox, we have to check the axis aswell.
            switch (blockState.getValue(BrassGearboxBlock.AXIS)) {
                case Y -> {
                    switch (direction) {
                        case NORTH -> {
                            if (blockState.getValue(BrassGearboxBlock.SHAFT_N)) {
                                northShaft = instance;
                            } else {
                                instance.delete();
                                northShaft = null;
                            }
                        }
                        case EAST -> {
                            if (blockState.getValue(BrassGearboxBlock.SHAFT_E)) {
                                eastShaft = instance;
                            } else {
                                instance.delete();
                                eastShaft = null;
                            }
                        }
                        case SOUTH -> {
                            if (blockState.getValue(BrassGearboxBlock.SHAFT_S)) {
                                southShaft = instance;
                            } else {
                                instance.delete();
                                southShaft = null;
                            }
                        }
                        case WEST -> {
                            if (blockState.getValue(BrassGearboxBlock.SHAFT_W)) {
                                westShaft = instance;
                            } else {
                                instance.delete();
                                westShaft = null;
                            }
                        }
                    }
                }

                case X -> {
                    switch (direction) {
                        case NORTH -> {
                            if (blockState.getValue(BrassGearboxBlock.SHAFT_N)) {
                                northShaft = instance;
                            } else {
                                instance.delete();
                                northShaft = null;
                            }
                        }
                        case UP -> {
                            if (blockState.getValue(BrassGearboxBlock.SHAFT_E)) {
                                eastShaft = instance;
                            } else {
                                instance.delete();
                                eastShaft = null;
                            }
                        }
                        case SOUTH -> {
                            if (blockState.getValue(BrassGearboxBlock.SHAFT_S)) {
                                southShaft = instance;
                            } else {
                                instance.delete();
                                southShaft = null;
                            }
                        }
                        case DOWN -> {
                            if (blockState.getValue(BrassGearboxBlock.SHAFT_W)) {
                                westShaft = instance;
                            } else {
                                instance.delete();
                                westShaft = null;
                            }
                        }
                    }
                }

                case Z -> {
                    switch (direction) {
                        case UP -> {
                            if (blockState.getValue(BrassGearboxBlock.SHAFT_N)) {
                                northShaft = instance;
                            } else {
                                instance.delete();
                                northShaft = null;
                            }
                        }
                        case EAST -> {
                            if (blockState.getValue(BrassGearboxBlock.SHAFT_E)) {
                                eastShaft = instance;
                            } else {
                                instance.delete();
                                eastShaft = null;
                            }
                        }
                        case DOWN -> {
                            if (blockState.getValue(BrassGearboxBlock.SHAFT_S)) {
                                southShaft = instance;
                            } else {
                                instance.delete();
                                southShaft = null;
                            }
                        }
                        case WEST -> {
                            if (blockState.getValue(BrassGearboxBlock.SHAFT_W)) {
                                westShaft = instance;
                            } else {
                                instance.delete();
                                westShaft = null;
                            }
                        }
                    }
                }
            }
        }
        this.northShaft = northShaft;
        this.eastShaft = eastShaft;
        this.southShaft = southShaft;
        this.westShaft = westShaft;
    }

    private float getSpeed(Direction direction) {
        float speed = blockEntity.getSpeed();

        if (speed != 0 && sourceFacing != null) {
            if (sourceFacing.getAxis() == direction.getAxis())
                speed *= sourceFacing == direction ? 1 : -1;
            else if (sourceFacing.getAxisDirection() == direction.getAxisDirection())
                speed *= -1;
        }
        return speed;
    }

    protected void updateSourceFacing() {
        if (blockEntity.hasSource()) {
            BlockPos source = blockEntity.source.subtract(pos);
            sourceFacing = Direction.getNearest(source.getX(), source.getY(), source.getZ());
        } else {
            sourceFacing = null;
        }
    }

    @Override
    public void update(float pt) {
        updateSourceFacing();

        switch (blockState.getValue(BrassGearboxBlock.AXIS)) {
            case Y -> {
                if (northShaft != null) {
                    northShaft.setup(blockEntity, Direction.Axis.Z, getSpeed(Direction.NORTH))
                            .setChanged();
                }
                if (eastShaft != null) {
                    eastShaft.setup(blockEntity, Direction.Axis.X, getSpeed(Direction.EAST))
                            .setChanged();
                }
                if (southShaft != null) {
                    southShaft.setup(blockEntity, Direction.Axis.Z, getSpeed(Direction.SOUTH))
                            .setChanged();
                }
                if (westShaft != null) {
                    westShaft.setup(blockEntity, Direction.Axis.X, getSpeed(Direction.WEST))
                            .setChanged();
                }
            }
            case X -> {
                if (northShaft != null) {
                    northShaft.setup(blockEntity, Direction.Axis.Z, getSpeed(Direction.NORTH))
                            .setChanged();
                }
                if (eastShaft != null) {
                    eastShaft.setup(blockEntity, Direction.Axis.Y, getSpeed(Direction.UP))
                            .setChanged();
                }
                if (southShaft != null) {
                    southShaft.setup(blockEntity, Direction.Axis.Z, getSpeed(Direction.SOUTH))
                            .setChanged();
                }
                if (westShaft != null) {
                    westShaft.setup(blockEntity, Direction.Axis.Y, getSpeed(Direction.DOWN))
                            .setChanged();
                }
            }
            case Z -> {
                if (northShaft != null) {
                    northShaft.setup(blockEntity, Direction.Axis.Y, getSpeed(Direction.UP))
                            .setChanged();
                }
                if (eastShaft != null) {
                    eastShaft.setup(blockEntity, Direction.Axis.X, getSpeed(Direction.EAST))
                            .setChanged();
                }
                if (southShaft != null) {
                    southShaft.setup(blockEntity, Direction.Axis.Y, getSpeed(Direction.DOWN))
                            .setChanged();
                }
                if (westShaft != null) {
                    westShaft.setup(blockEntity, Direction.Axis.X, getSpeed(Direction.WEST))
                            .setChanged();
                }
            }
        }
    }

    @Override
    public void updateLight(float partialTick) {
        relight(northShaft, eastShaft, southShaft, westShaft);
    }

    @Override
    protected void _delete() {
        if (northShaft != null) {
            northShaft.delete();
        }
        if (eastShaft != null) {
            eastShaft.delete();
        }
        if (southShaft != null) {
            southShaft.delete();
        }
        if (westShaft != null) {
            westShaft.delete();
        }

        //keys.values().forEach(AbstractInstance::delete);
        //keys.clear();
    }

    @Override
    public void collectCrumblingInstances(Consumer<Instance> consumer) {
        consumer.accept(northShaft);
        consumer.accept(eastShaft);
        consumer.accept(southShaft);
        consumer.accept(westShaft);
    }
}
