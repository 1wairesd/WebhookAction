package com.wairesd.webhookaction;

import com.wairesd.webhookaction.command.WebHook;
import com.wairesd.webhookaction.config.ConfigMain;
import com.wairesd.webhookaction.discord.webhook.Send;
import com.wairesd.webhookaction.event.player.PlayerDeath;
import com.wairesd.webhookaction.event.player.PlayerJoin;
import com.wairesd.webhookaction.event.player.PlayerKillEntity;
import com.wairesd.webhookaction.event.player.PlayerQuit;
import com.wairesd.webhookaction.event.world.Lightning;
import com.wairesd.webhookaction.event.world.Weather;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    private static Main instance;

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        ConfigMain.starter(this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new PlayerQuit(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeath(), this);
        getServer().getPluginManager().registerEvents(new PlayerKillEntity(), this);
        getServer().getPluginManager().registerEvents(new Lightning(), this);
        getServer().getPluginManager().registerEvents(new Weather(), this);
        this.getCommand("webhook").setExecutor(new WebHook());
        Send.send("Сервер запущен");
    }

    @Override
    public void onDisable() {
        Send.send("Сервер остановлен");
    }
}
