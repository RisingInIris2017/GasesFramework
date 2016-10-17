package net.trentv.gasesframework;

import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.trentv.gasesframework.api.GFAPI;
import net.trentv.gasesframework.common.GasesFrameworkCreativeTab;
import net.trentv.gasesframework.common.GasesFrameworkImplementation;
import net.trentv.gasesframework.common.GasesFrameworkRegistry;
import net.trentv.gasesframework.init.GasesFrameworkObjects;

@Mod(modid = GasesFramework.MODID, version = GasesFramework.VERSION, acceptedMinecraftVersions = "1.10.2")
public class GasesFramework
{
	@Instance(GasesFramework.MODID)
	public static GasesFramework instance;

	public static final String MODID = "gasesframework";
	public static final String VERSION = "2.0.0";
	public static final GasesFrameworkCreativeTab CREATIVE_TAB = new GasesFrameworkCreativeTab("gasesframework");

	@SidedProxy(clientSide = "net.trentv.gasesframework.client.ClientProxy", serverSide = "net.trentv.gasesframework.server.ServerProxy")
	public static CommonProxy proxy;

	public static Logger logger;

	public static GasesFrameworkRegistry registry = new GasesFrameworkRegistry();
	public static GasesFrameworkImplementation implementation = new GasesFrameworkImplementation();

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		GFAPI.install(implementation, registry);
		logger = event.getModLog();

		// Register all items, blocks, and gases
		GasesFrameworkObjects.init();
		proxy.registerRenderers();
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.registerColorHandlers();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{

	}
}