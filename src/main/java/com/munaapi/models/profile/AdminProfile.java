package com.munaapi.models.profile;


import com.munaapi.models.proverbs.Ethnic;
import com.munaapi.models.user.AppUser;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString @Entity
@Table(name = "author_profile")
public class AdminProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String first_name;
    private String last_name;
    private String phone_number;

    @ManyToMany
    @JoinTable(
            name="author_profile_ethnic",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "id")
    )
    private Set<Ethnic> ethnic = new HashSet<>();

    @OneToOne
    @JoinColumn(name="user", referencedColumnName = "id")
    private AppUser user;
}
