package com.charly1307.decosoul.common.entity.passive.model;

import com.charly1307.decosoul.DecoSoulM;
import com.charly1307.decosoul.common.entity.passive.SolaireEntity;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SolaireModel extends AnimatedGeoModel<SolaireEntity> {

	@Override
	public ResourceLocation getAnimationFileLocation(SolaireEntity animatable) {
		return new ResourceLocation(DecoSoulM.MOD_ID, "animations/solaire.animation.json");
	}

	@Override
	public ResourceLocation getModelLocation(SolaireEntity object) {
		return new ResourceLocation(DecoSoulM.MOD_ID, "geo/solaire.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(SolaireEntity object) {
		return new ResourceLocation(DecoSoulM.MOD_ID, "textures/entity/solaire.png");
	}

}
