package com.bab.loadingimmunity.loadingimmunity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Server-side event handler.
 */
public class ServerEventHandler {
    @SubscribeEvent(priority = EventPriority.HIGHEST, receiveCanceled = true)
    public void joinedWorld(EntityJoinWorldEvent event) {
        if (event.getEntity() instanceof EntityPlayer) {
            LoadingImmunity.logger.info("Player " + event.getEntity().getName() + " joined/changed world, making invulnerable");
            event.getEntity().setEntityInvulnerable(true);
        }
    }
}
