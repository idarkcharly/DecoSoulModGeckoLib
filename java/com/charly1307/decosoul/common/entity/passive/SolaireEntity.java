package com.charly1307.decosoul.common.entity.passive;

import com.charly1307.decosoul.common.items.ItemsModR;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MerchantOffer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class SolaireEntity extends AbstractVillagerEntity implements IAnimatable {
	private boolean invulnerable;
	private AnimationFactory factory = new AnimationFactory(this);

	public SolaireEntity(EntityType<? extends AbstractVillagerEntity> type, World worldIn) {
		super(type, worldIn);
	}

	public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 1024.0D);
	}

	protected void registerGoals() {
		return;
	}

	@SuppressWarnings("deprecation")
	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		if (event.isMoving()) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.solaire.walk", true));
			return PlayState.CONTINUE;
		}
		event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.solaire.idle", true));
		return PlayState.CONTINUE;
	}

	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<IAnimatable>(this, "controller", 0, this::predicate));

	}

	@Override
	public AnimationFactory getFactory() {
		return factory;
	}

	/**
	 * Returns whether this Entity is invulnerable to the given DamageSource.
	 */
	public boolean isInvulnerableTo(DamageSource source) {
		return this.invulnerable && source != DamageSource.OUT_OF_WORLD && !source.isCreativePlayer();
	}

	public boolean isInvulnerable() {
		return this.invulnerable;
	}

	/**
	 * Sets whether this Entity is invulnerable.
	 */
	public void setInvulnerable(boolean isInvulnerable) {
		this.invulnerable = isInvulnerable;
	}

	@Override
	protected void onVillagerTrade(MerchantOffer offer) {
	}

	@Override
	protected void populateTradeData() {

	}

	public void onDeath(DamageSource cause) {
		super.onDeath(cause);
	}

	protected ActionResultType getEntityInteractionResult(PlayerEntity playerIn, Hand hand) {
		ItemStack itemstack = playerIn.getHeldItem(hand);
		Item item = itemstack.getItem();
		if (item != ItemsModR.HUMANITY.get()) {
			return ActionResultType.PASS;
		} else {

			float f1 = 1.0F + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F;
			this.playSound(SoundEvents.ENTITY_IRON_GOLEM_REPAIR, 1.0F, f1);

			if (!playerIn.abilities.isCreativeMode) {
				itemstack.shrink(1);
			}

			return ActionResultType.func_233537_a_(this.world.isRemote);
		}
	}

	@Override
	public AgeableEntity createChild(ServerWorld world, AgeableEntity mate) {
		return null;
	}
}
