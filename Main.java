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
                    System.out.println(" Se va a agregar un nuevo libro \n ingresa los siguientes datos: ");
                    Libro nuevoLibro = new Libro();
                    System.out.println("ID: ");
                    nuevoLibro.setId(entrada.nextInt());
                    System.out.println("Titulo: ");
                    nuevoLibro.setTitulo(entrada.next());
                    System.out.println("Genero: ");
                    nuevoLibro.setCategoria(entrada.next());
                    System.out.println("Clasificacion: ");
                    nuevoLibro.setRestriccion(entrada.next());
                    System.out.println("Autor: ");
                    nuevoLibro.setAutor(entrada.next());
                    System.out.println("Editorial: ");
                    nuevoLibro.setEditorial(entrada.next());
                    System.out.println("Año de publicacion: ");
                    nuevoLibro.setAnio(entrada.nextInt());
                    System.out.println("Cantidad de copias: ");
                    nuevoLibro.setCantidad(entrada.nextInt());
                    biblioteca.agregarLibro(nuevoLibro);
                    System.out.println("El libro " + nuevoLibro.getTitulo() + " Con el ID" + nuevoLibro.getId()
                            + " Ha sido agregado exitosamente ");
                    break;
                case 4:
                    System.out.print("ID: ");
                    int id = entrada.nextInt();
                    entrada.nextLine();
                    System.out.print("Fecha nacimiento: ");
                    String fecha = entrada.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = entrada.nextLine();
                    System.out.print("Correo: ");
                    String correo = entrada.nextLine();
                    System.out.print("Teléfono: ");
                    String tel = entrada.nextLine();
                    Usuario nuevo = new Usuario(id, fecha, nombre, correo, tel);
                    biblioteca.agregarUsuario(nuevo);
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
                default:
                    System.out.println("No ingresaste una opción valida, intente de nuevo");
                    break;
            }
        } while (aux == true);

    }
}
