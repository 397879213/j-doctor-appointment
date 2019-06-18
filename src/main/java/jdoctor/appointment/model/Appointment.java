package jdoctor.appointment.model;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Appointment implements Serializable {
    @Id
    @GeneratedValue
    @Getter @Setter
    private Integer id;
    
    @ManyToOne
    @Getter @Setter
    private Doctor doctor;
    
    @ManyToOne
    @Getter @Setter
    private Secretary secretary;
    
    @ManyToOne
    @Getter @Setter
    private Person person;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter
    private Calendar data;
    
    @Getter @Setter
    private String description;
    
    @Getter @Setter
    private Float totalValue;
    
    @Getter @Setter
    private Integer installments;
}
