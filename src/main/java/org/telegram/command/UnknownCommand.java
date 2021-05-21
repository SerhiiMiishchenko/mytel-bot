package org.telegram.command;

import org.telegram.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Unknown {@link Command}
 */
public class UnknownCommand implements Command{
    private final SendBotMessageService sendBotMessageService;
    public static final String UNKNOWN_MESSAGE = "Извините, я не понимаю. Введите /help для получения списка доступных команд";

    public UnknownCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), UNKNOWN_MESSAGE);
    }
}
