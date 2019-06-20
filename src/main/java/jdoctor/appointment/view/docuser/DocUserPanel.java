package jdoctor.appointment.view.docuser;

import jdoctor.appointment.controller.DocUserController;
import jdoctor.appointment.exception.ControllerException;
import jdoctor.appointment.exception.VisionException;
import jdoctor.appointment.model.DocUser;
import jdoctor.appointment.util.GuiUtils;
import jdoctor.appointment.view.MainFrame;
import lombok.Getter;
import lombok.Setter;


public class DocUserPanel extends javax.swing.JPanel {
    private DocUser user;
    @Setter
    private MainFrame mainFrame;
    private DocUserController docUserController;
    
    public DocUserPanel() {
        initComponents();
    }
    
    public void setUser(DocUser user) {
        this.user = user;
        personFormPanel.cleanForm();
        personFormPanel.setForm(user);
        errorPanel.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lblHeader = new javax.swing.JLabel();
        errorPanel = new jdoctor.appointment.view.error.ErrorPanel();
        personFormPanel = new jdoctor.appointment.view.form.PersonFormPanel();
        actionsPanel = new javax.swing.JPanel();
        btnRegister = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(412, 400));
        setLayout(new java.awt.GridBagLayout());

        lblHeader.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblHeader.setText("MINHAS INFORMAÇÕES");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 8, 0);
        add(lblHeader, gridBagConstraints);

        javax.swing.GroupLayout errorPanelLayout = new javax.swing.GroupLayout(errorPanel);
        errorPanel.setLayout(errorPanelLayout);
        errorPanelLayout.setHorizontalGroup(
            errorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        errorPanelLayout.setVerticalGroup(
            errorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        add(errorPanel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        add(personFormPanel, gridBagConstraints);

        actionsPanel.setLayout(new java.awt.GridLayout(1, 0, 15, 0));

        btnRegister.setText("Editar");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        actionsPanel.add(btnRegister);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        gridBagConstraints.weightx = 0.9;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        add(actionsPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        errorPanel.clean();
        
        docUserController = new DocUserController();
        
        try {
            personFormPanel.formToObject(user);
            docUserController.save(user);
            GuiUtils.showConfirmOkDialog("Infomações editadas com sucesso! :)", this);
        } catch (VisionException | ControllerException e) {
            errorPanel.addError(e.getMessage());
        }
    }//GEN-LAST:event_btnRegisterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel actionsPanel;
    private javax.swing.JButton btnRegister;
    private jdoctor.appointment.view.error.ErrorPanel errorPanel;
    private javax.swing.JLabel lblHeader;
    private jdoctor.appointment.view.form.PersonFormPanel personFormPanel;
    // End of variables declaration//GEN-END:variables
}
