package jdoctor.appointment.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name="id")
public class DocUser extends Person implements Serializable {    
    @Getter @Setter
    private String userNick;
    
    @Getter @Setter
    private String password;
    
    @Getter @Setter
    private String passwordSalt;
    
    @ElementCollection(targetClass=UserRolesEnum.class)
    @Getter @Setter
    private Set<UserRolesEnum> roles;
    
    public boolean roleCheck(UserRolesEnum role) {
        return roles.contains(role);
    }
}
