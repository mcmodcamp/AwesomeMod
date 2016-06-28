package mymod.armor;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class MyArmor extends ItemArmor {
	private String name;
	
	public MyArmor(String name, ArmorMaterial material, int renderIndex, EntityEquipmentSlot armorType) {
		super(material, renderIndex, armorType);
		this.name = name;
		this.setUnlocalizedName(name);
		this.setCreativeTab(CreativeTabs.COMBAT);
	}
	
	public String getName() { return name; }
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
		if(slot == EntityEquipmentSlot.HEAD || slot == EntityEquipmentSlot.CHEST || slot == EntityEquipmentSlot.FEET)
			return "mymod:textures/models/armor/myarmor_1.png";
		else if(slot == EntityEquipmentSlot.LEGS)
			return "mymod:textures/models/armor/myarmor_2.png";
		else
			return null;
	}
}
