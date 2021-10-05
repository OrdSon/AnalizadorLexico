/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Editor;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

/**
 *
 * @author ordson
 */
public class Import {

    public Import() {

    }

    public void importar(Component partner, JTextPane textPane) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(partner);

        try {
            File file = fileChooser.getSelectedFile();
            String nombreArchivo = file.getAbsolutePath();
            FileReader reader = new FileReader(nombreArchivo);
            try (BufferedReader bufferedReader = new BufferedReader(reader)) {
                textPane.read(bufferedReader, null);
            }
            textPane.requestFocus();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(partner, "Error al encontrar archivo");
        }
    }
}
