package com.charly1307.decosoul.common.entity.monster.render;

import com.charly1307.decosoul.DecoSoulM;
import com.charly1307.decosoul.common.entity.monster.HollowKnightEntity;
import com.charly1307.decosoul.common.entity.monster.model.HollowKnightModel;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class HollowKnightRender extends MobRenderer<HollowKnightEntity, HollowKnightModel<HollowKnightEntity>> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation(DecoSoulM.MOD_ID,
			"textures/entity/knight.png");

	public HollowKnightRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new HollowKnightModel<>(), 0.5F);
	}

	@Override
	public ResourceLocation getEntityTexture(HollowKnightEntity entity) {
		return TEXTURE;
	}
}
