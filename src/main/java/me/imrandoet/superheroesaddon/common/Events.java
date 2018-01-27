package me.imrandoet.superheroesaddon.common;

//import cpw.mods.fml.common.eventhandler.Event;
//import cpw.mods.fml.common.eventhandler.SubscribeEvent;
//import cpw.mods.fml.common.gameevent.InputEvent;
//import fiskfille.heroes.common.block.ModBlocks;
//import fiskfille.heroes.common.config.SHConfig;
//import fiskfille.heroes.common.damagesource.ModDamageSources;
//import fiskfille.heroes.common.data.SHData;
//import fiskfille.heroes.common.entity.EntityCanaryCry;
//import fiskfille.heroes.common.helper.SHHelper;
//import fiskfille.heroes.common.hero.ISizeManipulation;
//import fiskfille.heroes.common.keybinds.SHKeyBinds;
//import fiskfille.heroes.common.time.Tickrate;
//import fiskfille.heroes.common.time.TimeHelper;
//import me.imrandoet.superheroesaddon.heroes.*;
//import me.imrandoet.superheroesaddon.others.GUIHandler;
//import me.imrandoet.superheroesaddon.others.IWebSlinger;
//import me.imrandoet.superheroesaddon.others.KeybindManager;
//import me.imrandoet.superheroesaddon.common.abilities.Abilities;
//import me.imrandoet.superheroesaddon.common.entity.EntityBeam;
//import me.imrandoet.superheroesaddon.common.entity.EntityWingding;
//import me.imrandoet.superheroesaddon.common.entity.SlingEntity;
//import me.imrandoet.superheroesaddon.helper.Utils;
//import net.minecraft.block.Block;
//import net.minecraft.client.Minecraft;
//import net.minecraft.entity.monster.EntityMob;
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.util.*;
//import net.minecraft.world.World;
//import net.minecraftforge.event.entity.living.LivingEvent;
//import net.minecraftforge.event.entity.living.LivingFallEvent;
//import net.minecraftforge.event.entity.living.LivingHurtEvent;
//import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import java.util.*;

/**
 * Created by ImranDoet on 20-6-2017.
 */
public class Events {

//    public HashMap<EntityPlayer, Long> cooldowns = new LinkedHashMap<EntityPlayer, Long>();
//
//    public void coldbreath(EntityPlayer ep) {
//        if (SHHelper.getHero(ep).hasAbility(Abilities.coldBreath)) {
//            if (SHKeyBinds.keyBindingAbility4.getIsKeyPressed()) {
//                Utils.fireColdBeam(ep);
//            }
//        }
//    }
//
//    public void beam(EntityPlayer ep) {
//        if (SHHelper.getHero(ep).hasAbility(Abilities.energyBeam) && SHHelper.getHero(ep) instanceof Cyclops) {
//            if (SHData.getBoolean(ep, 16)) {
//                int x;
//                int y;
//                int z;
//                World world = ep.worldObj;
//                if (world.isRemote) {
//                    world.spawnEntityInWorld(new EntityBeam(world, ep));
//                }
//
//                MovingObjectPosition mop = SHHelper.getHeatVisionMOP(ep, 1.0F);
//                if (mop != null) {
//                    if (mop.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
//                        if (!world.isRemote) {
//                            x = mop.blockX;
//                            y = mop.blockY;
//                            z = mop.blockZ;
//                            x = world.getBlockMetadata(x, y, z);
//                            Block block = world.getBlock(x, y, z);
//                            if (block == ModBlocks.iceLayer) {
//                                world.setBlockToAir(x, y, z);
//                            }
//
//                            if (SHConfig.heatVisionGriefing && SHHelper.getHeatVisionResult(block, x) != null) {
//                                world.setBlock(x, y, z, SHHelper.getHeatVisionResult(block, x));
//                            }
//                        }
//                    } else if (mop.entityHit != null) {
//                        mop.entityHit.attackEntityFrom(ModDamageSources.causeBurnDamage(ep), 7.0F);
//                    }
//                }
//            }
//        }
//    }
//
//    public void menu(EntityPlayer ep) {
//        if (SHHelper.getHero(ep).hasAbility(Abilities.vibe) && Vibe.getVibeing(ep).getIsKeyPressed()) {
//            ep.openGui(SuperheroesAddon.instance, GUIHandler.VIBE_GUI_ID, ep.worldObj, (int) ep.posX,(int) ep.posY, (int) ep.posZ);
//        }
//    }
//
//    public void phase(EntityPlayer ep) {
//        if ((ep.noClip) || (ep.motionY == 0.0D) || ((ep.onGround) && (!KeybindManager.phase.isPressed()))) {
//            ep.noClip = false;
//            ep.onGround = true;
//            if (SuperheroesAddon.motionYs.containsKey(ep.getUniqueID())) {
//                ep.motionY = SuperheroesAddon.motionYs.get(ep.getUniqueID());
//                SuperheroesAddon.motionYs.remove(ep.getUniqueID());
//            }
//        }
//        if (KeybindManager.phase.getIsKeyPressed()) {
//            int blockX = MathHelper.floor_double(ep.posX);
//            int blockY = MathHelper.floor_double(ep.posY-0.2D - (double)ep.yOffset);
//            int blockZ = MathHelper.floor_double(ep.posZ);
//            int speedLevel = (SHData.getInt(ep, SHData.SPEED) - 1);
//            if (!ep.onGround) {
//                return;
//            }
//            if (ep.worldObj.isAirBlock(blockX, blockY, blockZ)) {
//                return;
//            }
//            if ((SHHelper.canRunSuperSpeed(ep)) && speedLevel >= 7) {
//                SuperheroesAddon.motionYs.put(ep.getUniqueID(), ep.motionY);
//                ep.noClip = true;
//                ep.motionY = 0.0D;
//                ep.onGround = true;
//            }
//        }
//    }
//
////    public void lightningThrow(EntityPlayer ep) {
////                    if (SHHelper.isPlayerSpeedster(ep)) {
////                if (SHKeyBinds.keyBindingAbility3.isPressed()) {
////                    if (!Utils.getCooldowns().containsKey(ep)) {
////
////                        Vec3 v1 = Vec3.createVectorHelper(-10.6F, 0, 0);
////                        Vec3 v2 = v1.v1.rotateAroundX(-ep.rotationYaw * (float) Math.PI / 180F);
////                for (int i = 0; i < 3; i++)
////                    ep.worldObj.spawnEntityInWorld(new EntityLightning(ep.worldObj, ep, ep.posX + v1.xCoord, ep.posY + (ep.height / 1.8F) * 0.8F, ep.posZ + v1.zCoord));
////                    }
////
////                    long cooldown = System.currentTimeMillis() + (10 * 1000);
////                    Utils.getCooldowns().put(ep, cooldown);
////                    }
////                }
////            }
////    }
//
//    public void claws(EntityPlayer ep) {
//        if (SHHelper.getHero(ep) == null) return;
//        if (SHHelper.getHero(ep).hasAbility(Abilities.claws)) {
//            if (SHKeyBinds.keyBindingAbility2.isPressed()) {
//                Wolverine.claws = true;
//            } else {
//                Wolverine.claws = false;
//            }
//        }
//    }
//
//    public void grow(EntityPlayer ep) {
//        if (SHHelper.getHero(ep) instanceof ISizeManipulation) {
//        }
//    }
//
//    public void spawnsavitar(EntityPlayer ep) {
//        if (SHHelper.getHero(ep) instanceof Savitar) {
//            if (SHKeyBinds.keyBindingAbility5.getIsKeyPressed()) {
//                Utils.savitarsuit(ep);
//            }
//        }
//    }
//
//    public int wingdingCooldown(EntityPlayer ep) {
//        Date current = new Date();
//        Date dan = new Date(cooldowns.get(ep));
//        return (int) (dan.getTime() - current.getTime()) / 1000;
//    }
//
//    public void wingding(EntityPlayer ep) {
//        if (SHHelper.getHero(ep) instanceof Nightwing) {
//            if (SHKeyBinds.keyBindingAbility1.getIsKeyPressed()) {
//                if (cooldowns.containsKey(ep)) {
//                    long l = cooldowns.get(ep);
//                    if (System.currentTimeMillis() >= l) {
//                        EntityWingding wingding = new EntityWingding(ep.worldObj, ep);
//                        ep.worldObj.spawnEntityInWorld(wingding);
//                        cooldowns.remove(ep);
//                        long newTime = System.currentTimeMillis() + (1000 * 3);
//                        cooldowns.put(ep, newTime);
//                        return;
//                    } ep.addChatMessage(new ChatComponentText("§cYou still have an cooldown of " + wingdingCooldown(ep) + "s!"));
//                    return;
//                }
//                EntityWingding wingding = new EntityWingding(ep.worldObj, ep);
//                ep.worldObj.spawnEntityInWorld(wingding);
//                long newTime = System.currentTimeMillis() + (1000 * 3);
//                cooldowns.put(ep, newTime);
//                return;
//            }
//        }
//    }
//
//    @SubscribeEvent
//    public void input(InputEvent.KeyInputEvent e) {
//        EntityPlayer ep = Minecraft.getMinecraft().thePlayer;
//        if (SHHelper.getHero(ep) == null) return;
////        claws(ep);
//        wingding(ep);
////        menu(ep);
//    }
//
//    @SubscribeEvent
//    public void living(LivingEvent.LivingUpdateEvent e) {
//        if (e.entity instanceof EntityPlayer) {
//            EntityPlayer ep = (EntityPlayer) e.entity;
//            if (SHHelper.getHero(ep) == null) return;
//            coldbreath(ep);
//            beam(ep);
//            phase(ep);
//            spawnsavitar(ep);
////            vibe(ep);
//            spiderSense(ep);
//        }
//    }
//
//    public void teleportGui(EntityPlayer ep) {
////        ep.openGui(SuperheroesAddon.instance, 3, ep.worldObj, ep.x, ep.posY, ep.posZ);
//    }
//
//    public void vibe(EntityPlayer ep) {
//        if (SHHelper.getHero(ep).hasAbility(Abilities.vibeEnergy)) {
//            if (Vibe.getVibeKey(ep).getIsKeyPressed()) {
//                if (!ep.worldObj.isRemote) {
//                    ep.worldObj.spawnEntityInWorld(new EntityCanaryCry(ep.worldObj, ep));
//                }
//            }
//        }
//    }
//
//    public static void slingWeb(EntityPlayer ep) {
//        ep.worldObj.spawnEntityInWorld(new SlingEntity(ep.worldObj, ep, 8.0F));
//    }
//
//    public void spiderSense(EntityPlayer ep) {
//        List<EntityMob> list = ep.worldObj.getEntitiesWithinAABB(EntityMob.class, AxisAlignedBB.getBoundingBox(ep.posX - 3, ep.posY - 3, ep.posZ - 3, ep.posX + 3, ep.posY + 3, ep.posZ + 3));
//        if (!list.isEmpty()) {
//            if (SHHelper.getHero(ep).hasAbility(Abilities.spiderSense)) {
////                ep.worldObj.getGameRules().setOrCreateGameRule("");
//                if (ep.worldObj.isRemote) {
//                    TimeHelper.updateClientTickrate(4.0F);
//                    Tickrate.updateClientTickrate(4.0F);
//                }
//            }
//        }
//    }
//
//    @SubscribeEvent
//    public void interact(PlayerInteractEvent e) {
//        EntityPlayer ep = e.entityPlayer;
//
//        if (e.action == PlayerInteractEvent.Action.RIGHT_CLICK_AIR) {
//            if (SHHelper.getHero(ep) == null) return;
//            if (SHHelper.getHero(ep) instanceof IWebSlinger) {
//                slingWeb(ep);
//                e.setCanceled(true);
//                return;
//            }
//        }
//    }
//
//    @SubscribeEvent
//    public void fall(LivingFallEvent e) {
//        if (e.entity instanceof EntityPlayer) {
//            EntityPlayer ep = (EntityPlayer) e.entity;
//            if (SHHelper.getHero(ep) == null) return;
//            if (SHHelper.getHero(ep) instanceof Superman) {
//                e.setCanceled(true);
//            }
//            else if (SHHelper.getHero(ep) instanceof Spiderman) {
//                e.setCanceled(true);
//            }
//        }
//    }
//
//    @SubscribeEvent
//    public void dmg(LivingHurtEvent e) {
//        if (e.entity instanceof EntityPlayer) {
//            if (KeybindManager.phase.getIsKeyPressed() && e.source.equals(DamageSource.inWall)) {
//                e.setCanceled(true);
//                e.setResult(Event.Result.DENY);
//            }
//        }
//    }
//
//    @SubscribeEvent
//    public void jump(LivingEvent.LivingJumpEvent e) {
//        if (e.entity instanceof EntityPlayer) {
//            EntityPlayer ep = (EntityPlayer) e.entity;
//            if (KeybindManager.phase.getIsKeyPressed() && SHHelper.canRunSuperSpeed(ep) && SHData.getInt(ep, 1) >= 7) {
//                if (SuperheroesAddon.motionYs.containsKey(ep.getUniqueID())) {
//                    ep.motionY = 0;
//                    ep.setJumping(false);
//                }
//            }
//        }
//    }
//
//
}
