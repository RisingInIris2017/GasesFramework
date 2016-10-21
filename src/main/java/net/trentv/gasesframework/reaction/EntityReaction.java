package net.trentv.gasesframework.reaction;

import net.minecraft.entity.Entity;

public abstract class EntityReaction extends Reaction
{
	public abstract void react(Entity e);
	
	public abstract int getCurrentDelay();
	
	public abstract int getMaximumDelay();
}
