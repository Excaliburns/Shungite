package org.tutmods.shungite.items.crystal.effects;

import lombok.Getter;
import lombok.Setter;
import net.minecraft.potion.Effect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.registries.ForgeRegistryEntry;

@Getter @Setter
public class ShungiteEffect extends ForgeRegistryEntry<ShungiteEffect> {
    private String name;
    private Effect minecraftEffect;
    private int pointValue;
    private TextFormatting color;

    public ShungiteEffect(ResourceLocation registryName) {
        this.setRegistryName(registryName);
    }

    public ShungiteEffect(final Effect effect, final String name, final int pointValue, final TextFormatting color) {
        this.name = name;
        this.minecraftEffect = effect;
        this.pointValue = pointValue;
        this.color = color;
    }

    public String getDisplayName() {
        return this.minecraftEffect.getDisplayName().getString();
    }
}
