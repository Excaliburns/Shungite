package org.tutmods.shungite;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.tutmods.shungite.setup.Registration;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ShungiteConstants.MOD_ID)
public class Shungite
{
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    public Shungite() {
        Registration.register();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
}
