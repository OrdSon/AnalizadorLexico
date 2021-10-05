/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Editor;

import javax.swing.JTextPane;
import org.drjekyll.fontchooser.FontChooser;

/**
 *
 * @author ordson
 */
public class FontStyler {

    public FontStyler() {

    }

    public void chooseFont(JTextPane textPane) {
        FontChooser fontChooser = new FontChooser();
        fontChooser.setVisible(true);

    }
}
