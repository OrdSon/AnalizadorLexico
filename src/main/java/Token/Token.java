/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Token;

/**
 *
 * @author ordson201931185
 */
public class Token {

    Token.Tipo tipo;
    String valor;

    public Token() {
    }

    public Token(String valor, Token.Tipo tipo) {
        this.valor = valor;
        this.tipo = tipo;
    }

    public enum Tipo {
        IDENTIFICADOR,
        ENTERO,
        DECIMAL,
        PUNTUACION,
        AGRUPACION,
        OPERADOR,
        ERROR
    }

    public String getTipo() {
        return this.tipo.toString();
    }

    public Token.Tipo getTipoT() {
        return this.tipo;
    }

    public String getValor() {
        return this.valor;
    }
}
