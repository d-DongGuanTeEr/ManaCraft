package yaossg.mod.mana_craft.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import yaossg.mod.Util;
import yaossg.mod.mana_craft.ManaCraft;
import yaossg.mod.mana_craft.item.ManaCraftItems;

import java.util.Random;

public class BlockManaOre extends Block {
    public BlockManaOre() {
        super(Material.ROCK);
        this.setSoundType(SoundType.STONE);
        this.setHarvestLevel("pickaxe",  Util.STONE_PICKAXE);
        this.setLightLevel(Util.getLightLevel(7));
        this.setHardness(3);
    }

    @Override
    public int quantityDroppedWithBonus(int fortune, Random random) {
        return 5 + fortune + random.nextInt(4 + fortune * 2);
    }
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return ManaCraftItems.itemMana;
    }
    @Override
    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
        return 1 + fortune;
    }
}