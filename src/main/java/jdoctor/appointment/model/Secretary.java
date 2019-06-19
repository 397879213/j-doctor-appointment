package jdoctor.appointment.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@PrimaryKeyJoinColumn(name="id")
@NoArgsConstructor
@AllArgsConstructor
public class Secretary extends DocUser {
    @OneToMany(mappedBy = "secretary", cascade = CascadeType.ALL)
    private List<Appointment> appointments;
}
