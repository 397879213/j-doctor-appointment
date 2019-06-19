package jdoctor.appointment.view.form;

import jdoctor.appointment.exception.VisionException;
import jdoctor.appointment.model.DocUser;
import jdoctor.appointment.model.Person;
import jdoctor.appointment.view.GenericFormPanel;


public class UserFormPanel extends GenericFormPanel {
    
    public UserFormPanel() {
        super();
        initComponents();
        
    }
    
    @Override 
    public void setForm(Object entity) {
        DocUser docUser;
        try {
            docUser = (DocUser) entity; 
        } catch (Exception e) {
            System.out.println("FALHA EM CONVERTER "+entity);
            return;
        }
        
        txtUserNick.setText(docUser.getUserNick());
    }
    
    @Override
    public void formToObject(Object object) throws VisionException {
        DocUser docUser;
        try {
            docUser = (DocUser) object; 
        } catch (Exception e) {
            System.out.println("FALHA EM CONVERTER "+object);
            return;
        }
        
        if (!pasConfirm.getText().equals(pasPassword.getText())) {
            throw new VisionException("Senhas não coincidem");
        }
        
        docUser.setUserNick(txtUserNick.getText());
        docUser.setPassword(pasPassword.getText());
    }

    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lblHeaderUser = new javax.swing.JLabel();
        lblUserNick = new javax.swing.JLabel();
        txtUserNick = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        pasPassword = new javax.swing.JPasswordField();
        lblConfirm = new javax.swing.JLabel();
        pasConfirm = new javax.swing.JPasswordField();

        setLayout(new java.awt.GridBagLayout());

        lblHeaderUser.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblHeaderUser.setText("Sistema");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(18, 0, 18, 0);
        add(lblHeaderUser, gridBagConstraints);

        lblUserNick.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblUserNick.setText("Usuario");
        lblUserNick.setPreferredSize(new java.awt.Dimension(100, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 10);
        add(lblUserNick, gridBagConstraints);

        txtUserNick.setFont(txtUserNick.getFont().deriveFont(txtUserNick.getFont().getSize()+3f));
        txtUserNick.setMaximumSize(new java.awt.Dimension(300, 2147483647));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 0);
        add(txtUserNick, gridBagConstraints);

        lblPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPassword.setText("Senha");
        lblPassword.setPreferredSize(new java.awt.Dimension(100, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 10);
        add(lblPassword, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 0);
        add(pasPassword, gridBagConstraints);

        lblConfirm.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblConfirm.setText("Confirme");
        lblConfirm.setPreferredSize(new java.awt.Dimension(100, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 10);
        add(lblConfirm, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 0);
        add(pasConfirm, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblConfirm;
    private javax.swing.JLabel lblHeaderUser;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUserNick;
    private javax.swing.JPasswordField pasConfirm;
    private javax.swing.JPasswordField pasPassword;
    private javax.swing.JTextField txtUserNick;
    // End of variables declaration//GEN-END:variables
}
