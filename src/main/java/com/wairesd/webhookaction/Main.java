package com.wairesd.webhookaction;

import com.wairesd.webhookaction.config.ConfigMain;
import com.wairesd.webhookaction.discord.webhook.Send;
import com.wairesd.webhookaction.event.PlayerJoin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public Main() {
    }

    @Override
    public void onEnable() {
        ConfigMain.starter(this);
        new Send().main("Сервер запущен!");
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
    }

    @Override
    public void onDisable() {

    }
}
