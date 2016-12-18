package com.bab.loadingimmunity.loadingimmunity;


import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.UUID;

/**
 * Client-side event handler.
 */

public class ClientEventHandler {
    @SubscribeEvent(priority = EventPriority.HIGHEST, receiveCanceled = true)
    @SideOnly(value = Side.CLIENT)
    public void joinedWorld(EntityJoinWorldEvent event) {
        if (event.getEntity().equals(Minecraft.getMinecraft().player)) {
            LoadingImmunity.logger.info("Player " + event.getEntity().getName() + " joined/changed world, making invulnerable");
            event.getEntity().setEntityInvulnerable(true);
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST, receiveCanceled = true)
    @SideOnly(value = Side.CLIENT)
    public void input(InputEvent.KeyInputEvent event) {
        EntityPlayer player = Minecraft.getMinecraft().player;
        if (player.isEntityInvulnerable(new EntityDamageSourceLoading("loading", player))) {
            LoadingImmunity.logger.info("Player " + player.getName() + " created input, making vulnerable");
            player.setEntityInvulnerable(false);
            PacketHandler.INSTANCE.sendToServer(new Message());
        }
    }
}
