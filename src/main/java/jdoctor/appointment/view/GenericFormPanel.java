
package jdoctor.appointment.view;

import java.awt.Component;
import javax.swing.JTextField;
import jdoctor.appointment.view.error.ErrorPanel;
import lombok.Setter;


public class GenericFormPanel extends javax.swing.JPanel implements FormInterface<Object> {
    @Setter
    private ErrorPanel errorPanel;
    
    public GenericFormPanel() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void cleanForm() {
        for(Component component : this.getComponents()) {
            try {
                if (component.getClass().equals(JTextField.class)) {
                    ((JTextField) component).setText("");
                }
            } catch (Exception e) {
                System.out.println("Falha ao limpar "+component.toString());
            } 
        }
    }

    @Override
    public void setForm(Object entity) {
        
    }

    @Override
    public void formToObject(Object object) {
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
