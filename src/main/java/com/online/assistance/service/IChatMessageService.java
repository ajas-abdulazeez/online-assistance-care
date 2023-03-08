package com.online.assistance.service;

import com.online.assistance.entity.ChatMessage;
import com.online.assistance.entity.MessageStatus;

import java.util.List;

public interface IChatMessageService {

    ChatMessage save(ChatMessage chatMessage);

    long countNewMessages(String senderId, String recipientId);

    List<ChatMessage> findChatMessages(String senderId, String recipientId);
    ChatMessage findById(String id);

    void updateStatuses(String senderId, String recipientId, MessageStatus status);
}
