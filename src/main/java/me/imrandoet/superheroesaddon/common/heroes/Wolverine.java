package me.imrandoet.superheroesaddon.common.heroes;

import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.common.item.armor.ItemHeroArmor;
import me.imrandoet.superheroesaddon.SuperheroesAddon;

/**
 * Created by ImranDoet on 17-1-2018.
 */

public class Wolverine extends Hero {

    @Override
    public void init() {
        this.chestplate = new ItemHeroArmor(this, ItemHeroArmor.ArmorType.TORSO).setCreativeTab(SuperheroesAddon.tab);
        this.leggings = new ItemHeroArmor(this, ItemHeroArmor.ArmorType.PANTS).setCreativeTab(SuperheroesAddon.tab);
        this.boots = new ItemHeroArmor(this, ItemHeroArmor.ArmorType.BOOTS).setCreativeTab(SuperheroesAddon.tab);
    }

    @Override
    public int getTier() {
        return 4;
    }

    @Override
    public ItemHeroArmor.ArmorVersion getVersion() {
        return ItemHeroArmor.ArmorVersion.XMEN;
    }
}
