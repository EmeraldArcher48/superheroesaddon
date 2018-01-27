package me.imrandoet.superheroesaddon.common.heroes;

import fiskfille.heroes.common.ability.Ability;
import fiskfille.heroes.common.ability.IAbilityContainer;
import fiskfille.heroes.common.entity.attribute.IAttributeContainer;
import fiskfille.heroes.common.entity.attribute.SHAttributes;
import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.common.item.armor.ItemHeroArmor;
import me.imrandoet.superheroesaddon.SuperheroesAddon;
import me.imrandoet.superheroesaddon.common.abilities.Abilities;
import me.imrandoet.superheroesaddon.common.abilities.interfaces.IWebSlinging;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

/**
 * Created by ImranDoet on 12-6-2017.
 */
public class Spiderman extends Hero implements IWebSlinging {

    @Override
    public void init() {
        this.helmet = new ItemHeroArmor(this, ItemHeroArmor.ArmorType.MASK).setCreativeTab(SuperheroesAddon.tab);
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
        return ItemHeroArmor.ArmorVersion.MCU;
    }

    @Override
    public boolean hasProperty(EntityLivingBase entity, Property property) {
        if (property == Property.MASK_TOGGLE) return true;
        else return false;
    }

    @Override
    public void getAbilities(IAbilityContainer abilities) {
        super.getAbilities(abilities);
        abilities.add(this, Abilities.WEB_SLINGING);
        abilities.add(this, Abilities.WALL_CLIMB);
        abilities.add(this, Ability.GLIDING);
        abilities.add(this, Abilities.SPIDER_SENSE);
    }

    @Override
    public void getAttributeModifiers(IAttributeContainer attributes, ItemStack itemstack) {
        super.getAttributeModifiers(attributes, itemstack);
        attributes.add(SHAttributes.PUNCH_DAMAGE, 4.0D, 0);
        attributes.add(SHAttributes.SPRINT_SPEED, 0.5D, 1);
        attributes.add(SHAttributes.JUMP_HEIGHT, 4.0D, 0);
        attributes.add(SHAttributes.FALL_RESISTANCE, 12.0D, 0);
        attributes.add(SHAttributes.STEP_HEIGHT, 1.0D, 0);

    }

    //    public boolean toggleMask(EntityPlayer player, boolean state) {
//        return true;
//    }
//
//    public static SHKeyBinding getWallKey(EntityPlayer entityPlayer) { return SHKeyBinds.keyBindingAbility2; }
//
//    @Override
//    public int getTier() {
//        return 4;
//    }
//
//    @Override
//    public String getName() {
//        return "Spiderman";
//    }
//
//    @Override
//    public Item getHelmet() {
//        return ModItems.spHat;
//    }
//
//    @Override
//    public Item getChestplate() {
//        return ModItems.spChest;
//    }
//
//    @Override
//    public Item getLeggings() {
//        return ModItems.spLeg;
//    }
//
//    @Override
//    public Item getBoots() {
//        return ModItems.spBoot;
//    }
//
//    @Override
//    public Ability[] getAbilities() {
//        return new Ability[]{Ability.gliding, Abilities.webSling, Abilities.wallClimb, Abilities.spiderSense};
//    }
}
