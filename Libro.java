public class Libro {
    // Creando atributos
    private int id;
    private String titulo;
    private String categoria;
    private String restriccion;
    private String autor;
    private String editorial;
    private int anio;
    private int cantidad;

    private Usuario usuarioPrestamo;

    // Constructor
    public Libro(int id, String titulo, String categoria, String restriccion, String autor, String editorial, int anio,
            int cantidad) {
        this.id = id;
        this.titulo = titulo;
        this.categoria = categoria;
        this.restriccion = restriccion;
        this.autor = autor;
        this.editorial = editorial;
        this.anio = anio;
        this.cantidad = cantidad;
    }

    public Libro() {
    }

    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getRestriccion() {
        return restriccion;
    }

    public void setRestriccion(String restriccion) {
        this.restriccion = restriccion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Usuario getUsuarioPrestamo() {
        return usuarioPrestamo;
    }

    public void setUsuarioPrestamo(Usuario usuarioPrestamo) {
        this.usuarioPrestamo = usuarioPrestamo;
    }

    // creando los metodos de buscar

    public boolean buscarID(int idBuscado) {
        return this.id == idBuscado;
    }

    public boolean buscarTitulo(String tituloBuscado) {
        return this.titulo.equals(tituloBuscado);
    }

    public boolean prestadoUsuario(int id) {
        return cantidad > 0 && usuarioPrestamo != null && usuarioPrestamo.buscarID(id);
    }

    // creando los metodos

    public void prestarLibro(Usuario usuario) {
        if (this.cantidad > 0) {
            cantidad -= 1;
            this.usuarioPrestamo = usuario;
            usuario.librosPrestados(this);
            System.out.printf("libro prestado %s a %s.", titulo, usuario.getNombre());
        } else {
            System.out.printf("el libro %s no esta disponible", titulo);
        }

    }

    public void devolverLibro() {
        this.usuarioPrestamo.librosDevueltos(this);
        cantidad += 1;
        System.out.printf("Libro %s devuleto.", titulo);
    }

}
