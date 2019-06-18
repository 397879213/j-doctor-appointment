package jdoctor.appointment.view.docuser;

import jdoctor.appointment.model.Doctor;
import jdoctor.appointment.model.Secretary;
import jdoctor.appointment.view.GenericFormPanel;


public class UserFunctionFormPanel extends GenericFormPanel {

    
    public UserFunctionFormPanel() {
        initComponents();
        doctorPanel.setVisible(false);
    }
    
    @Override 
    public void setForm(Object entity) {
        if (entity.getClass().equals(Doctor.class)) {
            cbxType.setSelectedIndex(1);
            Doctor doctor = (Doctor) entity;
            txtEspecialization.setText(doctor.getSpecialization());
        } 
        
        if (entity.getClass().equals(Secretary.class)) {
            cbxType.setSelectedIndex(2);
        }
    }
    
    public boolean isDoctor() {
       if (cbxType.getSelectedIndex() == 1) {
           return true;
       }
        return false;
    }
    
    public boolean isSecretary() {
        if (cbxType.getSelectedIndex() == 2) {
           return true;
       }
        return false;
    }
    
    @Override
    public void formToObject(Object object) {
        if (object.getClass().equals(Doctor.class)) {
            Doctor doctor = (Doctor) object;
            doctor.setSpecialization(txtEspecialization.getText());
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lblHeaderUser2 = new javax.swing.JLabel();
        lblUserNick5 = new javax.swing.JLabel();
        cbxType = new javax.swing.JComboBox<>();
        doctorPanel = new javax.swing.JPanel();
        lblEspecialization = new javax.swing.JLabel();
        txtEspecialization = new javax.swing.JTextField();

        setLayout(new java.awt.GridBagLayout());

        lblHeaderUser2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblHeaderUser2.setText("Função");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(18, 0, 18, 0);
        add(lblHeaderUser2, gridBagConstraints);

        lblUserNick5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblUserNick5.setText("Sou");
        lblUserNick5.setPreferredSize(new java.awt.Dimension(100, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 10);
        add(lblUserNick5, gridBagConstraints);

        cbxType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione uma Função", "Doutor(a)", "Secretario(a)" }));
        cbxType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTypeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 0);
        add(cbxType, gridBagConstraints);

        doctorPanel.setLayout(new java.awt.GridBagLayout());

        lblEspecialization.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblEspecialization.setText("Especialidade");
        lblEspecialization.setMaximumSize(new java.awt.Dimension(100, 22));
        lblEspecialization.setMinimumSize(new java.awt.Dimension(100, 22));
        lblEspecialization.setPreferredSize(new java.awt.Dimension(100, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 10);
        doctorPanel.add(lblEspecialization, gridBagConstraints);

        txtEspecialization.setFont(txtEspecialization.getFont().deriveFont(txtEspecialization.getFont().getSize()+3f));
        txtEspecialization.setMaximumSize(new java.awt.Dimension(300, 2147483647));
        txtEspecialization.setMinimumSize(new java.awt.Dimension(131, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 0);
        doctorPanel.add(txtEspecialization, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        add(doctorPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void cbxTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTypeActionPerformed
        String option = (String) cbxType.getSelectedItem();
        if (option.equals("Doutor(a)")) {
            System.out.println("deu");
            doctorPanel.setVisible(true);
        } else {
            doctorPanel.setVisible(false);
        }
    }//GEN-LAST:event_cbxTypeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxType;
    private javax.swing.JPanel doctorPanel;
    private javax.swing.JLabel lblEspecialization;
    private javax.swing.JLabel lblHeaderUser2;
    private javax.swing.JLabel lblUserNick5;
    private javax.swing.JTextField txtEspecialization;
    // End of variables declaration//GEN-END:variables
}
