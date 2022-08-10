package com.prueba.melitest.components;

import com.prueba.melitest.exceptions.FoundException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class EsMuntante {

    EsMuntante(){
        //
    }

    /* Completa matriz con DNA */
    static char[][] completeMatriz (String[] dna ){

        int lenghMatriz = dna.length;
        char[][] arr = new char[dna.length][dna.length];
        for (int i = 0; i < lenghMatriz; i++) {
            char [] dnaSimple = dna[i].toCharArray();

            /*
             * se valida que la matriz no tenga un tamaño menor a 4,
             * ya que la condicion es que al menos coincidan 4 letras
             * por ende la matriz no debe ser menor a 4x4
             * */
            if (dnaSimple.length!=lenghMatriz || lenghMatriz<4){
                throw new FoundException("la matrix debe ser cuadrada");
            }
            /*
             * se valida si las letras corresponden a A, T, C, G
             */
            if (!validaLetras(dnaSimple)){
                throw new FoundException("la matrix debe ser cuadrada");
            }
             /*
              se devuelve en un una matriz de caracteres por argumento
              cada resultado
              */
            arr[i] = dnaSimple;
        }
        return arr;
    }

    /* Válida que las letras sean las correctas
    *  a las pedidas en el problema */
    static boolean validaLetras(char [] dnaSimple){

        for (char c : dnaSimple) {
            if (c != 'A' && c != 'T' && c != 'C' && c != 'G') {
                return false;
            }
        }
        return true;
    }

    /* Cuenta secuencia Horizontal*/
    static int contarSecuenciaHoriz(char[][] arr, int lenghMatriz){
        int countSecuenceHoriz=0;
        for (int i = 0; i < lenghMatriz; i++) {
            for (int j = 0; j < lenghMatriz; j++) {
                if (lenghMatriz-j>=4 &&
                     arr[i][j] == arr[i][j+ 1] &&
                     arr[i][j] == arr[i][j + 2] &&
                     arr[i][j] == arr[i][j + 3]
                    ) {
                        countSecuenceHoriz++;
                        j += + 3;
                        /* Acelera la busqueda de la solución*/
                        if (countSecuenceHoriz>1){
                            return (countSecuenceHoriz);
                        }
                    }

            }
        }
        return countSecuenceHoriz;
        }


    /* Cuenta secuencia de forma Vertical*/
    static int contarSecuenciaVert(char[][] arr) {
        int countSecuenceVert = 0;
        for (int j = 0; j < arr[0].length; j++) {
            for (int i = 0; i < arr.length - 3; i++) {
                if (arr[i][j] == arr[i + 1][j] && arr[i][j] == arr[i + 2][j] && arr[i][j] == arr[i + 3][j]) {
                    countSecuenceVert++;
                    i += 3;
                    /* Acelera la busqueda de la solución */
                    if (countSecuenceVert > 1) {
                        return (countSecuenceVert);
                    }
                }
            }
        }
        return countSecuenceVert;
    }

    /* Busca secuancia diagonal de IZQ a DER*/
    static int buscarDiagIzqDer(char[][] arr, int lenghMatriz, int i, int j, String indLimit){
        int contSecuencia =0;
        int limit;
        while (i<=lenghMatriz-1 && j<=lenghMatriz-1){
            if (Objects.equals(indLimit, "J")){
                limit=lenghMatriz-j;
            }else{
                limit=lenghMatriz-i;
            }
            if (limit>=4 &&
                arr[i][j] == arr[i+1][j+1] &&
                arr[i][j] == arr[i+2][j+2] &&
                arr[i][j] == arr[i+3][j+3]
                ) {
                    contSecuencia++;
                }

            i++;
            j++;
        }
        return contSecuencia;
    }

    /* Cuenta secuencia de forma diagonal Izquierda a Derecha */
    static int contaSecuenciaDiagIzqDer(char[][] arr, int lenghMatriz){
        int i;
        int j=0;
        int countSecuence=0;
        for (int indI = lenghMatriz-1; indI >= 0; indI--) {
            /*
             * entra en este lugar si la busqueda comienza desde [0,n]
             * */
            if (indI==0){
                for (int indJ = 0; indJ < lenghMatriz; indJ++) {
                    i=indI;
                    j=indJ;
                    int cont = buscarDiagIzqDer(arr, lenghMatriz, i, j, "J");
                    countSecuence = countSecuence + cont;
                }
            /*
              entra en este lugar si la busqueda comienza desde [n,0]
            */
            }else{
                i=indI;
                int cont = buscarDiagIzqDer(arr, lenghMatriz, i, j, "I");
                countSecuence = countSecuence + cont;
            }
            // Acelera busqueda de solución
            if (countSecuence > 1){
                return countSecuence;
            }
        }
        return countSecuence;
    }

    /* Busca secuencia diagonal de DER a IZq*/
    static int busquedaDiagDerIzq(char[][] arr, int lenghMatriz, int i, int j, String indLimit){
        int contSecuencia =0;
        int limit=0;
        while (i<=lenghMatriz-1 && j>=0){
            if (Objects.equals(indLimit, "J")){
                limit=j;
            }else{
                limit=lenghMatriz-i-1;
            }
            if (limit>=3 && arr[i][j] == arr[i+1][j-1] &&
                        arr[i][j] == arr[i+2][j-2] &&
                        arr[i][j] == arr[i+3][j-3]
                ) {
                    contSecuencia++;
                }

            i++;
            j--;
        }
        return contSecuencia;
    }

    /* Cuenta secuencia de forma diagonal Derecha a Izquierda */
    static int contarSecuenciaDiagDerIzq(char[][] arr, int lenghMatriz){
        int i=0;
        int j;
        int countSecuence=0;
        for (int indJ = 0; indJ <= lenghMatriz-1; indJ++) {
            if (indJ==lenghMatriz-1){
                /*
                 comienza la busqueda desde [n,n]
                * */
                for (int indI = 0; indI <= lenghMatriz-1 ; indI++) {
                    i=indI;
                    j=indJ;
                    int cont = busquedaDiagDerIzq(arr, lenghMatriz, i, j, "I");
                    countSecuence = countSecuence + cont;
                }
                /*
                busca desde [0,n]
                */
            }else{
                j=indJ;
                int cont = busquedaDiagDerIzq(arr, lenghMatriz, i, j, "J");
                countSecuence = countSecuence + cont;
            }

            // Acelera busqueda de solución
            if (countSecuence > 1){
                return countSecuence;
            }

        }
        return countSecuence;
    }

    /* Evalua si es mutante o no */
    public static boolean isMutant(String[] dna){
        int tamanioMatriz = dna.length;
        char[][] arr = completeMatriz(dna);


        /* ***************************************************
         * EVALUA RESULTADOS PARA DETERMINAR SI ES MUTANTE O NO
         * *****************************************************/

        /* Evalúa secuencia horizontal  */
        int totalSecuenceHoriz = contarSecuenciaHoriz(arr, tamanioMatriz);
        if (totalSecuenceHoriz>1){
            return true;
        }

        /* Evalúa secuencia vertical + horizontal  */
        int totSecuenceVert = contarSecuenciaVert(arr);
        if ((totalSecuenceHoriz+totSecuenceVert)>1){
            return true;
        }

        /* Evalúa secuencia horizontal + vertical + diagonal IZQ => DER */
        int totalSecuenceDiagIzqDer = contaSecuenciaDiagIzqDer(arr, tamanioMatriz);
        if ((totalSecuenceHoriz+totSecuenceVert+totalSecuenceDiagIzqDer)>1){
            return true;
        }

        /* Evalúa secuencia horizontal + vertical + diagonal IZQ => DER + diagonal DER => IZQ */
        int totalSecuenceDiagDerIzq = contarSecuenciaDiagDerIzq(arr, tamanioMatriz);
        return (totalSecuenceHoriz + totSecuenceVert + totalSecuenceDiagIzqDer + totalSecuenceDiagDerIzq) > 1;
    }
}
