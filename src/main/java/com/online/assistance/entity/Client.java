package com.online.assistance.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "app_id")
    private String appId;

    @Column(name = "email_id")
    private String email;

    @Column(name = "created_date")
    private Date timestamp;

    @Column(name = "status")
    private String status;

    @Column(name = "secret")
    private String secretKey;


    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "client_members",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<UserAccounts> users = new HashSet<>();


}
