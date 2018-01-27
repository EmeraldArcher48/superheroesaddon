package me.imrandoet.superheroesaddon.common.heroes;

import fiskfille.heroes.common.ability.IAbilityContainer;
import fiskfille.heroes.common.entity.attribute.IAttributeContainer;
import fiskfille.heroes.common.entity.attribute.SHAttributes;
import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.common.item.armor.ItemHeroArmor;
import fiskfille.heroes.common.keybinds.SHKeyBinding;
import fiskfille.heroes.common.keybinds.SHKeyBinds;
import me.imrandoet.superheroesaddon.SuperheroesAddon;
import me.imrandoet.superheroesaddon.common.abilities.Abilities;
import me.imrandoet.superheroesaddon.common.abilities.interfaces.IEnergyBeam;
import net.minecraft.item.ItemStack;

/**
 * Created by ImranDoet on 1-7-2017.
 */
public class Cyclops extends Hero implements IEnergyBeam {

    @Override
    public void init() {
        this.helmet = new ItemHeroArmor(this, ItemHeroArmor.ArmorType.GOGGLES).setCreativeTab(SuperheroesAddon.tab);
        this.chestplate = new ItemHeroArmor(this, ItemHeroArmor.ArmorType.CHESTPLATE).setCreativeTab(SuperheroesAddon.tab);
        this.leggings = new ItemHeroArmor(this, ItemHeroArmor.ArmorType.LEGGINGS).setCreativeTab(SuperheroesAddon.tab);
        this.boots = new ItemHeroArmor(this, ItemHeroArmor.ArmorType.BOOTS).setCreativeTab(SuperheroesAddon.tab);
    }

    @Override
    public int getTier() {
        return 2;
    }

    @Override
    public ItemHeroArmor.ArmorVersion getVersion() {
        return ItemHeroArmor.ArmorVersion.XMEN;
    }

//    @Override
//    public int getHeatVisionColor(EntityLivingBase entityLivingBase) {
//        return 16711680;
//    }

    @Override
    public void getAbilities(IAbilityContainer abilities) {
        super.getAbilities(abilities);
        abilities.add(this, Abilities.ENERGY_BEAM);
    }

    @Override
    public void getAttributeModifiers(IAttributeContainer attributes, ItemStack itemstack) {
        super.getAttributeModifiers(attributes, itemstack);
        attributes.add(SHAttributes.PUNCH_DAMAGE, 4.0D, 0);
        attributes.add(SHAttributes.ATTACK_DAMAGE, 0.4D, 1);
        attributes.add(SHAttributes.FALL_RESISTANCE, 3.0D, 0);
    }

    @Override
    public SHKeyBinding getEergyBeamKey() {
        return SHKeyBinds.ABILITY_5;
    }

    //    @Override
//    public int getTier() {
//        return 2;
//    }
//
//    @Override
//    public String getName() {
//        return "Cyclops";
//    }
//
//    @Override
//    public Item getHelmet() {
//        return ModItems.cHat;
//    }
//
//    @Override
//    public Item getChestplate() {
//        return ModItems.cHest;
//    }
//
//    @Override
//    public Item getLeggings() {
//        return ModItems.cLeg;
//    }
//
//    @Override
//    public Item getBoots() {
//        return ModItems.cBoot;
//    }
//
//    @Override
//    public SHKeyBinding getHeatVisionKey(EntityPlayer entityPlayer) {
//        return SHKeyBinds.keyBindingAbility5;
//    }
//
//    @Override
//    public Color getHeatVisionColor(EntityPlayer entityPlayer) {
//        return Color.RED;
//    }
//
//    @Override
//    public Ability[] getAbilities() {
//        return new Ability[]{Abilities.energyBeam};
//    }
}
