package com.wairesd.webhookaction.event;

import com.wairesd.webhookaction.discord.webhook.Send;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void PlayerJoin (PlayerJoinEvent event) {
        String playerName = event.getPlayer().getName();

        Send.send("Игрок " + playerName + " зашёл на сервер");
    }
}
