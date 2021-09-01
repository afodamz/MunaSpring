package com.munaapi.models.proverbs;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.munaapi.models.user.AppUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "proverb")
public class Proverb {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String content;
    private String slug;
    @Enumerated(EnumType.STRING)
    private Status status;
    @CreationTimestamp
    private  Date date_created;
    @UpdateTimestamp
    private Date date_modified;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private AppUser author;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reviewer_id", referencedColumnName = "id")
    private AppUser reviewer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publisher_id", referencedColumnName = "id")
    private AppUser publisher;

    private Boolean hidden;
    private String origin;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "userProfile", cascade = CascadeType.ALL)
    private List<PublicComment> userComment;
}

enum Status{
    AWAITING, CREATED, ACCEPTED, REJECTED, PUBLISHED, UNPUBLISHED
}
