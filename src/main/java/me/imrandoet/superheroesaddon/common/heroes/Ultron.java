package me.imrandoet.superheroesaddon.common.heroes;

import fiskfille.heroes.common.ability.Ability;
import fiskfille.heroes.common.ability.IAbilityContainer;
import fiskfille.heroes.common.data.SHData;
import fiskfille.heroes.common.entity.attribute.IAttributeContainer;
import fiskfille.heroes.common.entity.attribute.SHAttributes;
import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.common.hero.IAiming;
import fiskfille.heroes.common.hero.IHovering;
import fiskfille.heroes.common.hero.IIronMan;
import fiskfille.heroes.common.item.armor.ItemHeroArmor;
import fiskfille.heroes.common.keybinds.SHKeyBinding;
import fiskfille.heroes.common.keybinds.SHKeyBinds;
import fiskfille.heroes.common.weakness.Weakness;
import me.imrandoet.superheroesaddon.SuperheroesAddon;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

/**
 * Created by ImranDoet on 11-6-2017.
 */
public class Ultron extends Hero implements IAiming, IHovering {

    public void init() {
        this.helmet = new ItemHeroArmor(this, ItemHeroArmor.ArmorType.HELMET).setCreativeTab(SuperheroesAddon.tab);
        this.chestplate = new ItemHeroArmor(this, ItemHeroArmor.ArmorType.CHESTPLATE).setCreativeTab(SuperheroesAddon.tab);
        this.leggings = new ItemHeroArmor(this, ItemHeroArmor.ArmorType.LEGGINGS).setCreativeTab(SuperheroesAddon.tab);
        this.boots = new ItemHeroArmor(this, ItemHeroArmor.ArmorType.BOOTS).setCreativeTab(SuperheroesAddon.tab);
    }

    public int getTier() {
        return 4;
    }

    public ItemHeroArmor.ArmorVersion getVersion() {
        return ItemHeroArmor.ArmorVersion.MCU;
    }

    public SHKeyBinding getAimKey() {
        return SHKeyBinds.ABILITY_1;
    }

    public SHKeyBinding getHoverKey() {
        return SHKeyBinds.ABILITY_2;
    }

    public boolean canAim(EntityPlayer player, ItemStack heldItem) {
        return heldItem == null && !SHData.JETPACKING.get(player);
    }

    public boolean hasProperty(EntityLivingBase entity, Property property) {
        switch(property) {
            case BREATHE_UNDERWATER:
                return !SHData.MASK_OPEN.get(entity);
            case BREATHE_SPACE:
                return !SHData.MASK_OPEN.get(entity);
            default:
                return super.hasProperty(entity, property);
        }
    }

    public void getAbilities(IAbilityContainer abilities) {
        abilities.add(this, Ability.PROPELLED_FLIGHT);
        abilities.add(this, Ability.REPULSOR_BLAST);
        abilities.add(this, Ability.HOVER);
        abilities.add(this, Weakness.METAL_SKIN);
        abilities.add(this, Weakness.HEAT);
    }

    public void getAttributeModifiers(IAttributeContainer attributes, ItemStack itemstack) {
        super.getAttributeModifiers(attributes, itemstack);
        attributes.add(SHAttributes.ATTACK_DAMAGE, 1.2D, 1);
        attributes.add(SHAttributes.DAMAGE_REDUCTION, 1.0D, 0);
        attributes.add(SHAttributes.PUNCH_DAMAGE, 6.5D, 0);
    }

//    @Override
//    public boolean toggleMask(EntityPlayer player, boolean state) {
//        return false;
//    }
//
//    @Override
//    public float getDefaultScale(EntityPlayer player) {
//        return 1.1F;
//    }
//
//    @Override
//    public int getTier() {
//        return 4;
//    }
//
//    @Override
//    public String getName() {
//        return "Ultron";
//    }
//
//    @Override
//    public Item getHelmet() {
//        return ModItems.uHat;
//    }
//
//    @Override
//    public Item getChestplate() {
//        return ModItems.uChest;
//    }
//
//    @Override
//    public Item getLeggings() {
//        return ModItems.uLeg;
//    }
//
//    @Override
//    public Item getBoots() {
//        return ModItems.uBoot;
//    }
//
//    @Override
//    public SHKeyBinding getAimKey(EntityPlayer entityPlayer) {
//        return SHKeyBinds.keyBindingAbility1;
//    }
//
//    @Override
//    public String getAimTranslationKey() {
//        return "key.aim";
//    }
//
//    @Override
//    public SHKeyBinding getHoverKey(EntityPlayer entityPlayer) {
//        return SHKeyBinds.keyBindingAbility2;
//    }
//
//    @Override
//    public Ability[] getAbilities() {
//        return new Ability[]{Ability.flight1, Ability.repulsorBlast, Ability.hover};
//    }
//
//    @Override
//    public boolean canBreatheInSpace(EntityPlayer player) {
//        return !SHData.getBoolean(player, 7);
//    }
//
//    @Override
//    public boolean canBreatheUnderwater(EntityPlayer player) {
//        return !SHData.getBoolean(player, 7);
//    }

}
