package nukeeng.main;

import java.util.logging.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.src.BaseMod;
import nukeeng.main.blocks.Blocks;
import nukeeng.main.handlers.CraftingHandler;
import nukeeng.main.handlers.MassfabHelper;
import nukeeng.main.handlers.OreDictionaryHandler;
import nukeeng.main.handlers.radiation.NukeEngPotion;
import nukeeng.main.items.Items;
import nukeeng.main.proxies.CommonProxy;

@Mod(name="Nuclear Engineering", version="1.3", modid="nukeeng", dependencies="required-after:IC2; after:factorization; after:Railcraft; after:ThermalExpansion; after:ThermalExpansion|Transport; after:ThermalExpansion|Energy; after:ThermalExpansion|Factory; after:XyCraft; after:MetallurgyCore; after:MetallurgyBase; after:MetallurgyEnder; after:MetallurgyFantasy; after:MetallurgyNether; after:MetallurgyPrecious; after:MetallurgyUtility; after:BuildCraft|Silicon; after:BuildCraft|Core; after:BuildCraft|Transport; after:BuildCraft|Factory; after:BuildCraft|Energy; after:BuildCraft|Builders; after:enhancedgeology;")
public class Main extends BaseMod{
	
	public static Logger nukeLog = Logger.getLogger("nukeeng");
	
	@SidedProxy(clientSide="nukeeng.main.proxies.ClientProxy", serverSide="nukeeng.main.proxies.ServerProxy")
	public static CommonProxy proxy;
	
	@Override
	public String getVersion() {
		return "1.3";
	}

	@Override
	public void load() {
	}
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		nukeLog.info("Ⓒ 1986 Leonid Toptunov");			
	}
	
	
	@Init
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
		Items.initItems();
		Items.initLanguageRegistry();
		NukeEngPotion.init();
		Blocks.initBlocks();
		Blocks.registerBlocks();
		Blocks.initLanguageRegistry();
		Blocks.registerTileEntities();
		Localization.initLocalization();
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent event) {
		CraftingHandler.initCrafting();
		OreDictionaryHandler.initOreDictionary();
		MassfabHelper.initMassfab();
	    proxy.postInit(event);
	}
}
