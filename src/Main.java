import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Jugador> listaJugadores = new ArrayList<>();
    public static ArrayList<Bota> listaBotas = new ArrayList<>();
    public static void main(String[] args){
        JFutbol futbol = new JFutbol();
    }
    public static void ordenarBotas(){
        for(int i = 0; i<listaBotas.size(); i++){
            for (Bota bota : listaBotas){
                if(listaBotas.get(i).getId() < bota.getId()){
                    Bota mayor = listaBotas.get(i);
                    Bota menor = bota;
                    int id_mayor = listaBotas.indexOf(mayor);
                    int id_menor = listaBotas.indexOf(menor);
                    listaBotas.set(id_mayor, menor);
                    listaBotas.set(id_menor, mayor);
                }
            }
        }
    }
}
