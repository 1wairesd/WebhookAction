package com.wairesd.webhookaction;

import com.wairesd.webhookaction.command.WebHook;
import com.wairesd.webhookaction.config.ConfigMain;
import com.wairesd.webhookaction.discord.webhook.Send;
import com.wairesd.webhookaction.event.player.PlayerKillEntity;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.weather.LightningStrikeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Main extends JavaPlugin implements Listener {
    private static Main instance;

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        ConfigMain.starter(this);
        registerEvents();

        Objects.requireNonNull(this.getCommand("webhook")).setExecutor(new WebHook());
        Send.send("Сервер запущен");
    }

    private void registerEvents() {
        PluginManager pluginManager = getServer().getPluginManager();

        pluginManager.registerEvent(PlayerJoinEvent.class, this, EventPriority.NORMAL, (listener, event) -> {
            String playerName = ((PlayerJoinEvent) event).getPlayer().getName();

            Send.send("Игрок " + playerName + " зашёл на сервер");
        }, this);

        pluginManager.registerEvent(PlayerQuitEvent.class, this, EventPriority.NORMAL, (listener, event) -> {
            String playerName = ((PlayerQuitEvent) event).getPlayer().getName();

            Send.send("Игрок " + playerName + " вышел с сервера");
        }, this);

        pluginManager.registerEvent(PlayerDeathEvent.class, this, EventPriority.NORMAL, (listener, event) -> {
            String playerName = ((PlayerDeathEvent) event).getPlayer().getName();

            Send.send("Игрок " + playerName + " умер");
        }, this);

        pluginManager.registerEvent(LightningStrikeEvent.class, this, EventPriority.NORMAL, (listener, event) -> Send.send("Ударила молния!"), this);

        pluginManager.registerEvent(WeatherChangeEvent.class, this, EventPriority.NORMAL, (listener, event) -> {
            if (((WeatherChangeEvent) event).toWeatherState()) {
                Send.send("Начался дождь!");
            } else {
                Send.send("Дождь закончился!");
            }
        }, this);

        pluginManager.registerEvents(new PlayerKillEntity(), this);
    }
}
