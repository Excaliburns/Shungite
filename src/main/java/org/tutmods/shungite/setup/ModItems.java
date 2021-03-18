package org.tutmods.shungite.setup;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import org.tutmods.shungite.ShungiteConstants;
import org.tutmods.shungite.items.Shungite;

public class ModItems {
    public static final RegistryObject<Item> SHUNGITE = Registration.ITEM_DEFERRED_REGISTER.register("shungite", () ->
            new Shungite(new Item.Properties().tab(ShungiteConstants.SHUNGITE_GROUP)));

    static void register() {}
}
