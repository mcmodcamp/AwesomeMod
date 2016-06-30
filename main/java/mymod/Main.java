package mymod;

import java.awt.Color;

import mymod.armor.MyArmor;
import mymod.blocks.MyBlock;
import mymod.blocks.MyBlockGen;
import mymod.entity.MyEntity;
import mymod.entity.MyEntityModel;
import mymod.entity.MyEntityRender;
import mymod.items.MyFood;
import mymod.items.MyItem;
import mymod.items.MyPickaxe;
import mymod.items.MySword;
import mymod.proxies.CommonProxy;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = "Your Name Here",
	name = "Your Mod's Name Here",
	version = "1.5")
public class Main {
	@SidedProxy(clientSide="mymod.proxies.ClientProxy", serverSide="mymod.proxies.CommonProxy")
	public static CommonProxy proxy;

	// DECLARE THE ITEM
	public static MyItem myItem;
	
	// DECLARE NEW TOOL MATERIAL
	public static ToolMaterial MTM = EnumHelper.addToolMaterial("Awesomeness", 3, 15610, 180.0F, 30.0F, 20);

	// DECLARE THE SWORD
	public static MySword mySword;
	
	// DECLARE THE PICKAXE
	public static MyPickaxe myPickaxe;
	
	// DECLARE THE BLOCK
	public static MyBlock myBlock;
	public static MyBlock.MyBlockItem myBlockItem;
	
	// DECLARE THE ARMOR
	public static MyArmor myHelmet;
	public static MyArmor myChest;
	public static MyArmor myLeggings;
	public static MyArmor myBoots;
	
	// DECLARE THE ARMOR MATERIAL
	public static ArmorMaterial MAM = EnumHelper.addArmorMaterial("Awesomeness",  "MyChest_1", 33, new int[] {3,  8, 6, 3}, 10, null, 33.0F);
	
	// DECLARE THE FOOD
	public static MyFood myFood;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		// LOAD THE ITEM
		myItem = new MyItem("Awesome Item");
		GameRegistry.register(myItem, new ResourceLocation("mymod", myItem.getName()));
		
		// LOAD THE SWORD
		mySword = new MySword(MTM, "Awesome Sword");
		GameRegistry.register(mySword, new ResourceLocation("mymod", mySword.getName()));
		
		// LOAD THE PICKAXE
		myPickaxe = new MyPickaxe(MTM, "Awesome Pickaxe");
		GameRegistry.register(myPickaxe, new ResourceLocation("mymod", myPickaxe.getName()));
		
		// LOAD THE BLOCK
		myBlock = new MyBlock(Material.ROCK, "Awesome Block");
		myBlockItem = new MyBlock.MyBlockItem(myBlock);
		GameRegistry.register(myBlock, new ResourceLocation("mymod", myBlock.getName()));
		GameRegistry.register(myBlockItem, new ResourceLocation("mymod", myBlockItem.getName()));
		myBlock.setHarvestLevel("pickaxe", 0);
		myBlock.setHardness(5.0F);
		
		// LOAD THE ENTITY
		EntityRegistry.registerModEntity(MyEntity.class, "Awesome Cow", 3050, this, 80, 3, false);
		EntityRegistry.registerEgg(MyEntity.class,
				new Color(0, 255, 0).getRGB(),
				new Color(255, 0, 0).getRGB());
		EntityRegistry.addSpawn(MyEntity.class, 10, 1, 5, EnumCreatureType.MONSTER, Biomes.DESERT);
		RenderingRegistry.registerEntityRenderingHandler(MyEntity.class, new IRenderFactory<MyEntity>() {
			@Override
			public Render<? super MyEntity> createRenderFor(RenderManager manager) {
				return new MyEntityRender(manager, new MyEntityModel(), 0.3F);
			}
		});
		
		// LOAD ALL ARMOR PARTS
		myHelmet = new MyArmor("Awesome Helmet", MAM, 0, EntityEquipmentSlot.HEAD);
		myChest = new MyArmor("Awesome Chestplate", MAM, 0, EntityEquipmentSlot.CHEST);
		myLeggings = new MyArmor("Awesome Leggings", MAM, 0, EntityEquipmentSlot.LEGS);
		myBoots = new MyArmor("Awesome Boots", MAM, 0, EntityEquipmentSlot.FEET);
		GameRegistry.register(myHelmet, new ResourceLocation("mymod", myHelmet.getName()));
		GameRegistry.register(myChest, new ResourceLocation("mymod", myChest.getName()));
		GameRegistry.register(myLeggings, new ResourceLocation("mymod", myLeggings.getName()));
		GameRegistry.register(myBoots, new ResourceLocation("mymod", myBoots.getName()));
		
		// LOAD THE FOOD
		myFood = new MyFood("Awesome Food", 3, 3.0F, true);
		GameRegistry.register(myFood, new ResourceLocation("mymod", myFood.getName()));
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		// SET THE SWORD RECIPE
		GameRegistry.addRecipe(new ItemStack(mySword, 1), new Object[] {
			" X ",
			" X ",
			" S ",
			
			'X', myItem,
			'S', Items.STICK,
		});
		
		// SET THE PICKAXE RECIPE
		GameRegistry.addRecipe(new ItemStack(myPickaxe, 1), new Object[] {
			"XXX",
			" S ",
			" S ",
			
			'X', myItem,
			'S', Items.STICK,
		});
		
		// SET THE ARMOR RECIPES
		GameRegistry.addRecipe(new ItemStack(myHelmet, 1), new Object[] {
			"XXX",
			"X X",
			
			'X', myItem,
		});
		GameRegistry.addRecipe(new ItemStack(myChest, 1), new Object[] {
			"X X",
			"XXX",
			"XXX",
			
			'X', myItem,
		});
		GameRegistry.addRecipe(new ItemStack(myLeggings, 1), new Object[] {
			"XXX",
			"X X",
			"X X",
			
			'X', myItem,
		});
		GameRegistry.addRecipe(new ItemStack(myBoots, 1), new Object[] {
			"X X",
			"X X",
			
			'X', myItem,
		});
		
		// SET THE FOOD RECIPE
		GameRegistry.addRecipe(new ItemStack(myFood, 1), new Object[] {
			"BBB",
			" B ",
			"BBB",
			
			'B', Items.BREAD,
		});

		// SMELTING RECIPE
		GameRegistry.addSmelting(myBlock, new ItemStack(myItem, 1), 10);
	
		if(event.getSide() == Side.CLIENT) {
			RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
			
			// LOAD THE ITEM TEXTURE
			renderItem.getItemModelMesher().register(myItem, 0,
					new ModelResourceLocation("mymod:" + myItem.getName(), "inventory"));
			
			// LOAD THE SWORD TEXTURE
			renderItem.getItemModelMesher().register(mySword, 0,
					new ModelResourceLocation("mymod:" + mySword.getName(), "inventory"));
			
			// LOAD THE PICKAXE TEXTURE
			renderItem.getItemModelMesher().register(myPickaxe, 0,
					new ModelResourceLocation("mymod:" + myPickaxe.getName(), "inventory"));
			
			// LOAD THE BLOCK TEXTURE
			renderItem.getItemModelMesher().register(Item.getItemFromBlock(myBlock), 0,
					new ModelResourceLocation("mymod:" + myBlock.getName(), "inventory"));
			
			// LOAD THE ARMOR TEXTURES
			renderItem.getItemModelMesher().register(myHelmet, 0,
					new ModelResourceLocation("mymod:" + myHelmet.getName(), "inventory"));
			renderItem.getItemModelMesher().register(myChest, 0,
					new ModelResourceLocation("mymod:" + myChest.getName(), "inventory"));
			renderItem.getItemModelMesher().register(myLeggings, 0,
					new ModelResourceLocation("mymod:" + myLeggings.getName(), "inventory"));
			renderItem.getItemModelMesher().register(myBoots, 0,
					new ModelResourceLocation("mymod:" + myBoots.getName(), "inventory"));
			
			// LOAD THE FOOD TEXTURE
			renderItem.getItemModelMesher().register(myFood, 0,
					new ModelResourceLocation("mymod:" + myFood.getName(), "inventory"));
		}
		
		// REGISTER ORE GENERATION
		GameRegistry.registerWorldGenerator(new MyBlockGen(myBlock), 0);
	}
}
