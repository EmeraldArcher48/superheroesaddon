package me.imrandoet.superheroesaddon.common.abilities;

import cpw.mods.fml.common.gameevent.TickEvent;
import fiskfille.core.FiskUtils;
import fiskfille.heroes.common.ability.Ability;
import fiskfille.heroes.common.data.SHData;
import fiskfille.heroes.common.hero.*;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by ImranDoet on 24-10-2017.
 */

public class AbilityFlight extends Ability<IAbility> {

    public AbilityFlight(int tier) {
        super(tier);
    }

    public void onUpdate(EntityLivingBase entity, Hero hero, IAbility instance, TickEvent.Phase phase) {
        if (phase == TickEvent.Phase.END) {
            if (entity.worldObj.isRemote && FiskUtils.proxy.isClientPlayer(entity) && entity instanceof EntityPlayer) {
                Minecraft mc = Minecraft.getMinecraft();
                EntityPlayer player = (EntityPlayer)entity;
                if (!player.capabilities.isFlying && !player.onGround) {
                    if (!player.isInWater() && player.dimension != 31 && player.motionY < 0.0D) {
                        player.motionY += 0.05999999865889549D;
                    }

                    player.moveFlying(player.moveStrafing, player.moveForward, 0.075F);
                    if (mc.gameSettings.keyBindJump.getIsKeyPressed()) {
                        player.motionY += player.dimension == 31 ? 0.10000000149011612D : 0.125D;
                    }

                    if (mc.gameSettings.keyBindSneak.getIsKeyPressed()) {
                        player.motionY -= player.dimension == 31 ? 0.10000000149011612D : 0.07500000298023224D;
                    }
                }
//                SHData.JETPACKING.set(entity, mc.gameSettings.keyBindJump.getIsKeyPressed() && !player.capabilities.isFlying);
                if (player.moveForward >= 0.98) {
                    SHData.FLIGHT_ANIMATION.set(entity, (byte) 1);
                    return;
                } else if (player.moveForward <= -0.98) {
                    SHData.FLIGHT_ANIMATION.set(entity, (byte) -1);
                    return;
                }
            }

            entity.fallDistance = 0.0F;
        }
    }

    public boolean applyMotion(EntityLivingBase entity) {
        boolean flying = SHData.JETPACKING.get(entity);
        if (flying) {
            if (entity.motionY < 0.0D) {
                entity.motionY += 0.18000000715255737D;
            } else {
                entity.motionY += 0.11999999731779099D;
            }
            System.out.println(entity.moveForward);
            entity.moveFlying(entity.moveStrafing, entity.moveForward, 0.15F);
            return true;
        } else {
            return false;
        }
    }

}
