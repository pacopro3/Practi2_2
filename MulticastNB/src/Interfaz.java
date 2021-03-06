
import java.awt.event.KeyEvent;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sweet
 */
public class Interfaz extends javax.swing.JFrame {
    DefaultListModel listModel;
    String jugador="";
    SimpleAttributeSet attrs;
    boolean flag = false;
    boolean close = false;
    /**
     * Creates new form Interfaz
     */
    public Interfaz() {
        attrs = new SimpleAttributeSet();
        listModel = new DefaultListModel();
        initComponents();
        jTextArea3.requestFocus();
        jList1.setModel(listModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jTextArea3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextArea3KeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(jTextArea3);

        jButton1.setText("Enviar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });

        jLabel1.setText("Chat grupal");

        jLabel2.setText("Contactos");

        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(jList1);

        jScrollPane1.setViewportView(jTextPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Al presionar el boton 
        flag = true;
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextArea3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea3KeyPressed
        // Validación de tecla presionada para el ENTER y TAB
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            flag = true;
        }
        if(evt.getKeyCode() == KeyEvent.VK_TAB) {
            jButton1.requestFocus();
        }
        
    }//GEN-LAST:event_jTextArea3KeyPressed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // Validación de tecla ENTER presionada en el button 
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            flag = true;
        }
    }//GEN-LAST:event_jButton1KeyPressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        close = true;
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }
    
    public boolean comprobar(String text){ //Validación para ingresar al chat
        for(int i = 0; i< jList1.getModel().getSize();i++){
            if(jList1.getModel().getElementAt(i).equals(text)){
                return true;
            }
        }
        jugador = text;
        this.setTitle("Bienvenido al chat " + jugador);
        return false;
    }
    
    public void insertarArray(String text){//Insertamos un nuevo integrante del chat
        listModel.addElement(text);
        jList1.setSelectedIndex(0);
    }
    
    public boolean quitarArray(String text){ //Quitamos el integrante del chat restante
        jList1.setSelectedIndex(0);
        for(int i = 0; i< jList1.getModel().getSize();i++){
            if(jList1.getModel().getElementAt(i).equals(text)){
                listModel.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean existeArray(String text){//validamos si existe el integrante solicitado
        for(int i = 0; i< jList1.getModel().getSize();i++){
            if(jList1.getModel().getElementAt(i).equals(text)){
                return true;
            }
        }
        return false;
    }

    public void writeMsj(String origen,String msj){
        //aqui se escribe la parte derecha del chat donde son nuestros mensajes que mandamos
        try {
            StyleConstants.setBold(attrs, true);
            StyleConstants.setAlignment(attrs,StyleConstants.ALIGN_RIGHT);
            jTextPane1.getStyledDocument().setParagraphAttributes(
                                jTextPane1.getStyledDocument().getLength(), origen.length(), attrs, false);
            jTextPane1.getStyledDocument().insertString(
				jTextPane1.getStyledDocument().getLength(), origen + "\n", attrs);
            
            StyleConstants.setBold(attrs, false);
            StyleConstants.setAlignment(attrs, StyleConstants.ALIGN_RIGHT);
            jTextPane1.getStyledDocument().setParagraphAttributes(
                                jTextPane1.getStyledDocument().getLength(), msj.length()  + 2, attrs, false);
            jTextPane1.getStyledDocument().insertString(
				jTextPane1.getStyledDocument().getLength(), msj + "\n", attrs);
        } catch (BadLocationException ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Aquí reemplazamos los íconos en caso de existir
        
         Document doc = jTextPane1.getDocument();
         String find=";)";
         String find1=":P";
         String find2=":*";
         String currentDirectory = Paths.get(".").toAbsolutePath().normalize().toString();
         
                    try {
                        for (int pos = 0; pos < doc.getLength() - find1.length(); pos++) {

                            String text = doc.getText(pos, find.length());
                            if (find.equals(text)) {
                                doc.remove(pos, find1.length());
                                StyledDocument doc2 = (StyledDocument) jTextPane1.getDocument();
                                Style style2 = doc2.addStyle("StyleName0", null);
                                StyleConstants.setIcon(style2, new ImageIcon(currentDirectory + "\\img\\imagen_guino.jpg"));
                                doc2.insertString(pos, "GG", style2);
                            }
                            if (find1.equals(text)) {
                                doc.remove(pos, find1.length());
                                StyledDocument doc2 = (StyledDocument) jTextPane1.getDocument();
                                Style style2 = doc2.addStyle("StyleName1", null);
                                StyleConstants.setIcon(style2, new ImageIcon(currentDirectory + "\\img\\imagen_gesto.jpg"));
                                doc.insertString(pos, "GG", style2);
                            }
                            if (find2.equals(text)) {
                                doc.remove(pos, find2.length());
                                StyledDocument doc2 = (StyledDocument) jTextPane1.getDocument();
                                Style style2 = doc2.addStyle("StyleName2", null);
                                StyleConstants.setIcon(style2, new ImageIcon(currentDirectory + "\\img\\imagen_beso.jpg"));
                                doc.insertString(pos, "GG", style2);
                            }

                        }
                    } catch (BadLocationException exp) {
                        exp.printStackTrace();
                    }
    
    }
    
    public boolean getFlag(){
        return flag;
    }
    
    public boolean getClose(){
        return close;
    }
    
    public void setFlag(boolean flag){
        this.flag = flag;
    }
    public String getText(){//Regresa el texto del jTextArea3
        return jTextArea3.getText().toString();
    }
    
    public void setText(String text){
        jTextArea3.setText(text);
    }
    
    public String getTipo(){//Regresa si vamos a enviar mensaje a todos o a alguien en privado
        return jList1.getSelectedValue();
    }
    
    public void insertMSJ(String origen, String msj){
        //Aqui se escribe la parte izquierda del chat donde nos indica quien nos ha escrito mensaje
        try {
            StyleConstants.setBold(attrs, true);
            StyleConstants.setAlignment(attrs,0);
            StyleConstants.setAlignment(attrs,StyleConstants.ALIGN_LEFT);
            jTextPane1.getStyledDocument().setParagraphAttributes(
                                jTextPane1.getStyledDocument().getLength(), origen.length(), attrs, false);
            jTextPane1.getStyledDocument().insertString(
				jTextPane1.getStyledDocument().getLength(), origen + "\n", attrs);
            
            StyleConstants.setBold(attrs, false);
            StyleConstants.setAlignment(attrs,0);
            StyleConstants.setAlignment(attrs,StyleConstants.ALIGN_LEFT);
            jTextPane1.getStyledDocument().setParagraphAttributes(
                                jTextPane1.getStyledDocument().getLength(), msj.length() + 2, attrs, false);
            jTextPane1.getStyledDocument().insertString(
				jTextPane1.getStyledDocument().getLength(), msj + "\n", attrs);
        } catch (BadLocationException ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        // Aquí reemplazamos los íconos en caso de existir
        
         Document doc = jTextPane1.getDocument();
         String find=";)";
         String find1=":P";
         String find2=":*";
         String currentDirectory = Paths.get(".").toAbsolutePath().normalize().toString();
         
                    try {
                        for (int pos = 0; pos < doc.getLength() - find1.length(); pos++) {

                            String text = doc.getText(pos, find.length());
                            if (find.equals(text)) {
                                doc.remove(pos, find1.length());
                                StyledDocument doc2 = (StyledDocument) jTextPane1.getDocument();
                                Style style2 = doc2.addStyle("StyleName0", null);
                                StyleConstants.setIcon(style2, new ImageIcon(currentDirectory + "\\img\\imagen_guino.jpg"));
                                doc2.insertString(pos, "GG", style2);
                            }
                            if (find1.equals(text)) {
                                doc.remove(pos, find1.length());
                                StyledDocument doc2 = (StyledDocument) jTextPane1.getDocument();
                                Style style2 = doc2.addStyle("StyleName1", null);
                                StyleConstants.setIcon(style2, new ImageIcon(currentDirectory + "\\img\\imagen_gesto.jpg"));
                                doc.insertString(pos, "GG", style2);
                            }
                            if (find2.equals(text)) {
                                doc.remove(pos, find2.length());
                                StyledDocument doc2 = (StyledDocument) jTextPane1.getDocument();
                                Style style2 = doc2.addStyle("StyleName2", null);
                                StyleConstants.setIcon(style2, new ImageIcon(currentDirectory + "\\img\\imagen_beso.jpg"));
                                doc.insertString(pos, "GG", style2);
                            }

                        }
                    } catch (BadLocationException exp) {
                        exp.printStackTrace();
                    }
    }
            
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
