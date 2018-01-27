package me.imrandoet.superheroesaddon.common.abilities;

import cpw.mods.fml.common.gameevent.TickEvent;
import fiskfille.core.helper.FiskServerUtils;
import fiskfille.core.helper.VectorHelper;
import fiskfille.heroes.SHConstants;
import fiskfille.heroes.client.particle.SHParticleType;
import fiskfille.heroes.client.particle.SHParticles;
import fiskfille.heroes.common.ability.Ability;
import fiskfille.heroes.common.block.ModBlocks;
import fiskfille.heroes.common.damagesource.ModDamageSources;
import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.common.hero.IAbility;
import fiskfille.heroes.common.keybinds.SHKeyBinds;
import fiskfille.heroes.common.tileentity.TileEntityIceLayer;
import fiskfille.heroes.helper.SHHelper;
import fiskfille.heroes.helper.TemperatureHelper;
import me.imrandoet.superheroesaddon.common.data.SUHData;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.List;

/**
 * Created by ImranDoet on 27-10-2017.
 */

public class AbilityColdBreath extends Ability<IAbility> {

    public AbilityColdBreath(int tier) {
        super(tier);
    }

    @Override
    public void onUpdate(EntityLivingBase entity2, Hero hero, IAbility instance, TickEvent.Phase phase) {
        if (phase == TickEvent.Phase.END) {
            if (!hero.hasAbility(Abilities.COLD_BREATH)) return;
            if (SUHData.COLD_BREATH.get(entity2)) {
                EntityPlayer player = (EntityPlayer) entity2;
                World world = player.worldObj;
                double range = 32D;
                MovingObjectPosition rayTrace = SHHelper.rayTrace(player, range, 5, 1);

                if (rayTrace != null) {
                    if (rayTrace.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
                        int x = rayTrace.blockX;
                        int y = rayTrace.blockY;
                        int z = rayTrace.blockZ;
                        int side = rayTrace.sideHit;

                        ForgeDirection dir = ForgeDirection.getOrientation(side);
                        Block block = player.worldObj.getBlock(x, y, z);

                        if (block instanceof BlockLiquid || block != Blocks.vine && block != Blocks.tallgrass && block != Blocks.deadbush && !block.isReplaceable(player.worldObj, x, y, z)) {
                            x += dir.offsetX;
                            y += dir.offsetY;
                            z += dir.offsetZ;
                        }
                        else if (block.isReplaceable(player.worldObj, x, y, z) && block != Blocks.vine) {
                            side = 1;
                        }

                        List<Entity> list = world.getEntitiesWithinAABBExcludingEntity(null, AxisAlignedBB.getBoundingBox(x, y, z, x + 1, y + 1, z + 1));
                        boolean canPlaceLayer = list.isEmpty();

                        if (canPlaceLayer && FiskServerUtils.canEntityEdit(player, rayTrace, null) && world.getBlock(rayTrace.blockX, rayTrace.blockY, rayTrace.blockZ) == ModBlocks.iceLayer) {
                            TileEntityIceLayer tile = (TileEntityIceLayer) world.getTileEntity(rayTrace.blockX, rayTrace.blockY, rayTrace.blockZ);

                            if (tile != null && tile.thickness < 64) {
                                canPlaceLayer = false;
                                tile.setThickness(++tile.thickness);
                            }
                        }

                        if (canPlaceLayer && !player.worldObj.isRemote && player.canPlayerEdit(x, y, z, side, null) && (world.getBlock(rayTrace.blockX, rayTrace.blockY, rayTrace.blockZ) != ModBlocks.iceLayer || world.getBlockMetadata(rayTrace.blockX, rayTrace.blockY, rayTrace.blockZ) == side)) {
                            world.setBlock(x, y, z, ModBlocks.iceLayer, side, 3);
                        }
                    }
                    else if (rayTrace.entityHit != null) {
                        rayTrace.entityHit.attackEntityFrom(ModDamageSources.causeFreezeDamage(player), SHConstants.DMG_COLD_GUN);

                        if (rayTrace.entityHit instanceof EntityLivingBase) {
                            EntityLivingBase entity = (EntityLivingBase) rayTrace.entityHit;

                            if (TemperatureHelper.getCurrentBodyTemperature(entity) > 0) {
                                TemperatureHelper.setTemperature(entity, TemperatureHelper.getTemperature(entity) - 0.1F);
                            }
                        }
                    }
                }

                if (player.worldObj.isRemote) {
                    double length = rayTrace != null && rayTrace.hitInfo instanceof Double ? (Double) rayTrace.hitInfo : range;
                    Vec3 src = VectorHelper.getOffsetCoords(player, 0, -0.15, 0);
                    Vec3 dest = VectorHelper.getOffsetCoords(player, 0, 0, length);
                    length = src.distanceTo(dest);

                    for (double point = 0; point <= length; point += 0.15) {
                        Vec3 vec3 = VectorHelper.interpolate(dest, src, point);
                        SHParticles.spawnParticle(SHParticleType.FREEZE_RAY, vec3.xCoord, vec3.yCoord, vec3.zCoord, 0, 0, 0);
                    }
                }

            }
        }
    }
}
