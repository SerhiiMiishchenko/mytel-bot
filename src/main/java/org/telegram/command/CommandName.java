package org.telegram.command;

/**
 * Enumeration for {@link Command}'s
 */
public enum CommandName {
    START("/start"),
    RP5("/rp5"),
    GISMETEO("/gismeteo"),
    NO("nocommand"),
    HELP("/help");

    private final String commandName;

    CommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}
