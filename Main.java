import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // scanner
        Scanner entrada = new Scanner(System.in);

        // CREAR BIBLIOTECA
        Biblioteca biblioteca = new Biblioteca();

        // Crear libros
        biblioteca.agregarLibro(new Libro(111, "Las muejeres aman demasiado", "Libro de autoayuda", "Todo publico",
                "Robin Norwood", "Ediciones B", 1985,
                4));

        biblioteca.agregarLibro(new Libro(122, "Leer es resistir ", "Juvenil", "No",
                "Mario Mendoza", "Planeta Lector", 2022,
                7));

        biblioteca.agregarLibro(new Libro(133, "Etereo", "Juvenil", "16+",
                "Joana Marcus", "Montana", 2024,
                5));

        // Crear usuarios
        biblioteca.agregarUsuario(
                new Usuario(777, "16/08/2008", "Daniel Mahecha", "dmahecha44@unisalle.edu.co", "3046663544"));

        biblioteca.agregarUsuario(
                new Usuario(1234, "10/06/2007", "María Paula Ramírez", "maramirez13@unisalle.edu.co", "3125131295"));

        biblioteca.agregarUsuario(
                new Usuario(1000, "20/09/2003", "Katherynn Gómez", "kgomez25@unisalle.edu.co", "3177493853"));

        // MENU

        boolean aux = true;
        do {
            System.out.println("");
            System.out.println("----------------------------------");
            System.out.println("Biblioteca los tres mostequeros");
            System.out.println("1. Mostrar libros disponibles");
            System.out.println("2. Mostrar usuarios disponibles");
            System.out.println("3. Agregar libros");
            System.out.println("4. Registrar usuarios");
            System.out.println("5. Pedir prestado libros");
            System.out.println("6. Devolver libros");
            System.out.println("7. Libros prestados por usuario ");
            System.out.println("0. Salir");
            System.out.println("----------------------------------");

            System.out.println("Elige una opcion");
            int dato = entrada.nextInt();

            switch (dato) {
                case 1:
                    biblioteca.mostrarLibrosDisponibles();
                    break;
                case 2:
                    biblioteca.mostrarUsuariosDisponibles();
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    System.out.println("Ingresar el ID del libro que se va a prestar");
                    int idPrestar = entrada.nextInt();
                    System.out.println("Ingresa el ID del usuario que se lo llevara");
                    int idUsuarioPrestar = entrada.nextInt();
                    Usuario usuarioPrestamo = biblioteca.buscarUsuarioPorID(idUsuarioPrestar);
                    if (usuarioPrestamo != null) {
                        biblioteca.prestarLibro(idPrestar, usuarioPrestamo);
                    } else {
                        System.out.println("usuario no encontrado");
                    }
                    break;
                case 6:
                    System.out.println("Ingresar el ID del libro a devolver");
                    int idDevolver = entrada.nextInt();
                    biblioteca.devolverLibro(idDevolver);
                    break;
                case 7:
                    System.out.println("Ingresar el ID del usuario a revisar");
                    int idBuscar = entrada.nextInt();
                    biblioteca.mostrarLibrosPrestadosUsuarios(idBuscar);
                    break;
                case 0:
                    aux = false;
                    break;
            }
        } while (aux == true);

    }
}
