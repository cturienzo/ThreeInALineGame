import java.beans.PropertyChangeSupport;

public class Tablero {

    private int tamanio;
    private int[][] tablero;
    private PropertyChangeSupport soporteTablero;


    public Tablero(PropertyChangeSupport soporteTablero){
        tamanio=3;
        tablero=new int[3][3];
        inicializaTablero();
        this.soporteTablero = soporteTablero;
    }

    public void inicializaTablero(){
        for(int i=0;i<tablero.length;i++){
            for(int j= 0;j<tablero.length;j++){
                tablero[i][j]=0;

            }
        }
    }
    public void setTablero(int [][] tablero){
        this.tablero=tablero;

    }

    public int[][] getTablero(){
        return this.tablero;
    }

    public void setPosicion(Posicion p, int valor){
        int[][] nuevoTablero= new int[tamanio][tamanio];
        copiarTablero(nuevoTablero);
        nuevoTablero[p.getY()][p.getX()]=valor;
        soporteTablero.firePropertyChange("TABLERO",this.tablero,nuevoTablero);
        this.tablero=nuevoTablero;


    }

    public int getPosicion(Posicion p){
        return tablero[p.getX()][p.getY()];
    }

    public void copiarTablero(int[][] nuevoTablero){
        for(int i=0;i<tablero.length;i++){
            for(int j=0;j<tablero.length;j++){
                nuevoTablero[i][j]=tablero[i][j];
            }
        }
    }

    public void dibujaTablero(){
        for(int i=0;i<tablero.length;i++){
            for(int j= 0;j<tablero.length;j++){
                System.out.print(tablero[i][j]);

            }
            System.out.println();
        }

    }

    public boolean tableroLleno(){
        int cont=0;
        for(int i=0;i<tablero.length;i++){
            for(int j=0;j<tablero.length;j++){
                if(tablero[i][j]!=0){
                    cont++;
                }
            }
        }
        return (cont==9);
    }

    public boolean casillaOcupada(Posicion p){
        return (tablero[p.getY()][p.getX()]!=0);

    }

    public boolean tresEnRayaVertical(){
        int i=0;
        boolean hayTresenRaya=false;
        while(i<tablero.length && !hayTresenRaya) {
            if (tablero[i][0] != 0) {
                if (tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2]) {
                    hayTresenRaya = true;
                }

            }
            i++;
        }
        return hayTresenRaya;

    }

    public boolean tresEnRayaHorizontal(){
        int i=0;
        boolean hayTresenRaya=false;
        while(i<tablero.length && !hayTresenRaya) {
            if (tablero[0][i] != 0) {
                if (tablero[0][i] == tablero[1][i] && tablero[1][i] == tablero[2][i]) {
                    hayTresenRaya = true;
                }

            }
            i++;
        }
        return hayTresenRaya;

    }

    public boolean tresEnRayaDiagonal(){
        boolean DP=false, DS=false;
        if(tablero[1][1]!=0){
            DP = (tablero[0][0]==tablero[1][1] && tablero[1][1]==tablero[2][2]);
            DS = (tablero[2][0]==tablero[1][1] && tablero[1][1]==tablero[0][2]);

        }
        return (DP || DS);

    }

    public boolean hayTresEnRaya(){
        return tresEnRayaVertical() || tresEnRayaHorizontal() || tresEnRayaDiagonal();
    }



}
