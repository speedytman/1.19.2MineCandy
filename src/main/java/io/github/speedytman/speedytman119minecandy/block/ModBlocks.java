package io.github.speedytman.speedytman119minecandy.block;

import com.google.common.base.Supplier;
import io.github.speedytman.speedytman119minecandy.MineCandy;
import io.github.speedytman.speedytman119minecandy.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MineCandy.MODID);

    public static final  RegistryObject<Block> CANDY_CRYSTAL_ORE = registerBlock("candy_crystal_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops()
                    .strength(3.0F, 3.0F)), MineCandy.MINE_CANDY_TAB);

    public static final  RegistryObject<Block> DEEPSLATE_CANDY_CRYSTAL_ORE = registerBlock("deepslate_candy_crystal_ore",
            () -> new Block(BlockBehaviour.Properties.copy(ModBlocks.CANDY_CRYSTAL_ORE.get())
                    .strength(4.0f, 4.0f).requiresCorrectToolForDrops()), MineCandy.MINE_CANDY_TAB);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn,tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
