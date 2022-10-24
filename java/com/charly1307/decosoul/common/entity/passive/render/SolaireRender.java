package com.charly1307.decosoul.common.entity.passive.render;

import com.charly1307.decosoul.DecoSoulM;
import com.charly1307.decosoul.common.entity.passive.SolaireEntity;
import com.charly1307.decosoul.common.entity.passive.model.SolaireModel;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class SolaireRender extends GeoEntityRenderer<SolaireEntity> {

	public SolaireRender(EntityRendererManager renderManager) {
		super(renderManager, new SolaireModel());
		this.shadowSize = 0.5f;
	}

	@Override
	public ResourceLocation getEntityTexture(SolaireEntity entity) {
		return new ResourceLocation(DecoSoulM.MOD_ID, "textures/entity/solaire.png");
	}

	@Override
	public RenderType getRenderType(SolaireEntity animatable, float partialTicks, MatrixStack stack,
			IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn,
			ResourceLocation textureLocation) {

		return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn,
				textureLocation);
	}

}
