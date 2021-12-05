package nukeeng.main.tileentities;

import ic2.api.Direction;
import ic2.api.IWrenchable;
import ic2.api.energy.event.EnergyTileLoadEvent;
import ic2.api.energy.event.EnergyTileSourceEvent;
import ic2.api.energy.tile.IEnergySource;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;
import nukeeng.main.blocks.Blocks;

public class TileEntityRTG_IEU1 extends TileEntity implements IEnergySource, IWrenchable {
	
	public boolean added = false;
	private static final int KILOWATTS = 7;
	
	public TileEntityRTG_IEU1() {

	}

	public void updateEntity() {
		if (!added) {
			EnergyTileLoadEvent loadevent = new EnergyTileLoadEvent(this);
			MinecraftForge.EVENT_BUS.post(loadevent);
			added = true;
		}
		EnergyTileSourceEvent sourceEvent = new EnergyTileSourceEvent(this, KILOWATTS);
		MinecraftForge.EVENT_BUS.post(sourceEvent);
	}
	@Override
	public boolean emitsEnergyTo(TileEntity receiver, Direction direction) {
		return true;
	}

	@Override
	public boolean isAddedToEnergyNet() {
		return added;
	}

	@Override
	public int getMaxEnergyOutput() {
		return KILOWATTS;
	}
	
	@Override
	public boolean wrenchCanSetFacing(EntityPlayer entityPlayer, int side) {
		return false;
	}

	@Override
	public short getFacing() {
		return 0;
	}

	@Override
	public void setFacing(short facing) {
	}

	@Override
	public boolean wrenchCanRemove(EntityPlayer entityPlayer) {
		return true;
	}

	@Override
	public float getWrenchDropRate() {
		return 1.0f;
	}

	@Override
	public ItemStack getWrenchDrop(EntityPlayer entityPlayer) {
		return new ItemStack(Blocks.RTG_IEU1);
	}
}
