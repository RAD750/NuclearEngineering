package nukeeng.main;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import nukeeng.main.items.Items;

public class CreativeTab extends CreativeTabs {

	private String name;
	public static CreativeTabs tabNukeEngMain = new CreativeTab(CreativeTabs.getNextID(), "Nuclear Engineering");

	public CreativeTab(int par1, String par2Str) {
		super(par1, par2Str);
		this.name = par2Str;
	}
	
	@Override
	public String toString() {
		return super.getTabLabel();
	}
	
	@SideOnly(Side.CLIENT) 
	public ItemStack getIconItemStack() {
		if(this.name == tabNukeEngMain.getTabLabel()) {
			return new ItemStack(Items.blanketHEU);
		}
		return null;
	}
	
	
	@Override
	public String getTranslatedTabLabel() {
		return this.name;
	}

}
