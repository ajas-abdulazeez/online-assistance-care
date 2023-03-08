package com.online.assistance.entity;


import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "chat_notification")
public class ChatNotification {

    @Id
    private String id;
    private String senderId;
    private String senderName;
}