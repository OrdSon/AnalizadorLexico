/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Analizador;

/**
 *
 * @author ordson201931185
 */
public class Distinguisher {
    char[] puntuacion = {'.',',',';',':'};
    char[] agrupacion = {'(',')','[',']','{','}'};
    char[] operadores = {'+','-','*','/','%'};
    public Distinguisher(){
        
    }
    
    public String distinguish(char caracter){
        if (Character.isDigit(caracter)) {
            return getNumberType(caracter);
        }else if (Character.isLetter(caracter)) {
            return "L";
        }else if (isPuntuacion(caracter)) {
            if (isDot(caracter)) {
                return ".";
            }
            return "P";
        }else if (isAgrupacion(caracter)){
            return "A";
        }else if(isOperador(caracter)){
            return "O";
        }
        return "X";
    }
    private boolean isDot(char caracter){
        if (caracter == '.') {
            return true;
        }
        return false;
    }
    private boolean isPuntuacion(char caracter){
        for (int i = 0; i < puntuacion.length; i++) {
            if (Character.compare(caracter, puntuacion[i]) == 0) {
                return true;
            }
        }
        return false;
    }
    
    private boolean isAgrupacion(char caracter){
        for (int i = 0; i < agrupacion.length; i++) {
            if (Character.compare(caracter, agrupacion[i]) == 0) {
                return true;
            }
        }
        return false;
    }
    
    private boolean isOperador(char caracter){
        for (int i = 0; i < operadores.length; i++) {
            if (Character.compare(caracter, operadores[i]) == 0) {
                return true;
            }
        }
        return false;
    }
    
    private String getNumberType(char caracter){
        try {
            int numero = Integer.parseInt(caracter+"");
            for (int i = 1; i <= 9; i++) {
                if (i == numero) {
                    return "N";
                }
            }
            for (int i = 0; i <= 9; i++) {
                if (i == numero) {
                    return "D";
                }
            }
        } catch (NumberFormatException e) {
            
        }
        return "X"; 
    }
    
}
