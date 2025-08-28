package com.wairesd.webhookaction.tools.message.error.webhook;

public class SendNotFound {
    public static boolean check(String webhookUrl) {
        if (webhookUrl == null || webhookUrl.isEmpty()) {
            System.out.println("Webhook URL not found!");
            return true;
        }
        return false;
    }

}
