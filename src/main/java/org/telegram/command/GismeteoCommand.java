package org.telegram.command;

import org.telegram.WeatherParser;
import org.telegram.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Gismeteo {@link Command}
 */
public class GismeteoCommand implements Command{
    private final SendBotMessageService sendBotMessageService;
    public final static String GISMETEO_MESSAGE = WeatherParser.getGismeteo();

    public GismeteoCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), GISMETEO_MESSAGE);
    }
}
