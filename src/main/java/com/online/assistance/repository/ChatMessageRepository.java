package com.online.assistance.repository;

import com.online.assistance.entity.ChatMessage;
import com.online.assistance.entity.MessageStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage, String> {

    long countBySenderIdAndRecipientIdAndStatus(String senderId, String recipientId, MessageStatus status);

    List<ChatMessage> findByChatId(String chatId);

    @Modifying
    @Transactional
    @Query(value = "update chat u set u.status = :status where u.senderId = :senderId and u.recipientId = :recipientId",nativeQuery = true)
    void updateStatus( @Param("senderId") String senderId, @Param("recipientId") String recipientId, @Param("status") String status);


}
