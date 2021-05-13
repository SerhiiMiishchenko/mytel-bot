package org.telegram.command;

import org.telegram.WeatherParser;
import org.telegram.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;


/**
 * Rp5 {@link Command}
 */
public class Rp5Command implements Command{
    private final SendBotMessageService sendBotMessageService;
    public final static String RP5_MESSAGE = WeatherParser.getRp5Weather();

    public Rp5Command(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), RP5_MESSAGE);
    }
}
