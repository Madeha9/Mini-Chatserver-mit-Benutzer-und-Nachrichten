package MiniChatServer;

import java.time.Instant;

public class User {
    //Attribute
    private final Integer userId;
    private String userName;
    ChatServer server;

    //Constructor
    public User(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.server = server;
    }

    //Getter and Setter
    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ChatServer getServer() {
        return server;
    }

    public void setServer(ChatServer server) {
        //use throw exception in some cases
        this.server = server;
    }

    //Methoden
    //send  messages to the server....
    void sendBroadcast() throws MessageContentException {
        ChatMessage newChatmessage = new ChatMessage("875f", "Der kurs fangt " +
                "um 9 uhr an ", "Text");
        newChatmessage.setClientTimestamp(Instant.now());
        server.broadcastMessage(newChatmessage, this);
//        server.privateMessage(newChatmessage, ,this);
        //Zeittempel
    }

    public void sendPrivateMessage(User touser) throws MessageContentException {
        ChatMessage message = new ChatMessage("6577", "Hello, are you coming tonight?", "Text");
        message.setClientTimestamp(Instant.now());
        message.setSenderId(this.getUserId().toString());
        message.setReceiverId(touser.getUserId().toString());
        server.privateMessage(message, touser, this);
        message.setClientTimestamp(Instant.now());
        System.out.println("time" + message.getClientTimestamp());

    }

    //receive messages  from the  server and other users as well ....
    void receiveMessage(ChatMessage message) throws MessageContentException {
        if (message.getContent().contains("Schwimpfort")) {
            throw new MessageContentException("Inappropriate word in message!");
        }
        if (message.getReceiverId() == null) {
            System.out.println("you have a new Broadcast message from " +
                    message.getSenderId() + message.getContent() + message.getClientTimestamp());
        } else {
            System.out.println("new message from" + message.getSenderId() +
                    message.getContent() + message.getClientTimestamp());
        }
    }
}
