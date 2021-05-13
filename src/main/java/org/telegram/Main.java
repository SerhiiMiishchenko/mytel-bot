package org.telegram;

import org.apache.log4j.Logger;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.updateshandlers.Bot;

public class Main {
    private static final Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) throws TelegramApiException {
        new Bot().botConnect();
        log.info("Start of Bot");
    }
}
