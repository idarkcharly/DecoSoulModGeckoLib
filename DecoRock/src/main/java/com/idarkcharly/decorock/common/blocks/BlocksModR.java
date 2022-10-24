package com.idarkcharly.decorock.common.blocks;

import com.google.common.base.Supplier;
import com.idarkcharly.decorock.DecoRockM;
import com.idarkcharly.decorock.common.items.ItemsModR;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlocksModR {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			DecoRockM.MOD_ID);

	// All Blocks
	public static final RegistryObject<Block> GEM_BLOCK = registerBlock("gem_block",
			() -> new Block(AbstractBlock.Properties.create(Material.ROCK)
					.harvestLevel(2)
					.setRequiresTool()
					.harvestTool(ToolType.PICKAXE)
					.hardnessAndResistance(1.5f, 6f)));

	private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
		RegistryObject<T> toReturn = BLOCKS.register(name, block);
		registerBlockItem(name, toReturn);
		return toReturn;
	}

	// Se registra el bloque en el Inventario?
	private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
		ItemsModR.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().group(ItemGroup.COMBAT)));
	}

	public static void register(IEventBus eventBus) {
		BLOCKS.register(eventBus);
	}
}
