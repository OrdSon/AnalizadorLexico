/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Analizador;

import Token.Token;
import java.util.ArrayList;

/**
 *
 * @author ordson201931185
 */
public class Analizador {
    ArrayList<Token> tokens = new ArrayList<>();
    Distinguisher distinguisher = new Distinguisher();
    String[][] transiciones = {{"S1", "L", "S2"},
    {"S2", "L", "S2"},
    {"S2", "D", "S2"},
    {"S1", "N", "S3"},
    {"S3", "D", "S3"},
    {"S3", ".", "S4"},
    {"S4", "D", "S4"},
    {"S1", "P", "S5"},
    {"S1", ".", "S5"},
    {"S1", "A", "S6"},
    {"S1", "O", "S7"}};
    String[] aceptacion = {"S1", "S3", "S4", "S5", "S6", "S7"};
    String estadoInicial = "S1";
    String estadoActual = estadoInicial;
    boolean error;
    boolean match;

    public Analizador() {

    }

    public void Analizar(ArrayList<String> cadenas) {
        
        for (int i = 0; i < cadenas.size(); i++) {
            char[] caracteres = cadenas.get(i).toCharArray();
            for (int j = 0; j < caracteres.length; j++) {
                String valor = distinguisher.distinguish(caracteres[j]);
                int contador = 0;
                for (int k = 0; k < transiciones.length; k++) {
                    String estado = transiciones[k][0];
                    String valorRequerido = transiciones[k][1];
                    String siguiente = transiciones[k][2];
                    if (estado.equals(estadoActual) && valorRequerido.equals(valor)) {
                        estadoActual = siguiente;
                        contador = 0;
                        break;
                    } else {
                        contador++;
                    }
                    if (contador == (transiciones.length - 1)) {
                        estadoActual = "X";
                    }
                }
                
            }
            verificarAceptacion(cadenas.get(i));
            estadoActual = estadoInicial;
        }
    }
    
    private void verificarAceptacion(String cadena){
        switch(estadoActual){
            case "S2":
                tokens.add(new Token(cadena, Token.Tipo.IDENTIFICADOR));
                break;
            case "S3":
                tokens.add(new Token(cadena, Token.Tipo.ENTERO));
                break;
            case "S4":
                tokens.add(new Token(cadena, Token.Tipo.DECIMAL));
                break;
            case "S5":
                tokens.add(new Token(cadena, Token.Tipo.PUNTUACION));
                break;
            case "S6":
                tokens.add(new Token(cadena, Token.Tipo.AGRUPACION));
                break;
            case "S7":
                tokens.add(new Token(cadena, Token.Tipo.OPERADOR));
                break;
            default:
                tokens.add(new Token(cadena, Token.Tipo.ERROR));
                break;
        }
    }
    public void print(){
        for (int i = 0; i < 10; i++) {
            System.out.println(tokens.get(i).getTipo()+"  "+tokens.get(i).getValor());
        }
    }
}
