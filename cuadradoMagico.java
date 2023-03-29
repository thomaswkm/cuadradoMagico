import java.util.Random;

public class cuadradoMagico {
    public static void main(String[] args) {
        int[][] matriz = new int[3][3];
        llenarArreglo(matriz);
        imprimir(matriz);
        mostrarVerificacion(verificarCuadradoMagico(matriz));
    }

    public static void llenarArreglo(int[][] matriz){
        Random rd = new Random();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                while(true){
                    int n = rd.nextInt(1,10);
                    if(!verificarRepeticion(matriz, n)){
                        matriz[i][j] = n;
                        break;
                    }
                }
            }
        }
    }

    public static boolean verificarRepeticion(int[][] matriz, int n){

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (n==matriz[i][j]){
                    return true;
                }
            }
        }
        return false;
    }

    public static void imprimir(int[][] matriz){

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("["+matriz[i][j]+"]");
            }
            System.out.println();
        }
    }

    public static boolean verificarCuadradoMagico(int[][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            if(matriz[i][0]+matriz[i][1]+matriz[i][2]!=15){
                return false;
            }
        }

        for (int i = 0; i < matriz.length; i++) {
            if(matriz[0][i]+matriz[1][i]+matriz[2][i]!=15){
                return false;
            }
        }
        if (matriz[0][0]+matriz[1][1]+matriz[2][2]!=15&&matriz[0][2]+matriz[1][1]+matriz[2][0]!=15){
            return false;
        }
        return true;
    }

    public static void mostrarVerificacion(boolean b){
        if (b){
            System.out.println("El cuadrado es magico");
        }else{
            System.out.println("El cuadrado no es magico");
        }
    }

}
