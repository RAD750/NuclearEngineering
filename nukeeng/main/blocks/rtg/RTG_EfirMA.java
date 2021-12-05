package nukeeng.main.blocks.rtg;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import nukeeng.main.CreativeTab;
import nukeeng.main.blocks.Blocks;
import nukeeng.main.handlers.radiation.NukeEngPotion;
import nukeeng.main.tileentities.TileEntityRTG_EfirMA;

public class RTG_EfirMA extends BlockContainer {
	public static final String name = "RTG_EfirMA";

	public RTG_EfirMA(int id, int texture) {
		super(id, Material.iron);
		setHardness(0.6F);
		setResistance(0.6F);
		setStepSound(Block.soundMetalFootstep);
		setCreativeTab(CreativeTab.tabNukeEngMain);
		setBlockName("RTG_EfirMA");
		blockIndexInTexture = 145;
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
		this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
		return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
	}

	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
		this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
		return super.getSelectedBoundingBoxFromPool(par1World, par2, par3, par4);
	}

	public void setBlockBoundsBasedOnState(IBlockAccess blockAccess, int x, int y, int z) {
	      setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}
	
	//Dai il cancro se provi a smontare
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int metadata)
	{
		EntityPlayer player = world.getClosestPlayer(x, y, z, 10);
		player.addPotionEffect(new PotionEffect(Potion.hunger.id, 3600, 0));
		player.addPotionEffect(new PotionEffect(Potion.confusion.id, 1100, 2));
		player.addPotionEffect(new PotionEffect(NukeEngPotion.radiationSickness.id, 500, 0));
	}

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving entity) {
		if ((entity instanceof EntityPlayer)) {
			int yaw = (int) entity.rotationYaw;

			if (yaw < 0)
				yaw += 360;
			yaw += 22;
			yaw %= 360;
			int facing = yaw / 45;

			world.setBlockAndMetadataWithNotify(x, y, z, Blocks.RTG_EfirMA.blockID, facing / 2);
		}
	}

	public int getRenderType() {
		return -1;
	}

	public String getTextureFile() {
		return "/nukeeng/textures/items.png";
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public int idDropped(int par1, int par2) {
		return blockID;
	}

	public int quantityDropped() {
		return 1;
	}

	public TileEntity createNewTileEntity(World world) {
		return null;
	}

	public TileEntity createTileEntity(World world, int meta) {
		return new TileEntityRTG_EfirMA();
	}
}