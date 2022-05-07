package com.dolthhaven.project_coast.core.registry;

import com.dolthhaven.project_coast.ProjectCoast;
import com.teamabnormals.blueprint.core.util.registry.ItemSubRegistryHelper;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = ProjectCoast.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PCItems {
    public static final ItemSubRegistryHelper HELPER = ProjectCoast.REGISTRY_HELPER.getItemSubHelper();

    public static final RegistryObject<Item> SEAGULL_EGG = HELPER.createItem("seagull_egg", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
}
