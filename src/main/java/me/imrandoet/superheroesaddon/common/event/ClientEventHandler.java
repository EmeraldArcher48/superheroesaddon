package me.imrandoet.superheroesaddon.common.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.common.keybinds.SHKeyBinds;
import fiskfille.heroes.helper.SHHelper;
import me.imrandoet.superheroesaddon.common.data.SUHData;
import me.imrandoet.superheroesaddon.common.interaction.key.KeyManager;
import me.imrandoet.superheroesaddon.common.abilities.Abilities;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import org.lwjgl.opengl.GL11;

/**
 * Created by ImranDoet on 29-10-2017.
 */

public class ClientEventHandler {

    public Minecraft mc = Minecraft.getMinecraft();

    @SubscribeEvent
    public void onTick(TickEvent.PlayerTickEvent e) {
        EntityPlayer ep = e.player;
        World world = ep.worldObj;

        if (e.phase == TickEvent.Phase.END) {
            if (ep == mc.thePlayer) {
                if (SHHelper.getHero(ep) == null) return;
                Hero hero = SHHelper.getHero(ep);
                if (hero.getAbilities().contains(Abilities.PHASING)) {
                    SUHData.PHASING.set(ep, KeyManager.ABILITY_6.getIsKeyPressed());
                }
                if (hero.getAbilities().contains(Abilities.COLD_BREATH)) {
                    SUHData.COLD_BREATH.set(ep, SHKeyBinds.ABILITY_2.getIsKeyPressed());
                }
            }
        }
    }

}
