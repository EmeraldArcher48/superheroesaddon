package me.imrandoet.superheroesaddon.common.interaction;

import cpw.mods.fml.relauncher.Side;
import fiskfille.heroes.common.data.Cooldowns;
import fiskfille.heroes.common.interaction.EnumInteraction;
import fiskfille.heroes.common.interaction.InteractionBase;
import fiskfille.heroes.helper.SHHelper;
import me.imrandoet.superheroesaddon.common.abilities.Abilities;
import me.imrandoet.superheroesaddon.common.entity.EntityWebSlingArrow;
import me.imrandoet.superheroesaddon.common.heroes.Spiderman;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by ImranDoet on 24-10-2017.
 */

public class InteractionWebSlinging extends InteractionBase {

    public InteractionWebSlinging() {
        super(Abilities.WEB_SLINGING, new EnumInteraction.InteractionType[]{EnumInteraction.InteractionType.RIGHT_CLICK_AIR, EnumInteraction.InteractionType.RIGHT_CLICK_BLOCK});
    }

    @Override
    public boolean serverRequirements(EntityPlayer entityPlayer, EnumInteraction.InteractionType interactionType, int x, int y, int z) {
        return SHHelper.getHero(entityPlayer) != null && entityPlayer.getHeldItem() == null && SHHelper.getHero(entityPlayer).hasAbility(Abilities.WEB_SLINGING);
    }

    @Override
    public boolean clientRequirements(EntityPlayer entityPlayer, EnumInteraction.InteractionType interactionType, int x, int y, int z) {
        return Cooldowns.Cooldown.valueOf("WEB_SLINGING_COOLDOWN").available(entityPlayer);
    }

    @Override
    public void receive(EntityPlayer entityPlayer, EntityPlayer entityPlayer1, EnumInteraction.InteractionType interactionType, Side side, int i, int i1, int i2, Integer[] integers) {
        if (!entityPlayer.worldObj.isRemote) {
            entityPlayer.worldObj.spawnEntityInWorld(new EntityWebSlingArrow(entityPlayer.worldObj, entityPlayer, 2.0F));
//            entityPlayer.worldObj.spawnEntityInWorld(new EntityWebSlingArrow(entityPlayer.worldObj, entityPlayer, 3.0F));
        }
        if (side.isClient() && entityPlayer == entityPlayer1) {
            Cooldowns.Cooldown.valueOf("WEB_SLINGING_COOLDOWN").set(entityPlayer);
        }
        return;
    }
}
