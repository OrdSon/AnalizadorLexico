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
    ArrayList<Token> errores = new ArrayList<>();
    Distinguisher distinguisher = new Distinguisher();
    String[][] transiciones = {{"S1", "A", "S6"},
    {"S1", "L", "S2"},
    {"S2", "L", "S2"},
    {"S2", "D", "S2"},
    {"S2", "N", "S2"},
    {"S1", "N", "S3"},
    {"S3", "D", "S3"},
    {"S3", "N", "S3"},
    {"S3", ".", "S4"},
    {"S4", "D", "S8"},
    {"S4", "N", "S8"},
    {"S8", "N", "S8"},
    {"S8", "D", "S8"},
    {"S1", "P", "S5"},
    {"S1", ".", "S5"},
    {"S1", "O", "S7"}};
    String[] aceptacion = {"S1", "S3", "S8", "S5", "S6", "S7"};
    String estadoInicial = "S1";
    String estadoActual = estadoInicial;
    boolean error;
    boolean match;
    boolean signo;

    public Analizador() {

    }

    public void Analizar(ArrayList<String> cadenas) {
        tokens.clear();
        errores.clear();
        for (int i = 0; i < cadenas.size(); i++) {
            char[] caracteres = cadenas.get(i).toCharArray();
            String cadena = "";
            String ultimoEstado = "";
            for (int j = 0; j < caracteres.length; j++) {
                String valor = distinguisher.distinguish(caracteres[j]);

                int contador = 0;
                for (int k = 0; k < transiciones.length; k++) {
                    String estado = transiciones[k][0];
                    String valorRequerido = transiciones[k][1];
                    String siguiente = transiciones[k][2];

                    if (valor.equals("A") || valor.equals("O")) {
                        if (cadena.length() > 0) {
                            estadoActual = ultimoEstado;
                            verificarAceptacion(cadena);
                            cadena = "";
                        }
                        if (valor.equals("A")) {
                            guardarSigno(cadena, "S6", caracteres[j]);
                        } else {
                            guardarSigno(cadena, "S7", caracteres[j]);
                        }

                        signo = true;
                        cadena = "";
                        break;
                    }

                    if (estado.equals(estadoActual) && valorRequerido.equals(valor)) {
                        ultimoEstado = siguiente;
                        estadoActual = siguiente;
                        cadena += caracteres[j];
                        contador = 0;
                        error = false;
                        break;
                    } else {
                        if (contador == (transiciones.length - 1)) {
                            estadoActual = "X";
                            cadena += caracteres[j];
                            verificarAceptacion(cadena);
                            estadoActual = estadoInicial;
                            cadena = "";
                            error = true;

                        }
                        contador++;
                    }

                }

            }
            if (error != true || signo != true) {
                if (!cadena.isBlank()) {
                    guardar(cadena);
                }
            }
            if (signo == true) {
                signo = false;
            }

        }
    }

    private void guardar(String cadena) {
        verificarAceptacion(cadena);
        estadoActual = estadoInicial;
    }

    private void verificarAceptacion(String cadena) {
        switch (estadoActual) {
            case "S2":
                tokens.add(new Token(cadena, Token.Tipo.IDENTIFICADOR));
                break;
            case "S3":
                tokens.add(new Token(cadena, Token.Tipo.ENTERO));
                break;
            case "S8":
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

    private void guardarSigno(String cadena, String siguiente, char caracter) {
        estadoActual = siguiente;
        cadena += caracter;
        verificarAceptacion(cadena);
        estadoActual = estadoInicial;
    }

    public void print() {
        for (int i = 0; i < tokens.size(); i++) {
            System.out.println(tokens.get(i).getTipo() + "  " + tokens.get(i).getValor());
        }
    }
    
    public ArrayList<Token> getTokens(){
        return tokens;
    }
    public ArrayList<Token> getErrores(){
        return tokens;
    }
}
