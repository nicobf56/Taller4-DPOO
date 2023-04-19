package uniandes.dpoo.taller4.interfaz;

import javax.swing.*;


import java.awt.*;
import java.awt.event.*;


public class PanelSuperior extends JPanel implements ItemListener, ActionListener{
	
	private JLabel size;
	private JComboBox<String> comboBox;
	private JLabel dificultad;
	private JRadioButton facil;
	private JRadioButton medio;
	private JRadioButton dificil;
	private int sizeTablero = 3;
	private int dificultadTablero;
	
	/**
	 * @param interfaz
	 */
	public PanelSuperior(InterfazLightsOut interfaz) {
		
		this.size = new JLabel("Tamaño: ");
		size.setBackground(Color.WHITE);
		
		this.comboBox = new JComboBox<String>();
		comboBox.setBackground(Color.WHITE);
		comboBox.addItem("3x3");
		comboBox.addItem("5x5");
		comboBox.addItem("8x8");
		comboBox.setBounds(10,10,100,20);
		comboBox.addItemListener(this);
		
		this.dificultad = new JLabel("Dificultad:");
		dificultad.setBackground(Color.WHITE);
		
		this.facil = new JRadioButton("Fácil");
		facil.setBackground(Color.WHITE);
		facil.setBounds(75,50,100,30);
		facil.addActionListener(this);
		
		this.medio = new JRadioButton("Medio");
		medio.setBackground(Color.WHITE);
		medio.setBounds(75,50,100,30);
		medio.addActionListener(this);
		
		this.dificil = new JRadioButton("Difícil");
		dificil.setBackground(Color.WHITE);
		dificil.setBounds(75,50,100,30);
		dificil.addActionListener(this);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(facil);
		bg.add(medio);
		bg.add(dificil);
		
		setLayout(new FlowLayout());
		add(size);
		add(comboBox);
		add(dificultad);
		add(facil);
		add(medio);
		add(dificil);
		
		this.dificultadTablero = sizeTablero*sizeTablero/4;
		this.setBackground(Color.WHITE);
	}

	public void actionPerformed(ActionEvent e) {
		
		if (facil.isSelected()) {
			this.dificultadTablero = sizeTablero*sizeTablero/4;
		}
		else if (medio.isSelected()) {
			this.dificultadTablero = sizeTablero*sizeTablero/3;
		}
		else if (dificil.isSelected()) {
			this.dificultadTablero = sizeTablero*sizeTablero/2;
		}
	}

	public void itemStateChanged(ItemEvent e) {
        if (e.getSource()==comboBox) {
            String seleccionado=(String)comboBox.getSelectedItem();
			if (seleccionado.equals("3x3")) 
			{
				sizeTablero = 3;
				
        	}
			else if (seleccionado.equals("5x5"))
			{
				sizeTablero = 5;
				
			}
			else if (seleccionado.equals("8x8"))
			{
				sizeTablero = 8;
				
			}
		}
	}
		
    public int getSizeTablero() {
        return this.sizeTablero;
    }

	public int getDificultadTablero() {
		return this.dificultadTablero;
	}
}