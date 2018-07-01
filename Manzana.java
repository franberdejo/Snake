package Serpiente;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Manzana {
	int x, y;
	boolean estado;
	
	void dibujar(Graphics g) {
		g.setColor(Color.blue);
		g.fillOval(x,y,10,10);
	}
	
	void generaCoor () {
		Random pos = new Random();
		x = pos.nextInt(79-1)*10;
		y = pos.nextInt(49-1)*10;
	}
	
	boolean getStatus() {
		return estado;
	}
	
	void setStatus(boolean a) {
		estado = a;
	}
	int getX() {
		return x;
	}
	int getY() {
		return y;
	}
}
