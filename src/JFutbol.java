import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Vector;

public class JFutbol extends JFrame implements ActionListener {
    private JTextField infoJugadorTextField;
    private JButton guardarBotaEnJugadorButton;
    private JTextField infoBotaTextField;
    private JList listaBotas;
    private JButton generearFicheroConTodoButton;
    private JTable tablaJugadores;
    private JPanel mainPanel;
    private DefaultTableModel modeloTablaJugadores;

    public JFutbol(){
        modeloTablaJugadores = new DefaultTableModel();
        modeloTablaJugadores.addColumn("Nombre");
        modeloTablaJugadores.addColumn("Apellido");
        modeloTablaJugadores.addColumn("Posicion");
        modeloTablaJugadores.addColumn("Id_bota");

        tablaJugadores.setModel(modeloTablaJugadores);
        tablaJugadores.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int num_fila = tablaJugadores.getSelectedRow();
                Vector datos = modeloTablaJugadores.getDataVector().elementAt(num_fila);
                int id_bota = Integer.parseInt(datos.elementAt(3)+"");
                listaBotas.setSelectedIndex(id_bota-1);

                infoJugadorTextField.setText(datos.get(0) + " " + datos.get(1));
                infoBotaTextField.setText(Main.listaBotas.get(id_bota-1).toString());
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });

        guardarBotaEnJugadorButton.addActionListener(this);
        generearFicheroConTodoButton.addActionListener(this);
        add(mainPanel);
        cargarDatosJugadores();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == guardarBotaEnJugadorButton){
            for(Jugador jugador : Main.listaJugadores){
                jugador.setBota(Main.listaBotas.get(jugador.getId_bota()-1));
            }
            JOptionPane.showMessageDialog(null, "Botas guardadas", "Save", JOptionPane.INFORMATION_MESSAGE);
        }
        if(e.getSource() == generearFicheroConTodoButton){
            generarFicheroConTodo();
        }
    }
    private void generarFicheroConTodo(){
       try{
           BufferedWriter archivo = new BufferedWriter(new FileWriter("datosTodo.txt"));
           for (Jugador jugador : Main.listaJugadores){
               archivo.write(jugador.toString() + "\n");
           }
           archivo.close();
           JOptionPane.showMessageDialog(null, "Se ha generado el fichero datosTodo.txt correctamente", "info", JOptionPane.INFORMATION_MESSAGE);
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
    }
    private void cargarDatosJugadores(){
        try{
            BufferedReader archivo = new BufferedReader(new FileReader("datos.txt"));
            String fila = archivo.readLine();
            while (fila != null){
                String[] datos = fila.split(";");
                if(datos.length == 4){
                    Main.listaJugadores.add(new Jugador(datos[0], datos[1], datos[2], Integer.parseInt(datos[3])));
                    modeloTablaJugadores.addRow(new Object[]{datos[0], datos[1], datos[2], Integer.parseInt(datos[3])});
                }
                else{
                    Main.listaBotas.add(new Bota(Integer.parseInt(datos[0]), datos[1], datos[2]));
                }
                fila = archivo.readLine();
            }
            Main.ordenarBotas();
            listaBotas.setListData(getListaBotas());
            archivo.close();
        }catch (IOException ex){
            JOptionPane.showMessageDialog(null, "No se han podido cargar los datos", "File", JOptionPane.ERROR_MESSAGE);
        }
    }
    private String[] getListaBotas(){
        String[] aux = new String[Main.listaBotas.size()];
        for (int i =0; i<Main.listaBotas.size(); i++){
            aux[i] = Main.listaBotas.get(i).toString();
        }
        return aux;
    }
}
