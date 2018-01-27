package me.imrandoet.superheroesaddon.common.heroes;

import fiskfille.heroes.common.ability.Ability;
import fiskfille.heroes.common.ability.IAbilityContainer;
import fiskfille.heroes.common.entity.attribute.IAttributeContainer;
import fiskfille.heroes.common.entity.attribute.SHAttributes;
import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.common.item.armor.ItemHeroArmor;
import me.imrandoet.superheroesaddon.SuperheroesAddon;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

/**
 * Created by ImranDoet on 18-6-2017.
 */
public class WinterSoldier extends Hero {
    @Override
    public void init() {
        this.helmet = new ItemHeroArmor(this, ItemHeroArmor.ArmorType.COWL).setCreativeTab(SuperheroesAddon.tab);
        this.chestplate = new ItemHeroArmor(this, ItemHeroArmor.ArmorType.CHESTPLATE).setCreativeTab(SuperheroesAddon.tab);
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
    public void getAbilities(IAbilityContainer abilities) {
        abilities.add(this, Ability.CELLULAR_REGENERATION);
        abilities.add(this, Ability.ENHANCED_REFLEXES);
        abilities.add(this, Ability.SUPERHUMAN_DURABILITY);
    }

    public boolean hasPermission(EntityLivingBase entity, Permission permission) {
        return permission == Permission.THROW_SHIELD || permission == Permission.USE_SHIELD || super.hasPermission(entity, permission);
    }

    @Override
    public void getAttributeModifiers(IAttributeContainer attributes, ItemStack itemstack) {
        super.getAttributeModifiers(attributes, itemstack);
        attributes.add(SHAttributes.PUNCH_DAMAGE, 5.5D, 0);
        attributes.add(SHAttributes.ATTACK_DAMAGE, 1.4D, 1);
        attributes.add(SHAttributes.JUMP_HEIGHT, 3.3D, 0);
        attributes.add(SHAttributes.FALL_RESISTANCE, 7.0D, 0);
        attributes.add(SHAttributes.SPRINT_SPEED, 0.6D, 1);
    }

    //    @Override
//    public int getTier() {
//        return 4;
//    }
//
//    @Override
//    public String getName() {
//        return "The Winter Soldier";
//    }
//
//    @Override
//    public Item getHelmet() {
//        return ModItems.wHat;
//    }
//
//    @Override
//    public Item getChestplate() {
//        return ModItems.wChest;
//    }
//
//    @Override
//    public Item getLeggings() {
//        return ModItems.wLeg;
//    }
//
//    @Override
//    public Item getBoots() {
//        return ModItems.wBoot;
//    }
//
//    public Ability[] getAbilities() {
//        return new Ability[]{Ability.regeneration1, Ability.enhancedReflexes};
//    }
}
