package com.wairesd.webhookaction;

import com.wairesd.webhookaction.config.ConfigMain;
import com.wairesd.webhookaction.event.PlayerJoin;
import com.wairesd.webhookaction.event.PlayerQuit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    private static Main instance;

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        ConfigMain.starter(this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new PlayerQuit(), this);
    }

    @Override
    public void onDisable() {
    }
}
