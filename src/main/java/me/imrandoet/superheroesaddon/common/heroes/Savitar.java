package me.imrandoet.superheroesaddon.common.heroes;

import cpw.mods.fml.common.gameevent.TickEvent;
import fiskfille.heroes.client.trail.TrailType;
import fiskfille.heroes.common.entity.attribute.IAttributeContainer;
import fiskfille.heroes.common.entity.attribute.SHAttributes;
import fiskfille.heroes.common.hero.ISuperSpeed;
import fiskfille.heroes.common.item.armor.ItemHeroArmor;
import fiskfille.heroes.helper.SHRenderHelper;
import fiskfille.heroes.helper.SpeedsterHelper;
import me.imrandoet.superheroesaddon.SuperheroesAddon;
import me.imrandoet.superheroesaddon.client.Trails;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

/**
 * Created by ImranDoet on 4-6-2017.
 */

public class Savitar extends ISuperSpeed.Impl {

    public Savitar() {}

    @Override
    public void init() {
        this.helmet = new ItemHeroArmor(this, ItemHeroArmor.ArmorType.HELMET).setCreativeTab(SuperheroesAddon.tab);
        this.chestplate = new ItemHeroArmor(this, ItemHeroArmor.ArmorType.CHESTPIECE).setCreativeTab(SuperheroesAddon.tab);
        this.leggings = new ItemHeroArmor(this, ItemHeroArmor.ArmorType.LEGGINGS).setCreativeTab(SuperheroesAddon.tab);
        this.boots = new ItemHeroArmor(this, ItemHeroArmor.ArmorType.BOOTS).setCreativeTab(SuperheroesAddon.tab);
    }

    @Override
    public int getTier() {
        return 4;
    }

    @Override
    public ItemHeroArmor.ArmorVersion getVersion() {
        return ItemHeroArmor.ArmorVersion.DCTV;
    }

    @Override
    public TrailType getTrailType() {
        return Trails.lightblue;
    }

    @Override
    public void onUpdate(EntityPlayer player, TickEvent.Phase phase) {
        super.onUpdate(player, phase);

        if (phase == TickEvent.Phase.START && player.worldObj.isRemote && SpeedsterHelper.hasSuperSpeed(player) && Math.random() < 0.4D) {
            SHRenderHelper.doLightningAura(player);
        }
    }

    @Override
    public float getDefaultScale(EntityPlayer player) {
        return 1.5F;
    }

    @Override
    public void getAttributeModifiers(IAttributeContainer attributes, ItemStack itemstack) {
        super.getAttributeModifiers(attributes, itemstack);
        attributes.add(SHAttributes.BASE_SPEED_LEVELS, 10.0D, 0);
        attributes.add(SHAttributes.PUNCH_DAMAGE, 3.0D, 0);
        attributes.add(SHAttributes.JUMP_HEIGHT, 1.0D, 0);
        attributes.add(SHAttributes.FALL_RESISTANCE, 5.0D, 0);
    }

    //    @Override
//    public int getTier() {
//        return 4;
//    }
//
//    @Override
//    public float getDefaultScale(EntityPlayer player) {
//        return 1.5F;
//    }
//
//    @Override
//    public void onUpdate(EntityPlayer player, TickEvent.Phase phase) {
//        super.onUpdate(player, phase);
//        if (FMLCommonHandler.instance().getSide().isClient()) {
//            if (SHHelper.canRunSuperSpeed(player) && SHData.getInt(player, 1) >= 0 && Math.random() < 0.4D && phase == TickEvent.Phase.START) {
//                SHRenderHelper.doLightningAura(player);
//            }
//        }
//    }
//
//    @Override
//    public String getName() {
//        return "Savitar";
//    }
//
//    @Override
//    public Item getHelmet() {
//        return ModItems.sHat;
//    }
//
//    @Override
//    public Item getChestplate() {
//        return ModItems.sChest;
//    }
//
//    @Override
//    public Item getLeggings() {
//        return ModItems.sLeg;
//    }
//
//    @Override
//    public Item getBoots() {
//        return ModItems.sBoot;
//    }
//
//    @Override
//    public TrailType getTrailType() {
//        return Trails.lightblue;
//    }
}
