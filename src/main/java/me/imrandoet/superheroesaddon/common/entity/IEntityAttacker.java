package me.imrandoet.superheroesaddon.common.entity;

import net.minecraft.entity.player.EntityPlayer;
import java.util.UUID;

/**
 * Created by ImranDoet on 22-11-2017.
 */

public interface IEntityAttacker {

    EntityPlayer getTarget();

    UUID getTargetUUID();

}
