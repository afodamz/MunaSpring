package com.munaapi.models.profile;


import com.munaapi.models.proverbs.PublicComment;
import com.munaapi.models.user.AppUser;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor @Getter
@Setter @ToString @Entity @Table(name = "user_profile")
public class UserProfile {

    @Id @GeneratedValue
    private Long id;
    private int gender;
    private String first_name;
    private String last_name;
    private String phone_number;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private AppUser user;
    // @Column(name="address", length=512)
    private String address;
    private String city;
    private String country;
    private String username;
    private String state;

    @OneToMany(mappedBy = "userProfile", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PublicComment> publicComments;

}
