package jdoctor.appointment.session;

import jdoctor.appointment.model.DocUser;
import lombok.Getter;
import lombok.Setter;


public class CurrentSession {
    @Getter @Setter
    public static DocUser user;
}
