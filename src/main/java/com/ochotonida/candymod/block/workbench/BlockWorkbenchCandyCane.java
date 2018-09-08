package com.ochotonida.candymod.block.workbench;

import com.ochotonida.candymod.block.candycane.BlockCandyCane;
import net.minecraft.block.BlockWorkbench;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockWorkbenchCandyCane extends BlockCandyCane {

    public BlockWorkbenchCandyCane() {
        super("candy_cane_workbench");
        this.setRecursiveMiningSpeed(false);
        this.setStackable(false);
        this.setTrunkBlock(false);
    }

    public void registerOreNames() { }

    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (worldIn.isRemote) {
            return true;
        } else {
            playerIn.displayGui(new BlockWorkbench.InterfaceCraftingTable(worldIn, pos));
            playerIn.addStat(StatList.CRAFTING_TABLE_INTERACTION);
            return true;
        }
    }
}
