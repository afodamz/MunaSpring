package com.munaapi.models.proverbs;

import com.munaapi.models.profile.UserProfile;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "user_comments")
public class PublicComment {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "proverb_id", referencedColumnName = "id")
    private Proverb proverb;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userprofile_id", referencedColumnName = "id")
    private UserProfile userProfile;

}
