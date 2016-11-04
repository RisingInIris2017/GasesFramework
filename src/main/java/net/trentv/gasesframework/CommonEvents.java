package net.trentv.gasesframework;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.trentv.gasesframework.capability.GasEffectsStorage;
import net.trentv.gasesframework.capability.GasEffectsProvider;
import net.trentv.gasesframework.capability.IGasEffects;

public class CommonEvents
{
	@SubscribeEvent
	public void onLivingUpdate(LivingUpdateEvent event)
	{
		Entity b = event.getEntity();
		if (b.hasCapability(GasEffectsProvider.GAS_EFFECTS, null))
		{
			IGasEffects q = b.getCapability(GasEffectsProvider.GAS_EFFECTS, null);
			if (q.getSuffocation() < 200) // This should be configurable
				q.setSuffocation(q.getSuffocation() + 1);
			if (q.getBlindness() > 0)
				q.setBlindness(q.getBlindness() - 1);
			if (q.getSlowness() > 0)
				q.setSlowness(q.getSlowness() - 1);
		}
	}

	@SubscribeEvent
	public void AttachCapabilityEventEntity(AttachCapabilitiesEvent.Entity e)
	{
		e.addCapability(new ResourceLocation(GasesFramework.MODID, "gasEffectsCapability"), new GasEffectsProvider());
	}
}