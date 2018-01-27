package me.imrandoet.superheroesaddon.common.interaction;

import cpw.mods.fml.relauncher.Side;
import fiskfille.heroes.common.data.Cooldowns;
import fiskfille.heroes.common.data.SHData;
import fiskfille.heroes.common.interaction.EnumInteraction;
import fiskfille.heroes.common.interaction.InteractionBase;
import me.imrandoet.superheroesaddon.common.entity.EntityLightning;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by ImranDoet on 30-10-2017.
 */

public class InteractionLightningThrow extends InteractionBase {

    public InteractionLightningThrow() {
        super(null, new EnumInteraction.InteractionType[]{EnumInteraction.InteractionType.RIGHT_CLICK_AIR});
    }

    @Override
    public boolean serverRequirements(EntityPlayer player, EnumInteraction.InteractionType type, int x, int y, int z) {
        return true;
    }

    @Override
    public boolean clientRequirements(EntityPlayer player, EnumInteraction.InteractionType type, int x, int y, int z) {
        return Cooldowns.Cooldown.valueOf("LIGHTNING_THROWING_COOLDOWN").available(player) && SHData.SPEEDING.get(player);
    }

    @Override
    public void receive(EntityPlayer sender, EntityPlayer clientPlayer, EnumInteraction.InteractionType type, Side side, int x, int y, int z, Integer[] args) {
        if (!sender.worldObj.isRemote) {
            sender.worldObj.spawnEntityInWorld(new EntityLightning(sender.worldObj, sender));
        }
    }
}
