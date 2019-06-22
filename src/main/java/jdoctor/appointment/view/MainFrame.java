package jdoctor.appointment.view;

import com.jtattoo.plaf.smart.SmartLookAndFeel;
import java.awt.CardLayout;
import java.util.Calendar;
import java.util.Properties;
import javax.swing.UIManager;
import jdoctor.appointment.controller.DocUserController;
import jdoctor.appointment.model.DocUser;
import jdoctor.appointment.model.Doctor;
import jdoctor.appointment.model.Secretary;
import jdoctor.appointment.session.CurrentSession;
import jdoctor.appointment.util.Connection;
import jdoctor.appointment.util.FinalStrings;

public class MainFrame extends javax.swing.JFrame {
    CardLayout layout;
    /**
     * Creates new form mainFrame
     */
    public MainFrame() {
        initComponents();
        mainLoginPanel.setMainFrame(this);
        homePanel.setMainFrame(this);
        layout = (CardLayout) getContentPane().getLayout();
        this.setJMenuBar(null);
        
        menuDoctor.setVisible(false);
        menuSecretary.setVisible(false);
        
        switchLogin();
    }
    
    public void switchLogin() {
        layout.show(getContentPane(), "cardLogin");
        setTitle(FinalStrings.titleSub+" Login");
    }
    
    public void switchHome(String userNick) {
        menuBar.setVisible(true);
        this.setJMenuBar(menuBar);
        setTitle(FinalStrings.titleSub+" Pagina Inicial");
        
        DocUserController docUserController = new DocUserController();
        DocUser currentUser =  docUserController.get(userNick);
        CurrentSession.setUser(currentUser);
        
        if (currentUser.getClass().equals(Doctor.class)) {
            menuDoctor.setVisible(true);
        } else if (currentUser.getClass().equals(Secretary.class)) {
            menuSecretary.setVisible(true);
        }
        
        switchHome();
    }
    
    public void switchHome() {
        layout.show(getContentPane(), "cardHome");
    }
    
    public void switchEditProfile() {
        layout.show(getContentPane(), "cardProfileEdit");
        docUserPanel.setUser(CurrentSession.getUser());
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

        mainLoginPanel = new jdoctor.appointment.view.docuser.MainLoginPanel();
        homePanel = new jdoctor.appointment.view.system.HomePanel();
        scrollUserPanel = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        docUserPanel = new jdoctor.appointment.view.docuser.DocUserPanel();
        editSchedulePanel1 = new jdoctor.appointment.view.doctor.EditSchedulePanel();
        appointmentDateForm = new jdoctor.appointment.view.appointment.AppointmentMain();
        menuBar = new javax.swing.JMenuBar();
        menuSystem = new javax.swing.JMenu();
        menuItemHome = new javax.swing.JMenuItem();
        menuUser = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuSecretary = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        menuDoctor = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 500));
        setPreferredSize(new java.awt.Dimension(502, 600));
        getContentPane().setLayout(new java.awt.CardLayout());

        mainLoginPanel.setMinimumSize(new java.awt.Dimension(400, 750));
        getContentPane().add(mainLoginPanel, "card2");
        getContentPane().add(homePanel, "cardHome");

        jPanel1.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(docUserPanel, gridBagConstraints);

        scrollUserPanel.setViewportView(jPanel1);

        getContentPane().add(scrollUserPanel, "cardProfileEdit");
        getContentPane().add(editSchedulePanel1, "EditScheduleCard");
        getContentPane().add(appointmentDateForm, "cardAppointmentForm");

        menuSystem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/info.png"))); // NOI18N
        menuSystem.setText("Sistema");

        menuItemHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/window.png"))); // NOI18N
        menuItemHome.setText("Pagina inicial");
        menuItemHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemHomeActionPerformed(evt);
            }
        });
        menuSystem.add(menuItemHome);

        menuBar.add(menuSystem);

        menuUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/gravatar_mistery_man.png"))); // NOI18N
        menuUser.setText("Meu Usuário");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pencil.png"))); // NOI18N
        jMenuItem1.setText("Editar minhas informações");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuUser.add(jMenuItem1);

        menuBar.add(menuUser);

        menuSecretary.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/tumblr_inline_nfq8i3motj1siyl8l.gif"))); // NOI18N
        menuSecretary.setText("Secretário(a)");

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pencil.png"))); // NOI18N
        jMenuItem3.setText("Marcar consulta");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menuSecretary.add(jMenuItem3);

        menuBar.add(menuSecretary);

        menuDoctor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/medic32.gif"))); // NOI18N
        menuDoctor.setText("Médico");

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pencil.png"))); // NOI18N
        jMenuItem2.setText("Editar Horários");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuDoctor.add(jMenuItem2);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/event_icon.gif"))); // NOI18N
        jMenuItem4.setText("Minhas Consultas");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        menuDoctor.add(jMenuItem4);

        menuBar.add(menuDoctor);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemHomeActionPerformed
        switchHome();
    }//GEN-LAST:event_menuItemHomeActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        switchEditProfile();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        layout.show(this.getContentPane(), "EditScheduleCard");
        editSchedulePanel1.setDoctor((Doctor) CurrentSession.getUser());
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        layout.show(this.getContentPane(), "cardAppointmentForm");
        appointmentDateForm.setDate(Calendar.getInstance());
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        layout.show(this.getContentPane(), "cardAppointmentForm");
        appointmentDateForm.setDate(Calendar.getInstance());
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            // select the Look and Feel
            UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
        } catch (Exception e) {
            System.out.println("Falha ao usar JTatto");
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private jdoctor.appointment.view.appointment.AppointmentMain appointmentDateForm;
    private jdoctor.appointment.view.docuser.DocUserPanel docUserPanel;
    private jdoctor.appointment.view.doctor.EditSchedulePanel editSchedulePanel1;
    private jdoctor.appointment.view.system.HomePanel homePanel;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private jdoctor.appointment.view.docuser.MainLoginPanel mainLoginPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuDoctor;
    private javax.swing.JMenuItem menuItemHome;
    private javax.swing.JMenu menuSecretary;
    private javax.swing.JMenu menuSystem;
    private javax.swing.JMenu menuUser;
    private javax.swing.JScrollPane scrollUserPanel;
    // End of variables declaration//GEN-END:variables
}
