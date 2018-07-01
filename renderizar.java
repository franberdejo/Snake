package Serpiente;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class renderizar extends JPanel{
	
	ArrayList<Serpiente> serpi;
	Manzana manzana;

	private static final long serialVersionUID = 1L;
	
	public void paint (Graphics g) {
		super.paint(g);
		try {
			manzana.dibujar(g);
		}catch(Exception e) {}
		
		try {
			for(int i=0; i< serpi.size();i++) {
				serpi.get(i).dibujar(g);
			}
		}catch(Exception e){}
		setBackground(Color.darkGray);
		g.setColor(Color.white);
		try {
			g.drawString("Score: "+serpi.size(), 10, 10);
		}catch(Exception e) {}
	}
	
	void setSerpiente (ArrayList<Serpiente> a) {
		serpi = a;
	}
	void setManzana(Manzana manzana) {
		this.manzana = manzana;
	}
}
