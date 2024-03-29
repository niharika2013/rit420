package PresentationLayer;

/**
 *
 * @author Group 6
 */
public class KudoWindow extends javax.swing.JFrame {

    View parentView = null;
    String kudoId = null;
    
    /**
     * Creates new form CourseWindow with ability to get back to 
     */
    public KudoWindow(View v) {
        initComponents();
        parentView = v;
    }
    
    /**
     * This is the constructor for doing edits on a Kudo
     * @param v
     * @param kudoId 
     */
    public KudoWindow(View v, String kudoId){
        initComponents();
        parentView = v;
        this.kudoId = kudoId;
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
        kudoField = new javax.swing.JTextField();
        facultyPane = new javax.swing.JScrollPane();
        facultyList = new javax.swing.JList();
        submitKudo = new javax.swing.JButton();
        cancelKudo = new javax.swing.JButton();
        yearLabel = new javax.swing.JLabel();
        kudoLabel = new javax.swing.JLabel();
        facultyMemberLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        yearField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearFieldActionPerformed(evt);
            }
        });

        kudoField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kudoFieldActionPerformed(evt);
            }
        });

        facultyList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        facultyPane.setViewportView(facultyList);

        submitKudo.setText("Submit");
        submitKudo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitKudoMouseClicked(evt);
            }
        });

        cancelKudo.setText("Cancel");
        cancelKudo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelKudoMouseClicked(evt);
            }
        });
        cancelKudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelKudoActionPerformed(evt);
            }
        });

        yearLabel.setText("Year");

        kudoLabel.setText("Kudo");

        facultyMemberLabel.setText("Faculty Member");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(facultyPane, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(facultyMemberLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kudoLabel)
                            .addComponent(yearLabel))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(yearField)
                            .addComponent(kudoField))
                        .addGap(44, 44, 44))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancelKudo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                        .addComponent(submitKudo)
                        .addGap(18, 18, 18))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yearField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearLabel)
                    .addComponent(facultyMemberLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kudoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kudoLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(submitKudo)
                            .addComponent(cancelKudo)))
                    .addComponent(facultyPane))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void yearFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearFieldActionPerformed

    private void kudoFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kudoFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kudoFieldActionPerformed

    /**
     * This is the constructor for doing edits on a Kudo
     * @param evt 
     */
    private void submitKudoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitKudoMouseClicked
        //To Do
        //Do database insertions
        //If successful, update parent view's table
        this.setVisible(false);
        parentView.setEnabled(true);
        //If not, pop a message out
    }//GEN-LAST:event_submitKudoMouseClicked

    /**
    * Close a kudo window without submitting
    * @param evt 
    */
    private void cancelKudoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelKudoMouseClicked
        //The user wanted to cancel out of the operation?  Easy.
        this.setVisible(false);
        parentView.setEnabled(true);
    }//GEN-LAST:event_cancelKudoMouseClicked

    private void cancelKudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelKudoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelKudoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelKudo;
    private javax.swing.JList facultyList;
    private javax.swing.JLabel facultyMemberLabel;
    private javax.swing.JScrollPane facultyPane;
    private javax.swing.JTextField kudoField;
    private javax.swing.JLabel kudoLabel;
    private javax.swing.JButton submitKudo;
    private javax.swing.JTextField yearField;
    private javax.swing.JLabel yearLabel;
    // End of variables declaration//GEN-END:variables
}
