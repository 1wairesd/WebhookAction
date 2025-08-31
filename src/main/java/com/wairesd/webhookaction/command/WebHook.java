package com.wairesd.webhookaction.command;

import com.wairesd.webhookaction.discord.webhook.Send;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class WebHook implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String label, @NotNull String[] strings) {
        if (strings.length == 0) {
            commandSender.sendMessage("Использование: /webhook <сообщение>");
            return true;
        }

        StringBuilder message = new StringBuilder();
        for (String arg : strings) {
            message.append(arg).append(" ");
        }

        Send.send(message.toString().trim());
        commandSender.sendMessage("Сообщение: '" + message.toString().trim() + "' отправлено в вебхук.");
        return true;
    }
}
