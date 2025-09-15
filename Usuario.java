import java.util.ArrayList;
import java.util.List;

public class Usuario {
    // Creacion de atributos

    private int id;
    private String fechaNacimiento;
    private String nombre;
    private String correo;
    private String telefono;

    private List<Libro> librosPrestados;

    // constructor

    public Usuario(int id, String fechaNacimiento, String nombre, String correo, String telefono) {
        this.id = id;
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.librosPrestados = new ArrayList<>();
    }

    // setter and getter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Libro> getLibrosPrestados() {
        return new ArrayList<>(librosPrestados);
    }

    // tostring
    @Override
    public String toString() {
        return "Usuario con id " + id + "\n " + " Nombre = " + nombre + "\n" + " Correo = " + correo + "\n"
                + " Telefono =" + telefono;
    }

    // metodos para buscar

    public boolean buscarID(int idBuscado) {
        return this.id == idBuscado;
    }

    public boolean buscarNombre(String nombreBuscado) {
        return this.nombre.equals(nombreBuscado);
    }

    public boolean buscarCorreo(String correoBuscado) {
        return this.nombre.equals(correoBuscado);
    }

    // metodos para realizar

    public void librosPrestados(Libro libro) {
        librosPrestados.add(libro);
    }

    public void librosDevueltos(Libro libro) {
        if (librosPrestados.remove(libro)) {
            System.out.println("devolviste el libro");
        } else {
            System.out.println("No hay libros para devolver");
        }

    }

    public void mostrarLibrosPrestadosUsuarioS() {
        if (librosPrestados.isEmpty()) {
            System.out.println("No ha pedido prestados.");
        } else {
            System.out.println("Libros prestados:");
            for (Libro libro : librosPrestados) {
                System.out.printf("El libro %s fue prestado y añadido a tu id (%d)", libro.getTitulo(), id);
            }
        }
    }

    public Libro buscarLibroPrestadoID(int id) {
        for (Libro libro : librosPrestados) {
            if (libro.buscarID(id)) {
                return libro;
            }
        }
        return null;
    }

    public List<Libro> buscarLibrosPrestadoTitulo(String titulo) {
        List<Libro> resultados = new ArrayList<>();
        for (Libro libro : librosPrestados) {
            if (libro.buscarTitulo(titulo)) {
                resultados.add(libro);
            }
        }
        return resultados;
    }

}
