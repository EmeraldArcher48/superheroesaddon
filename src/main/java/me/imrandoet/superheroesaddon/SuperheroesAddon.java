package me.imrandoet.superheroesaddon;

import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import me.imrandoet.superheroesaddon.common.items.SUHItems;
import me.imrandoet.superheroesaddon.common.proxy.ServerProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

@Mod(modid = SuperheroesAddon.MODID, version = SuperheroesAddon.VERSION, dependencies = "required-after:fiskheroes")
public class SuperheroesAddon {


    public static final String MODID = "superheroesaddon";
    public static final String VERSION = "1.0";

    @Mod.Instance(value = MODID)
    public static SuperheroesAddon instance;

    @SidedProxy(serverSide = "me.imrandoet.superheroesaddon.common.proxy.ServerProxy", clientSide = "me.imrandoet.superheroesaddon.common.proxy.ClientProxy")
    public static ServerProxy proxy;

    public static CreativeTabs tab = new CreativeTabs("SuperheroesAddon") {@Override public Item getTabIconItem() {return SUHItems.reverseFlashEmblem;}};

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        System.out.println("SuperheroesAddon v" + VERSION + " enabled, author: ImranDoet");
        System.out.println("[SuperheroesAddon] Initializing mod.. ");
        proxy.preInit();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {}
}
