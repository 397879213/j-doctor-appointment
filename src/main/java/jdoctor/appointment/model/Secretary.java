package jdoctor.appointment.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class Secretary extends DocUser {
    @OneToMany(mappedBy = "secretary", cascade = CascadeType.ALL)
    private List<Appointment> appointments;
}
