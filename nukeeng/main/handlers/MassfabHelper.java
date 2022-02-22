package nukeeng.main.handlers;

import net.minecraft.item.ItemStack;
import nukeeng.main.items.Items;

public class MassfabHelper {
	public static void initMassfab() {
		ic2.api.Ic2Recipes.addMatterAmplifier(new ItemStack(Items.dustMGEU), 2250000);
		ic2.api.Ic2Recipes.addMatterAmplifier(new ItemStack(Items.dustHEU), 1750000);
		ic2.api.Ic2Recipes.addMatterAmplifier(new ItemStack(Items.dustLEU), 1250000);
		ic2.api.Ic2Recipes.addMatterAmplifier(new ItemStack(Items.dustDU), 100000);
	}
}
