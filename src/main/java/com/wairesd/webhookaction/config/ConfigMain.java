package com.wairesd.webhookaction.config;

import com.wairesd.webhookaction.config.configurators.Settings;
import org.bukkit.plugin.java.JavaPlugin;

public class ConfigMain {

    public static void starter(JavaPlugin plugin) {
        Settings.start(plugin);
    }
}
