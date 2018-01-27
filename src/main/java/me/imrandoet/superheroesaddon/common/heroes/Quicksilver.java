package me.imrandoet.superheroesaddon.common.heroes;

import com.google.common.collect.Lists;
import fiskfille.heroes.client.trail.TrailType;
import fiskfille.heroes.common.entity.attribute.IAttributeContainer;
import fiskfille.heroes.common.entity.attribute.SHAttributes;
import fiskfille.heroes.common.hero.ISuperSpeed;
import fiskfille.heroes.common.item.armor.ItemHeroArmor;
import me.imrandoet.superheroesaddon.SuperheroesAddon;
import me.imrandoet.superheroesaddon.client.Trails;
import net.minecraft.item.ItemStack;

import java.util.List;

/**
 * Created by ImranDoet on 11-6-2017.
 */
public class Quicksilver extends ISuperSpeed.Impl {

    @Override
    public List getEquipment() {
        return Lists.newArrayList();
    }

    @Override
    public void init() {
        this.chestplate = new ItemHeroArmor(this, ItemHeroArmor.ArmorType.TORSO).setCreativeTab(SuperheroesAddon.tab);
        this.leggings = new ItemHeroArmor(this, ItemHeroArmor.ArmorType.LEGGINGS).setCreativeTab(SuperheroesAddon.tab);
        this.boots = new ItemHeroArmor(this, ItemHeroArmor.ArmorType.BOOTS).setCreativeTab(SuperheroesAddon.tab);
    }

    @Override
    public int getTier() {
        return 1;
    }

    @Override
    public ItemHeroArmor.ArmorVersion getVersion() {
        return ItemHeroArmor.ArmorVersion.MCU;
    }

    @Override
    public TrailType getTrailType() {
        return Trails.none;
    }

    @Override
    public void getAttributeModifiers(IAttributeContainer attributes, ItemStack itemstack) {
        super.getAttributeModifiers(attributes, itemstack);
        attributes.add(SHAttributes.BASE_SPEED_LEVELS, 3.0D, 0);
        attributes.add(SHAttributes.SWORD_DAMAGE, 4.0D, 0);
        attributes.add(SHAttributes.PUNCH_DAMAGE, 3.0D, 0);
        attributes.add(SHAttributes.JUMP_HEIGHT, 1.0D, 0);
        attributes.add(SHAttributes.FALL_RESISTANCE, 9.0D, 0);

    }

    //    @Override
//    public TrailType getTrailType() {
//        return new TrailType("transparent").setTrailColor(0x7ee5dc).setMirageColor(255,255,255);
//    }
//
//    @Override
//    public int getTier() {
//        return 1;
//    }
//
//    @Override
//    public String getName() {
//        return "Quicksilver";
//    }
//
//    @Override
//    public void onUpdate(EntityPlayer ep, TickEvent.Phase ph) {
//        super.onUpdate(ep, ph);
//
////        if (ep.moveForward != 0 || ep.moveStrafing != 0) {
////            World w = ep.worldObj;
////            int i = new Random().nextInt(10) / 10;
////            w.spawnParticle("reddust", ep.playerLocation.posX, (double) ep.playerLocation.posY - i, ep.playerLocation.posZ, 0.0D, 0.0D, 0.0D);
////        }
//    }
//
//    @Override
//    public Item getHelmet() {
//        return null;
//    }
//
//    @Override
//    public Item getChestplate() {
//        return ModItems.qsChest;
//    }
//
//    @Override
//    public Item getLeggings() {
//        return ModItems.qsLeg;
//    }
//
//    @Override
//    public Item getBoots() {
//        return ModItems.qsBoot;
//    }
}
