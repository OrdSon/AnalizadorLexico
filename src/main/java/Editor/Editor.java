/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Editor;

import Analizador.Analizador;
import Analizador.Contador;
import Analizador.Export;
import Analizador.Splitter;
import Reporte.Reporte;
import TextLine.TextLineNumber;
import Token.Token;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import org.drjekyll.fontchooser.FontChooser;

/**
 *
 * @author ordson
 */
public class Editor extends javax.swing.JFrame {
    Export export = new Export();
    Import importar = new Import();
    Contador contador = new Contador();
    FontChooser fontChooser = new FontChooser();
    Splitter splitter = new Splitter();
    Analizador analizador = new Analizador();
    Pintor pintor = new Pintor();

    /**
     * Creates new form Editor
     */
    public Editor() {
        initComponents();
        addLineNumbers();
    }

    private void addLineNumbers() {
        TextLineNumber textLineNumber = new TextLineNumber(panelPrincipal);
        scroller.setRowHeaderView(textLineNumber);
    }
    private void mostrarCoincidencias(){
        txtErrores.setText("");
        txtTokens.setText("");
        txtRecuento.setText("");
        for (int i = 0; i < analizador.getTokens().size(); i++) {
            if (analizador.getTokens().get(i).getTipo().equals("ERROR")) {
                txtErrores.setText(txtErrores.getText()+analizador.getTokens().get(i).getTipo()+" "+ analizador.getTokens().get(i).getValor()+"\n");
            }else{
                txtTokens.setText(txtTokens.getText()+analizador.getTokens().get(i).getTipo()+" "+ analizador.getTokens().get(i).getValor()+"\n");
            }
        }
        ArrayList<String> contadas = contador.contar(analizador.getTokens());
        for (int i = 0; i < contadas.size(); i++) {
            txtRecuento.setText(txtRecuento.getText()+contadas.get(i)+"\n");
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPestañas = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtTokens = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtErrores = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtRecuento = new javax.swing.JTextPane();
        scroller = new javax.swing.JScrollPane();
        panelPrincipal = new javax.swing.JTextPane();
        barraDeOpciones = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        opcionAbrir = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        menuEditar = new javax.swing.JMenu();
        opcionFuente = new javax.swing.JMenuItem();
        menuCodigo = new javax.swing.JMenu();
        opcionCompilar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));

        PanelPestañas.setMinimumSize(new java.awt.Dimension(78, 200));
        PanelPestañas.setPreferredSize(new java.awt.Dimension(228, 200));

        jScrollPane1.setViewportView(txtTokens);

        PanelPestañas.addTab("Tokens", jScrollPane1);

        jScrollPane2.setViewportView(txtErrores);

        PanelPestañas.addTab("Errores", jScrollPane2);

        jScrollPane4.setViewportView(txtRecuento);

        PanelPestañas.addTab("Recuento", jScrollPane4);

        getContentPane().add(PanelPestañas, java.awt.BorderLayout.PAGE_END);

        panelPrincipal.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        scroller.setViewportView(panelPrincipal);

        getContentPane().add(scroller, java.awt.BorderLayout.CENTER);

        menuArchivo.setText("Archivo");

        opcionAbrir.setText("Abrir");
        opcionAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionAbrirActionPerformed(evt);
            }
        });
        menuArchivo.add(opcionAbrir);

        jMenuItem4.setText("Reporte");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        menuArchivo.add(jMenuItem4);

        jMenuItem2.setText("Reporte de palabras");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuArchivo.add(jMenuItem2);

        jMenuItem1.setText("Reporte de errores");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuArchivo.add(jMenuItem1);

        jMenuItem3.setText("Guardar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menuArchivo.add(jMenuItem3);

        barraDeOpciones.add(menuArchivo);

        menuEditar.setText("Editar");

        opcionFuente.setText("Fuente");
        opcionFuente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionFuenteActionPerformed(evt);
            }
        });
        menuEditar.add(opcionFuente);

        barraDeOpciones.add(menuEditar);

        menuCodigo.setText("Codigo");

        opcionCompilar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        opcionCompilar.setText("Analizar");
        opcionCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionCompilarActionPerformed(evt);
            }
        });
        menuCodigo.add(opcionCompilar);

        barraDeOpciones.add(menuCodigo);

        setJMenuBar(barraDeOpciones);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opcionAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionAbrirActionPerformed
        importar.importar(panelPrincipal, panelPrincipal);
    }//GEN-LAST:event_opcionAbrirActionPerformed

    private void opcionFuenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionFuenteActionPerformed
        JOptionPane.showMessageDialog(null, fontChooser, "Escoger fuente", JOptionPane.PLAIN_MESSAGE);
        SimpleAttributeSet normal = new SimpleAttributeSet();
        StyleConstants.setFontFamily(normal, fontChooser.getSelectedFont().getFamily());
        StyleConstants.setFontSize(normal, (int)fontChooser.getSelectedSize());
        panelPrincipal.setCharacterAttributes(normal, true);
    }//GEN-LAST:event_opcionFuenteActionPerformed

    private void opcionCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionCompilarActionPerformed
        try {
            ArrayList<String> cadenas = splitter.getStringList(panelPrincipal.getDocument().getText(0, panelPrincipal.getDocument().getLength()));
            analizador = new Analizador();
            analizador.Analizar(cadenas);
            analizador.print();
            pintar();
        } catch (BadLocationException ex) {
            Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
        }
        mostrarCoincidencias();
    }//GEN-LAST:event_opcionCompilarActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Reporte reporte = new Reporte();
        reporte.mostrarPalabras(analizador.getTokens());
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
      export.SaveAs(panelPrincipal, this);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        Reporte reporte = new Reporte();
        reporte.mostrar(analizador.getTokens());
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Reporte reporte = new Reporte();
        reporte.mostrarErrores(analizador.getTokens());
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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Editor().setVisible(true);
            }
        });
    }

    private void pintar() {
        try {
             panelPrincipal.setText("");
        } catch (Exception e) {
        }
       
        
        ArrayList<Token> tokens = analizador.getTokens();
        for (int i = 0; i < tokens.size(); i++) {
            try {                
                    pintor.display(" ", fontChooser.getSelectedFont().getFamily(), (int) fontChooser.getSelectedSize(), tokens.get(i), panelPrincipal);
                
            } catch (BadLocationException ex) {
                Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            pintor.setBlack(fontChooser.getSelectedFont().getFamily(), (int) fontChooser.getSelectedSize(), panelPrincipal);
        } catch (BadLocationException ex) {
            Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
        } catch(NullPointerException ex){
            JOptionPane.showMessageDialog(null, "null aqui");
        }finally {
            panelPrincipal.setCaretPosition(panelPrincipal.getDocument().getLength()-1);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane PanelPestañas;
    private javax.swing.JMenuBar barraDeOpciones;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuCodigo;
    private javax.swing.JMenu menuEditar;
    private javax.swing.JMenuItem opcionAbrir;
    private javax.swing.JMenuItem opcionCompilar;
    private javax.swing.JMenuItem opcionFuente;
    private javax.swing.JTextPane panelPrincipal;
    private javax.swing.JScrollPane scroller;
    private javax.swing.JTextPane txtErrores;
    private javax.swing.JTextPane txtRecuento;
    private javax.swing.JTextPane txtTokens;
    // End of variables declaration//GEN-END:variables

    public JTextPane getjTextPane1() {
        return panelPrincipal;
    }
}
