package jdoctor.appointment.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class Doctor extends DocUser {
    @Getter @Setter
    private String specialization;
    
    @OneToOne(cascade = CascadeType.ALL)
    @Getter @Setter
    private AvailableSchedule availableSchedule;
    
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Appointment> appointments;
}
