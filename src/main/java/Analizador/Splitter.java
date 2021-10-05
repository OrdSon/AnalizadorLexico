/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Analizador;

import java.util.ArrayList;

/**
 *
 * @author ordson201931185
 */
public class Splitter {
    public Splitter(){
        
    }
    
    public ArrayList<String> getStringList(String texto){
        char[] caracteres = texto.toCharArray();
        ArrayList<String> cadenas = new ArrayList<>();
        String segmento = "";
        for (int i = 0; i < caracteres.length; i++) {
            if (caracteres[i] == ' ') {
                if (!segmento.isEmpty() && !segmento.isBlank()) {
                    cadenas.add(segmento);
                    segmento = "";
                    
                }else{
                    int contador = 0;
                    for (int j = i; j < caracteres.length; j++) {
                        if (caracteres[i] == ' ') {
                            contador++;
                        }
                    }
                    i += contador;
                }
            }else{
                segmento += caracteres[i];
            }
        }
        return cadenas;
    }
}
