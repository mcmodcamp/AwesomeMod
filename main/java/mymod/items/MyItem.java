package mymod.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MyItem extends Item {
	private String name;
	
	public MyItem(String name) {
		super();
		this.name = name;
		this.setUnlocalizedName(this.name);
		this.setCreativeTab(CreativeTabs.MATERIALS);
	}
	
	public String getName() { return name; }
}
