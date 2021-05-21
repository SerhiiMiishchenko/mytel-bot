package org.telegram.command;

import org.telegram.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Help{@link Command}
 */
public class HelpCommand implements Command{
    private final SendBotMessageService sendBotMessageService;
    private final String HELP_MESSAGE = "<b>Доступные команды</b>:\n"
            + "/start" + " - начало работы с ботом\n" +
            "/rp5" + " - узнать текущий прогноз с rp5\n" +
            "/gismeteo" + " - узнать текущий прогноз с Gismeteo\n" +
            "/help" + "- получить список всех команд";

    public HelpCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), HELP_MESSAGE);
    }
}
