package nukeeng.main.items;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import nukeeng.main.CreativeTab;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Items {

	//ITEMS
	public static Item ingotYttrium;
	public static Item dustDU, dustHEU, dustMGEU, dustLEU, dustIridium, dustYttrium;
	public static Item blanketY, blanketDU, blanketHEU, blanketMGEU, blanketLEU, blanketIr, blanketPu, blanketSteel, blanketU;
	public static Item blanketEnrichedY, blanketEnrichedDU, blanketEnrichedHEU, blanketEnrichedMGEU, blanketEnrichedLEU, blanketEnrichedIr, blanketEnrichedPu, blanketEnrichedSteel, blanketEnrichedU;
	public static Item dustYttrium90, dustMolybdenum99, dustIridium192, dustAmericium241, dustCesium137, dustCobalt60, dustIodine131, dustStrontium90, dustPlutonium238;
	public static Item pelletYttrium90,pelletMolybdenum99, pelletIridium192, pelletAmericium241, pelletCesium137, pelletCobalt60, pelletIodine131, pelletStrontium90, pelletPlutonium238;
	
	
	public static Item ceramicPlate, PNJunction, smallTEG, largeTEG;
	
	public static void initItems() {


		// polveri di vari gradi di uranio
		dustDU = new ItemRadioactive(17000, 0, "dustDU", 64, "alpha", 0);
		dustHEU = new ItemRadioactive(17001, 1, "dustHEU", 64, "alpha", 14);
		dustMGEU = new ItemRadioactive(17002, 2, "dustMGEU", 64, "alpha", 37);
		dustLEU = new ItemRadioactive(17003, 3, "dustLEU", 64, "alpha", 5);
		ingotYttrium = new ItemGeneric(17004, 4, "ingotYttrium", 64); 
		dustIridium = new ItemGeneric(17005, 66, "dustIridium", 64);
		dustYttrium = new ItemGeneric(17006, 64, "dustYttrium", 64);
		
		// dust dopo che si sono arricchite
		dustYttrium90 = new ItemRadioactive(17064, 64, "dustYttrium90", 64, "beta", 200);
		dustMolybdenum99 = new ItemRadioactive(17065, 65, "dustMolybdenum99", 64, "beta", 629);
		dustIridium192 = new ItemRadioactive(17066, 66, "dustIridium192", 64, "gamma", 22200);
		dustAmericium241 = new ItemRadioactive(17067, 67, "dustAmericium241", 64, "alpha", 127);
		dustCesium137 = new ItemRadioactive(17068, 68, "dustCesium137", 64, "gamma", 32150);
		dustCobalt60 = new ItemRadioactive(17069, 69, "dustCobalt60", 64, "gamma", 44000);
		dustIodine131 = new ItemRadioactive(17070, 70, "dustIodine131", 64, "beta", 46000);
		dustStrontium90 = new ItemRadioactive(17071, 71, "dustStrontium90", 64, "beta", 5217);
		dustPlutonium238 = new ItemRadioactive(17072, 72, "dustPlutonium238", 64, "alpha", 644);

		// blanket arricchito	
		blanketEnrichedY = new ItemEnrichedBlanket(17105, 32, "blanketEnrichedY", 1, "beta", 200);
		blanketEnrichedDU = new ItemEnrichedBlanket(17106, 33, "blanketEnrichedDU", 1, "gamma", 32150);
		blanketEnrichedHEU = new ItemEnrichedBlanket(17107, 34, "blanketEnrichedHEU", 1, "beta", 629);
		blanketEnrichedMGEU = new ItemEnrichedBlanket(17108, 35, "blanketEnrichedMGEU", 1, "alpha", 127);
		blanketEnrichedLEU = new ItemEnrichedBlanket(17109, 36, "blanketEnrichedLEU", 1, "alpha", 644);
		blanketEnrichedIr = new ItemEnrichedBlanket(17110, 37, "blanketEnrichedIr", 1, "gamma", 22200);
		blanketEnrichedPu = new ItemEnrichedBlanket(17111, 38, "blanketEnrichedPu", 1, "beta", 46000);
		blanketEnrichedSteel = new ItemEnrichedBlanket(17112, 39, "blanketEnrichedSteel", 1, "gama", 44000);
		blanketEnrichedU = new ItemEnrichedBlanket(17113, 40, "blanketEnrichedU", 1, "beta", 5217);
		
		// blanket da arricchire
		blanketY = new ItemBlanket(17032, 32, "blanketY", Items.blanketEnrichedY, 25000);
		blanketDU = new ItemBlanket(17033, 33, "blanketDU", Items.blanketEnrichedDU, 15000);
		blanketHEU = new ItemBlanket(17034, 34, "blanketHEU", Items.blanketEnrichedHEU, 16000);
		blanketMGEU = new ItemBlanket(17035, 35, "blanketMGEU", Items.blanketEnrichedMGEU, 8200);
		blanketLEU = new ItemBlanket(17036, 36, "blanketLEU", Items.blanketEnrichedLEU, 27700);
		blanketIr = new ItemBlanket(17037, 37, "blanketIr", Items.blanketEnrichedIr, 7500);
		blanketPu = new ItemBlanket(17038, 38, "blanketPu", Items.blanketEnrichedPu, 13000);
		blanketSteel = new ItemBlanket(17039, 39, "blanketSteel", Items.blanketEnrichedSteel, 12500);
		blanketU = new ItemBlanket(17040, 40, "blanketU", Items.blanketEnrichedU, 6500);

		//pellet dopo sintering (forma finale)
		pelletYttrium90 = new ItemRadioactive(17096, 96, "pelletYttrium90", 64, "beta", 200);
		pelletMolybdenum99 = new ItemRadioactive(17097, 97, "pelletMolybdenum99", 64, "beta", 629);
		pelletIridium192 = new ItemRadioactive(17098, 98, "pelletIridium192", 64, "gamma", 22000);
		pelletAmericium241 = new ItemRadioactive(17099, 99, "pelletAmericium241", 64, "alpha", 127);
		pelletCesium137 = new ItemRadioactive(17100, 100, "pelletCesium137", 64, "gamma", 32150);
		pelletCobalt60 = new ItemRadioactive(17101, 101, "pelletCobalt60", 64, "gamma", 44000);
		pelletIodine131 = new ItemRadioactive(17102, 102, "pelletIodine131", 64, "beta", 46000);
		pelletStrontium90 = new ItemRadioactive(17103, 103, "pelletStrontium90", 64, "beta", 5217);
		pelletPlutonium238 = new ItemRadioactive(17104, 104, "pelletPlutonium238", 64, "alpha", 644);
		
		// materiale per RTG
		ceramicPlate = new ItemGeneric(17128, 128, "ceramicPlate", 64);
		PNJunction = new ItemGeneric(17129, 129, "PNJunction", 64);
		smallTEG = new ItemGeneric(17130, 130, "smallTEG", 64);
		largeTEG = new ItemGeneric(17131, 131, "largeTEG", 64);
		
	}




	public static void initLanguageRegistry() {

		LanguageRegistry.addName(dustDU, "Depleted Uranium Dust");
		LanguageRegistry.addName(dustHEU, "Highly Enriched Uranium Dust");
		LanguageRegistry.addName(dustMGEU, "Military Grade Uranium Dust");
		LanguageRegistry.addName(dustLEU, "Lightly Enriched Uranium Dust");
		LanguageRegistry.addName(dustYttrium, "Yttrium Dust");
		LanguageRegistry.addName(dustIridium, "Iridium Dust");
		
		LanguageRegistry.addName(blanketY, "Yttrium Blanket");
		LanguageRegistry.addName(blanketDU, "Depleted Uranium Blanket");
		LanguageRegistry.addName(blanketHEU, "Highly Enriched Uranium Blanket");
		LanguageRegistry.addName(blanketMGEU, "Military Grade Uranium Blanket");
		LanguageRegistry.addName(blanketLEU, "Lightly Enriched Uranium Blanket");
		LanguageRegistry.addName(blanketIr, "Iridium Blanket");
		LanguageRegistry.addName(blanketPu, "Plutonium Blanket");
		LanguageRegistry.addName(blanketSteel, "Steel Blanket");
		LanguageRegistry.addName(blanketU, "Uranium Blanket");
		
		LanguageRegistry.addName(blanketEnrichedY, "Yttrium Irradiated Blanket");
		LanguageRegistry.addName(blanketEnrichedDU, "Depleted Uranium Irradiated Blanket");
		LanguageRegistry.addName(blanketEnrichedHEU, "Highly Enriched Uranium Irradiated Blanket");
		LanguageRegistry.addName(blanketEnrichedMGEU, "Military Grade Uranium Irradiated Blanket");
		LanguageRegistry.addName(blanketEnrichedLEU, "Lightly Enriched Uranium Irradiated Blanket");
		LanguageRegistry.addName(blanketEnrichedIr, "Iridium Irradiated Blanket");
		LanguageRegistry.addName(blanketEnrichedPu, "Plutonium Irradiated Blanket");
		LanguageRegistry.addName(blanketEnrichedSteel, "Steel Irradiated Blanket");
		LanguageRegistry.addName(blanketEnrichedU, "Uranium Irradiated Blanket");

		LanguageRegistry.addName(dustYttrium90, "Yttrium-90 Dust");
		LanguageRegistry.addName(dustMolybdenum99, "Molybdenum-99 Dust");
		LanguageRegistry.addName(dustIridium192, "Iridium-192 Dust");
		LanguageRegistry.addName(dustAmericium241, "Americium-241 Dust");
		LanguageRegistry.addName(dustCesium137, "Cesium-137 Dust");
		LanguageRegistry.addName(dustCobalt60, "Cobalt-60 Dust");
		LanguageRegistry.addName(dustIodine131, "Iodine-131 Dust");
		LanguageRegistry.addName(dustStrontium90, "Strontium-90 Dust");
		LanguageRegistry.addName(dustPlutonium238, "Plutonium-238 Dust");

		LanguageRegistry.addName(pelletYttrium90, "Yttrium-90 Pellet");
		LanguageRegistry.addName(pelletMolybdenum99, "Molybdenum-99 Pellet");
		LanguageRegistry.addName(pelletIridium192, "Iridium-192 Pellet");
		LanguageRegistry.addName(pelletAmericium241, "Americium-241 Pellet");
		LanguageRegistry.addName(pelletCesium137, "Cesium-137 Pellet");
		LanguageRegistry.addName(pelletCobalt60, "Cobalt-60 Pellet");
		LanguageRegistry.addName(pelletIodine131, "Iodine-131 Pellet");
		LanguageRegistry.addName(pelletStrontium90, "Strontium-90 Pellet");
		LanguageRegistry.addName(pelletPlutonium238, "Plutonium-238 Pellet");
		
		LanguageRegistry.addName(ingotYttrium, "Yttrium Ingot");
		LanguageRegistry.addName(PNJunction, "Thermoelectric Junction");
		LanguageRegistry.addName(ceramicPlate, "Ceramic Plate");
		LanguageRegistry.addName(smallTEG, "Small Thermoelectric Generator");
		LanguageRegistry.addName(largeTEG, "Large Thermoelectric Generator");

	}
}




