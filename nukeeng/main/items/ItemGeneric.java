package nukeeng.main.items;

import net.minecraft.item.Item;
import nukeeng.main.CreativeTab;

public class ItemGeneric extends Item {

	public ItemGeneric(int id, int textureId, String itemName, int maxStackSize) {
		super(id-256);
		/**
		 * Registra un oggetto generico
		 * @param id ID dell'oggetto
		 * @param textureId ID della texture
		 * @param itemName nome oggetto
		 * @param maxStackSize Max stack size
		 * @return Item.
		 */
		this.setTextureFile("/nukeeng/textures/items.png");
		this.setIconIndex(textureId);
		this.setCreativeTab(CreativeTab.tabNukeEngMain);
		this.setItemName(itemName);
		this.setMaxStackSize(maxStackSize);
	}

}
