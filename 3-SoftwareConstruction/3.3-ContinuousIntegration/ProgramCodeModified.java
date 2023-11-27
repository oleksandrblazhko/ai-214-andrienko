/**
 * Represents a message in the system.
 */
package com.example.myapplication.models;

import java.util.Date;

/**
 * Represents a message in the system.
 */
public final class Message {
    /**
     * The username of the sender.
     */
    private String userName;

    /**
     * The text content of the message.
     */
    private String textMessage;

    /**
     * The timestamp of the message.
     */
    private long messageTime;

    /**
     * Default constructor.
     */
    public Message() {
    }

    /**
     * Creates a new message with the given username and text message.
     *
     * @param initialUserName The username of the sender.
     * @param initialTextMessage The text content of the message.
     */
    public Message(final String initialUserName,
                   final String initialTextMessage) {
        this.userName = initialUserName;
        this.textMessage = initialTextMessage;
        this.messageTime = new Date().getTime();
    }

    /**
     * Gets the username of the sender.
     *
     * @return The username.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the username of the sender.
     *
     * @param newUserName The new username.
     */
    public void setUserName(final String newUserName) {
        this.userName = newUserName;
    }

    /**
     * Gets the text content of the message.
     *
     * @return The text content.
     */
    public String getTextMessage() {
        return textMessage;
    }

    /**
     * Sets the text content of the message.
     *
     * @param newTextMessage The new text content.
     */
    public void setTextMessage(final String newTextMessage) {
        this.textMessage = newTextMessage;
    }

    /**
     * Gets the timestamp of the message.
     *
     * @return The timestamp.
     */
    public long getMessageTime() {
        return messageTime;
    }

    /**
     * Sets the timestamp of the message.
     *
     * @param newMessageTime The new timestamp.
     */
    public void setMessageTime(final long newMessageTime) {
        this.messageTime = newMessageTime;
    }
}
