package mymod.entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.world.World;

public class MyEntity extends EntityCow {
	public MyEntity(World world) {
		super(world);
		this.setSize(0.9F, 1.3F);
	}
	
	// @Override
	public MyEntity createChild(EntityAgeable entityAgeable) {
		return new MyEntity(this.worldObj);
	}
}
