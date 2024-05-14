public class Jugador {
    private String nombre;
    private String apellido;
    private String posicion;
    private int id_bota;
    private Bota bota;

    public void setBota(Bota bota) {
        this.bota = bota;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getPosicion() {
        return posicion;
    }

    public int getId_bota() {
        return id_bota;
    }

    public Bota getBota() {
        return bota;
    }

    public Jugador(String nombre, String apellido, String posicion, int id_bota) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.posicion = posicion;
        this.id_bota = id_bota;
        bota = null;
    }

    public Jugador(String nombre, String apellido, String posicion, int id_bota, Bota bota) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.posicion = posicion;
        this.id_bota = id_bota;
        this.bota = bota;
    }

    @Override
    public String toString() {
        return nombre + ";" + apellido + ";" + posicion + ";" + id_bota + (bota == null? "": ";" + bota.toStringWrite());
    }
}
