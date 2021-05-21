package org.telegram.command;

import org.telegram.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * No {@link Command}
 */
public class NoCommand implements Command{
    private final SendBotMessageService sendBotMessageService;
    private final String NO_MESSAGE = "Я поддерживаю команды которые начинаются " +
            "с \"/\".\n Для вывода списка доступных команд" +
            "введите /help";

    public NoCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), NO_MESSAGE);
    }
}
