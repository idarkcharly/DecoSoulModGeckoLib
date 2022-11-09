package com.charly1307.decosoul.common.entity.monster.geckoentities.render;

import com.charly1307.decosoul.DecoSoulM;
import com.charly1307.decosoul.common.entity.monster.geckoentities.KnightEntity;
import com.charly1307.decosoul.common.entity.monster.geckoentities.model.KnightModel;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class KnightRender extends GeoEntityRenderer<KnightEntity> {

	public KnightRender(EntityRendererManager renderManager) {
		super(renderManager, new KnightModel());
		this.shadowSize = 0.4f;
	}

	@Override
	public ResourceLocation getEntityTexture(KnightEntity entity) {
		return new ResourceLocation(DecoSoulM.MOD_ID, "textures/entity/knight.png");
	}

	@Override
	public RenderType getRenderType(KnightEntity animatable, float partialTicks, MatrixStack stack,
			IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn,
			ResourceLocation textureLocation) {

		return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn,
				textureLocation);
	}
}
