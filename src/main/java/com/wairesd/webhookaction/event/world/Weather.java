package com.wairesd.webhookaction.event.world;

import com.wairesd.webhookaction.discord.webhook.Send;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class Weather implements Listener {

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent event) {
        if (event.toWeatherState()) {
            Send.send("Начался дождь!");
        } else {
            Send.send("Дождь закончился!");
        }
    }
}
