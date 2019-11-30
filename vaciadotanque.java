import java.io.BufferedReader;
import java.io.InputStreamReader;
// todos funcan
public class tpepregunta2a {
    public static void main(String[] args) {
        double tiempoInicial = 0;
        double intervaloTiempo = 0;
        double maxTiempo = 100000000; // maximo 100.000.000
        double caudalEntrada = 0; // caudal entrada E
        // double caudalSalida=0; // caudal salida S
        double areaTanque = 0; // area transversal del tanque A
        double alturaTanque = 0; // altura del tanque
        double alturaAguaTanque = 0; // altura del agua en el tanque
        double volumenTotalTanque = 0; //
        double volumenAguaTanque = 0; // V(t)
        // int alturaDeAgua=0; // h(t)
        double alturaDeAguaInicial = 0; // h(ti)
        boolean pasaMitad = false;
        boolean alturaNula = false;
        double modifCaudal = 0;

        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

            do {
                System.out.println("introduzca un valor para el intervalo de tiempo");
                intervaloTiempo = new Double(entrada.readLine());
            } while (intervaloTiempo <= 0);

            do {
                System.out.println("introduzca un valor para el area del tanque");
                areaTanque = new Double(entrada.readLine());
            } while (areaTanque <= 0);

            do {
                System.out.println("introduzca un valor para la altura del tanque");
                alturaTanque = new Double(entrada.readLine());
            } while (alturaTanque <= 0);

            do {
                System.out.println("introduzca con que altura de agua comienza el tanque");
                alturaDeAguaInicial = new Double(entrada.readLine());
            } while ((alturaDeAguaInicial < 0) || (alturaDeAguaInicial > alturaTanque));

            do {
                System.out.println("introduzca un caudal de entrada");
                caudalEntrada = new Double(entrada.readLine());
            } while (caudalEntrada < 0);

            do {
                System.out.println("introduzca un modif de caudal de salida");
                System.out.println("el caudal de salida final sera modif*t");
                modifCaudal = new Double(entrada.readLine());
            } while (modifCaudal < 0);

            volumenTotalTanque = areaTanque * alturaTanque;
            System.out.println("su tanque tiene un volumen total de: " + volumenTotalTanque);

            volumenAguaTanque = areaTanque * alturaAguaTanque;
            alturaAguaTanque=alturaDeAguaInicial; // VER
            // informador c/2
            if (alturaAguaTanque >= (alturaTanque / 2) && pasaMitad == false) {
                System.out.println("se supero la mitad del tanque");
                // System.out.println("altura agua tanque " + alturaAguaTanque + "mts");
                System.out.println("altura " + alturaDeAguaInicial + "mts");
                System.out.println("a los " + tiempoInicial + " segundos");
                pasaMitad = true;
            }

            // llenado
            while ((alturaAguaTanque < alturaTanque) && (tiempoInicial < (intervaloTiempo * maxTiempo))) {

                tiempoInicial += intervaloTiempo; // esto se hace antes de la formula
                alturaAguaTanque = alturaDeAguaInicial + (caudalEntrada - (modifCaudal * tiempoInicial)) * intervaloTiempo / areaTanque;
                
                alturaDeAguaInicial = alturaAguaTanque;

                // informador c/2
                if (alturaAguaTanque >= (alturaTanque / 2) && pasaMitad == false) {
                    System.out.println("se supero la mitad del tanque");
                    System.out.println("altura " + alturaDeAguaInicial + "mts");
                    System.out.println("a los " + tiempoInicial + " segundos");
                    pasaMitad = true;
                }
                // para ajustar correctamente el llenado
                if (alturaAguaTanque >= alturaTanque) {
                    // tanque lleno
                    alturaAguaTanque = alturaTanque;
                    alturaDeAguaInicial = alturaAguaTanque;
                }
                ;

                if (alturaAguaTanque < 0 && alturaNula == false) {
                    // tanque vacio
                    System.out.println("tiempo que se autovacia " + tiempoInicial);
                    alturaNula = true;
                    alturaAguaTanque = 0;
                    alturaDeAguaInicial = 0;
                    break;
                }
                ;

            }

            if (alturaAguaTanque == alturaTanque) {
                System.out.println("el tanque se lleno a los " + tiempoInicial + " segundos");
                
                while (alturaAguaTanque > 0 && (tiempoInicial < (intervaloTiempo * maxTiempo))) {
                    tiempoInicial += intervaloTiempo;
                    alturaAguaTanque = alturaDeAguaInicial + (0 - (modifCaudal * tiempoInicial)) * intervaloTiempo / areaTanque;
                    alturaDeAguaInicial = alturaAguaTanque;
                }
                if (alturaAguaTanque <= 0) {
                    System.out.println("el tanque se vació a los " + tiempoInicial + " segundos");
                    alturaAguaTanque=0;
                    alturaDeAguaInicial=alturaAguaTanque;
                } else {
                    System.out.println("se alcanzó la simulación máxima y su tanque no se vació por completo");
                }
            } else if (alturaAguaTanque < alturaTanque) {
                // System.out.println(alturaDeAguaInicial);
                volumenAguaTanque = areaTanque * alturaAguaTanque;
                System.out.println("su tanque no se lleno, solo alcanzó los " + volumenAguaTanque + " m3");
                System.out.println("tiempo:" + tiempoInicial);
                
            }

        } catch (Exception exc) {
            System.out.println("hubo un error al ingresar valores");
        }
    }

}