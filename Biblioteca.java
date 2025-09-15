import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    // Crear atributos
    private List<Libro> libros;
    private List<Usuario> usuarios;

    // Constructor
    public Biblioteca() {
        this.libros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    // Metodos para libro

    public void agregarLibro(Libro libro) {
        libros.add(libro);
        System.out.println("Libro agregado");
    }

    public void mostrarLibrosDisponibles() {
        boolean aux = false;
        System.out.println("Libros disponibles:");
        for (Libro libro : libros) {
            if (libro.getCantidad() > 0) {
                System.out.printf("Titulo: %s, Cantidad: %d. %n", libro.getTitulo(), libro.getCantidad());
                aux = true;
            }
        }
        if (!aux) {
            System.out.println("No hay libros! Agrega!");
        }
    }

    // Buscar
    public Libro buscarLibroPorID(int id) {
        for (Libro libro : libros) {
            if (libro.getId() == (id)) {
                return libro;
            }
        }
        return null;
    }

    public List<Libro> buscarLibrosPorTitulo(String titulo) {
        List<Libro> resultados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                resultados.add(libro);
            }
        }
        return resultados;
    }

    public List<Libro> buscarLibrosPrestadosUsuario(int id) {
        List<Libro> resultados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.prestadoUsuario(id)) {
                resultados.add(libro);
            }
        }
        return resultados;
    }

    public void eliminarLibro(int id) {
        Libro libro = buscarLibroPorID(id);
        if (libro != null) {
            libros.remove(libro);
            System.out.printf("Libro eliminado: %s", libro.getTitulo());
        } else {
            System.out.printf("Libro con id %d no encontrado", id);
        }
    }

    // Metodos para usuario

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuario agregado");
    }

    public void mostrarUsuariosDisponibles() {
        System.out.println("Usuarios disponibles:");
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios! Agrega!");
        } else {
            for (Usuario usuario : usuarios) {
                System.out.printf("Nombre: %s, Correo: %s. %n", usuario.getNombre(), usuario.getCorreo());
            }
        }
    }

    public void mostrarLibrosPrestadosUsuarios(int id) {
        Usuario usuario = buscarUsuarioPorID(id);
        if (usuario != null) {
            System.out.println("Libros prestados: ");
            usuario.mostrarLibrosPrestadosUsuarioS();
        } else {
            System.out.println("Usuario no encontrado");
        }
    }

    public void prestarLibro(int id, Usuario usuario) {
        Libro libro = buscarLibroPorID(id);
        if (libro != null) {
            libro.prestarLibro(usuario);
        } else {
            System.out.printf("Libro con id %d no encontrado", id);
        }
    }

    public void devolverLibro(int id) {
        Libro libro = buscarLibroPorID(id);
        if (libro != null) {
            libro.devolverLibro();
            ;
        } else {
            System.out.printf("Libro con id %d no encontrado", id);
        }
    }

    // Buscar
    public Usuario buscarUsuarioPorID(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == (id)) {
                return usuario;
            }
        }
        return null;
    }

    public List<Usuario> buscarUsuariosPorNombre(String nombre) {
        List<Usuario> resultados = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            if (usuario.buscarNombre(nombre)) {
                resultados.add(usuario);
            }
        }
        return resultados;
    }

    public Usuario buscarUsuarioPorCorreo(String correo) {
        for (Usuario usuario : usuarios) {
            if (usuario.buscarCorreo(correo)) {
                return usuario;
            }
        }
        return null;
    }

}
