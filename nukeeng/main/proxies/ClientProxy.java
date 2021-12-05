package nukeeng.main.proxies;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.client.MinecraftForgeClient;
import nukeeng.main.Main;
import nukeeng.main.blocks.rtg.rendertables.RenderTableRTG_BetaM;
import nukeeng.main.blocks.rtg.rendertables.RenderTableRTG_EfirMA;
import nukeeng.main.blocks.rtg.rendertables.RenderTableRTG_GongGorn;
import nukeeng.main.blocks.rtg.rendertables.RenderTableRTG_IEU1;
import nukeeng.main.tileentities.TileEntityRTG_BetaM;
import nukeeng.main.tileentities.TileEntityRTG_EfirMA;
import nukeeng.main.tileentities.TileEntityRTG_GongGorn;
import nukeeng.main.tileentities.TileEntityRTG_IEU1;

public class ClientProxy extends CommonProxy {
	public ClientProxy() {
	}

	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		
	}

	@Init
	public void init(FMLInitializationEvent event) {
		super.init(event);
		// Preloading texture per evitare bug
		MinecraftForgeClient.preloadTexture("/nukeeng/textures/items.png");
		Main.nukeLog.info("Preloading texture completato");
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRTG_BetaM.class, new RenderTableRTG_BetaM());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRTG_EfirMA.class, new RenderTableRTG_EfirMA());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRTG_GongGorn.class, new RenderTableRTG_GongGorn());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRTG_IEU1.class, new RenderTableRTG_IEU1());
	}

	@Mod.PostInit
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}
}
