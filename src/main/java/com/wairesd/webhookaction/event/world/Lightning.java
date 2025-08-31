package com.wairesd.webhookaction.event.world;

import com.wairesd.webhookaction.discord.webhook.Send;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.LightningStrikeEvent;

public class Lightning implements Listener {

    @EventHandler
    public void onLightningStrike(LightningStrikeEvent event) {
        Send.send("Ударила молнии!");
    }
}
