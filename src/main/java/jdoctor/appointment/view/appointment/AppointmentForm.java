/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdoctor.appointment.view.appointment;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import jdoctor.appointment.controller.AppointmentController;
import jdoctor.appointment.controller.DoctorController;
import jdoctor.appointment.controller.PersonController;
import jdoctor.appointment.controller.SecretaryController;
import jdoctor.appointment.exception.ControllerException;
import jdoctor.appointment.model.Appointment;
import jdoctor.appointment.model.AppointmentTypeEnum;
import jdoctor.appointment.model.Doctor;
import jdoctor.appointment.model.PaymentStatusEnum;
import jdoctor.appointment.model.Person;
import jdoctor.appointment.model.Secretary;
import jdoctor.appointment.session.CurrentSession;
import jdoctor.appointment.util.GuiUtils;
import lombok.Setter;

/**
 *
 * @author aug
 */
public class AppointmentForm extends javax.swing.JPanel {
    @Setter
    private AppointmentMain main;
    
    private Calendar hour;
    
    private DoctorController doctorController;
    private PersonController personController;
    private final SimpleDateFormat sdf;
    private final SimpleDateFormat dateF;
    
    private Appointment appointment;
    
    private AppointmentController controller;
    
    /**
     * Creates new form AppointmentForm
     */
    public AppointmentForm() {
        initComponents();
        sdf = new SimpleDateFormat("HH:mm");
        dateF = new SimpleDateFormat("dd/MM/yyyy");
    }
    
    public void setDate(Appointment appointment, Doctor selCalendarDoctor) {      
        errorPanel.setVisible(false);
        this.appointment = appointment;
        
        System.out.println(appointment.getId()+"------");
        // ---- ID
        if (appointment.getId() == null) {
            btnRemove.setEnabled(false);
        } else {
            btnRemove.setEnabled(true);
        }
        
        // ------------- Data
        // Set data
        txtData.setText(dateF.format(appointment.getData().getTime()));
        // Set hours
        txtHour.setText(sdf.format(appointment.getData().getTime()));
        
        // ------------- Doutor
        if (appointment.getDoctor() == null) {
            appointment.setDoctor(selCalendarDoctor);
        }
        
        lblMedic.setText("Medico: ["+appointment.getDoctor().getSpecialization()+"] "
                +appointment.getDoctor().getName());
        
        // ------------- Pessoa
        Person selPerson = null;
        if (appointment.getPerson()!= null) {
            selPerson = appointment.getPerson();
            personTablePanel.setHeader("Paciente "+selPerson.getName());
        } else {
            personTablePanel.setHeader("Paciente");
        }
        
        personController = new PersonController();
        ArrayList<ArrayList<String>> persons = new ArrayList<>();
        
        try {
            for (Person person : personController.getAll()) {
                if (person.getClass().equals(Person.class)) {
                   ArrayList<String> data = new ArrayList<>();
                   data.add(person.getId().toString());
                   data.add(person.getName());
                   persons.add(data);
                }
            }
        } catch (Exception e) {
            GuiUtils.showErrorOkDialog(e.getMessage(), this);
        }
        
        personTablePanel.setData(persons);
        
        // ------------- Horas
        hour = Calendar.getInstance();
        hour.set(Calendar.HOUR_OF_DAY, 0);
        hour.set(Calendar.MINUTE, 0);
        hour.set(Calendar.SECOND, 0);
        
        if (appointment.getDuration() != null) {
            hour.add(Calendar.MINUTE, appointment.getDuration());
        } else {
            hour.add(Calendar.MINUTE, 30);
            appointment.setDuration(30);
        }
        
        txtDuration.setText(sdf.format(hour.getTime()));
        
        // ------------- Consulta
        if (appointment.getAppointmentType() != null) {
            switch (appointment.getAppointmentType()) {
                case NORMAL:
                    cbxAppointmentType.setSelectedIndex(0);
                    break;
                case RETURN:
                    cbxAppointmentType.setSelectedIndex(1);
                    break;
            }
        } else {
            appointment.setAppointmentType(AppointmentTypeEnum.NORMAL);
            cbxAppointmentType.setSelectedIndex(0);
        }
        
        // ------------- Situação Pagamento
        if (appointment.getPaymentStatus() != null) {
            switch (appointment.getPaymentStatus()) {
                case PENDING:
                    cbxPaymentType.setSelectedIndex(0);
                    break;
                case CONFIRMED:
                    cbxPaymentType.setSelectedIndex(1);
                    break;
            }
        } else {
            appointment.setPaymentStatus(PaymentStatusEnum.PENDING);
            cbxPaymentType.setSelectedIndex(0);
        }
        
        // ------------- Parcelas
        if (appointment.getInstallments() == null) {
            spnInstallments.setValue(0);
        } else {
            spnInstallments.setValue(appointment.getInstallments());
        }
        
        // ------------- Valor
        DecimalFormat dFormat = new DecimalFormat("#,###,###.00") ;
        NumberFormatter formatter = new NumberFormatter(dFormat) ;
        formatter.setFormat(dFormat) ;
        formatter.setAllowsInvalid(false) ; 
        
        if (appointment.getTotalValue() == null) {
            appointment.setTotalValue(0.00f);
        }
        
        txtPrice.setFormatterFactory(new DefaultFormatterFactory ( formatter ));
        txtPrice.setText((appointment.getTotalValue().toString()).replace(".",","));
        
        // ------------- Descricao
        if (appointment.getDescription() == null) {
            appointment.setDescription("");
        }
        
        txtDescription.setText("");
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        lblHeader1 = new javax.swing.JLabel();
        errorPanel = new jdoctor.appointment.view.error.ErrorPanel();
        jPanel1 = new javax.swing.JPanel();
        lblHours = new javax.swing.JLabel();
        txtData = new javax.swing.JFormattedTextField();
        lblData = new javax.swing.JLabel();
        txtHour = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnSub = new javax.swing.JButton();
        btnSubHour = new javax.swing.JButton();
        btnAddHour = new javax.swing.JButton();
        personTablePanel = new jdoctor.appointment.view.tables.StringTablePanel();
        form = new javax.swing.JPanel();
        lblUserNick = new javax.swing.JLabel();
        txtPrice = new javax.swing.JFormattedTextField();
        lblUserNick3 = new javax.swing.JLabel();
        cbxAppointmentType = new javax.swing.JComboBox<>();
        lblUserNick4 = new javax.swing.JLabel();
        cbxPaymentType = new javax.swing.JComboBox<>();
        lblUserNick1 = new javax.swing.JLabel();
        txtDuration = new javax.swing.JTextField();
        btnHourSub = new javax.swing.JButton();
        btnHourAdd = new javax.swing.JButton();
        lblUserNick5 = new javax.swing.JLabel();
        spnInstallments = new javax.swing.JSpinner();
        actionsPanel = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        btnRemove = new javax.swing.JToggleButton();
        btnSave = new javax.swing.JButton();
        lblMedic = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblHeader2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();

        setLayout(new java.awt.GridBagLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        lblHeader1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblHeader1.setText("CONSULTA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 8, 0);
        jPanel2.add(lblHeader1, gridBagConstraints);

        javax.swing.GroupLayout errorPanelLayout = new javax.swing.GroupLayout(errorPanel);
        errorPanel.setLayout(errorPanelLayout);
        errorPanelLayout.setHorizontalGroup(
            errorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 533, Short.MAX_VALUE)
        );
        errorPanelLayout.setVerticalGroup(
            errorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        jPanel2.add(errorPanel, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        lblHours.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblHours.setText("Hora");
        lblHours.setMaximumSize(new java.awt.Dimension(40, 22));
        lblHours.setMinimumSize(new java.awt.Dimension(40, 22));
        lblHours.setPreferredSize(new java.awt.Dimension(40, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 8, 8);
        jPanel1.add(lblHours, gridBagConstraints);

        txtData.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 0);
        jPanel1.add(txtData, gridBagConstraints);

        lblData.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblData.setText("Data");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 10);
        jPanel1.add(lblData, gridBagConstraints);

        txtHour.setEditable(false);
        txtHour.setMinimumSize(new java.awt.Dimension(75, 20));
        txtHour.setPreferredSize(new java.awt.Dimension(75, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 0);
        jPanel1.add(txtHour, gridBagConstraints);

        btnAdd.setText("+");
        btnAdd.setMaximumSize(new java.awt.Dimension(25, 23));
        btnAdd.setMinimumSize(new java.awt.Dimension(40, 23));
        btnAdd.setPreferredSize(new java.awt.Dimension(40, 23));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 0);
        jPanel1.add(btnAdd, gridBagConstraints);

        btnSub.setText("-");
        btnSub.setMaximumSize(new java.awt.Dimension(40, 23));
        btnSub.setMinimumSize(new java.awt.Dimension(40, 23));
        btnSub.setPreferredSize(new java.awt.Dimension(40, 23));
        btnSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 0);
        jPanel1.add(btnSub, gridBagConstraints);

        btnSubHour.setText("-");
        btnSubHour.setMaximumSize(new java.awt.Dimension(25, 23));
        btnSubHour.setMinimumSize(new java.awt.Dimension(40, 23));
        btnSubHour.setPreferredSize(new java.awt.Dimension(40, 23));
        btnSubHour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubHourActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 0);
        jPanel1.add(btnSubHour, gridBagConstraints);

        btnAddHour.setText("+");
        btnAddHour.setMaximumSize(new java.awt.Dimension(25, 23));
        btnAddHour.setMinimumSize(new java.awt.Dimension(40, 23));
        btnAddHour.setPreferredSize(new java.awt.Dimension(40, 23));
        btnAddHour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddHourActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 0);
        jPanel1.add(btnAddHour, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(jPanel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        jPanel2.add(personTablePanel, gridBagConstraints);

        form.setLayout(new java.awt.GridBagLayout());

        lblUserNick.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUserNick.setText("Duração");
        lblUserNick.setPreferredSize(new java.awt.Dimension(100, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 8, 10);
        form.add(lblUserNick, gridBagConstraints);

        txtPrice.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 0);
        form.add(txtPrice, gridBagConstraints);

        lblUserNick3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUserNick3.setText("Parcelas");
        lblUserNick3.setPreferredSize(new java.awt.Dimension(100, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 8, 10);
        form.add(lblUserNick3, gridBagConstraints);

        cbxAppointmentType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal", "Retorno" }));
        cbxAppointmentType.setMinimumSize(new java.awt.Dimension(100, 20));
        cbxAppointmentType.setPreferredSize(new java.awt.Dimension(100, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 0);
        form.add(cbxAppointmentType, gridBagConstraints);

        lblUserNick4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUserNick4.setText("Situação");
        lblUserNick4.setPreferredSize(new java.awt.Dimension(100, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 8, 10);
        form.add(lblUserNick4, gridBagConstraints);

        cbxPaymentType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendente", "Pago" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 0);
        form.add(cbxPaymentType, gridBagConstraints);

        lblUserNick1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUserNick1.setText("Consulta");
        lblUserNick1.setPreferredSize(new java.awt.Dimension(100, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 10);
        form.add(lblUserNick1, gridBagConstraints);

        txtDuration.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 0);
        form.add(txtDuration, gridBagConstraints);

        btnHourSub.setText("-");
        btnHourSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHourSubActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 0);
        form.add(btnHourSub, gridBagConstraints);

        btnHourAdd.setText("+");
        btnHourAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHourAddActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 0);
        form.add(btnHourAdd, gridBagConstraints);

        lblUserNick5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUserNick5.setText("Valor Total");
        lblUserNick5.setPreferredSize(new java.awt.Dimension(100, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 10);
        form.add(lblUserNick5, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 0);
        form.add(spnInstallments, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(9, 0, 9, 0);
        jPanel2.add(form, gridBagConstraints);

        actionsPanel.setLayout(new java.awt.GridLayout(1, 0, 20, 0));

        btnBack.setText("Voltar");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        actionsPanel.add(btnBack);

        btnRemove.setText("Deletar");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
        actionsPanel.add(btnRemove);

        btnSave.setText("Salvar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        actionsPanel.add(btnSave);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(7, 0, 7, 0);
        jPanel2.add(actionsPanel, gridBagConstraints);

        lblMedic.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblMedic.setText("Medico: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 6, 0);
        jPanel2.add(lblMedic, gridBagConstraints);

        jTabbedPane1.addTab("Detalhes Consulta", jPanel2);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        lblHeader2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblHeader2.setText("ANOTAÇÕES");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 8, 0);
        jPanel3.add(lblHeader2, gridBagConstraints);

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jScrollPane1.setViewportView(txtDescription);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(9, 9, 9, 9);
        jPanel3.add(jScrollPane1, gridBagConstraints);

        jTabbedPane1.addTab("Anotações", jPanel3);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jTabbedPane1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        main.switchCalendar();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        appointment.getData().add(Calendar.DAY_OF_MONTH, +1);
        txtData.setText(dateF.format(appointment.getData().getTime()));
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubActionPerformed
        appointment.getData().add(Calendar.DAY_OF_MONTH, -1);
        txtData.setText(dateF.format(appointment.getData().getTime()));
    }//GEN-LAST:event_btnSubActionPerformed

    private void btnSubHourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubHourActionPerformed
        appointment.getData().add(Calendar.MINUTE, -5);
        txtHour.setText(sdf.format(appointment.getData().getTime()));
    }//GEN-LAST:event_btnSubHourActionPerformed

    private void btnAddHourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddHourActionPerformed
        appointment.getData().add(Calendar.MINUTE, +5);
        txtHour.setText(sdf.format(appointment.getData().getTime()));
    }//GEN-LAST:event_btnAddHourActionPerformed

    public void formToObject(Appointment appointment) throws ControllerException {
        
        // ----- Pessoa 
        PersonController personController = new PersonController();
        if (personTablePanel.getSelectedRow() != -1) {
            Person aux = personController.get(personTablePanel.getId());
            appointment.setPerson(aux);
        }
        
        // ----- Secreatria
        appointment.setSecretary((Secretary) CurrentSession.getUser());
        
        // ----- Tipo consulta
        switch ((String) cbxAppointmentType.getSelectedItem()) {
            case "Normal":
                appointment.setAppointmentType(AppointmentTypeEnum.NORMAL);
                break;
            case "Retorno":
                appointment.setAppointmentType(AppointmentTypeEnum.RETURN);
                break;
        }
        
        // ----- Preço
        String price = txtPrice.getText();
        price = price.replace(".", "");
        price = price.replace(',', '.');
        
        appointment.setTotalValue(Float.parseFloat(price));
        
        // ----- Pagamento
        switch ((String) cbxPaymentType.getSelectedItem()) {
            case "Pendente":
                appointment.setPaymentStatus(PaymentStatusEnum.PENDING);
                break;
            case "Pago":
                appointment.setPaymentStatus(PaymentStatusEnum.CONFIRMED);
                break;
        }
        
        // ----- Parcelas
        appointment.setInstallments((Integer) spnInstallments.getValue());
        
        // ----- Descricao
        appointment.setDescription(txtDescription.getText());
        
    }
    
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        controller = new AppointmentController();
        errorPanel.clean();
        System.out.println(txtPrice.getText());
        System.out.println(Float.parseFloat("222234.123"));
        try {
            formToObject(appointment);
            controller.save(appointment);
        } catch (ControllerException ex) {
            errorPanel.addError(ex.getMessage());
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnHourAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHourAddActionPerformed
        appointment.setDuration(appointment.getDuration()+5);
        hour.add(Calendar.MINUTE, +5);
        txtDuration.setText(sdf.format(hour.getTime()));
    }//GEN-LAST:event_btnHourAddActionPerformed

    private void btnHourSubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHourSubActionPerformed
        if (appointment.getDuration() > 5) {
            appointment.setDuration(appointment.getDuration()-5);
            hour.add(Calendar.MINUTE, -5);
            txtDuration.setText(sdf.format(hour.getTime()));
        }
    }//GEN-LAST:event_btnHourSubActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        try {
            if (GuiUtils.showYesNo("Tem certeza que deseja remover?", this)) {
                controller = new AppointmentController();
                controller.remove(appointment.getId());
                GuiUtils.showConfirmOkDialog("Removido com sucesso!", this);
                main.switchCalendar();
            }
        } catch (ControllerException ex) {
            GuiUtils.showErrorOkDialog(ex.getMessage(), this);
        }
    }//GEN-LAST:event_btnRemoveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel actionsPanel;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddHour;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnHourAdd;
    private javax.swing.JButton btnHourSub;
    private javax.swing.JToggleButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSub;
    private javax.swing.JButton btnSubHour;
    private javax.swing.JComboBox<String> cbxAppointmentType;
    private javax.swing.JComboBox<String> cbxPaymentType;
    private jdoctor.appointment.view.error.ErrorPanel errorPanel;
    private javax.swing.JPanel form;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblHeader1;
    private javax.swing.JLabel lblHeader2;
    private javax.swing.JLabel lblHours;
    private javax.swing.JLabel lblMedic;
    private javax.swing.JLabel lblUserNick;
    private javax.swing.JLabel lblUserNick1;
    private javax.swing.JLabel lblUserNick3;
    private javax.swing.JLabel lblUserNick4;
    private javax.swing.JLabel lblUserNick5;
    private jdoctor.appointment.view.tables.StringTablePanel personTablePanel;
    private javax.swing.JSpinner spnInstallments;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtDuration;
    private javax.swing.JTextField txtHour;
    private javax.swing.JFormattedTextField txtPrice;
    // End of variables declaration//GEN-END:variables
}
