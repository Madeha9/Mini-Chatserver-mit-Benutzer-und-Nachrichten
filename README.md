# MiniChatServer — README
scroll down for English version-------->

Kurzbeschreibung (Deutsch) 
--------------------------
Ein kleines Java-Beispielprojekt für einen einfachen Chat-Server im Package `MiniChatServer`. Enthalten ist eine Demo-Klasse `ChatDemo`, die mehrere `User` erzeugt, sie zum `ChatServer` hinzufügt und Nachrichten (private und Broadcast) versendet. Die Demo zeigt außerdem Suche nach Benutzern und Ausgabe aller Nachrichten.

Projektstruktur (erwartet)
--------------------------
- MiniChatServer/
  - ChatDemo.java
  - ChatServer.java
  - User.java
  - ChatMessage.java
  - MessageContentException.java

Wichtige Klassen & Methoden
--------------------------
- ChatDemo
  - main(String[] args): Demo, die den Server verwendet (Bereits vorhanden in deinem Snippet).
- ChatServer
  - adduser(User u): Benutzer zum Server hinzufügen.
  - showAlluserList(): Alle registrierten Benutzer ausgeben.
  - privateMessage(ChatMessage msg, User from, User to): Sende eine private Nachricht von `from` an `to`. Kann eine `MessageContentException` werfen.
  - broadcastMessage(ChatMessage msg, User from): Sende eine Broadcast-Nachricht von `from` an alle Nutzer.
  - findUserWithName(String nameFragment): Suche Benutzer anhand eines Namensfragments (Teilübereinstimmung).
  - printAllMessages(): Gibt alle bisherigen Nachrichten im Server aus.
- User
  - Konstruktor: User(int id, String name)
  - getter/setter je nach Implementierung (z. B. getId(), getName()).
- ChatMessage
  - Konstruktor: ChatMessage(String idOrThread, String content, String type)
  - Enthält Nachrichteninhalt, Typ (z. B. "Text") und optional Thread-/Konversations-ID.
- MessageContentException
  - Custom Exception, wird bei ungültigem oder verbotenem Nachrichteninhalt geworfen.

Voraussetzungen
--------------
- Java Development Kit (JDK) 11+ installiert.
- Source-Dateien liegen im Paketverzeichnis `MiniChatServer/`.

Build & Run (einfach)
---------------------
1. Auf Verzeichnisebene mit den Quelldateien:
   - Kompilieren:
     javac MiniChatServer/*.java
   - Ausführen:
     java MiniChatServer.ChatDemo

2. Oder in ein Output-Verzeichnis:
   - javac -d out MiniChatServer/*.java
   - java -cp out MiniChatServer.ChatDemo

Beispielausgabe 
--------------------------
View all the users:
User{id=1, name='Thomas Peter'}
User{id=2, name='Philip Adam'}
User{id=3, name='Julian Peter'}
User{id=4, name='Chris Ibrahim'}
User{id=5, name='Helen juliy'}
Message sent: [private] from Thomas Peter to Philip Adam — Good Morning Thomas
Message sent: [broadcast] from Julian Peter — Hello guys Schwimpfort
Search results for "Tho":
 - Thomas Peter
Search results for "qs":
 - (keine Treffer)
View all the messages in the server :
[1] (private) Thomas Peter -> Philip Adam: Good Morning Thomas
[2] (broadcast) Julian Peter -> ALL: Hello guys Schwimpfort


Fehlerbehandlung
----------------
- Demo fängt `MessageContentException` ab und gibt Fehler-/Fehlermeldungen auf System.out aus.
- Weitere Exceptions (z. B. NullPointer bei unbekannten Usern) solltest du gezielt behandeln oder mit aussagekräftigen Fehlermeldungen versehen.


English Version
===============

Short description (English)
---------------------------
A small Java example project for a simple chat server in the `MiniChatServer` package. The demo class `ChatDemo` creates multiple `User` instances, adds them to a `ChatServer`, and sends messages (private and broadcast). The demo also demonstrates searching for users and printing all messages.

Expected project layout
-----------------------
- MiniChatServer/
  - ChatDemo.java
  - ChatServer.java
  - User.java
  - ChatMessage.java
  - MessageContentException.java

Key classes & methods
---------------------
- ChatDemo
  - main(String[] args): Demo that uses the server (provided by your snippet).
- ChatServer
  - adduser(User u): Add a user to the server.
  - showAlluserList(): Print all registered users.
  - privateMessage(ChatMessage msg, User from, User to): Send a private message; may throw MessageContentException.
  - broadcastMessage(ChatMessage msg, User from): Send a broadcast message from `from` to all users.
  - findUserWithName(String nameFragment): Find users by partial name match.
  - printAllMessages(): Prints all messages stored on the server.
- User
  - Constructor: User(int id, String name)
  - Provide getters/setters as needed.
- ChatMessage
  - Constructor: ChatMessage(String idOrThread, String content, String type)
  - Holds content, type, and optional thread/conversation ID.
- MessageContentException
  - Custom exception thrown for invalid/forbidden message content.

Prerequisites
-------------
- Java JDK 11+ installed.
- Sources under package path `MiniChatServer/`.

Build & Run (simple)
--------------------
1. From directory containing the source files:
   - Compile:
     javac MiniChatServer/*.java
   - Run:
     java MiniChatServer.ChatDemo

2. Or using an output directory:
   - javac -d out MiniChatServer/*.java
   - java -cp out MiniChatServer.ChatDemo

Sample output (approx.)
-----------------------
View all the users:
User{id=1, name='Thomas Peter'}
User{id=2, name='Philip Adam'}
User{id=3, name='Julian Peter'}
User{id=4, name='Chris Ibrahim'}
User{id=5, name='Helen juliy'}
Message sent: [private] from Thomas Peter to Philip Adam — Good Morning Thomas
Message sent: [broadcast] from Julian Peter — Hello guys Schwimpfort
Search results for "Tho":
 - Thomas Peter
Search results for "qs":
 - (no matches)
View all the messages in the server :
[1] (private) Thomas Peter -> Philip Adam: Good Morning Thomas
[2] (broadcast) Julian Peter -> ALL: Hello guys Schwimpfort



