import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int smallCups = 10;   // Cantidad inicial de vasos pequeños
        int mediumCups = 10;  // Cantidad inicial de vasos medianos
        int largeCups = 10;   // Cantidad inicial de vasos grandes

        int sugarSupply = 100; // Cantidad inicial de azúcar

        System.out.println("Bienvenido a la Máquina Dispensadora de Café");

        int coffeeAmount =0;
        int sugarAmount = 0;
        char cupSize = '\0';

        while (true) {
            System.out.println("\nOpciones disponibles:");
            System.out.println("1) Seleccionar tamaño de vaso");
            System.out.println("2) Seleccionar cantidad de azúcar");
            System.out.println("3) Recoger vaso de café");
            System.out.println("4) Salir");
            System.out.print("Seleccione una opción: ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Tamaños de vaso disponibles:");
                    System.out.println("a) Pequeño");
                    System.out.println("b) Mediano");
                    System.out.println("c) Grande");
                    System.out.print("Seleccione un tamaño de vaso: ");
                     cupSize = scanner.next().charAt(0);

                    coffeeAmount = 0;
                    String cupType = "";

                    switch (cupSize) {
                        case 'a':
                            coffeeAmount = 3;
                            cupType = "Pequeño";
                            if (smallCups <= 0) {
                                System.out.println("Lo siento, no hay vasos pequeños disponibles.");
                                continue;
                            }
                            break;
                        case 'b':
                            coffeeAmount = 5;
                            cupType = "Mediano";
                            if (mediumCups <= 0) {
                                System.out.println("Lo siento, no hay vasos medianos disponibles.");
                                continue;
                            }
                            break;
                        case 'c':
                            coffeeAmount = 7;
                            cupType = "Grande";
                            if (largeCups <= 0) {
                                System.out.println("Lo siento, no hay vasos grandes disponibles.");
                                continue;
                            }
                            break;
                        default:
                            System.out.println("Opción no válida.");
                            continue;
                    }

                    System.out.println("Seleccionó un vaso " + cupType + " de " + coffeeAmount + " Oz de café.");
                    break;

                case 2:
                    System.out.print("Seleccione la cantidad de azúcar deseada: ");
                     sugarAmount = scanner.nextInt();
                    if (sugarAmount > sugarSupply) {
                        System.out.println("Lo siento, no hay suficiente azúcar disponible.");
                        continue;
                    }
                    System.out.println("Seleccionó " + sugarAmount + " cucharadas de azúcar.");
                    break;

                case 3:
                    if (coffeeAmount == 0) {
                        System.out.println("Primero debe seleccionar un tamaño de vaso.");
                        continue;
                    }
                    if (sugarAmount == 0) {
                        System.out.println("Primero debe seleccionar la cantidad de azúcar.");
                        continue;
                    }
                    System.out.println("Recoge tu café. ¡Disfruta!");
                    coffeeAmount = 0;
                    sugarAmount = 0;

                    // Disminuir la cantidad de vasos y azúcar disponibles
                    if (cupSize == 'a') {
                        smallCups--;
                    } else if (cupSize == 'b') {
                        mediumCups--;
                    } else if (cupSize == 'c') {
                        largeCups--;
                    }
                    sugarSupply -= sugarAmount;
                    break;

                case 4:
                    System.out.println("¡Hasta luego!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}
