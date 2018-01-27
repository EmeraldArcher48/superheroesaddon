package me.imrandoet.superheroesaddon.common.heroes;

import fiskfille.heroes.common.ability.Ability;
import fiskfille.heroes.common.ability.IAbilityContainer;
import fiskfille.heroes.common.entity.attribute.IAttributeContainer;
import fiskfille.heroes.common.entity.attribute.SHAttributes;
import fiskfille.heroes.common.hero.*;
import fiskfille.heroes.common.item.armor.ItemHeroArmor;
import fiskfille.heroes.common.keybinds.SHKeyBinding;
import fiskfille.heroes.common.keybinds.SHKeyBinds;
import me.imrandoet.superheroesaddon.SuperheroesAddon;
import me.imrandoet.superheroesaddon.common.abilities.Abilities;
import me.imrandoet.superheroesaddon.common.abilities.weakness.Weaknesses;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

/**
 * Created by ImranDoet on 16-6-2017.
 */
public class Superman extends Hero implements IHeatVision, IAbility {

    @Override
    public void init() {
        this.chestplate = new ItemHeroArmor(this, ItemHeroArmor.ArmorType.CHESTPIECE).setCreativeTab(SuperheroesAddon.tab);
        this.leggings = new ItemHeroArmor(this, ItemHeroArmor.ArmorType.LEGGINGS).setCreativeTab(SuperheroesAddon.tab);
        this.boots = new ItemHeroArmor(this, ItemHeroArmor.ArmorType.BOOTS).setCreativeTab(SuperheroesAddon.tab);
    }

    @Override
    public int getTier() {
        return 5;
    }

    @Override
    public ItemHeroArmor.ArmorVersion getVersion() {
        return ItemHeroArmor.ArmorVersion.DCEU;
    }

    @Override
    public SHKeyBinding getHeatVisionKey() {
        return SHKeyBinds.ABILITY_5;
    }

    @Override
    public int getHeatVisionColor(EntityLivingBase entityLivingBase) {
        return 16711680;
    }

    @Override
    public void getAbilities(IAbilityContainer abilities) {
        abilities.add(this, Ability.COLD_RESISTANCE);
        abilities.add(this, Ability.HEAT_RESISTANCE);
        abilities.add(this, Ability.HEAT_VISION);
        abilities.add(this, Abilities.FLIGHT);
        abilities.add(this, Weaknesses.HIGH_PITCH);
        abilities.add(this, Abilities.COLD_BREATH);
        abilities.add(this, Abilities.LEAD_SIGHT);
    }

    @Override
    public void getAttributeModifiers(IAttributeContainer attributes, ItemStack itemstack) {
        super.getAttributeModifiers(attributes, itemstack);
        attributes.add(SHAttributes.SPRINT_SPEED, 0.5D, 0);
        attributes.add(SHAttributes.PUNCH_DAMAGE, 5.0D, 0);
        attributes.add(SHAttributes.JUMP_HEIGHT, 1.5D, 0);
        attributes.add(SHAttributes.FALL_RESISTANCE, 1.0D, 1);
    }

    //    @Override
//    public int getTier() {
//        return 5;
//    }
//
//    @Override
//    public String getName() {
//        return "Superman";
//    }
//
//    @Override
//    public Item getHelmet() {
//        return null;
//    }
//
//    @Override
//    public Item getChestplate() {
//        return ModItems.suChest;
//    }
//
//    @Override
//    public Item getLeggings() {
//        return ModItems.suLeg;
//    }
//
//    @Override
//    public Item getBoots() {
//        return ModItems.suBoot;
//    }
//
//    @Override
//    public Ability[] getAbilities() {
//        return new Ability[]{Ability.coldResistance, Ability.heatResistance, Ability.heatVision, Abilities.coldBreath, Abilities.flight};
//    }
//
//    @Override
//    public void onUpdate(EntityPlayer player, TickEvent.Phase phase) {
//        super.onUpdate(player, phase);
//    }
//
//    public SHKeyBinding getColdbreathKey(EntityPlayer entityPlayer) { return SHKeyBinds.keyBindingAbility4; }
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
}
