package jdoctor.appointment.view.appointment;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import jdoctor.appointment.controller.AppointmentController;
import jdoctor.appointment.controller.DoctorController;
import jdoctor.appointment.exception.ControllerException;
import jdoctor.appointment.model.Appointment;
import jdoctor.appointment.model.AvailableSchedule;
import jdoctor.appointment.model.Doctor;
import jdoctor.appointment.model.Secretary;
import jdoctor.appointment.session.CurrentSession;
import jdoctor.appointment.util.GuiUtils;


public class AppointmentMain extends javax.swing.JPanel {
    private Calendar day;
    private CardLayout layout;
    private Doctor doctor;
    
    /**
     * Creates new form AppointmentDateForm
     */
    public AppointmentMain() {
        initComponents();
        
        appointmentForm.setMain(this);
        
        layout = (CardLayout) cardPanel.getLayout();
        
        for (int i = 0; i < 24; i++) {
            JLabel label = new JLabel(""+i+":00");
            label.setFont(new Font(label.getName(), Font.PLAIN, 12));
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setMinimumSize(new Dimension(50, timesPanel.getHeight()/24));
            
            if((i & 1) == 0) {
                label.setBackground(Color.GRAY);
            }
            timesPanel.add(label);
        }
        
        // ---- Doutores
        DoctorController controller = new DoctorController();
        List<Doctor> doctors = new ArrayList<Doctor>();
        try {
            doctors = new ArrayList<Doctor>(controller.getAll());
        } catch (ControllerException ex) {
            GuiUtils.showErrorOkDialog("Falha ao obter doutores", this);
        }
        
        cbxDoctors.setModel(new DefaultComboBoxModel(doctors.toArray()));
    }
    
    public void switchCalendar() {
        layout.show(cardPanel, "calendarCard");
        if (CurrentSession.getUser().getClass() == Secretary.class) {
            medicSelectPanel.setVisible(true);
        }
    }
    
    public void switchForm(Appointment appointment) {
        if (doctor != null) {
             appointmentForm.setDate(appointment, doctor);
             layout.show(cardPanel, "cardForm");
             medicSelectPanel.setVisible(false);
        } else {
            GuiUtils.showErrorOkDialog("Você deve selecionar um doutor", this);
        }
    }
    
    public void setDate(Calendar day) {
        AppointmentController appointmentControler = 
                new AppointmentController();  
        
        this.day = day;
        panelDays.removeAll();
        panelDays.setLayout(new GridLayout(1, 7, 2, 0));
        for (int i = 0; i < 7; i++) {
            boolean color = false;
            if ( (i & 1) == 0 ) {
                color = true;
            }
            
            Calendar aux = Calendar.getInstance();
            aux.setTime(day.getTime());
            aux.add(Calendar.DAY_OF_WEEK, i);
            
            List<Date> dates = new ArrayList<>();
            
            if (doctor != null) {
                AvailableSchedule schedule = doctor.getAvailableSchedule();
                switch (aux.get(Calendar.DAY_OF_WEEK)) {
                    case 1: dates = new ArrayList<>(schedule.getOnSunday()); break;
                    case 2: dates = new ArrayList<>(schedule.getOnMonday()); break;
                    case 3: dates = new ArrayList<>(schedule.getOnTuesday()); break;
                    case 4: dates = new ArrayList<>(schedule.getOnWednesday()); break;
                    case 5: dates = new ArrayList<>(schedule.getOnThursday()); break;
                    case 6: dates = new ArrayList<>(schedule.getOnFriday()); break;
                    case 7: dates = new ArrayList<>(schedule.getOnSaturday()); break;
                }
            }
            
            try {
                DayPanel dayPanel = new DayPanel(aux, color, this,
                        appointmentControler.get(aux, doctor), dates); 
                panelDays.add(dayPanel);
            } catch (ControllerException ex) {
                GuiUtils.showErrorOkDialog(ex.getMessage(), this);
            }
        }
        panelDays.revalidate();
        panelDays.repaint();
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

        medicSelectPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbxDoctors = new javax.swing.JComboBox<>();
        cardPanel = new javax.swing.JPanel();
        calendarPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelDays = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        arrowsPanel = new javax.swing.JPanel();
        btnLeft = new javax.swing.JButton();
        btnRight = new javax.swing.JButton();
        timesPanel = new javax.swing.JPanel();
        scrollUserPanel = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        appointmentForm = new jdoctor.appointment.view.appointment.AppointmentForm();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        setLayout(new java.awt.GridBagLayout());

        medicSelectPanel.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Medicos ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 7);
        medicSelectPanel.add(jLabel1, gridBagConstraints);

        cbxDoctors.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxDoctors.setMinimumSize(new java.awt.Dimension(56, 30));
        cbxDoctors.setPreferredSize(new java.awt.Dimension(56, 30));
        cbxDoctors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDoctorsActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        medicSelectPanel.add(cbxDoctors, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 7, 5, 7);
        add(medicSelectPanel, gridBagConstraints);

        cardPanel.setLayout(new java.awt.CardLayout());

        calendarPanel.setLayout(new java.awt.GridBagLayout());

        panelDays.setLayout(new java.awt.GridLayout(1, 7, 2, 0));
        jScrollPane1.setViewportView(panelDays);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        calendarPanel.add(jScrollPane1, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        arrowsPanel.setMinimumSize(new java.awt.Dimension(80, 58));
        arrowsPanel.setPreferredSize(new java.awt.Dimension(100, 58));
        arrowsPanel.setLayout(new java.awt.GridLayout(1, 0));

        btnLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Arrow Left.png"))); // NOI18N
        btnLeft.setMaximumSize(new java.awt.Dimension(40, 40));
        btnLeft.setMinimumSize(new java.awt.Dimension(40, 40));
        btnLeft.setPreferredSize(new java.awt.Dimension(40, 40));
        btnLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeftActionPerformed(evt);
            }
        });
        arrowsPanel.add(btnLeft);

        btnRight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Arrow Rigth.png"))); // NOI18N
        btnRight.setMaximumSize(new java.awt.Dimension(40, 40));
        btnRight.setMinimumSize(new java.awt.Dimension(40, 40));
        btnRight.setPreferredSize(new java.awt.Dimension(40, 40));
        btnRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRightActionPerformed(evt);
            }
        });
        arrowsPanel.add(btnRight);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel2.add(arrowsPanel, gridBagConstraints);

        timesPanel.setBackground(new java.awt.Color(204, 204, 204));
        timesPanel.setForeground(new java.awt.Color(255, 255, 255));
        timesPanel.setMinimumSize(new java.awt.Dimension(75, 0));
        timesPanel.setPreferredSize(new java.awt.Dimension(25, 100));
        timesPanel.setLayout(new java.awt.GridLayout(24, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel2.add(timesPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        calendarPanel.add(jPanel2, gridBagConstraints);

        cardPanel.add(calendarPanel, "calendarCard");

        jPanel1.setPreferredSize(new java.awt.Dimension(460, 680));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        appointmentForm.setMinimumSize(new java.awt.Dimension(470, 437));
        appointmentForm.setPreferredSize(new java.awt.Dimension(470, 700));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(appointmentForm, gridBagConstraints);

        scrollUserPanel.setViewportView(jPanel1);

        cardPanel.add(scrollUserPanel, "cardForm");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(cardPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeftActionPerformed
        day.add(Calendar.DAY_OF_WEEK, -6);
        setDate(day);
    }//GEN-LAST:event_btnLeftActionPerformed

    private void btnRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRightActionPerformed
        day.add(Calendar.DAY_OF_WEEK, +6);
        setDate(day);
    }//GEN-LAST:event_btnRightActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        if (CurrentSession.getUser().getClass() == Secretary.class) {
            medicSelectPanel.setVisible(true);
        } else {
            medicSelectPanel.setVisible(false);
        }
    }//GEN-LAST:event_formComponentShown

    private void cbxDoctorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDoctorsActionPerformed
        doctor = (Doctor) cbxDoctors.getSelectedItem();
        setDate(day);
    }//GEN-LAST:event_cbxDoctorsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private jdoctor.appointment.view.appointment.AppointmentForm appointmentForm;
    private javax.swing.JPanel arrowsPanel;
    private javax.swing.JButton btnLeft;
    private javax.swing.JButton btnRight;
    private javax.swing.JPanel calendarPanel;
    private javax.swing.JPanel cardPanel;
    private javax.swing.JComboBox<String> cbxDoctors;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel medicSelectPanel;
    private javax.swing.JPanel panelDays;
    private javax.swing.JScrollPane scrollUserPanel;
    private javax.swing.JPanel timesPanel;
    // End of variables declaration//GEN-END:variables
}
