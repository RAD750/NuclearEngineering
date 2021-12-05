package nukeeng.main.handlers;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cpw.mods.fml.common.registry.GameRegistry;
import ljdp.minechem.api.core.Chemical;
import ljdp.minechem.api.core.Element;
import ljdp.minechem.api.core.EnumElement;
import ljdp.minechem.api.recipe.DecomposerRecipe;
import ljdp.minechem.api.recipe.SynthesisRecipe;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import nukeeng.main.Main;
import nukeeng.main.blocks.Blocks;
import nukeeng.main.items.ItemBlanket;
import nukeeng.main.items.ItemRadioactive;
import nukeeng.main.items.Items;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CraftingHandler {

	public static void initCrafting() {
		
		/*
		 * GREGTECH SINTASSI
		 * 
		 * getGregTechItem(TIPO, QTA, META)
		 * 
		 * TIPO: 0. Lingotti 1. Polveri 2. Celle
		 */
		
		ArrayList<ItemStack> ores;
			
		//Yttrio da Minechem
		final ItemStack yttriumIngot = new ItemStack(Items.ingotYttrium, 1);
		final Element yttrium = new Element(EnumElement.Y, 1);
        SynthesisRecipe.add(new SynthesisRecipe(yttriumIngot, true, 1000, new Chemical[] { null, yttrium, null, null, yttrium, null, null, yttrium, null }));
        DecomposerRecipe.add(new DecomposerRecipe(yttriumIngot, new Chemical[] { new Element(EnumElement.Y, 3) }));

        //Macerazione di tutte le dust EnhancedGeology
       
        ores = OreDictionary.getOres("ingotLeu");
		if ( ores.size() > 0 ) {
			ItemStack ingotLeu = ores.get(0);
			ic2.api.Ic2Recipes.addMaceratorRecipe(ingotLeu, new ItemStack(Items.dustLEU, 1));
		} else {
			Main.nukeLog.warning("Missing LEU ingot");;
		}
		
        ores = OreDictionary.getOres("ingotHeu");
		if ( ores.size() > 0 ) {
			ItemStack ingotHeu = ores.get(0);
			ic2.api.Ic2Recipes.addMaceratorRecipe(ingotHeu, new ItemStack(Items.dustHEU, 1));
		} else {
			Main.nukeLog.warning("Missing HEU ingot");;
		}
		
        ores = OreDictionary.getOres("ingotMgeu");
		if ( ores.size() > 0 ) {
			ItemStack ingotMgeu = ores.get(0);
			ic2.api.Ic2Recipes.addMaceratorRecipe(ingotMgeu, new ItemStack(Items.dustMGEU, 1));
		} else {
			Main.nukeLog.warning("Missing MGEU ingot");;
		}
        
		//Dust da IC2
		ic2.api.Ic2Recipes.addMaceratorRecipe(ic2.api.Items.getItem("nearDepletedUraniumCell"), new ItemStack(Items.dustDU, 1));
		
		//Yttrio ed iridio
		ic2.api.Ic2Recipes.addMaceratorRecipe(new ItemStack(Items.ingotYttrium, 1), new ItemStack(Items.dustYttrium, 1));
		ic2.api.Ic2Recipes.addMaceratorRecipe(GregtechCompat.getGregTechItem(0, 1, 16), new ItemStack(Items.dustIridium, 1));
		
		//Tutti i blanket
		
		
        ores = OreDictionary.getOres("plateZircaloy4");
		if ( ores.size() > 0 ) {
			ItemStack plateZircaloy4 = ores.get(0);
			plateZircaloy4.stackSize = 4;
			GregtechCompat.addAssemblerRecipe(plateZircaloy4, new ItemStack(Items.dustYttrium, 3), new ItemStack(Items.blanketY, 1, Items.blanketY.getMaxDamage()-1), 4000, 95);
			GregtechCompat.addAssemblerRecipe(plateZircaloy4, new ItemStack(Items.dustDU, 3), new ItemStack(Items.blanketDU, 1, Items.blanketDU.getMaxDamage()-1), 4000, 95);
			GregtechCompat.addAssemblerRecipe(plateZircaloy4, new ItemStack(Items.dustHEU, 3), new ItemStack(Items.blanketHEU, 1, Items.blanketHEU.getMaxDamage()-1), 4000, 95);
			GregtechCompat.addAssemblerRecipe(plateZircaloy4, new ItemStack(Items.dustMGEU, 3), new ItemStack(Items.blanketMGEU, 1, Items.blanketMGEU.getMaxDamage()-1), 4000, 95);
			GregtechCompat.addAssemblerRecipe(plateZircaloy4, new ItemStack(Items.dustLEU, 3), new ItemStack(Items.blanketLEU, 1, Items.blanketLEU.getMaxDamage()-1), 4000, 95);
			GregtechCompat.addAssemblerRecipe(plateZircaloy4, new ItemStack(Items.dustIridium, 3), new ItemStack(Items.blanketIr, 1, Items.blanketIr.getMaxDamage()-1), 4000, 95);
			GregtechCompat.addAssemblerRecipe(plateZircaloy4, GregtechCompat.getGregTechItem(1, 5, 81), new ItemStack(Items.blanketPu, 1, Items.blanketPu.getMaxDamage()-1), 4000, 95);
			GregtechCompat.addAssemblerRecipe(plateZircaloy4, GregtechCompat.getGregTechItem(1, 64, 26), new ItemStack(Items.blanketSteel, 1, Items.blanketSteel.getMaxDamage()-1), 4000, 95);
			GregtechCompat.addAssemblerRecipe(plateZircaloy4, GregtechCompat.getGregTechItem(1, 5, 16), new ItemStack(Items.blanketU, 1, Items.blanketU.getMaxDamage()-1), 4000, 95);

		} else {
			Main.nukeLog.warning("Missing Zircaloy 4 plate");;
		}

		
		GregtechCompat.addVacuumFreezerRecipe(new ItemStack(Items.dustYttrium90, 1), new ItemStack(Items.pelletYttrium90, 1), 14000);
		GregtechCompat.addVacuumFreezerRecipe(new ItemStack(Items.dustMolybdenum99, 1), new ItemStack(Items.pelletMolybdenum99, 1), 14000);
		GregtechCompat.addVacuumFreezerRecipe(new ItemStack(Items.dustIridium192, 1), new ItemStack(Items.pelletIridium192, 1), 14000);
		GregtechCompat.addVacuumFreezerRecipe(new ItemStack(Items.dustAmericium241, 1), new ItemStack(Items.pelletAmericium241, 1), 14000);
		GregtechCompat.addVacuumFreezerRecipe(new ItemStack(Items.dustCesium137, 1), new ItemStack(Items.pelletCesium137, 1), 14000);
		GregtechCompat.addVacuumFreezerRecipe(new ItemStack(Items.dustCobalt60, 1), new ItemStack(Items.pelletCobalt60, 1), 14000);
		GregtechCompat.addVacuumFreezerRecipe(new ItemStack(Items.dustIodine131, 1), new ItemStack(Items.pelletIodine131, 1), 14000);
		GregtechCompat.addVacuumFreezerRecipe(new ItemStack(Items.dustStrontium90, 1), new ItemStack(Items.pelletStrontium90, 1), 14000);
		GregtechCompat.addVacuumFreezerRecipe(new ItemStack(Items.dustPlutonium238, 1), new ItemStack(Items.pelletPlutonium238, 1), 14000);
		
		//PN junction		
		GregtechCompat.addAssemblerRecipe(ic2.api.Items.getItem("tinCableItem"), ic2.api.Items.getItem("copperCableItem"), new ItemStack(Items.PNJunction), 600, 10);

		//Ceramic plate
		ores = OreDictionary.getOres("gemFeldspar");
		if ( ores.size() > 0 ) {
			ItemStack feldspar = ores.get(0);
			GregtechCompat.addBlastRecipe(feldspar, new ItemStack(Item.clay, 1), new ItemStack(Items.ceramicPlate), GregtechCompat.getGregTechItem(1, 1, 63), 500, 350, 2200);
		} else {
			Main.nukeLog.warning("Missing Feldspar");;
		}
		
		//TEG
		GregtechCompat.addAssemblerRecipe(new ItemStack(Items.ceramicPlate, 2), new ItemStack(Items.PNJunction, 16), new ItemStack(Items.smallTEG, 1), 75, 1050);
		GregtechCompat.addAssemblerRecipe(new ItemStack(Items.ceramicPlate, 8), new ItemStack(Items.PNJunction, 64), new ItemStack(Items.largeTEG, 1), 95, 2100); 
		
		//RTG
		ores = OreDictionary.getOres("blockLead");
		if ( ores.size() > 0 ) {
			ItemStack lead = ores.get(0);
			GameRegistry.addRecipe(new ItemStack(Blocks.RTG_BetaM), new Object[] {
				"CTC", "LPL", "STS", 
				'C', ic2.api.Items.getItem("advancedCircuit"),
				'L', lead,
				'P', new ItemStack(Items.pelletPlutonium238, 5),
				'S', ic2.api.Items.getItem("ironScaffold"),
				'T', new ItemStack(Items.smallTEG)
			});
			GameRegistry.addRecipe(new ItemStack(Blocks.RTG_EfirMA), new Object[] {
					"CTC", "LPL", "STS", 
					'C', ic2.api.Items.getItem("advancedCircuit"),
					'L', lead,
					'P', new ItemStack(Items.pelletPlutonium238, 10),
					'S', ic2.api.Items.getItem("ironScaffold"),
					'T', new ItemStack(Items.smallTEG)
			});
			GameRegistry.addRecipe(new ItemStack(Blocks.RTG_GongGorn), new Object[] {
					"CTC", "LPL", "STS", 
					'C', ic2.api.Items.getItem("advancedCircuit"),
					'L', lead,
					'P', new ItemStack(Items.pelletStrontium90, 5),
					'S', ic2.api.Items.getItem("ironScaffold"),
					'T', new ItemStack(Items.largeTEG)
			});
			GameRegistry.addRecipe(new ItemStack(Blocks.RTG_IEU1), new Object[] {
					"CTC", "LPL", "STS", 
					'C', ic2.api.Items.getItem("advancedCircuit"),
					'L', lead,
					'P', new ItemStack(Items.pelletPlutonium238, 10),
					'S', ic2.api.Items.getItem("ironScaffold"),
					'T', new ItemStack(Items.largeTEG)
			});
		} else {
			Main.nukeLog.warning("Missing Lead Block");;
		}
		
		//Disinfetta la rotten flesh
		GregtechCompat.addChemicalRecipe(new ItemStack(Item.rottenFlesh, 64), new ItemStack(Items.pelletCobalt60, 1), new ItemStack(Item.porkRaw), 1200);
		
		
	}
}
