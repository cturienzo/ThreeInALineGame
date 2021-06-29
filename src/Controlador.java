import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Controlador extends MouseAdapter {
    private Tablero tablero;
    private int turno;
    public boolean hayTresEnRaya;


    public Controlador(Tablero tablero){
        this.tablero=tablero;
        turno=0;
        hayTresEnRaya=false;

    }

    public void mousePressed(MouseEvent e) {
       try {

                if(!tablero.tableroLleno() && !tablero.hayTresEnRaya()){
                    Posicion p = new Posicion((e.getY() - Vista.COMIENZO_Y) / Vista.LADO, (e.getX() - Vista.COMIENZO_X) / Vista.LADO);
                    if(!tablero.casillaOcupada(p)) {
                        if (turno % 2 == 0) {
                            tablero.setPosicion(p, 1);
                        } else {
                            tablero.setPosicion(p, 2);
                        }
                        turno++;
                    }
                }



       }catch(Exception ex){

       }
    }

    public void mouseReleased(MouseEvent e){

        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Times New Roman", Font.PLAIN, 40)));

        if(tablero.hayTresEnRaya()){
            if(turno%2==0){
                JOptionPane.showMessageDialog(null,"Gana Circulos");
            }else{
                JOptionPane.showMessageDialog(null,"Gana Cruces");
            }
        }else if(tablero.tableroLleno()){
            JOptionPane.showMessageDialog(null,"Empate");
        }

    }





}




