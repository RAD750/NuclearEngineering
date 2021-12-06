package nukeeng.main.items;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.IReactor;
import ic2.api.IReactorComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import nukeeng.main.CreativeTab;
import nukeeng.main.Main;
import nukeeng.main.handlers.radiation.NukeEngDamageSource;
import nukeeng.main.handlers.radiation.NukeEngPotion;

public class ItemRadioactive extends Item {

	private String decayMode;
	private int specificActivity;
	private int ticks = 0;
	private static final int HELMET_ID = 5003;
	private static final int CHESTPLATE_ID = 5002;
	private static final int LEGGINGS_ID = 5001;
	private static final int BOOTS_ID = 5000;
	
	public ItemRadioactive(int id, int textureId, String itemName, int maxStackSize, String decayMode, int specificActivity) {
		super(id-256);
		/**
		 * Registra un oggetto radioattivo
		 * @param id ID dell'oggetto
		 * @param textureId ID della texture
		 * @param itemName nome oggetto
		 * @param maxStackSize Max stack size
		 * @param decayMode Può essere alpha, beta, gamma
		 * @param specificActivity attività specifica del decadimento in GBq/g, 0 = non decade mai
		 * @return Item.
		 */
		this.setTextureFile("/nukeeng/textures/items.png");
		this.setIconIndex(textureId);
		this.setCreativeTab(CreativeTab.tabNukeEngMain);
		this.setItemName(itemName);
		this.setMaxStackSize(maxStackSize);
		this.decayMode = decayMode;
		this.specificActivity = specificActivity;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack)
	{
		return true;
	}

	@Override
	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {	
		
		ticks++;
		if (ticks%20==0) {
			
			EntityPlayer player = (EntityPlayer) par3Entity;
			
			//recupera l'armatura attualmente indossata
			
			int boots = 0;
			int leggings = 0;
			int chestplate = 0; 
			int helmet = 0;
				
			if (player.getCurrentArmor(0) != null) {
				boots = player.getCurrentArmor(0).itemID;
			}
			if (player.getCurrentArmor(1) != null) {
				leggings = player.getCurrentArmor(1).itemID;
			}
			if (player.getCurrentArmor(2) != null) {
				chestplate = player.getCurrentArmor(2).itemID;
			}
			if (player.getCurrentArmor(3) != null) {
				helmet = player.getCurrentArmor(3).itemID;
			}
						
			Random random = new Random();
			int chance = random.nextInt(100000);
			switch(decayMode) {
			case "alpha":
				if (helmet != HELMET_ID & chance < specificActivity) {
					Main.nukeLog.info(player.username + " ha preso danno alfa");
					if (!player.isPotionActive(Potion.hunger.id)) {
						player.addPotionEffect(new PotionEffect(Potion.hunger.id, 3600, 0));
					}
					if (!player.isPotionActive(Potion.confusion.id)) {
						player.addPotionEffect(new PotionEffect(Potion.confusion.id, 1100, 1));
					}
				}
				break;
			case "beta":
				if (helmet != HELMET_ID & chestplate == 0 & leggings == 0 & boots == 0 & chance < specificActivity) {
					Main.nukeLog.info(player.username + " ha preso danno beta");
					if (!player.isPotionActive(Potion.hunger.id)) {
						player.addPotionEffect(new PotionEffect(Potion.hunger.id, 3600, 0));
					}
					if (!player.isPotionActive(Potion.confusion.id)) {
						player.addPotionEffect(new PotionEffect(Potion.confusion.id, 1100, 2));
					}
					if (!player.isBurning()) {
						player.setFire(10);
					}
				}
				break;
			case "gamma":
				if (helmet != HELMET_ID & chestplate != CHESTPLATE_ID & leggings != LEGGINGS_ID & boots != BOOTS_ID & chance < specificActivity) {
					Main.nukeLog.info(player.username + " ha preso danno gamma");
					if (!player.isPotionActive(Potion.hunger.id)) {
						player.addPotionEffect(new PotionEffect(Potion.hunger.id, 3600, 0));
					}
					if (!player.isPotionActive(Potion.confusion.id)) {
						player.addPotionEffect(new PotionEffect(Potion.confusion.id, 1100, 2));
					}
					if (!player.isPotionActive(NukeEngPotion.radiationSickness.id)) {
						player.addPotionEffect(new PotionEffect(NukeEngPotion.radiationSickness.id, 200, 0));
					}
				}
				break;
			}	
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
		par3List.add("\247bMain decay type: \247e" + decayMode);
		switch(specificActivity) {
		case 0:
			par3List.add("\247bSpecific activity: \247enegligible");
			break;
		default:
			par3List.add("\247bSpecific activity: \247e" + specificActivity + " GBq/g");
			break;
		}
	}
}
