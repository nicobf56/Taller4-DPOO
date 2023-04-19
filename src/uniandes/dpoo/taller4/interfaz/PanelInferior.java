package uniandes.dpoo.taller4.interfaz;

import javax.swing.*;


import java.awt.*;

public class PanelInferior extends JPanel{
    int sizeTablero;
    private  JLabel jugadas;
    private JLabel jugadorB;

    public PanelInferior(PanelSuperior panelSuperior, InterfazLightsOut interfaz, PruebaTablero prueba) {

        JPanel paneLbl = new JPanel();
        this.setBackground(Color.WHITE);
        paneLbl.setBackground(Color.WHITE);
    
		paneLbl.setLayout(new GridLayout(1,4, 0, 10));

        JLabel nuevoB = new JLabel("Jugadas: ");
		paneLbl.add(nuevoB);

        jugadas = new JLabel("0");
		paneLbl.add(jugadas);

        JLabel top10B = new JLabel("Jugador: ");
		paneLbl.add(top10B);

        jugadorB = new JLabel("");
		paneLbl.add(jugadorB);

        this.add(paneLbl, BorderLayout.CENTER);
    }

    public void actualizarJugadas(int contador, String nombreJugador)
    {
        String contString = String.valueOf(contador);
        jugadas.setText(contString);
        jugadorB.setText(nombreJugador);
    }

    public void actualizarJugadas(int contador)
    {
        String contString = String.valueOf(contador);
        jugadas.setText(contString);
    }
}
