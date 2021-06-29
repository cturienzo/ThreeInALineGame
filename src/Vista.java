import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Vista extends Canvas implements PropertyChangeListener {
    public static final int COMIENZO_X = 40;
    public static final int COMIENZO_Y = 40;
    public static  final int LADO = 80;
    public static final int CENTRO = 15;


    private int[][] tablero;
    private Graphics2D g2d;

    public Vista(Tablero tablero){
        this.tablero=tablero.getTablero();
    }


    public void paint(Graphics g){
        g2d = (Graphics2D) g;


            for (int i = 0; i < tablero.length; i++) {
                for (int j = 0; j < tablero.length; j++) {
                    g2d.setColor(Color.BLACK);
                    g2d.fillRect(COMIENZO_X + LADO * i, COMIENZO_Y + LADO * j, LADO, 1);
                    g2d.fillRect(COMIENZO_X + LADO * i, COMIENZO_Y + LADO * j, 1, LADO);

                    if (tablero[i][j] == 1) {
                        g2d.setColor(Color.BLACK);
                        g2d.setFont(new Font("Times New Roman", Font.PLAIN, 50));
                        g2d.drawString("X",  2* COMIENZO_X + LADO * i-CENTRO, 2*COMIENZO_Y + LADO * j+CENTRO);
                    } else if (tablero[i][j] == 2) {
                        g2d.setColor(Color.BLACK);
                        g2d.setFont(new Font("Times New Roman", Font.PLAIN, 50));
                        g2d.drawString("O", 2 * COMIENZO_X + LADO * i-CENTRO, 2 * COMIENZO_Y + LADO * j+CENTRO);
                    }
                }
            }


            g2d.fillRect(COMIENZO_X + 3 * LADO, COMIENZO_Y, 1, 3 * LADO);
            g2d.fillRect(COMIENZO_X, COMIENZO_Y + 3 * LADO, 3 * LADO, 1);


    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        tablero = (int[][]) evt.getNewValue();
        repaint();
    }


}
