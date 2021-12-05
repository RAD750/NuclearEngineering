package nukeeng.main.items;

import ic2.api.IReactor;
import ic2.api.IReactorComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import nukeeng.main.CreativeTab;



public class ItemBlanket extends Item implements IReactorComponent {
	
	private ItemStack resultItem;
	private int enrichmentDuration;

	public ItemBlanket(int id, int textureId, String itemName, ItemStack resultItem, int enrichmentDuration) {
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
		this.setMaxStackSize(1);
		this.resultItem = resultItem;
		this.setMaxDamage(enrichmentDuration);
		this.setNoRepair();

	}

	@Override
	public void processChamber(IReactor reactor, ItemStack yourStack, int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean acceptUraniumPulse(IReactor reactor, ItemStack yourStack, ItemStack pulsingStack, int youX, int youY,
			int pulseX, int pulseY) {
		final int myLevel = yourStack.getItemDamage() - 1 - reactor.getHeat() / 3000;
		if (myLevel <= 0) {
			reactor.setItemAt(youX, youY, resultItem);
		}
		else {
			yourStack.setItemDamage(myLevel);
		}
		return true;
	}

	@Override
	public boolean canStoreHeat(IReactor reactor, ItemStack yourStack, int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getMaxHeat(IReactor reactor, ItemStack yourStack, int x, int y) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCurrentHeat(IReactor reactor, ItemStack yourStack, int x, int y) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int alterHeat(IReactor reactor, ItemStack yourStack, int x, int y, int heat) {
		// TODO Auto-generated method stub
		return heat;
	}

	@Override
	public float influenceExplosion(IReactor reactor, ItemStack yourStack) {
		// TODO Auto-generated method stub
		return 0;
	}

}
