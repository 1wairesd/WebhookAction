package com.wairesd.webhookaction.tools.message.error.webhook;

public class SendError {
    public static void handle(int responseCode) {
        if (responseCode != 204 && responseCode != 200) {
            System.out.println("Error the send webhook: " + responseCode);
        }
    }
}
