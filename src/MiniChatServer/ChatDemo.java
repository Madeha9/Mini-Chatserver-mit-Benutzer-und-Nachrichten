package MiniChatServer;

//Create new users and apply the methods
public class ChatDemo {
    static void main(String[] args) throws MessageContentException {
        //create new user
        //join the server
        // send them messages
        User user1 = new User(1, "Thomas Peter");
        User user2 = new User(2, "Philip Adam");
        User user3 = new User(3, "Julian Peter");
        User user4 = new User(4, "Chris Ibrahim");
        User user5 = new User(5, "Helen juliy");
        ChatServer server = new ChatServer();
        server.adduser(user1);
        server.adduser(user2);
        server.adduser(user3);
        server.adduser(user4);
        server.adduser(user5);
        System.out.println("View all the users:");
        server.showAlluserList();
        try {
            server.privateMessage(new ChatMessage("46e", "Good Morning Thomas",
                    "Text"), user1, user2);
        } catch (MessageContentException e) {
            System.out.println("Error : " + e.getMessage());
        }
        try {
            server.broadcastMessage(new ChatMessage("Group3", "Hello guys Schwimpfort", "Text"), user3);
        } catch (MessageContentException e) {
            System.out.println("Error : " + e.getMessage());
        }

        server.findUserWithName("Tho");
        server.findUserWithName("qs");
        System.out.println("View all the messages in the server :");
        server.printAllMessages();
    }
}
