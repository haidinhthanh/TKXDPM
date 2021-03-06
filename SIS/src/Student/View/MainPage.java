/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student.View;

import Register.RegisterClassroom.View.SignClassForm;
import Register.RegisterCourse.View.SignCourseForm;
import Student.Dao.SqlStudentDao;
import Student.Model.Student;
import javax.swing.JPanel;

/**
 * This is view MainPage when guest is login success as student
 * @author haidt
 */
public class MainPage extends javax.swing.JFrame {
    private JPanel previousPanel;
    private Student student;
    /**
     * Creates new form MainPage
     */
    public MainPage() {
        initComponents();
        setStudentInfoMation();
        setSizeComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelHeader = new javax.swing.JPanel();
        jLabelHeaderName = new javax.swing.JLabel();
        jLabelHelloUser = new javax.swing.JLabel();
        jButtonSeePersonalInfo = new javax.swing.JButton();
        jPanelMenu = new javax.swing.JPanel();
        jButtonMainPage = new javax.swing.JButton();
        jButtonLearnProgram = new javax.swing.JButton();
        jButtonLearnTimeTable = new javax.swing.JButton();
        jButtonSeeMark = new javax.swing.JButton();
        jButtonSign = new javax.swing.JButton();
        jButtonSearch = new javax.swing.JButton();
        jButtonGuide = new javax.swing.JButton();
        jPanelMenuSign = new javax.swing.JPanel();
        jButtonSignCourse = new javax.swing.JButton();
        jButtonSignClass = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanelHeader.setBackground(new java.awt.Color(0, 51, 255));
        jPanelHeader.setLayout(null);

        jLabelHeaderName.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabelHeaderName.setForeground(new java.awt.Color(255, 255, 255));
        jLabelHeaderName.setText("SIS SYSTEM");
        jPanelHeader.add(jLabelHeaderName);
        jLabelHeaderName.setBounds(10, 11, 166, 40);

        jLabelHelloUser.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabelHelloUser.setForeground(new java.awt.Color(255, 255, 255));
        jLabelHelloUser.setText("Xin chào, ");
        jPanelHeader.add(jLabelHelloUser);
        jLabelHelloUser.setBounds(390, 10, 210, 40);

        jButtonSeePersonalInfo.setBackground(new java.awt.Color(0, 102, 204));
        jButtonSeePersonalInfo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButtonSeePersonalInfo.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSeePersonalInfo.setText("Thông tin cá nhân");
        jPanelHeader.add(jButtonSeePersonalInfo);
        jButtonSeePersonalInfo.setBounds(600, 10, 172, 40);

        getContentPane().add(jPanelHeader);
        jPanelHeader.setBounds(0, 0, 920, 60);

        jPanelMenu.setBackground(new java.awt.Color(51, 102, 255));
        jPanelMenu.setLayout(null);

        jButtonMainPage.setBackground(new java.awt.Color(51, 102, 255));
        jButtonMainPage.setForeground(new java.awt.Color(255, 255, 255));
        jButtonMainPage.setText("Trang chủ");
        jPanelMenu.add(jButtonMainPage);
        jButtonMainPage.setBounds(0, 10, 100, 23);

        jButtonLearnProgram.setBackground(new java.awt.Color(51, 102, 255));
        jButtonLearnProgram.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLearnProgram.setText("Chương trình đào tạo");
        jPanelMenu.add(jButtonLearnProgram);
        jButtonLearnProgram.setBounds(100, 10, 160, 23);

        jButtonLearnTimeTable.setBackground(new java.awt.Color(51, 102, 255));
        jButtonLearnTimeTable.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLearnTimeTable.setText("Kế hoạch học tập");
        jPanelMenu.add(jButtonLearnTimeTable);
        jButtonLearnTimeTable.setBounds(260, 10, 160, 23);

        jButtonSeeMark.setBackground(new java.awt.Color(51, 102, 255));
        jButtonSeeMark.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSeeMark.setText("Kết quả học tập");
        jButtonSeeMark.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSeeMarkMouseClicked(evt);
            }
        });
        jPanelMenu.add(jButtonSeeMark);
        jButtonSeeMark.setBounds(420, 10, 140, 23);

        jButtonSign.setBackground(new java.awt.Color(51, 102, 255));
        jButtonSign.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSign.setText("Đăng ký học tập");
        jButtonSign.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSignMouseClicked(evt);
            }
        });
        jPanelMenu.add(jButtonSign);
        jButtonSign.setBounds(560, 10, 130, 23);

        jButtonSearch.setBackground(new java.awt.Color(51, 102, 255));
        jButtonSearch.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSearch.setText("Tra cứu");
        jPanelMenu.add(jButtonSearch);
        jButtonSearch.setBounds(690, 10, 90, 23);

        jButtonGuide.setBackground(new java.awt.Color(51, 102, 255));
        jButtonGuide.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGuide.setText("Hướng dẫn");
        jPanelMenu.add(jButtonGuide);
        jButtonGuide.setBounds(780, 10, 105, 23);

        getContentPane().add(jPanelMenu);
        jPanelMenu.setBounds(0, 60, 910, 40);

        jPanelMenuSign.setBackground(new java.awt.Color(51, 102, 255));
        jPanelMenuSign.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jButtonSignCourse.setBackground(new java.awt.Color(51, 102, 255));
        jButtonSignCourse.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSignCourse.setText("Đăng ký học phần");
        jButtonSignCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSignCourseMouseClicked(evt);
            }
        });
        jPanelMenuSign.add(jButtonSignCourse);

        jButtonSignClass.setBackground(new java.awt.Color(51, 102, 255));
        jButtonSignClass.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSignClass.setText("Đăng ký lớp học");
        jButtonSignClass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSignClassMouseClicked(evt);
            }
        });
        jPanelMenuSign.add(jButtonSignClass);

        getContentPane().add(jPanelMenuSign);
        jPanelMenuSign.setBounds(560, 90, 130, 10);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * This method open the menu sign education
     * menu have category sign course, sign class 
     * @param evt event click Sign education
     */
    private void jButtonSignMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSignMouseClicked
        // TODO add your handling code here:
        if(jPanelMenuSign.getHeight()==0){
            jPanelMenuSign.setSize(130,70);
        }
        else{
            jPanelMenuSign.setSize(0,0);
        }  
        if(previousPanel!=jPanelMenuSign)
            resetSizeMenuComponents();
        previousPanel=jPanelMenuSign;
    }//GEN-LAST:event_jButtonSignMouseClicked
    /**
     * This method open the view SingCourseForm 
     * @author haidt
     * @param evt event click sign course category in the menu sign education 
     */
    private void jButtonSignCourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSignCourseMouseClicked
        // TODO add your handling code here:
        this.setEnabled(false);
        SignCourseForm signCourseForm= new SignCourseForm(this,student);
        signCourseForm.setVisible(true);
    }//GEN-LAST:event_jButtonSignCourseMouseClicked
    /**
     * This method open the view SeeMarkForm
     * @author haidt
     * @param evt 
     */
    private void jButtonSeeMarkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSeeMarkMouseClicked
        // TODO add your handling code here:
        if(previousPanel==jPanelMenuSign)
            resetSizeMenuComponents();
    }//GEN-LAST:event_jButtonSeeMarkMouseClicked
    /**
     * 
     * This method open the view SingClassForm 
     * @author haidt
     * @param evt event click sign class category in the menu sign education
     */
    private void jButtonSignClassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSignClassMouseClicked
        // TODO add your handling code here:
        this.setEnabled(false);
        SignClassForm signClassForm= new SignClassForm(this,student);
        signClassForm.setVisible(true);
    }//GEN-LAST:event_jButtonSignClassMouseClicked
    /**
     * This method set size components went start
     * @author haidt
     */
    private void setSizeComponents(){
        jPanelMenuSign.setSize(0,0);
    }
    /**
     * This method reset size menu component when click an item
     * @author haidt
     */
    private void resetSizeMenuComponents(){
         if(previousPanel!=null)
            previousPanel.setSize(0,0);
    }
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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainPage mainPage= new MainPage();
                mainPage.setVisible(true);
                mainPage.setSize(900, 800);
                mainPage.setResizable(false);
            }
        });
    }
    //fake code
    private void setStudentInfoMation() {
        student= SqlStudentDao.getInstance().getStudentByID("20151178");
        jLabelHelloUser.setText("Xin chào "+student.getName());
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGuide;
    private javax.swing.JButton jButtonLearnProgram;
    private javax.swing.JButton jButtonLearnTimeTable;
    private javax.swing.JButton jButtonMainPage;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonSeeMark;
    private javax.swing.JButton jButtonSeePersonalInfo;
    private javax.swing.JButton jButtonSign;
    private javax.swing.JButton jButtonSignClass;
    private javax.swing.JButton jButtonSignCourse;
    private javax.swing.JLabel jLabelHeaderName;
    private javax.swing.JLabel jLabelHelloUser;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel jPanelMenuSign;
    // End of variables declaration//GEN-END:variables

}
