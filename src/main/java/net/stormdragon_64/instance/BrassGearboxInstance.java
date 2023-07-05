package net.stormdragon_64.instance;

import com.jozufozu.flywheel.api.InstanceData;
import com.jozufozu.flywheel.api.Instancer;
import com.jozufozu.flywheel.api.Material;
import com.jozufozu.flywheel.api.MaterialManager;
import com.simibubi.create.AllPartialModels;
import com.simibubi.create.content.kinetics.base.KineticBlockEntityInstance;
import com.simibubi.create.content.kinetics.base.flwdata.RotatingData;
import com.simibubi.create.content.kinetics.gearbox.GearboxBlockEntity;
import com.simibubi.create.foundation.utility.Iterate;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.stormdragon_64.create_plus.block.BrassGearboxBlock;

import java.util.EnumMap;
import java.util.Map;

public class BrassGearboxInstance extends KineticBlockEntityInstance<GearboxBlockEntity> {
    EnumMap<Direction, RotatingData> keys;
    protected Direction sourceFacing;

    public BrassGearboxInstance(MaterialManager materialManager, GearboxBlockEntity blockEntity) {
        super(materialManager, blockEntity);

    keys = new EnumMap<>(Direction.class);

        final Direction.Axis boxAxis = blockState.getValue(BlockStateProperties.AXIS);

        int blockLight = world.getBrightness(LightLayer.BLOCK, pos);
        int skyLight = world.getBrightness(LightLayer.SKY, pos);
        updateSourceFacing();

        Material<RotatingData> rotatingMaterial = getRotatingMaterial();

        for (Direction direction : Iterate.directions) {
            final Direction.Axis axis = direction.getAxis();
            if (boxAxis == axis)
                continue;

            Instancer<RotatingData> shaft = rotatingMaterial.getModel(AllPartialModels.SHAFT_HALF, blockState, direction);

            RotatingData key = shaft.createInstance();

            key.setRotationAxis(Direction.get(Direction.AxisDirection.POSITIVE, axis).step())
                    .setRotationalSpeed(getSpeed(direction))
                    .setRotationOffset(getRotationOffset(axis)).setColor(blockEntity)
                    .setPosition(getInstancePosition())
                    .setBlockLight(blockLight)
                    .setSkyLight(skyLight);

            keys.put(direction, key);
            //Custom code
            if (blockState.getValue(BrassGearboxBlock.AXIS) == Direction.Axis.Y) {
                if (!blockState.getValue(BrassGearboxBlock.SHAFT_N)) {
                    if (direction == Direction.NORTH) {
                        key.delete();
                    }
                }
                if (!blockState.getValue(BrassGearboxBlock.SHAFT_E)) {
                    if (direction == Direction.EAST) {
                        key.delete();
                    }
                }
                if (!blockState.getValue(BrassGearboxBlock.SHAFT_S)) {
                    if (direction == Direction.SOUTH) {
                        key.delete();
                    }
                }
                if (!blockState.getValue(BrassGearboxBlock.SHAFT_W)) {
                    if (direction == Direction.WEST) {
                        key.delete();
                    }
                }

            } else if (blockState.getValue(BrassGearboxBlock.AXIS) == Direction.Axis.X) {
                if (!blockState.getValue(BrassGearboxBlock.SHAFT_N)) {
                    if (direction == Direction.NORTH) {
                        key.delete();
                    }
                }
                if (!blockState.getValue(BrassGearboxBlock.SHAFT_E)) {
                    if (direction == Direction.UP) {
                        key.delete();
                    }
                }
                if (!blockState.getValue(BrassGearboxBlock.SHAFT_S)) {
                    if (direction == Direction.SOUTH) {
                        key.delete();
                    }
                }
                if (!blockState.getValue(BrassGearboxBlock.SHAFT_W)) {
                    if (direction == Direction.DOWN) {
                        key.delete();
                    }
                }

            } else if (blockState.getValue(BrassGearboxBlock.AXIS) == Direction.Axis.Z) {
                if (!blockState.getValue(BrassGearboxBlock.SHAFT_N)) {
                    if (direction == Direction.UP) {
                        key.delete();
                    }
                }
                if (!blockState.getValue(BrassGearboxBlock.SHAFT_E)) {
                    if (direction == Direction.EAST) {
                        key.delete();
                    }
                }
                if (!blockState.getValue(BrassGearboxBlock.SHAFT_S)) {
                    if (direction == Direction.DOWN) {
                        key.delete();
                    }
                }
                if (!blockState.getValue(BrassGearboxBlock.SHAFT_W)) {
                    if (direction == Direction.WEST) {
                        key.delete();
                    }
                }
            }
        }
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
    public void update() {
        updateSourceFacing();
        for (Map.Entry<Direction, RotatingData> key : keys.entrySet()) {
            Direction direction = key.getKey();
            Direction.Axis axis = direction.getAxis();

            updateRotation(key.getValue(), axis, getSpeed(direction));
        }
    }
    @Override
    public void updateLight() {
        relight(pos, keys.values().stream());
    }

    @Override
    public void remove() {
        keys.values().forEach(InstanceData::delete);
        keys.clear();
    }

}
