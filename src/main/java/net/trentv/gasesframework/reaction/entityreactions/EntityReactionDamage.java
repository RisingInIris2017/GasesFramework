package net.trentv.gasesframework.reaction.entityreactions;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.trentv.gasesframework.reaction.EntityReaction;

public class EntityReactionDamage extends EntityReaction
{
	public final DamageSource source;
	public final float damage;
	public final int maxDelay;
	
	public EntityReactionDamage(int maxDelay, DamageSource source, float damage)
	{
		this.maxDelay = maxDelay;
		this.source = source;
		this.damage = damage;
	}
	
	@Override
	public void react(Entity e)
	{
		if(e instanceof EntityLivingBase)
		{
			NBTTagCompound a = e.getEntityData();
			int level = a.getInteger("gases-suffocation") + 1;
			a.setInteger("gases-suffocation", level);
			if(a.getInteger("gases-suffocation") > maxDelay)
			e.attackEntityFrom(source, damage);
		}
	}
}
