import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Conversor conversor = new Conversor();
        Monedas tasas = conversor.obtenerTasas();

        EXTERNA:
        while (true) {
            System.out.println("CONVERSOR DE MONEDAS");
            System.out.println("""
                               1. Soles Peruanos a dólares
                               2. Reales Brasileños a dólares
                               3. Pesos Colombianos a dólares
                               4. Pesos Argentinos a dólares
                               5. Salir
                               """);
            System.out.print("INGRESE UNA OPCIÓN: ");
            Scanner leer = new Scanner(System.in);

            int opcion = Integer.parseInt(leer.nextLine());

            switch (opcion) {
                case 1:
                    convertir(tasas.PEN(), "Soles Peruanos");
                    break;
                case 2:
                    convertir(tasas.BRL(), "Reales Brasileños");
                    break;
                case 3:
                    convertir(tasas.COP(), "Pesos Colombianos");
                    break;
                case 4:
                    convertir(tasas.ARS(), "Pesos Argentinos");
                    break;
                case 5:
                    System.out.println("CERRANDO EL PROGRAMA");
                    break EXTERNA;
                default:
                    System.out.println("ESTA OPCIÓN NO EXISTE");
                    break;
            }
        }
    }

    static void convertir(double tasa, String pais) {
        Scanner leer = new Scanner(System.in);
        System.out.printf("Ingrese la cantidad de %s: ", pais);
        double cantidadDeMoneda = leer.nextDouble();

        double dolares = cantidadDeMoneda / tasa;

        dolares = Math.round(dolares * 100.0) / 100.0;
        System.out.println("_______________________________________");
        System.out.println("|    Tienes $" + dolares + " Dólares       |");
        System.out.println("_______________________________________");
    }
}