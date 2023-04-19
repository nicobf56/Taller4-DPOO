package uniandes.dpoo.taller4.interfaz;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


import javax.swing.*;
import uniandes.dpoo.taller4.modelo.*;


@SuppressWarnings("serial")
public class InterfazLightsOut extends JFrame implements WindowListener
{

	private RegistroTop10 registro;
	private Tablero tablero;
	private Top10 top;
	
	private JFrame f;
	private JPanel ventana;
	private PanelSuperior panelSuperior;
	private boolean juegoIniciado;
	private PruebaTablero prueba;
	
	public InterfazLightsOut(RegistroTop10 registro, Tablero tablero, Top10 top) {

		this.registro = registro;
		this.tablero = tablero;
		this.top = top;
		
		JFrame f = new JFrame();
		ventana = new JPanel();
		this.setBackground(Color.WHITE);
		panelSuperior = new PanelSuperior(this);
		
		ventana.setLayout(new BorderLayout());
		add(panelSuperior, BorderLayout.NORTH);
		
		PanelInferior panelInferior = new PanelInferior(panelSuperior, this, null);
		add(panelInferior, BorderLayout.SOUTH);

		JPanel temp = new JPanel();
		temp.setBackground(Color.WHITE);

		add(temp, BorderLayout.CENTER);
		
		this.setSize(700, 600);
		this.setTitle("LightsOut");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.juegoIniciado = false;

		PanelIzq botonesPanel = new PanelIzq(panelSuperior, this, panelInferior, prueba);
		add(botonesPanel, BorderLayout.EAST);
		f.add(ventana);
	}
	
	public static void main(String[] args) {
		
		InterfazLightsOut interfaz = new InterfazLightsOut(null, null, new Top10());
		interfaz.setVisible(true);
		
	}

    public void agregarTablero(PruebaTablero prueba) {
		this.prueba = prueba;
		add(prueba, BorderLayout.CENTER);
    }

	public void eliminarTablero() {
		if (this.prueba != null)
		{
			remove(this.prueba);
		}
    }
	
	public JPanel getVentana() {
		return ventana;
	}

	public Top10 getTop() {
		return top;
	}
	
	public JFrame getF() {
		return f;
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

    /**
     * @return RegistroTop10 return the registro
     */
    public RegistroTop10 getRegistro() {
        return registro;
    }

    /**
     * @param registro the registro to set
     */
    public void setRegistro(RegistroTop10 registro) {
        this.registro = registro;
    }

    /**
     * @return Tablero return the tablero
     */
    public Tablero getTablero() {
        return tablero;
    }

    /**
     * @param tablero the tablero to set
     */
    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    /**
     * @param top the top to set
     */
    public void setTop(Top10 top) {
        this.top = top;
    }

    /**
     * @param ventana the ventana to set
     */
    public void setVentana(JPanel ventana) {
        this.ventana = ventana;
    }
    /**
     * @return PanelSuperior return the panelSuperior
     */
    public PanelSuperior getPanelSuperior() {
        return panelSuperior;
    }

    /**
     * @param panelSuperior the panelSuperior to set
     */
    public void setPanelSuperior(PanelSuperior panelSuperior) {
        this.panelSuperior = panelSuperior;
    }

    /**
     * @return boolean return the juegoIniciado
     */
    public boolean isJuegoIniciado() {
        return juegoIniciado;
    }

    /**
     * @param juegoIniciado the juegoIniciado to set
     */
    public void setJuegoIniciado(boolean juegoIniciado) {
        this.juegoIniciado = juegoIniciado;
    }

    /**
     * @return PruebaTablero return the prueba
     */
    public PruebaTablero getPrueba() {
        return prueba;
    }

    /**
     * @param prueba the prueba to set
     */
    public void setPrueba(PruebaTablero prueba) {
        this.prueba = prueba;
    }

}
