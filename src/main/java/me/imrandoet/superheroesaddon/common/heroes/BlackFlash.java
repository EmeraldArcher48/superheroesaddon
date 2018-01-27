package me.imrandoet.superheroesaddon.common.heroes;

import fiskfille.heroes.client.trail.TrailType;
import fiskfille.heroes.common.entity.attribute.IAttributeContainer;
import fiskfille.heroes.common.entity.attribute.SHAttributes;
import fiskfille.heroes.common.hero.ISuperSpeed;
import fiskfille.heroes.common.item.armor.ItemHeroArmor;
import me.imrandoet.superheroesaddon.SuperheroesAddon;
import net.minecraft.item.ItemStack;

/**
 * Created by ImranDoet on 22-11-2017.
 */

public class BlackFlash extends ISuperSpeed.Impl {

    @Override
    public void init() {
        this.helmet = new ItemHeroArmor(this, ItemHeroArmor.ArmorType.MASK);
        this.chestplate = new ItemHeroArmor(this, ItemHeroArmor.ArmorType.CHESTPIECE);
        this.leggings = new ItemHeroArmor(this, ItemHeroArmor.ArmorType.PANTS);
        this.boots = new ItemHeroArmor(this, ItemHeroArmor.ArmorType.BOOTS);
    }

    @Override
    public int getTier() {
        return 3;
    }

    @Override
    public boolean isHidden() {
        return true;
    }

    @Override
    public ItemHeroArmor.ArmorVersion getVersion() {
        return ItemHeroArmor.ArmorVersion.DCTV;
    }

    @Override
    public TrailType getTrailType() {
        return TrailType.LIGHTNINGS_RED;
    }

    public void getAttributeModifiers(IAttributeContainer attributes, ItemStack itemstack) {
        super.getAttributeModifiers(attributes, itemstack);
        attributes.add(SHAttributes.BASE_SPEED_LEVELS, 4.0D, 0);
        attributes.add(SHAttributes.PUNCH_DAMAGE, 2.0D, 0);
        attributes.add(SHAttributes.JUMP_HEIGHT, 1.0D, 0);
        attributes.add(SHAttributes.FALL_RESISTANCE, 5.0D, 0);
    }

}
