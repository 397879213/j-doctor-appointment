package jdoctor.appointment.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Inheritance(strategy = InheritanceType.JOINED)
public class Person implements Serializable {
    @Id
    @GeneratedValue
    @Getter
    @EqualsAndHashCode.Include
    private Integer id;
    
    @Getter @Setter
    private String name;
    
    @Getter @Setter
    private String email;
    
    @Getter @Setter
    private String phoneNumber;
    
    @Getter @Setter
    private String docRG;
    
    @Getter @Setter
    private String docCPF;
    
    @Getter
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar registredAt;
    
    public Person(String name, String email, String phoneNumber, 
            String docRG, String docCPF) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.docRG = docRG;
        this.docCPF = docCPF;
    }
    
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Appointment> personAppointments;
}
