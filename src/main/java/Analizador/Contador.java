/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Analizador;

import Token.Token;
import java.util.ArrayList;

/**
 *
 * @author ordson
 */
public class Contador {

    public Contador() {
    }
    
    public ArrayList<String> contar(ArrayList<Token> tokens){
        ArrayList<Token> temporal = (ArrayList<Token>)tokens.clone();
        ArrayList<String> contadas = new ArrayList<>();
        for (int i = 0; i < tokens.size(); i++) {
            int contador = 0;
            for (int j = 0; j < temporal.size(); j++) {
                String valor =tokens.get(i).getValor();
                String comparar = temporal.get(j).getValor();
                if (valor.equals(comparar) && !tokens.get(i).getTipo().equals("ERROR")) {
                    contador++;
                    temporal.remove(j);
                    j--;
                }
            }
            if (contador != 0) {
                contadas.add(tokens.get(i).getTipo()+" "+tokens.get(i).getValor()+" Apariciones: "+ contador);
            }
        }
        return  contadas;
    }
}   
