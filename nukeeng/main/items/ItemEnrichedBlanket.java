package nukeeng.main.items;

import ic2.api.IReactor;
import ic2.api.IReactorComponent;
import net.minecraft.item.ItemStack;

public class ItemEnrichedBlanket extends ItemRadioactive implements IReactorComponent {

	public ItemEnrichedBlanket(int id, int textureId, String itemName, int maxStackSize, String decayMode,
			int specificActivity) {
		super(id, textureId, itemName, maxStackSize, decayMode, specificActivity);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void processChamber(IReactor reactor, ItemStack yourStack, int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean acceptUraniumPulse(IReactor reactor, ItemStack yourStack, ItemStack pulsingStack, int youX, int youY,
			int pulseX, int pulseY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canStoreHeat(IReactor reactor, ItemStack yourStack, int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getMaxHeat(IReactor reactor, ItemStack yourStack, int x, int y) {
		// TODO Auto-generated method stub
		return 99999;
	}

	@Override
	public int getCurrentHeat(IReactor reactor, ItemStack yourStack, int x, int y) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int alterHeat(IReactor reactor, ItemStack yourStack, int x, int y, int heat) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float influenceExplosion(IReactor reactor, ItemStack yourStack) {
		// TODO Auto-generated method stub
		return 0;
	}
}