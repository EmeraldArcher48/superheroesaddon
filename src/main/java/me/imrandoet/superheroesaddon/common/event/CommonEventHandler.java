package me.imrandoet.superheroesaddon.common.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import fiskfille.heroes.common.data.SHData;
import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.helper.SHHelper;
import me.imrandoet.superheroesaddon.common.abilities.Abilities;
import me.imrandoet.superheroesaddon.common.data.SUHData;
import me.imrandoet.superheroesaddon.common.entity.EntityBlackFlash;
import me.imrandoet.superheroesaddon.common.heroes.HeroManager;
import me.imrandoet.superheroesaddon.common.interaction.key.KeyManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.world.WorldEvent;

import java.util.Random;

/**
 * Created by ImranDoet on 29-10-2017.
 */

public class CommonEventHandler {

    @SubscribeEvent
    public void onLoad(WorldEvent.Load e) {
        World w = e.world;

        if (w.getGameRules() != null) {
            w.getGameRules().addGameRule("leadSight", "true");
        }
    }

    @SubscribeEvent
    public void onJump(LivingEvent.LivingJumpEvent e) {
        if (e.entity instanceof EntityPlayer) {
            EntityPlayer ep = (EntityPlayer) e.entity;
            if (SHHelper.getHero(ep) == null) return;
            if (!SHHelper.isSpeedster(ep)) return;
            if (SUHData.PHASING.get(ep)) {
                ep.motionY = 0;
            }
        }
    }

    @SubscribeEvent
    public void onTick(TickEvent.PlayerTickEvent e) {
        EntityPlayer ep = e.player;
        if (ep != null) {
            if (SHHelper.getHero(ep) == null) return;
            Hero hero = SHHelper.getHero(ep);
            if (e.phase == TickEvent.Phase.END) {
                if (SHHelper.isSpeedster(ep)) {
                    if (SHData.SPEEDING.get(ep)) {
                        int trueSpeedLevel = (SHData.SPEED.get(ep) + 1);
                        if (trueSpeedLevel >= 16) {
                            if (!ep.worldObj.isRemote) {
                                if (!SUHData.BLACK_FLASH.get(ep)) {
                                    if (ep.ticksExisted >= 200) {
                                        EntityBlackFlash entityBlackFlash = new EntityBlackFlash(ep.worldObj);
                                        entityBlackFlash.setAttackTarget(ep);
                                        SHData.SPEEDING.set(entityBlackFlash, true);
                                        SHData.SPEED.set(entityBlackFlash, (byte) trueSpeedLevel);
                                        Random rand = new Random();
                                        double x = 25 + rand.nextInt((50 - 25) + 1);
                                        double y = 25 + rand.nextInt((50 - 25) + 1);
                                        double z = 25 + rand.nextInt((50 - 25) + 1);
                                        entityBlackFlash.setLocationAndAngles(ep.posX + x, ep.posY + y, ep.posZ + z, ep.rotationYaw, ep.rotationPitch);
                                        entityBlackFlash.setCurrentItemOrArmor(1, new ItemStack(HeroManager.BLACK_FLASH.getHelmet()));
                                        entityBlackFlash.setCurrentItemOrArmor(2, new ItemStack(HeroManager.BLACK_FLASH.getChestplate()));
                                        entityBlackFlash.setCurrentItemOrArmor(3, new ItemStack(HeroManager.BLACK_FLASH.getLeggings()));
                                        entityBlackFlash.setCurrentItemOrArmor(4, new ItemStack(HeroManager.BLACK_FLASH.getBoots()));
                                        ep.worldObj.spawnEntityInWorld(entityBlackFlash);
                                        entityBlackFlash.onSpawnWithEgg(null);
                                        SUHData.BLACK_FLASH.set(ep, true);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}
