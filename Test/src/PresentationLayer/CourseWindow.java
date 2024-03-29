/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DataLayer.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author Group 6
 */
public class CourseWindow extends javax.swing.JFrame {

    View parentView = null;
    String courseId = null;
    String option;
    ArrayList<User> facultyArrayList;
    
    
    /**
     * Creates a new course window with the proper option settings
     * @param v
     * @param option 
     */
    public CourseWindow(View v, String option) {
        initComponents();
        this.option = option;
        parentView = v;
        setCourseWindow();
    }
    
    /**
     * Creates a new course window with proper option settings and a given courseId
     * @param v
     * @param courseId
     * @param option 
     */
    public CourseWindow(View v, String courseId, String option){
        initComponents();
        parentView = v;
        this.courseId = courseId;
        this.option = option;
        setCourseWindow();
    }
    
    /**
     * Sets up the course window
     */
    public void setCourseWindow(){
        Users faculty = new Users();
        facultyArrayList = faculty.getUsers();
        //Get users from database
        for (Iterator<User> it = facultyArrayList.iterator(); it.hasNext();) {
            User user = it.next();
        }
        String[] userNames = new String[facultyArrayList.size()];
        //Set the users' names in the list
        for (int i = 0; i<= facultyArrayList.size() -1; i++){
            userNames[i] = facultyArrayList.get(i).getLName();
        }
        facultyList.setListData(userNames);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        yearField = new javax.swing.JTextField();
        courseNumberField = new javax.swing.JTextField();
        courseNameField = new javax.swing.JTextField();
        facultyPane = new javax.swing.JScrollPane();
        facultyList = new javax.swing.JList(new DefaultListModel<String>());
        submitCourse = new javax.swing.JButton();
        cancelUser = new javax.swing.JButton();
        yearLabel = new javax.swing.JLabel();
        courseNumberLabel = new javax.swing.JLabel();
        courseNameLabel = new javax.swing.JLabel();
        facultyMemberLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        yearField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearFieldActionPerformed(evt);
            }
        });

        courseNumberField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseNumberFieldActionPerformed(evt);
            }
        });

        facultyPane.setViewportView(facultyList);

        submitCourse.setText("Submit");
        submitCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitCourseMouseClicked(evt);
            }
        });

        cancelUser.setText("Cancel");
        cancelUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelUserMouseClicked(evt);
            }
        });

        yearLabel.setText("Year");

        courseNumberLabel.setText("Course Number");

        courseNameLabel.setText("Course Name");

        facultyMemberLabel.setText("Faculty Member");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(facultyMemberLabel)
                        .addGap(35, 35, 35)
                        .addComponent(yearLabel)
                        .addGap(56, 56, 56)
                        .addComponent(yearField, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(facultyPane, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(courseNumberLabel)
                            .addComponent(courseNameLabel)
                            .addComponent(cancelUser))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(courseNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(courseNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(134, 134, 134)
                                .addComponent(submitCourse))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(yearField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(facultyMemberLabel)
                            .addComponent(yearLabel))))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(facultyPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(courseNumberLabel)
                        .addGap(17, 17, 17)
                        .addComponent(courseNameLabel)
                        .addGap(59, 59, 59)
                        .addComponent(cancelUser))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(courseNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(courseNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(submitCourse))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void yearFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearFieldActionPerformed

    private void courseNumberFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseNumberFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseNumberFieldActionPerformed

    /**
     * Handles functions with the submit button on the coursewindow
     * @param evt 
     */
    private void submitCourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitCourseMouseClicked
        //To Do
        //Do database insertions
        //If successful, update parent view's table
        if(courseNameField.getText().length() != 0 && courseNumberField.getText().length() != 0 && yearField.getText().length() != 0 && !facultyList.isSelectionEmpty()){
            //Go here if doing an update
            if("Update".equals(option)){
                try {
                    User selectedUser = null;
                    //Pull all data from the list of users
                    for (User user: facultyArrayList){
                        if(user.getLName().equals(facultyList.getSelectedValue())){
                            selectedUser = user;
                        } 
                    }
                    //Make a new course an post
                    Course updateCourse = new Course(selectedUser.getUserId(), courseId, yearField.getText(), courseNumberField.getText(), courseNameField.getText());
                    updateCourse.post();
                    //Go back to main window
                    this.setVisible(false);
                    parentView.setEnabled(true);
                } catch (DLException ex) {

                }
            }
            //Go here if doing a create
            else if("Create".equals(option)){
                try {
                    User selectedUser = null;
                        //Pull all data from the list of users
                        for (User user: facultyArrayList){
                            if(user.getLName().equals(facultyList.getSelectedValue())){
                                selectedUser = user;
                            } 
                        }
                        //Make a new course and put
                        Course newCourse = new Course(selectedUser.getUserId(), courseId, yearField.getText(), courseNumberField.getText(), courseNameField.getText());
                        newCourse.put();
                } catch (DLException ex) {
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Must select a Last Name, and enter all relevant values.");
        }
        
        //If not, pop a message out
    }//GEN-LAST:event_submitCourseMouseClicked

    /**
     * Closes the current window and goes back to mean
     * @param evt 
     */
    private void cancelUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelUserMouseClicked
        //The user wanted to cancel out of the operation?  Easy.
        this.setVisible(false);
        parentView.setEnabled(true);
    }//GEN-LAST:event_cancelUserMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelUser;
    private javax.swing.JTextField courseNameField;
    private javax.swing.JLabel courseNameLabel;
    private javax.swing.JTextField courseNumberField;
    private javax.swing.JLabel courseNumberLabel;
    private javax.swing.JList facultyList;
    private javax.swing.JLabel facultyMemberLabel;
    private javax.swing.JScrollPane facultyPane;
    private javax.swing.JButton submitCourse;
    private javax.swing.JTextField yearField;
    private javax.swing.JLabel yearLabel;
    // End of variables declaration//GEN-END:variables
}
