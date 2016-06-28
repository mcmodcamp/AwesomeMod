package mymod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;

public class MyBlock extends Block {
	private String name;
	
	public MyBlock(Material material, String name) {
		super(material);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		this.setUnlocalizedName(name);
		this.name = name;
	}
	
	public String getName() { return this.name; }

	public static class MyBlockItem extends ItemBlock {
		private String name;
		
		public MyBlockItem(Block block) {
			super(block);
			this.name = ((MyBlock) block).getName();
			this.setUnlocalizedName(this.name);
		}
		
		public String getName() { return this.name; }
	}
}
