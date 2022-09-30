package nukeeng.main.items;

import java.util.logging.Logger;

import ic2.api.IReactor;
import ic2.api.IReactorComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import nukeeng.main.CreativeTab;

public class AdvancedHeatingCell extends Item implements IReactorComponent {
	
	private final static int HEATING_SPEED = 64;
	private Logger nukeLogger = Logger.getLogger("nukeeng");
	public AdvancedHeatingCell(int id, int textureId, String itemName) {
		super(id-256);
		/**
		 * Registra una advanced heating cell
		 * @param id ID dell'oggetto
		 * @param textureId ID della texture
		 * @param itemName nome oggetto
		 * @return Item.
		 */
		this.setTextureFile("/nukeeng/textures/items.png");
		this.setIconIndex(textureId);
		this.setCreativeTab(CreativeTab.tabNukeEngMain);
		this.setItemName(itemName);
		this.setMaxStackSize(1);

	}

	@Override
    public void processChamber(final IReactor reactor, final ItemStack yourStack, final int x, final int y) {
        this.heat(reactor, yourStack.stackSize, x + 1, y);
        this.heat(reactor, yourStack.stackSize, x - 1, y);
        this.heat(reactor, yourStack.stackSize, x, y + 1);
        this.heat(reactor, yourStack.stackSize, x, y - 1);
    }
    
    private void heat(final IReactor reactor, final int stacksize, final int x, final int y) {
        final int want = reactor.getMaxHeat() * 85 / 100;
        if (reactor.getHeat() >= want) {
            return;
        }
        final ItemStack stack = reactor.getItemAt(x, y);
        if (stack != null && stack.getItem() instanceof IReactorComponent) {
            final IReactorComponent comp = (IReactorComponent)stack.getItem();
            if (comp.canStoreHeat(reactor, stack, x, y)) {
                int add = this.HEATING_SPEED;
                final int curr = comp.getCurrentHeat(reactor, stack, x, y);
                if (add > want - curr) {
                    add = want - curr;
                }
                if (add > 0) {
                    comp.alterHeat(reactor, stack, x, y, add);
                }
            }
        }
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
		return 0;
	}

	@Override
	public int getCurrentHeat(IReactor reactor, ItemStack yourStack, int x, int y) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int alterHeat(IReactor reactor, ItemStack yourStack, int x, int y, int heat) {
		return heat;
	}

	@Override
	public float influenceExplosion(IReactor reactor, ItemStack yourStack) {
		// TODO Auto-generated method stub
		return 0;
	}
}