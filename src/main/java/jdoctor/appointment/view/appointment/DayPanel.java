/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdoctor.appointment.view.appointment;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdoctor.appointment.model.Appointment;
import lombok.Setter;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author aug
 */
public class DayPanel extends javax.swing.JPanel {
    private Calendar auxCalendar;
    private Calendar calendar;
    private int minutesTime;
    private final SimpleDateFormat sdf;
    private final SimpleDateFormat date;
    private final SimpleDateFormat day;
    private Date time;
    private ArrayList<AppointmentPanel> appointmentsComp;
    private ArrayList<AppointmentPanel> scheludeComp;
    private Dimension oldDimension;
    
    private ArrayList<Appointment> appointments;
    
    private List<Date> schedule;
    
    @Setter
    private AppointmentMain appointmentMain;
    /**
     * Creates new form DayPanel
     */
    public DayPanel(Calendar calendar, boolean pair, 
            AppointmentMain appointmentMain, ArrayList<Appointment> appointments,
            List<Date> schedule) {
        initComponents();
        panelSchedule.setOpaque(false);
        minutesTime = 0;
        this.appointmentMain = appointmentMain;
        
        appointmentsComp = new ArrayList<>();
        scheludeComp = new ArrayList<>();

        this.schedule = schedule;
        
        this.appointments = appointments;
        
        this.calendar = calendar;
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        
        sdf = new SimpleDateFormat("HH:mm");
        date = new SimpleDateFormat("dd/MM/yyyy");
        day = new SimpleDateFormat("EEEEE");
        lblTime.setText("00:00");
        lblTime.setVisible(false);
        
        panelAppointments.setOpaque(false);
        if (pair) {
            panelAp.setBackground(new Color(230, 230, 230));
            headerPanel.setBackground(new Color(200, 200, 200));
        } else {
            panelAp.setBackground(new Color(220, 220, 220));
            headerPanel.setBackground(new Color(190, 190, 190));
        }
        
        lblDay.setText(date.format(calendar.getTime()));
        lblDayString.setText(day.format(calendar.getTime()));
    }
    
    public void addSchedule() {
        for (AppointmentPanel comp : scheludeComp) {
            panelAp.remove(comp);
        }
        
        scheludeComp = new ArrayList<>();
        
        Float maxMinutes = 288f;
        Float step = (maxMinutes /panelAppointments.getHeight());
        
        for (int i = 0; i < schedule.size(); i += 2) {
            Date date = schedule.get(i);
            Calendar ap = Calendar.getInstance();
            ap.setTime(date);
            
            
            AppointmentPanel panel = new AppointmentPanel();
            Integer minute = (ap.get(Calendar.MINUTE)+
                    ap.get(Calendar.HOUR_OF_DAY)*60)/5;
            
            Color color = new Color(200, Math.round((255*minute)/288),200);
            panel.setColor(color);
            
            Integer posy = Math.round((minute*panelAppointments.getHeight())/288);
            
            // Altura
            Calendar ap2 = Calendar.getInstance();
            ap2.setTime(schedule.get(i+1));
            Integer duration = ap2.get(Calendar.HOUR_OF_DAY)*60+ap2.get(Calendar.MINUTE);
            duration -= ap.get(Calendar.HOUR_OF_DAY)*60+ap.get(Calendar.MINUTE);
            
            Integer heigth = Math.round(((duration/5)*panelAppointments.getHeight())/288);
            
            panelAp.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, posy, 200, heigth));
            scheludeComp.add(panel);
            
        }
        
        panelAp.revalidate();
        panelAp.repaint();
    }
    
    public void addAppointments() {
        for (AppointmentPanel comp : appointmentsComp) {
            panelAp.remove(comp);
        }
        appointmentsComp = new ArrayList<>();
        
        Float maxMinutes = 288f;
        Integer minMinutes = 0;
        
        Float step = (maxMinutes /panelAppointments.getHeight());
        
        for (Appointment ap : appointments) {
            AppointmentPanel panel = new AppointmentPanel();
            Integer minute = ((ap.getData()).get(Calendar.MINUTE)+
                    (ap.getData()).get(Calendar.HOUR_OF_DAY)*60)/5;
            
            Color color = new Color(Math.round((255*minute)/288),175,150);
            panel.setColor(color);
            
            Integer posy = Math.round((minute*panelAppointments.getHeight())/288);
            Integer heigth = Math.round(((ap.getDuration()/5)*panelAppointments.getHeight())/288);
            
            panelAp.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, posy, 200, heigth));
            appointmentsComp.add(panel);
            
        }
        
        panelAp.revalidate();
        panelAp.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        headerPanel = new javax.swing.JPanel();
        lblDay = new javax.swing.JLabel();
        lblDayString = new javax.swing.JLabel();
        panelAppointments = new javax.swing.JPanel();
        lblTime = new javax.swing.JLabel();
        panelAp = new javax.swing.JPanel();
        panelSchedule = new javax.swing.JPanel();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        setLayout(new java.awt.GridBagLayout());

        headerPanel.setBackground(new java.awt.Color(204, 204, 204));
        headerPanel.setLayout(new java.awt.GridLayout(2, 0, 0, 6));

        lblDay.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDay.setText("XX/XX/XX");
        lblDay.setPreferredSize(new java.awt.Dimension(100, 25));
        headerPanel.add(lblDay);

        lblDayString.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDayString.setText("jLabel2");
        headerPanel.add(lblDayString);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        add(headerPanel, gridBagConstraints);

        panelAppointments.setBackground(new java.awt.Color(255, 51, 51));
        panelAppointments.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelAppointmentsMouseMoved(evt);
            }
        });
        panelAppointments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelAppointmentsMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelAppointmentsMouseExited(evt);
            }
        });
        panelAppointments.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTime.setText("jLabel3");
        panelAppointments.add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        add(panelAppointments, gridBagConstraints);

        panelAp.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                panelApComponentResized(evt);
            }
        });
        panelAp.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        add(panelAp, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        add(panelSchedule, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void panelAppointmentsMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelAppointmentsMouseMoved
        auxCalendar = Calendar.getInstance();
        auxCalendar.setTime(calendar.getTime());
        
        // TODO add your handling code here:
        Integer posx = MouseInfo.getPointerInfo().getLocation().x 
                - panelAppointments.getLocationOnScreen().x;
        
        Integer posy = MouseInfo.getPointerInfo().getLocation().y 
                - panelAppointments.getLocationOnScreen().y;
        
        Float maxMinutes = 288f;
        Integer minMinutes = 0;
        
        Float step = (maxMinutes /panelAppointments.getHeight());
        
        Integer minute = Math.round(step*posy)*5;
        minutesTime = minute;
        
        auxCalendar.add(auxCalendar.MINUTE, minute);
        lblTime.setText(sdf.format(auxCalendar.getTime()));
        
        //time
        lblTime.setVisible(true);
        if (posy > lblTime.getHeight()) {
          //lblTime.setBounds(32, 100, 5, posy-lblTime.getHeight());
          panelAppointments.setLayout(null);
          lblTime.setLocation(5, posy-lblTime.getHeight());  
        }
    }//GEN-LAST:event_panelAppointmentsMouseMoved

    private void panelAppointmentsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelAppointmentsMouseExited
        lblTime.setVisible(false);
    }//GEN-LAST:event_panelAppointmentsMouseExited

    private void panelAppointmentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelAppointmentsMouseClicked
        Appointment appointment = new Appointment();
        
        Calendar aux = Calendar.getInstance();
        aux.setTime(this.calendar.getTime());
        aux.add(auxCalendar.MINUTE, minutesTime);
        appointment.setData(aux);
        
        Integer minutes = aux.get(Calendar.HOUR_OF_DAY)*60 + aux.get(Calendar.MINUTE);
                
        for (Appointment ap : appointments) {
            Integer start = (ap.getData()).get(Calendar.HOUR_OF_DAY)*60 
                    + (ap.getData()).get(Calendar.MINUTE);
            Integer end = start + ap.getDuration();
            
            if (minutes >= start && minutes <= end) {
                appointment = ap;
                break;
            }
        }
        appointmentMain.switchForm(appointment);
    }//GEN-LAST:event_panelAppointmentsMouseClicked

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentShown

    private void panelApComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_panelApComponentResized
        addAppointments();
        addSchedule();
    }//GEN-LAST:event_panelApComponentResized

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        addAppointments();
        addSchedule();
    }//GEN-LAST:event_formComponentResized

    public void setAppointments(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel lblDay;
    private javax.swing.JLabel lblDayString;
    private javax.swing.JLabel lblTime;
    private javax.swing.JPanel panelAp;
    private javax.swing.JPanel panelAppointments;
    private javax.swing.JPanel panelSchedule;
    // End of variables declaration//GEN-END:variables
}
