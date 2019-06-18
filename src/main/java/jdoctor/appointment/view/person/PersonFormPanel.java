package jdoctor.appointment.view.person;

import javax.swing.text.MaskFormatter;
import jdoctor.appointment.model.Person;
import jdoctor.appointment.util.Validation;
import jdoctor.appointment.view.error.ErrorPanel;
import lombok.Setter;
import jdoctor.appointment.view.GenericFormPanel;


public class PersonFormPanel extends GenericFormPanel {
    public PersonFormPanel() {
        super();
        initComponents();
        try {
            MaskFormatter masPhone = new MaskFormatter("(##) #####-####");  
            masPhone.install(txtPhone);
        } catch (Exception e) {
            System.out.println("Falha ao formatar campos");
        }
    }
    
    @Override 
    public void setForm(Object entity) {
        Person person;
        try {
            person = (Person) entity; 
        } catch (Exception e) {
            System.out.println("FALHA EM CONVERTER "+entity);
            return;
        }
        
        txtDocCPF.setText(person.getDocCPF());
        txtDocRG.setText(person.getDocRG());
        txtEmail.setText(person.getEmail());
        txtName.setText(person.getName());
        txtPhone.setText(person.getPhoneNumber());
    }
    
    @Override
    public void formToObject(Object object) {
        Person person;
        try {
            person = (Person) object; 
        } catch (Exception e) {
            System.out.println("FALHA EM CONVERTER "+object);
            return;
        }
        
        person.setDocCPF(txtDocCPF.getText());
        person.setDocRG(txtDocRG.getText());
        person.setEmail(txtEmail.getText());
        person.setName(txtName.getText());
        person.setPhoneNumber(txtPhone.getText());
    }
    
    @Override
    public boolean isFormValid() {
        boolean errorFind = false;
        if (txtName.getText().isEmpty() ||
                txtDocCPF.getText().isEmpty() ||
                txtDocRG.getText().isEmpty() ||
                txtEmail.getText().isEmpty() ||
                txtPhone.getText().isEmpty() ) {
            addError("Campos do formulario Pessoa não pode ser nulo");
            errorFind = true;
        }
        
        if(txtPhone.getText().length() < 7) {
            addError("Digite um numero de telefone valido");
            errorFind = true;
        }
        
        if (!Validation.isEmailValid(txtEmail.getText().trim())) {
            addError("Email é invalido");
            errorFind = true;
        }
        
        if (!Validation.isDocCPFValid(txtDocCPF.getText())) {
            addError ("CPF é invalido");
            errorFind = true;
        }
        
        return !errorFind;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lblHeaderUser1 = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblPhone = new javax.swing.JLabel();
        lblDocRG = new javax.swing.JLabel();
        txtDocRG = new javax.swing.JTextField();
        lblDocCPF = new javax.swing.JLabel();
        txtDocCPF = new javax.swing.JTextField();
        txtPhone = new javax.swing.JFormattedTextField();

        setLayout(new java.awt.GridBagLayout());

        lblHeaderUser1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblHeaderUser1.setText("Pessoa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(18, 0, 18, 0);
        add(lblHeaderUser1, gridBagConstraints);

        lblName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblName.setText("Nome");
        lblName.setPreferredSize(new java.awt.Dimension(100, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 10);
        add(lblName, gridBagConstraints);

        txtName.setFont(txtName.getFont().deriveFont(txtName.getFont().getSize()+3f));
        txtName.setMaximumSize(new java.awt.Dimension(300, 2147483647));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 0);
        add(txtName, gridBagConstraints);

        lblEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblEmail.setText("Email");
        lblEmail.setPreferredSize(new java.awt.Dimension(100, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 10);
        add(lblEmail, gridBagConstraints);

        txtEmail.setFont(txtEmail.getFont().deriveFont(txtEmail.getFont().getSize()+3f));
        txtEmail.setMaximumSize(new java.awt.Dimension(300, 2147483647));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 0);
        add(txtEmail, gridBagConstraints);

        lblPhone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPhone.setText("Telefone");
        lblPhone.setPreferredSize(new java.awt.Dimension(100, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 10);
        add(lblPhone, gridBagConstraints);

        lblDocRG.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDocRG.setText("Identidade");
        lblDocRG.setPreferredSize(new java.awt.Dimension(100, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 10);
        add(lblDocRG, gridBagConstraints);

        txtDocRG.setFont(txtDocRG.getFont().deriveFont(txtDocRG.getFont().getSize()+3f));
        txtDocRG.setMaximumSize(new java.awt.Dimension(300, 2147483647));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 0);
        add(txtDocRG, gridBagConstraints);

        lblDocCPF.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDocCPF.setText("CPF");
        lblDocCPF.setPreferredSize(new java.awt.Dimension(100, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 10);
        add(lblDocCPF, gridBagConstraints);

        txtDocCPF.setFont(txtDocCPF.getFont().deriveFont(txtDocCPF.getFont().getSize()+3f));
        txtDocCPF.setMaximumSize(new java.awt.Dimension(300, 2147483647));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 0);
        add(txtDocCPF, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 0);
        add(txtPhone, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblDocCPF;
    private javax.swing.JLabel lblDocRG;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblHeaderUser1;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JTextField txtDocCPF;
    private javax.swing.JTextField txtDocRG;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JFormattedTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
