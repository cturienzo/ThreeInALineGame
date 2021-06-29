import java.awt.*;
import java.beans.PropertyChangeSupport;

public class TresEnRaya extends Frame {
    private Tablero tablero;
    private Vista vista;
    private Controlador controlador;

    public TresEnRaya(){

        super("Tres En Raya");
        PropertyChangeSupport soporteTablero = new PropertyChangeSupport(this);
        tablero=new Tablero(soporteTablero);
        vista= new Vista(tablero);

        soporteTablero.addPropertyChangeListener(vista);


        controlador=new Controlador(tablero);

        this.add(vista);
        this.setSize(500, 500);
        vista.addMouseListener(controlador);
        this.setVisible(true);



    }

    public static void main(String [] args){

        new TresEnRaya();
    }
}
