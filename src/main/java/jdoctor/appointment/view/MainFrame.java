package jdoctor.appointment.view;

import com.jtattoo.plaf.smart.SmartLookAndFeel;
import java.awt.CardLayout;
import java.util.Properties;
import javax.swing.UIManager;
import jdoctor.appointment.controller.DocUserController;
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
        CurrentSession.setUser(docUserController.get(userNick));
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

        mainLoginPanel = new jdoctor.appointment.view.docuser.MainLoginPanel();
        homePanel = new jdoctor.appointment.view.system.HomePanel();
        scrollUserPanel = new javax.swing.JScrollPane();
        docUserPanel = new jdoctor.appointment.view.docuser.DocUserPanel();
        menuBar = new javax.swing.JMenuBar();
        menuSystem = new javax.swing.JMenu();
        menuItemHome = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 500));
        getContentPane().setLayout(new java.awt.CardLayout());

        mainLoginPanel.setMinimumSize(new java.awt.Dimension(400, 750));
        getContentPane().add(mainLoginPanel, "card2");
        getContentPane().add(homePanel, "cardHome");

        scrollUserPanel.setViewportView(docUserPanel);

        getContentPane().add(scrollUserPanel, "cardProfileEdit");

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

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/gravatar_mistery_man.png"))); // NOI18N
        jMenu1.setText("Meu Usuario");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pencil.png"))); // NOI18N
        jMenuItem1.setText("Editar minhas informações");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        menuBar.add(jMenu1);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemHomeActionPerformed
        switchHome();
    }//GEN-LAST:event_menuItemHomeActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        switchEditProfile();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
    private jdoctor.appointment.view.docuser.DocUserPanel docUserPanel;
    private jdoctor.appointment.view.system.HomePanel homePanel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private jdoctor.appointment.view.docuser.MainLoginPanel mainLoginPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuItemHome;
    private javax.swing.JMenu menuSystem;
    private javax.swing.JScrollPane scrollUserPanel;
    // End of variables declaration//GEN-END:variables
}
