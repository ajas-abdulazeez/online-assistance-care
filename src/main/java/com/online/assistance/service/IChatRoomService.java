package com.online.assistance.service;

import java.util.Optional;

public interface IChatRoomService {

    Optional<String> getChatId( String senderId, String recipientId, boolean createIfNotExist);
}
