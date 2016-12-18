package com.bab.loadingimmunity.loadingimmunity;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(
        modid = LoadingImmunity.MOD_ID,
        name = LoadingImmunity.MOD_NAME,
        version = LoadingImmunity.VERSION
)
public class LoadingImmunity {

    public static final String MOD_ID = "LoadingImmunity";
    public static final String MOD_NAME = "LoadingImmunity";
    public static final String VERSION = "1.0";

    @SidedProxy
    public static CommonProxy proxy;

    @Mod.Instance
    public static LoadingImmunity instance;

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        logger = e.getModLog();
        proxy.preInit(e);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }

    public static class CommonProxy {
        public void preInit(FMLPreInitializationEvent e) {
            PacketHandler.registerMessages("loadingImmunity");
        }

        public void init(FMLInitializationEvent e) {

        }

        public void postInit(FMLPostInitializationEvent e) {

        }
    }


    public static class ClientProxy extends CommonProxy {
        @Override
        public void preInit(FMLPreInitializationEvent e) {
            super.preInit(e);
            MinecraftForge.EVENT_BUS.register(new ClientEventHandler());
        }
    }

    public static class ServerProxy extends CommonProxy {
        @Override
        public void preInit(FMLPreInitializationEvent e) {
            super.preInit(e);
            MinecraftForge.EVENT_BUS.register(new ServerEventHandler());
        }
    }
}
