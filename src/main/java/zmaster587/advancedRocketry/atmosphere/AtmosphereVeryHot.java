package zmaster587.advancedRocketry.atmosphere;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import zmaster587.advancedRocketry.api.EntityRocketBase;
import zmaster587.advancedRocketry.api.capability.CapabilitySpaceArmor;
import zmaster587.advancedRocketry.entity.EntityElevatorCapsule;
import zmaster587.advancedRocketry.util.ItemAirUtils;
import zmaster587.libVulpes.LibVulpes;

public class AtmosphereVeryHot extends AtmosphereNeedsSuit {
	
	public AtmosphereVeryHot(boolean canTick, boolean isBreathable, boolean allowsCombustion,
			String name) {
		super(canTick, isBreathable, allowsCombustion, name);
	}
	

	@Override
	public String getDisplayMessage() {
		return LibVulpes.proxy.getLocalizedString("msg.tooHot");
	}
	
	// Needs full pressure suit
	protected boolean onlyNeedsMask()
	{
		return false;
	}
	
	@Override
	public void onTick(EntityLivingBase player) {
		if(player.world.getTotalWorldTime() % 20  == 0 && !isImmune(player)) {
			player.setFire(1);
			player.addPotionEffect(new PotionEffect(Potion.getPotionById(2), 40, 3));
		}
	}
}