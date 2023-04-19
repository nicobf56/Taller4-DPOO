package uniandes.dpoo.taller4.interfaz;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;


import uniandes.dpoo.taller4.modelo.*;


public class PruebaTablero extends JPanel implements MouseListener{

    private int size;
    private int width;
    private boolean[][] tableroActual;
    private int[][] cantidades;
    private int ultima_columna;
    private int ultima_fila;
    private Tablero principal;
    private Top10 top;
    private PanelInferior panelInferior;
    private String nombre;

    PruebaTablero(boolean[][] tableroActual, Tablero principal, PanelInferior panelInferior, Top10 top) {
        this.size = principal.darTablero().length;
        this.tableroActual = tableroActual;
        this.principal = principal;
        this.cantidades = new int[size][size];
        this.top = top;
        this.panelInferior = panelInferior;
        addMouseListener(this);
    }

    public void paintComponent(Graphics h) {
        super.paintComponent(h);
        this.setBackground(Color.WHITE);
        ImageIcon apagado = new ImageIcon(getClass().getResource("apagado.png"));
        ImageIcon prendido = new ImageIcon(getClass().getResource("prendido.png"));

        int widthT = getWidth();
        int heightT = getHeight();
        int spacingX;
        int spacingY;
        int casilla = width/this.size;

        if (widthT < heightT) {
            width = widthT;
            spacingX = 0;
            spacingY = (heightT - (casilla*size)) / 2;

        }
        else {
            width = heightT;
            spacingX = (widthT - (casilla*size)) / 2;
            spacingY = 0;
        }

        for (int i = 0; i<size; i++) {
            for (int j = 0; j<size; j++) {
                this.cantidades[i][j] = 0;
                if (tableroActual[j][i])
                {
                    h.drawImage(prendido.getImage(), i*casilla + spacingX, j*casilla + spacingY, casilla, casilla, this);
                }
                else
                {
                    h.drawImage(apagado.getImage(), i*casilla + spacingX, j*casilla + spacingY, casilla, casilla, this);
                }
            }
        }
    }

    public void optionPaneWin() {
        
        if (principal.tableroIluminado()==true)
        {
            if(nombre == null)
            {
                nombre = JOptionPane.showInputDialog(null, "Felicidades, has ganado el juego ¿Cuál es tu nombre?", "Lights Out", JOptionPane.QUESTION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "Felicidades, has ganado el juego", "Lights Out", JOptionPane.INFORMATION_MESSAGE);
            }

            if (nombre != null)
            {
                int puntaje = principal.calcularPuntaje();
                if (top.esTop10(puntaje) == true);
                {
                    top.agregarRegistro(nombre, puntaje);
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub 
    }
    
    
    @Override
    public void mousePressed(MouseEvent e) {
        int click_x = e.getX();
        int click_y = e.getY();
        int[] casilla = convertirCoordenadasACasilla(click_x, click_y);
        principal.jugar(casilla[0], casilla[1]);
        cantidades[casilla[0]][casilla[1]]++;
        this.ultima_fila = casilla[0];
        this.ultima_columna = casilla[1];
        panelInferior.actualizarJugadas(principal.darJugadas(), nombre);
        revalidate();
        repaint();  
        optionPaneWin();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    private int[] convertirCoordenadasACasilla(int x, int y)
    {
        int ladoTablero = size;
        int altoPanelTablero = getHeight();
        int anchoPanelTablero = getWidth();
        int altoCasilla = altoPanelTablero / ladoTablero;
        int anchoCasilla = anchoPanelTablero / ladoTablero;
        int fila = (int) (y / altoCasilla);
        int columna = (int) (x / anchoCasilla);
        return new int[] { fila, columna };
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return boolean[][] return the tableroActual
     */
    public boolean[][] getTableroActual() {
        return tableroActual;
    }

    /**
     * @param tableroActual the tableroActual to set
     */
    public void setTableroActual(boolean[][] tableroActual) {
        this.tableroActual = tableroActual;
    }

    /**
     * @return int[][] return the cantidades
     */
    public int[][] getCantidades() {
        return cantidades;
    }

    /**
     * @param cantidades the cantidades to set
     */
    public void setCantidades(int[][] cantidades) {
        this.cantidades = cantidades;
    }

    /**
     * @return int return the ultima_columna
     */
    public int getUltima_columna() {
        return ultima_columna;
    }

    /**
     * @param ultima_columna the ultima_columna to set
     */
    public void setUltima_columna(int ultima_columna) {
        this.ultima_columna = ultima_columna;
    }

    /**
     * @return int return the ultima_fila
     */
    public int getUltima_fila() {
        return ultima_fila;
    }

    /**
     * @param ultima_fila the ultima_fila to set
     */
    public void setUltima_fila(int ultima_fila) {
        this.ultima_fila = ultima_fila;
    }

    /**
     * @return Tablero return the principal
     */
    public Tablero getPrincipal() {
        return principal;
    }

    /**
     * @param principal the principal to set
     */
    public void setPrincipal(Tablero principal) {
        this.principal = principal;
    }

    /**
     * @return Top10 return the top
     */
    public Top10 getTop() {
        return top;
    }

    /**
     * @param top the top to set
     */
    public void setTop(Top10 top) {
        this.top = top;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}