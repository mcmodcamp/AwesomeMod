package mymod.items;

import net.minecraft.item.ItemFood;

public class MyFood extends ItemFood {
	private String name;

	public MyFood(String name, int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		this.setUnlocalizedName(name);
		this.name = name;
	}
	
	public String getName() { return this.name; }
}
