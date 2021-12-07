package nukeeng.main.handlers;

import net.minecraft.item.ItemStack;
import nukeeng.main.items.Items;

public class MassfabHelper {
	public static void initMassfab() {
		
		// 2 250 000  = MGEU Dust
		// 1 750 000  = HEU Dust
		// 1 250 000  = LEU Dust
		// 100 000 = DU Dust
		ic2.api.Ic2Recipes.addMatterAmplifier(new ItemStack(Items.dustMGEU), 2250000);
		ic2.api.Ic2Recipes.addMatterAmplifier(new ItemStack(Items.dustHEU), 1750000);
		ic2.api.Ic2Recipes.addMatterAmplifier(new ItemStack(Items.dustLEU), 1250000);
		ic2.api.Ic2Recipes.addMatterAmplifier(new ItemStack(Items.dustDU), 100000);
	}
}
