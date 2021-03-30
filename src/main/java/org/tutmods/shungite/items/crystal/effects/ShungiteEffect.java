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
    private Effect minecraftEffect;
    private String name;
    private int pointValue;
    private TextFormatting color;
    private ITextComponent readableName;

    public ShungiteEffect(ResourceLocation registryName) {
        this.setRegistryName(registryName);
    }

    public ShungiteEffect(final Effect effect, final String name, final int pointValue, final TextFormatting color, final ITextComponent readableName) {
        this.minecraftEffect = effect;
        this.name = name;
        this.pointValue = pointValue;
        this.color = color;
        this.readableName = readableName;
    }
}
