package me.imrandoet.superheroesaddon.common.items;

import cpw.mods.fml.common.registry.GameRegistry;
import fiskfille.heroes.FiskHeroes;
import fiskfille.heroes.common.registry.ItemRegistry;
import me.imrandoet.superheroesaddon.SuperheroesAddon;
import net.minecraft.item.Item;

/**
 * Created by ImranDoet on 31-10-2017.
 */

public class SUHItems {

    public static Item reverseFlashEmblem;
    public static Item kryptonite;

    public static void init() {
        reverseFlashEmblem = new Item().setTextureName("superheroesaddon:reverse_flash_emblem");
        kryptonite = new ItemKryptonite();
        registerItemNoTab(reverseFlashEmblem, "reverse_flash_emblem");
        registerItem(kryptonite, "kryptonite");
    }

    public static void registerItem(Item item, String unlocalizedName)
    {
        item.setCreativeTab(SuperheroesAddon.tab);
        registerItemNoTab(item, unlocalizedName);
    }

    public static void registerItemNoTab(Item item, String unlocalizedName)
    {
        item.setUnlocalizedName(unlocalizedName);

        GameRegistry.registerItem(item, unlocalizedName);
    }



}
