package mana_craft.proxy;

import mana_craft.block.ManaCraftBlocks;
import mana_craft.entity.ManaCraftEntities;
import mana_craft.item.ManaCraftItems;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        ManaCraftItems.manager.loadAllModel();
        ManaCraftBlocks.manager.loadAllModel();
        ManaCraftEntities.clientInit();
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }
}