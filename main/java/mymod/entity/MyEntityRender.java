package mymod.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class MyEntityRender extends RenderLiving {
	private static final ResourceLocation textures = new ResourceLocation("mymod:textures/entity/MyEntity.png");

	public MyEntityRender(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn) {
		super(renderManagerIn, modelBaseIn, shadowSizeIn);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return textures;
	}

}
