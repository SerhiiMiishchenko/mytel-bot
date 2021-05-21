package org.telegram;

import org.apache.log4j.Logger;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import org.telegram.updateshandlers.Bot;


public class Main {
    private static final Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        //new Bot().botConnect();
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new Bot());
            log.info("Start of Bot");
        } catch (TelegramApiException e) {
            e.printStackTrace();
            log.error("Error in initializing");
        }
    }
}
