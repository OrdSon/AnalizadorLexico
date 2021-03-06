/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Reporte;

import Analizador.Export;
import Token.Token;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/**
 *
 * @author ordson
 */
public class Reporte extends javax.swing.JFrame {
    Export export = new Export();
    /**
     * Creates new form Reporte
     */
    public Reporte() {
        initComponents();
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(420, 500));

        jScrollPane1.setViewportView(jTextPane1);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jMenu1.setText("Archivo");

        jMenuItem2.setText("Guardar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       export.SaveAs(jTextPane1, this);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(Reporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reporte().setVisible(true);
            }
        });
    }
    private void init(){
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    
    public void mostrarPalabras(ArrayList<Token> tokens) {
        for (int i = 0; i < tokens.size(); i++) {
            if (!tokens.get(i).getTipo().equals("ERROR")) {
                SimpleAttributeSet normal = new SimpleAttributeSet();
                StyleConstants.setFontFamily(normal, "SansSerif");
                StyleConstants.setFontSize(normal, 16);
                try {
                    jTextPane1.getDocument().insertString(jTextPane1.getDocument().getLength(), tokens.get(i).getTipo() +" " +tokens.get(i).getValor()+ "\n", normal);
                } catch (BadLocationException ex) {
                    Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public void mostrarErrores(ArrayList<Token> tokens){
        for (int i = 0; i < tokens.size(); i++) {
            if (tokens.get(i).getTipo().equals("ERROR")) {
                SimpleAttributeSet normal = new SimpleAttributeSet();
                StyleConstants.setFontFamily(normal, "SansSerif");
                StyleConstants.setFontSize(normal, 16);
                try {
                    jTextPane1.getDocument().insertString(jTextPane1.getDocument().getLength(), tokens.get(i).getTipo() +" " +tokens.get(i).getValor()+ "\n", normal);
                } catch (BadLocationException ex) {
                    Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public void mostrar(ArrayList<Token> tokens){
        for (int i = 0; i < tokens.size(); i++) {
           
                SimpleAttributeSet normal = new SimpleAttributeSet();
                StyleConstants.setFontFamily(normal, "SansSerif");
                StyleConstants.setFontSize(normal, 16);
                try {
                    jTextPane1.getDocument().insertString(jTextPane1.getDocument().getLength(), tokens.get(i).getTipo() +" " +tokens.get(i).getValor()+ "\n", normal);
                } catch (BadLocationException ex) {
                    Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
