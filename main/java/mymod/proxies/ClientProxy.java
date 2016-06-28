package mymod.proxies;

import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		super.init(event);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}
}
