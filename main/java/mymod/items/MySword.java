package mymod.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

public class MySword extends ItemSword {
	private String name;

	public MySword(ToolMaterial material, String name) {
		super(material);
		this.name = name;
		this.setUnlocalizedName(this.name);
		this.setCreativeTab(CreativeTabs.COMBAT);
	}

	public String getName() { return this.name; }
}
