package com.charly1307.decosoul.common.entity.monster.geckoentities.model;

import com.charly1307.decosoul.DecoSoulM;
import com.charly1307.decosoul.common.entity.monster.geckoentities.KnightEntity;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class KnightModel extends AnimatedGeoModel<KnightEntity> {

	@Override
	public ResourceLocation getAnimationFileLocation(KnightEntity animatable) {
		return new ResourceLocation(DecoSoulM.MOD_ID, "animations/knight.animation.json");
	}

	@Override
	public ResourceLocation getModelLocation(KnightEntity object) {
		return new ResourceLocation(DecoSoulM.MOD_ID, "geo/knight.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(KnightEntity object) {
		return new ResourceLocation(DecoSoulM.MOD_ID, "textures/entity/knight.png");
	}

}
