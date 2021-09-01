package com.munaapi.models.user;

import com.munaapi.models.profile.UserProfile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
@Table(name = "custom_user")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String password;
    private boolean is_superuser;
    private boolean is_verified;
    private String email;
    private boolean is_admin;
    private boolean is_author;
    private boolean is_suspended;
    private String last_login;

    @OneToOne(mappedBy = "user")
    private UserProfile userProfile;

    @OneToOne(mappedBy = "author")
    private UserProfile author;

    @OneToOne(mappedBy = "reviewer")
    private UserProfile reviewer;

    @OneToOne(mappedBy = "publisher")
    private UserProfile publisher;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<AdminRoles> roles = new ArrayList<>();

    @CreationTimestamp
    private Date date_joined;
    @UpdateTimestamp
    private Date last_updated;
}
