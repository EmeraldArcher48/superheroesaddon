package me.imrandoet.superheroesaddon.common.heroes;

import fiskfille.heroes.client.trail.TrailType;
import fiskfille.heroes.common.entity.attribute.IAttributeContainer;
import fiskfille.heroes.common.entity.attribute.SHAttributes;
import fiskfille.heroes.common.hero.ISuperSpeed;
import fiskfille.heroes.common.item.armor.ItemHeroArmor;
import me.imrandoet.superheroesaddon.SuperheroesAddon;
import me.imrandoet.superheroesaddon.client.Trails;
import net.minecraft.item.ItemStack;

/**
 * Created by ImranDoet on 4-6-2017.
 */
public class ACMan extends ISuperSpeed.Impl {

    public ACMan() {}

    @Override
    public void init() {
        this.helmet = new ItemHeroArmor(this, ItemHeroArmor.ArmorType.MASK).setCreativeTab(SuperheroesAddon.tab);
        this.chestplate = new ItemHeroArmor(this, ItemHeroArmor.ArmorType.CHESTPIECE).setCreativeTab(SuperheroesAddon.tab);
        this.leggings = new ItemHeroArmor(this, ItemHeroArmor.ArmorType.PANTS).setCreativeTab(SuperheroesAddon.tab);
        this.boots = new ItemHeroArmor(this, ItemHeroArmor.ArmorType.BOOTS).setCreativeTab(SuperheroesAddon.tab);
    }

    @Override
    public int getTier() {
        return 3;
    }

    @Override
    public ItemHeroArmor.ArmorVersion getVersion() {
        return ItemHeroArmor.ArmorVersion.DCTV;
    }

    @Override
    public TrailType getTrailType() {
        return Trails.purple;
    }

    public void getAttributeModifiers(IAttributeContainer attributes, ItemStack itemstack) {
        super.getAttributeModifiers(attributes, itemstack);
        attributes.add(SHAttributes.BASE_SPEED_LEVELS, 4.0D, 0);
        attributes.add(SHAttributes.PUNCH_DAMAGE, 3.0D, 0);
        attributes.add(SHAttributes.JUMP_HEIGHT, 1.0D, 0);
        attributes.add(SHAttributes.FALL_RESISTANCE, 7.0D, 0);
    }


//    @Override
//    public int getTier() {
//        return 3;
//    }
//
//    @Override
//    public String getName() {
//        return "Accelerated Man";
//    }
//
//    @Override
//    public Item getHelmet() {
//        return ModItems.acHat;
//    }
//
//    @Override
//    public Item getChestplate() {
//        return ModItems.acChest;
//    }
//
//    @Override
//    public Item getLeggings() {
//        return ModItems.acLeg;
//    }
//
//    @Override
//    public Item getBoots() {
//        return ModItems.acBoot;
//    }
//
//    @Override
//    public TrailType getTrailType() {
//        return Trails.purple;
//    }
}
