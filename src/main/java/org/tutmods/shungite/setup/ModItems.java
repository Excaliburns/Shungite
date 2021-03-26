package org.tutmods.shungite.setup;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import org.tutmods.shungite.ShungiteConstants;
import org.tutmods.shungite.items.crystal.ShungiteCrystal;

public class ModItems {
    public static final RegistryObject<Item> SHUNGITE = Registration.ITEM_DEFERRED_REGISTER.register("shungite", () ->
            new ShungiteCrystal(new Item.Properties().tab(ShungiteConstants.SHUNGITE_GROUP)));

    static void register() {}
}
