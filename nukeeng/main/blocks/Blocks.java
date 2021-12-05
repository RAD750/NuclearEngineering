package nukeeng.main.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import nukeeng.main.blocks.rtg.*;
import nukeeng.main.tileentities.*;

public class Blocks {

	public static Block RTG_BetaM, RTG_EfirMA, RTG_GongGorn, RTG_IEU1;
	
	public static void initBlocks() {
		RTG_BetaM = new RTG_BetaM(2010, 0);
		RTG_EfirMA = new RTG_EfirMA(2011, 0);
		RTG_GongGorn = new RTG_GongGorn(2012, 0);
		RTG_IEU1 = new RTG_IEU1(2013, 0);
	}
	
	public static void registerBlocks() {
		GameRegistry.registerBlock(RTG_BetaM, "RTG_BetaM");
		GameRegistry.registerBlock(RTG_EfirMA, "RTG_EfirMA");
		GameRegistry.registerBlock(RTG_GongGorn, "RTG_GongGorn");
		GameRegistry.registerBlock(RTG_IEU1, "RTG_IEU1");
	}
	
	public static void initLanguageRegistry() {
		LanguageRegistry.addName(RTG_BetaM, "Beta-M RTG");
		LanguageRegistry.addName(RTG_EfirMA, "Efir-MA RTG");
		LanguageRegistry.addName(RTG_GongGorn, "Gong/Gorn RTG");
		LanguageRegistry.addName(RTG_IEU1, "IEU-1/1M RTG");
	}
	
	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityRTG_BetaM.class, "TileEntityRTG_BetaM");
		GameRegistry.registerTileEntity(TileEntityRTG_EfirMA.class, "TileEntityRTG_EfirMA");
		GameRegistry.registerTileEntity(TileEntityRTG_GongGorn.class, "TileEntityRTG_GongGorn");
		GameRegistry.registerTileEntity(TileEntityRTG_IEU1.class, "TileEntityRTG_IEU1");
	}
}
