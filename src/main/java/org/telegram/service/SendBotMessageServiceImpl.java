package org.telegram.service;

import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.updateshandlers.Bot;


public class SendBotMessageServiceImpl implements SendBotMessageService {
    private static final Logger log = Logger.getLogger(SendBotMessageServiceImpl.class);
    private final Bot bot;

    public SendBotMessageServiceImpl(Bot bot) {
        this.bot = bot;
    }

    @Override
    public void sendMessage(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);

        try{
            bot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
            log.error("Error in SendBotMessageServiceImpl");
        }
    }
}
