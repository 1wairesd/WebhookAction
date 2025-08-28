package com.wairesd.webhookaction.config.configurators;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Settings {
    private static FileConfiguration config;
    private static final String file_name = "settings.yml";

    public static void start(JavaPlugin plugin) {
        File file = new File(plugin.getDataFolder(), file_name);
        if (!file.exists()) {
            plugin.getDataFolder().mkdirs();
            plugin.saveResource(file_name, false);
        }
        config = YamlConfiguration.loadConfiguration(file);
    }

    public static String getWebhookUrl() {
        return config.getString("webhook-url", "");
    }
}
