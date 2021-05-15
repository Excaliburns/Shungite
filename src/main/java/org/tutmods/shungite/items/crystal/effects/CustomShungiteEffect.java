package org.tutmods.shungite.items.crystal.effects;

import net.minecraft.potion.Effect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class CustomShungiteEffect extends ShungiteEffect {
    public String displayName;

    public CustomShungiteEffect(ResourceLocation registryName) {
        super(registryName);
    }

    public CustomShungiteEffect(final Effect effect, final String name, final int pointValue, final int maxLevel, final TextFormatting color, final String displayName) {
        super(effect, name, pointValue, maxLevel, color);
        this.displayName = displayName;
    }

    @Override
    public String getDisplayName() {
        return this.displayName;
    }
}
