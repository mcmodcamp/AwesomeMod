package mymod.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;

public class MyPickaxe extends ItemPickaxe {
	private String name;
	
	public MyPickaxe(ToolMaterial material, String name) {
		super(material);
		this.name = name;
		this.setUnlocalizedName(name);
		this.setCreativeTab(CreativeTabs.TOOLS);
	}
	
	public String getName() { return this.name; }
}
