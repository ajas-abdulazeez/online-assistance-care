CREATE TABLE IF NOT EXISTS chat(
    id VARCHAR (40) NOT NULL PRIMARY KEY,
    chatId VARCHAR (40) NOT NULL,
    senderId VARCHAR (40) NOT NULL,
    recipientId VARCHAR (40) NOT NULL,
    senderName VARCHAR (40) NOT NULL,
    recipientName VARCHAR (40) NOT NULL,
    content VARCHAR (3000) NOT NULL,
    posted_date TIMESTAMP,
    status VARCHAR (40) NOT NULL
);

CREATE TABLE IF NOT EXISTS chat_notification(
    id VARCHAR (40) NOT NULL PRIMARY KEY,
    senderId VARCHAR (40) NOT NULL,
    senderName VARCHAR (40) NOT NULL
);

CREATE TABLE IF NOT EXISTS chat_room(
    id VARCHAR (40) NOT NULL PRIMARY KEY,
    chatId VARCHAR (40) NOT NULL,
    senderId VARCHAR (40) NOT NULL,
    recipientId VARCHAR (40) NOT NULL
);