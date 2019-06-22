package jdoctor.appointment.model;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Appointment implements Serializable {
    @Id
    @GeneratedValue
    @Getter @Setter
    private Integer id;
    
    @ManyToOne
    @Getter @Setter
    @ToString.Exclude
    private Doctor doctor;
    
    @ManyToOne
    @Getter @Setter
    @ToString.Exclude
    private Secretary secretary;
    
    @ManyToOne
    @Getter @Setter
    @ToString.Exclude
    private Person person;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter
    private Calendar data;
    
    @Getter @Setter
    private Integer duration;
    
    @Getter @Setter
    private String description;
    
    @Getter @Setter
    private Float totalValue;
    
    @Getter @Setter
    private Integer installments;
    
    @Enumerated(EnumType.STRING)
    @Getter @Setter
    private AppointmentTypeEnum appointmentType;
    
    @Enumerated(EnumType.STRING)
    @Getter @Setter
    private PaymentStatusEnum paymentStatus;
}
