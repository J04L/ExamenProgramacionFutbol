public class Bota {
    private int id;
    private String marca;
    private String modelo;
    public Bota(int id, String marca, String modelo) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return id + " " + marca + " " + modelo;
    }
    public String toStringWrite(){
        return marca + ";" + modelo;
    }

    public int getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }
}
