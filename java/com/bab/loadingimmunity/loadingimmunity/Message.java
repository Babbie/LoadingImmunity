package com.bab.loadingimmunity.loadingimmunity;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

/**
 * An empty IMessage that signifies the player sending it should no longer be invulnerable.
 */
public class Message implements IMessage {

    @Override
    public void fromBytes(ByteBuf buf) {

    }

    @Override
    public void toBytes(ByteBuf buf) {

    }

    public static class Handler implements IMessageHandler<Message, IMessage> {
        @Override
        public IMessage onMessage(Message message, MessageContext ctx) {
            FMLCommonHandler.instance().getWorldThread(ctx.netHandler).addScheduledTask(() -> handle(message, ctx));
            return null;
        }

        private void handle(Message message, MessageContext ctx) {
            EntityPlayer player = ctx.getServerHandler().playerEntity;
            player.setEntityInvulnerable(false);
            LoadingImmunity.logger.info("Player " + player.getName() + " created input, making vulnerable");
        }
    }
}
