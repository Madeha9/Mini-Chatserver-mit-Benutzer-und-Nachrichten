package MiniChatServer;

import java.time.Instant;
import java.util.UUID;

public class ChatMessage {
    private UUID messageId; //zufallig
    private String chatId;// room ID group chat or 1:1
    private String senderId; //von server deshalb schreiben wir es nich im  konst
    private String receiverId; // von server , group chat null , only for  1:1 chat
    private String content;   //content of the message
    private String type; // //  image | file |text etc....
    private Instant timestamp; // when the server saved/received the message
    private Instant clientTimestamp; // when the user sent the messsage

    public ChatMessage(String chatId, String content, String type) {
        this.messageId = UUID.randomUUID();
        this.chatId = chatId;
        this.content = content;
        this.type = type;
//        this.clientTimestamp = Instant.now();
    }

    //Getter and Setter
    public UUID getMessageId() {
        return messageId;
    }

    public void setMessageId(UUID messageId) {
        this.messageId = messageId;
    }

    public Instant getClientTimestamp() {
        return clientTimestamp;
    }

    public void setClientTimestamp(Instant clientTimestamp) {
        this.clientTimestamp = clientTimestamp;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }
}