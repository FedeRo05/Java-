import java.util.ArrayList;
import java.util.Scanner;

public class Practca_11 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Double> pasivos = new ArrayList<>();
        ArrayList<Double> capitales = new ArrayList<>();

        int opcion;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Registrar pasivo");
            System.out.println("2. Registrar capital");
            System.out.println("3. Calcular activo");
            System.out.println("4. Mostrar pasivos y capitales");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    System.out.print("Ingresa el pasivo: ");
                    double pasivo = sc.nextDouble();
                    if (pasivo < 0) {
                        System.out.println("Error: No se permiten valores negativos");
                    } else {
                        pasivos.add(pasivo);
                        System.out.println("Pasivo registrado correctamente");
                    }
                    break;

                case 2:
                    System.out.print("Ingresa el capital: ");
                    double capital = sc.nextDouble();
                    if (capital < 0) {
                        System.out.println("Error: No se permiten valores negativos");
                    } else {
                        capitales.add(capital);
                        System.out.println("Capital registrado correctamente");
                    }
                    break;

                case 3:
                    double sumaPasivos = 0;
                    double sumaCapitales = 0;

                    for (double p : pasivos) {
                        sumaPasivos += p;
                    }

                    for (double c : capitales) {
                        sumaCapitales += c;
                    }

                    double activo = sumaPasivos + sumaCapitales;

                    System.out.println("Activo total: " + activo);
                    break;

                case 4:
                    System.out.println("\nPasivos:");
                    for (double p : pasivos) {
                        System.out.println(p);
                    }

                    System.out.println("\nCapitales:");
                    for (double c : capitales) {
                        System.out.println(c);
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        } while (opcion != 5);

        sc.close();
    }
}