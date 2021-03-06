/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdoctor.appointment.view.person;

import java.awt.CardLayout;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import jdoctor.appointment.controller.DoctorController;
import jdoctor.appointment.controller.PersonController;
import jdoctor.appointment.controller.SecretaryController;
import jdoctor.appointment.exception.ControllerException;
import jdoctor.appointment.exception.VisionException;
import jdoctor.appointment.model.DocUser;
import jdoctor.appointment.model.Doctor;
import jdoctor.appointment.model.Person;
import jdoctor.appointment.model.Secretary;
import jdoctor.appointment.util.Connection;
import jdoctor.appointment.util.GuiUtils;
import jdoctor.appointment.view.tables.PersonTable;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author aug
 */
public class PersonTableView extends javax.swing.JPanel {
    private SecretaryController secretaryController;
    private DoctorController doctorController;
    private PersonController personController;
    
    private Person currentEdit;
    
    private CardLayout layout;
    private ArrayList<Person> data;
    
    private Class currentClass;
    
    public PersonTableView() {
        initComponents();
        layout = (CardLayout) this.getLayout();
        layout.show(this, "cardTable");
    }
    
    public void setHeader(String header) {
        lblHeader.setText(header);
    }
    
    public void setData(ArrayList<Object> data, Class currentClass) {
        this.currentClass = currentClass;
        layout.show(this, "cardTable");
        ArrayList<Person> persons = new ArrayList<>();
        for (Object d : data) {
            persons.add((Person) d);
        }
        tableData.setModel(new PersonTable(persons));
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

        cardForm = new javax.swing.JPanel();
        personFormPanel = new jdoctor.appointment.view.form.PersonFormPanel();
        userFormPanel = new jdoctor.appointment.view.form.UserFormPanel();
        formActions = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblHeader = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableData = new javax.swing.JTable();
        btnActions = new javax.swing.JPanel();
        btnRemove = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setLayout(new java.awt.CardLayout());

        cardForm.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                cardFormComponentShown(evt);
            }
        });
        cardForm.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        cardForm.add(personFormPanel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        cardForm.add(userFormPanel, gridBagConstraints);

        formActions.setLayout(new java.awt.GridLayout(1, 0, 30, 0));

        btnBack.setText("Voltar");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        formActions.add(btnBack);

        btnSave.setText("Salvar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        formActions.add(btnSave);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        cardForm.add(formActions, gridBagConstraints);

        add(cardForm, "cardForm");

        jPanel1.setLayout(new java.awt.GridBagLayout());

        lblHeader.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("MEDICOS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel1.add(lblHeader, gridBagConstraints);

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        jPanel1.add(txtName, gridBagConstraints);

        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png"))); // NOI18N
        searchButton.setPreferredSize(new java.awt.Dimension(40, 40));
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        jPanel1.add(searchButton, gridBagConstraints);

        tableData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableData.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tableData);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 0);
        jPanel1.add(jScrollPane1, gridBagConstraints);

        btnActions.setLayout(new java.awt.GridLayout(1, 0, 30, 0));

        btnRemove.setText("Deletar");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
        btnActions.add(btnRemove);

        btnEdit.setText("Editar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        btnActions.add(btnEdit);

        jButton3.setText("Criar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        btnActions.add(jButton3);

        jButton1.setText("Relatorio");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        btnActions.add(jButton1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel1.add(btnActions, gridBagConstraints);

        add(jPanel1, "cardTable");
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        searchButtonActionPerformed(evt);
    }//GEN-LAST:event_txtNameActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        ((PersonTable)tableData.getModel()).filter(txtName.getText());
    }//GEN-LAST:event_searchButtonActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        Integer row = tableData.getSelectedRow();
        if (row != -1) {
            try {
                Person person = (((PersonTable)tableData.getModel()).getRow(row));
                if (GuiUtils.showYesNo("Tem certeza que deseja remover '"
                        +person.getName()+"' ?", this)) {
                    if (person.getClass() == Secretary.class) {
                        secretaryController = new SecretaryController();
                        secretaryController.remove(person.getId());
                        setData(new ArrayList<>(secretaryController.getAll()), Secretary.class);
                    }

                    if (person.getClass() == Doctor.class) {
                        doctorController = new DoctorController();
                        doctorController.remove(person.getId());
                        setData(new ArrayList<>(doctorController.getAll()), Doctor.class);
                    }

                    if (person.getClass() == Person.class) {
                        personController = new PersonController();
                        personController.remove(person.getId());
                        setData(new ArrayList<>(personController.getAll()), Person.class);
                    }
                    
                    GuiUtils.showConfirmOkDialog("Removido com sucesso", this);
                }
                
            } catch (ControllerException e) {
                GuiUtils.showErrorOkDialog(e.getMessage(), this);
            }
        } else {
            GuiUtils.showErrorOkDialog("Selecione uma pessoa", this);
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        Integer row = tableData.getSelectedRow();
        
        if (row != -1) {
            Person person = (((PersonTable)tableData.getModel()).getRow(row));
            currentEdit = person;
            personFormPanel.setForm(person);
            
            if (currentClass != Person.class) {
                userFormPanel.setForm((DocUser) person);
            }
            
            layout.show(this, "cardForm");
        } else {
            GuiUtils.showErrorOkDialog("Selecione uma pessoa", this);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        layout.show(this, "cardTable");
    }//GEN-LAST:event_btnBackActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        personFormPanel.cleanForm();
        userFormPanel.cleanForm();
        
        if (currentClass == Secretary.class) {
            currentEdit = (Person) new Secretary();
        }
        
        if (currentClass == Doctor.class) {
            currentEdit = (Person) new Doctor();
        }
        
        if (currentClass == Person.class) {
            currentEdit = new Person();
        }
            
        layout.show(this, "cardForm");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            personFormPanel.formToObject((Person) currentEdit);
            
            if(currentClass == Secretary.class) {
                Secretary secretary = (Secretary) currentEdit;
                secretaryController = new SecretaryController();
                userFormPanel.formToObject((DocUser) secretary);
                secretaryController.save(secretary);
                setData(new ArrayList<>(secretaryController.getAll()), Secretary.class);
            }
            
            if (currentClass == Doctor.class) {
                Doctor doctor = (Doctor) currentEdit;
                doctorController = new DoctorController();
                userFormPanel.formToObject((DocUser) doctor);
                doctorController.save(doctor);
                setData(new ArrayList<>(doctorController.getAll()), Doctor.class);
            }
            
            if (currentClass == Person.class) {
                Person person = (Person) currentEdit;
                personController = new PersonController();
                personController.save(person);
                setData(new ArrayList<>(personController.getAll()), Person.class);
            }
            
            GuiUtils.showConfirmOkDialog("Salvo com sucesso!", this);
            //layout.show(this, "cardForm");
        } catch (ControllerException | VisionException e) {
            GuiUtils.showErrorOkDialog(e.getMessage(), this);      
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void cardFormComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_cardFormComponentShown
        if (currentClass == Person.class) {
            userFormPanel.setVisible(false);
        } else {
            userFormPanel.setVisible(true);
        }
    }//GEN-LAST:event_cardFormComponentShown

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        Path path = Paths.get("src", "main", "resources", "report", "medicReport.jasper");
        
        JasperPrint jasperPrint = null;
        
        /**
        try {
            jasperPrint = JasperFillManager.fillReport(path.toString(), null, Connection.getConnectionC());
            JasperViewer view = new JasperViewer(jasperPrint, false);
            view.setVisible(true);
        } catch (JRException ex) {
            GuiUtils.showErrorOkDialog("Falha ao gerar relatorio "+ex.getMessage(), this);
        }**/
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnActions;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JPanel cardForm;
    private javax.swing.JPanel formActions;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHeader;
    private jdoctor.appointment.view.form.PersonFormPanel personFormPanel;
    private javax.swing.JButton searchButton;
    private javax.swing.JTable tableData;
    private javax.swing.JTextField txtName;
    private jdoctor.appointment.view.form.UserFormPanel userFormPanel;
    // End of variables declaration//GEN-END:variables
}
