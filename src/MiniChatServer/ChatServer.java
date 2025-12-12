package MiniChatServer;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//manages all users and messages
public class ChatServer {
    //Attribute
    private List<ChatMessage> saveMessage = new ArrayList<>();
    private List<User> alluserList = new ArrayList<>();

    //Constructor
//    public ChatServer(List<User> alluserList) {
//        this.alluserList = alluserList;
//    }
    //Getter and Setter
    public List<ChatMessage> getSaveMessage() {
        return saveMessage;
    }

    public void setSaveMessage(List<ChatMessage> saveMessage) {
        this.saveMessage = saveMessage;
    }

    public List<User> getAlluserList() {
        return alluserList;
    }

    public void setAlluserList(List<User> alluserList) {
        this.alluserList = alluserList;
    }

    //Functions/Methods
    //(done)
    public void adduser(User user) {
        alluserList.add(user);
        System.out.println(user.getUserName() + " has been added to the server");
    }

    //show all the users in the server (done)
    public void showAlluserList() {
        for (User user : alluserList) {
            System.out.println("User Name : " + user.getUserName() + "|" + "ID:" + user.getUserId());

        }
    }

    //forward the message to all users except the sender(done)
    void broadcastMessage(ChatMessage newmessage, User sender) throws MessageContentException {
        newmessage.setSenderId(sender.getUserId().toString());
        newmessage.setTimestamp(Instant.now());
        newmessage.setReceiverId(null);
        for (User user : alluserList) {
            if (!user.getUserId().equals(sender.getUserId())) {
                System.out.println(sender.getUserName().toString() +
                        " Sent a message to everyone ");
                user.receiveMessage(newmessage);
            }
            saveMessages(newmessage);
        }
        //Zeittempel
    }

    //use streams, collections, filters (done)
    public List<User> findUserWithName(String partofusername) {
        List<User> result = new ArrayList<>();
        result = alluserList.stream().filter(u -> u.getUserName().toLowerCase().
                contains(partofusername.toLowerCase())).collect(Collectors.toList());
        for (User user : result) {
            System.out.println("User Name : " + user.getUserName() + "|" + "ID:" + user.getUserId());
        }
        if (result.isEmpty()) {
            System.out.println("No user with username char " + partofusername +
                    " found, please try again");
        }
        return result;
    }

    //choose one user 1:1 (done)
    public void privateMessage(ChatMessage newmessage, User touser, User fromuser) throws MessageContentException {
        newmessage.setReceiverId(touser.getUserId().toString());
        newmessage.setSenderId(fromuser.getUserId().toString());
        newmessage.setTimestamp(Instant.now());
        System.out.println("Time:" + newmessage.getTimestamp());
        saveMessages(newmessage);
        boolean found = false;
        for (User user : alluserList) {
            if (user.getUserId().equals(touser.getUserId())) {
                System.out.println("[" + touser.getUserName() + "]" + "you have a new message from " + " :" + fromuser.getUserName());
                user.receiveMessage(newmessage);
                found = true;
            }
        }
        if (!found) {
            System.out.println(" no receiver, please check the information  " + touser.getUserName());
        }
    }

    //save all the messages in the server (done)
    public void saveMessages(ChatMessage newmessage) {
        saveMessage.add(newmessage);
    }

    public void printAllMessages() {
        for (ChatMessage newmessage : saveMessage) {
            System.out.println(newmessage.getSenderId() + "|" + newmessage.getTimestamp() + "||" + newmessage.getReceiverId() +
                    "||" + newmessage.getClientTimestamp() + "||" + newmessage.getContent() + "||" +
                    "||" + newmessage.getType() + "||" + newmessage.getChatId());
        }
    }
}
