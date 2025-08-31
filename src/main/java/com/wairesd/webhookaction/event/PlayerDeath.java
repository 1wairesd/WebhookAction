package com.wairesd.webhookaction.event;

import com.wairesd.webhookaction.discord.webhook.Send;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeath implements Listener {

    @EventHandler
    public void PlayerDeath(PlayerDeathEvent event) {
        String playerName = event.getPlayer().getName();

        Send.send("Игрок " + playerName + " умер");
    }
}
