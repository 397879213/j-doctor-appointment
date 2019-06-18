package jdoctor.appointment.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@NoArgsConstructor
@AllArgsConstructor
public class AvailableSchedule implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    
    @Getter @Setter
    @OneToOne(mappedBy = "availableSchedule")
    private Doctor doctor;
    
    @Getter @Setter
    @ElementCollection(targetClass=Date.class)
    @Temporal(TemporalType.TIMESTAMP)
    private List<Date> onMonday;
    
    @Getter @Setter
    @ElementCollection(targetClass=Date.class)
    @Temporal(TemporalType.TIMESTAMP)
    private List<Date> onTuesday;
    
    @Getter @Setter
    @ElementCollection(targetClass=Date.class)
    @Temporal(TemporalType.TIMESTAMP)
    private List<Date> onWednesday;
    
    @Getter @Setter
    @ElementCollection(targetClass=Date.class)
    @Temporal(TemporalType.TIMESTAMP)
    private List<Date> onThursday;
    
    @Getter @Setter
    @ElementCollection(targetClass=Date.class)
    @Temporal(TemporalType.TIMESTAMP)
    private List<Date> onFriday;
    
    @Getter @Setter
    @ElementCollection(targetClass=Date.class)
    @Temporal(TemporalType.TIMESTAMP)
    private List<Date> onSaturday;
    
    @Getter @Setter
    @ElementCollection(targetClass=Date.class)
    @Temporal(TemporalType.TIMESTAMP)
    private List<Date> onSunday;
    
    @Getter @Setter
    @ElementCollection(targetClass=Calendar.class)
    @Temporal(TemporalType.TIMESTAMP)
    private List<Calendar> daysOff;
}