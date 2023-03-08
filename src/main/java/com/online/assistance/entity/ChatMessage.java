package com.online.assistance.entity;

import lombok.*;

import java.util.Date;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "chat")
public class ChatMessage {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "chatId")
    private String chatId;

    @Column(name = "senderId")
    private String senderId;

    @Column(name = "recipientId")
    private String recipientId;

    @Column(name = "senderName")
    private String senderName;

    @Column(name = "recipientName")
    private String recipientName;

    @Column(name = "content")
    private String content;

    @Column(name = "timestamp")
    private Date timestamp;

    @Column(name = "status")
    private String status;
}
