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
        System.out.println(texto);
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
                        char actual = caracteres[j];
                        if (actual == ' ') {
                            contador++;
                        }else{
                            break;
                        }
                    }
                    i += contador-1;
                }
            } else{
                segmento += caracteres[i];
            }if (i == caracteres.length-1 && !segmento.isBlank()) {
                cadenas.add(segmento);
            }
        }
        return cadenas;
    }
}
