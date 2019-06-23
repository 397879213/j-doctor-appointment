package jdoctor.appointment.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.OrderColumn;
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
    
    public AvailableSchedule(Integer id, Doctor doctor) {
        this.id = id;
        this.doctor = doctor;
 
        this.onMonday = new ArrayList<>();
        this.onTuesday = new ArrayList<>();
        this.onWednesday = new ArrayList<>();
        this.onThursday = new ArrayList<>();
        this.onFriday = new ArrayList<>();
        this.onSaturday = new ArrayList<>();
        this.onSunday = new ArrayList<>();
    }
    
    @Getter @Setter
    @OneToOne(mappedBy = "availableSchedule")
    private Doctor doctor;
    
    private List<Date> orderDate(List<Date> dates) {
        List<Date> aux = new ArrayList<Date>(dates);
        
        Collections.sort(aux, new Comparator<Date>() {
            public int compare(Date o1, Date o2) {
                return (o1.compareTo(o2));
            }
        });
        
        return aux;
    }
    
    @Setter
    @ElementCollection(targetClass=Date.class)
    @Temporal(TemporalType.TIMESTAMP)
    private List<Date> onMonday;
    
    public List<Date> getOnMonday() {
        return orderDate(onMonday);
    }
    
    @Setter
    @ElementCollection(targetClass=Date.class)
    @Temporal(TemporalType.TIMESTAMP)
    private List<Date> onTuesday;
    
    public List<Date> getOnTuesday() {
        return orderDate(onTuesday);
    }
    
    @Setter
    @ElementCollection(targetClass=Date.class)
    @Temporal(TemporalType.TIMESTAMP)
    private List<Date> onWednesday;
    
    public List<Date> getOnWednesday() {
        return orderDate(onWednesday);
    }
    
    @Setter
    @ElementCollection(targetClass=Date.class)
    @Temporal(TemporalType.TIMESTAMP)
    private List<Date> onThursday;
    
    public List<Date> getOnThursday() {
        return orderDate(onThursday);
    }
    
    @Setter
    @ElementCollection(targetClass=Date.class)
    @Temporal(TemporalType.TIMESTAMP)
    private List<Date> onFriday;
    
    public List<Date> getOnFriday() {
        return orderDate(onFriday);
    }
    
    @Setter
    @ElementCollection(targetClass=Date.class)
    @Temporal(TemporalType.TIMESTAMP)
    private List<Date> onSaturday;
    
    public List<Date> getOnSaturday() {
        return orderDate(onSaturday);
    }
    
    @Setter
    @ElementCollection(targetClass=Date.class)
    @Temporal(TemporalType.TIMESTAMP)
    private List<Date> onSunday;
    
    public List<Date> getOnSunday() {
        return orderDate(onSunday);
    }
}
