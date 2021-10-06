/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Editor;

import Token.Token;
import java.awt.Color;
import java.util.Date;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author ordson
 */
public class Pintor {
    public void display(String spacer, String font, int size, Token token, JTextPane jtp) throws BadLocationException {
        StyledDocument doc = (StyledDocument) jtp.getDocument();

        SimpleAttributeSet normal = new SimpleAttributeSet();
        StyleConstants.setFontFamily(normal, font);
        StyleConstants.setFontSize(normal, size);
        SimpleAttributeSet custom = pintar(normal, token.getTipoT());
        doc.insertString(doc.getLength(), token.getValor() + " ", custom);
    }
    
    private SimpleAttributeSet pintar(SimpleAttributeSet normal, Token.Tipo tipo){
        SimpleAttributeSet custom = new SimpleAttributeSet(normal);
        StyleConstants.setBold(custom, true);
        Color color = Color.BLACK;
        switch(tipo){
            case IDENTIFICADOR:
                color = new Color(102, 0, 153);
                break;
            case ENTERO:
                color = new Color(204, 102, 0);
                break;
            case DECIMAL:
                color = new Color(51, 102, 255);
                break;
            case PUNTUACION:
                color = new Color(0, 204, 0);
                break;
            case AGRUPACION:
                color = new Color(151, 118, 160);
                break;
            case OPERADOR:
                color = new Color(204, 0, 255);
                break;
            case ERROR:
                color = new Color(204, 0, 0);
                break;
            default:
                break;
        }
        StyleConstants.setForeground(custom, color);
        return custom;
    }
    public void setBlack(String font, int size, JTextPane jtp) throws BadLocationException {
        StyledDocument doc = (StyledDocument) jtp.getDocument();
        SimpleAttributeSet normal = new SimpleAttributeSet();
        StyleConstants.setFontFamily(normal, font);
        StyleConstants.setFontSize(normal, size);
        StyleConstants.setForeground(normal, Color.BLACK);
        doc.insertString(doc.getLength(), " ", normal);
    }
}
