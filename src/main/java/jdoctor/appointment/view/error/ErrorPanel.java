package jdoctor.appointment.view.error;

import java.awt.GridLayout;
import javax.swing.JLabel;


public class ErrorPanel extends javax.swing.JPanel {

    
    public ErrorPanel() {
        initComponents();
    }
    
    public void clean() {
        this.setVisible(false);
        this.removeAll();
        this.setLayout(new GridLayout(1,0,0,3));
    }
    
    public void addError(String error) {
        this.setVisible(true);
        add(new JLabel(error));
        GridLayout layout = (GridLayout) this.getLayout();
        layout.setRows(layout.getRows()+1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Errors", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(153, 0, 0)), javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5))); // NOI18N
        setLayout(new java.awt.GridLayout());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}