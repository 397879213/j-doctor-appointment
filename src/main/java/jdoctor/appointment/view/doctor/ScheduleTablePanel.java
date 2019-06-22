package jdoctor.appointment.view.doctor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jdoctor.appointment.model.AvailableSchedule;
import jdoctor.appointment.view.tables.ScheduleTable;
import lombok.Getter;
import lombok.Setter;


public class ScheduleTablePanel extends javax.swing.JPanel {
    @Setter
    private EditSchedulePanel mainSchedule;
    private ArrayList<Date> oldDates;
    private ArrayList<Date> dates;
    private String day;
    
    public ScheduleTablePanel() {
        initComponents();
    }
    
    public void setDates(List<Date> dates, String day) {
        this.day = day;
        this.oldDates = new ArrayList<>(dates);
        this.dates = new ArrayList<>(dates);
        dateTable.setModel(new ScheduleTable(this.dates));
    }
    
    public List<Date> getDatesList() {
        return (List<Date>) dates;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnUp = new javax.swing.JButton();
        btnDown = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        dateTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnUnmake = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.GridLayout());

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Add32.png"))); // NOI18N
        btnAdd.setToolTipText("Adicionar");
        btnAdd.setMaximumSize(new java.awt.Dimension(40, 40));
        btnAdd.setMinimumSize(new java.awt.Dimension(40, 40));
        btnAdd.setPreferredSize(new java.awt.Dimension(40, 40));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd);

        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/remove32.png"))); // NOI18N
        btnRemove.setToolTipText("Remover");
        btnRemove.setMaximumSize(new java.awt.Dimension(40, 40));
        btnRemove.setMinimumSize(new java.awt.Dimension(40, 40));
        btnRemove.setPreferredSize(new java.awt.Dimension(40, 40));
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
        jPanel1.add(btnRemove);

        btnUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Arrow up.png"))); // NOI18N
        btnUp.setToolTipText("Mover para cima");
        btnUp.setMaximumSize(new java.awt.Dimension(40, 40));
        btnUp.setMinimumSize(new java.awt.Dimension(40, 40));
        btnUp.setPreferredSize(new java.awt.Dimension(40, 40));
        btnUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpActionPerformed(evt);
            }
        });
        jPanel1.add(btnUp);

        btnDown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Arrow Down.png"))); // NOI18N
        btnDown.setToolTipText("Mover para baixo");
        btnDown.setMaximumSize(new java.awt.Dimension(40, 40));
        btnDown.setMinimumSize(new java.awt.Dimension(40, 40));
        btnDown.setPreferredSize(new java.awt.Dimension(40, 40));
        btnDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownActionPerformed(evt);
            }
        });
        jPanel1.add(btnDown);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        add(jPanel1, gridBagConstraints);

        dateTable.setModel(new javax.swing.table.DefaultTableModel(
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
        dateTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(dateTable);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jScrollPane1, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridLayout(1, 0, 30, 0));

        btnUnmake.setText("Desfazer");
        btnUnmake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnmakeActionPerformed(evt);
            }
        });
        jPanel2.add(btnUnmake);

        btnSave.setText("Salvar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel2.add(btnSave);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        add(jPanel2, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        ((ScheduleTable)dateTable.getModel()).addRow();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownActionPerformed
        ((ScheduleTable)dateTable.getModel()).moveDown(dateTable.getSelectedRow());
    }//GEN-LAST:event_btnDownActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        ((ScheduleTable)dateTable.getModel()).removeRow(dateTable.getSelectedRow());
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpActionPerformed
        ((ScheduleTable)dateTable.getModel()).moveUp(dateTable.getSelectedRow());
    }//GEN-LAST:event_btnUpActionPerformed

    private void btnUnmakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnmakeActionPerformed
        dates = new ArrayList<>(oldDates);
        dateTable.setModel(new ScheduleTable(this.dates));
    }//GEN-LAST:event_btnUnmakeActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        System.out.println(dates);
        mainSchedule.save(dates, day);
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDown;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUnmake;
    private javax.swing.JButton btnUp;
    private javax.swing.JTable dateTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
