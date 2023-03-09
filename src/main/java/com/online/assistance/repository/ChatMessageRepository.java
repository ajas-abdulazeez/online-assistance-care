package com.online.assistance.repository;

import com.online.assistance.entity.ChatMessage;
import com.online.assistance.entity.MessageStatus;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ChatMessageRepository extends CrudRepository<ChatMessage, String> {

    long countBySenderIdAndRecipientIdAndStatus(String senderId, String recipientId, MessageStatus status);

    List<ChatMessage> findByChatId(String chatId);

    @Modifying
    @Transactional
    @Query(value = "update ChatMessage set status = :status where senderId = :senderId and recipientId = :recipientId")
    Integer updateStatus( @Param("senderId") String senderId, @Param("recipientId") String recipientId, @Param("status") String status);


}
