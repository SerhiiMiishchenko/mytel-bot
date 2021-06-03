package org.telegram.updateshandlers;

import org.apache.log4j.Logger;

import org.telegram.command.CommandContainer;
import org.telegram.service.SendBotMessageServiceImpl;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.*;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.telegram.command.CommandName.*;


public class Bot extends TelegramLongPollingBot{
    private static final Logger log = Logger.getLogger(Bot.class);
    final int RECONNECT_PAUSE = 10000;
    public static String COMMAND_PREFIX = "/";
    private final CommandContainer commandContainer;
    InputStream inputStream;
    private static final String BOT_NAME = System.getenv("BOT_NAME");
    private static final String BOT_TOKEN = System.getenv("BOT_TOKEN");


    public Bot() {
        super();
        this.commandContainer = new CommandContainer(new SendBotMessageServiceImpl(this));
    }

    @Override
    public String getBotUsername() {
        /*String botName = "";
        try {
            Properties properties = new Properties();
            String propFileName = "application.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            botName = properties.getProperty("bot.username");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        return BOT_NAME;
    }

    @Override
    public String getBotToken() {

        /*String botToken = "";
        try {
            Properties properties = new Properties();
            String propFileName = "application.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            botToken = properties.getProperty("bot.token");
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        return BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        log.debug("Receive new Update. updateID: " + update.getUpdateId());

        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            if (message.startsWith(COMMAND_PREFIX)) {
                String commandIdentifier = message.split(" ")[0].toLowerCase();
                commandContainer.retrieveCommand(commandIdentifier).execute(update);
            } else {
                commandContainer.retrieveCommand(NO.getCommandName()).execute(update);
            }
        }
    }

}
