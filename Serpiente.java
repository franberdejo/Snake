package Serpiente;

import java.awt.Color;
import java.awt.Graphics;

public class Serpiente {
	
	int x,y;
	boolean arriba = false;
	boolean abajo = false;
	boolean izq = false;
	boolean drch = false;
	Serpiente(int a, int b){
		x=a;
		y=b;
	}
	void dibujar(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x,y,10,10);
	}
	
	int getX() {
		return x;
	}
	int getY() {
		return y;
	}
	void setX(int a) {
		x = a;
	}
	void setY(int a) {
		y=a;
	}
	
	public void moverDerecha() {
		if(izq == false) {
			x =x+10;
			if(x>800) {
				x=0;
			}
			drch = true;
			izq = false;
			arriba = false;
			abajo = false;
		}else {moverIzquierda();}
	}
	public void moverIzquierda() {
		if(drch == false) {
			x = x-10;
			if(x<0) {
				x=800;
			}
			drch = false;
			izq = true;
			arriba = false;
			abajo = false;
		}else {moverDerecha();}
	}
	public void moverArriba() {
		if(abajo == false) {
			y=y-10;
			if(y<0) {
				y=500;
			}
			drch = false;
			izq = false;
			arriba = true;
			abajo = false;
		}else {moverAbajo();}
	}
	public void moverAbajo() {
		if(arriba == false) {
			y=y+10;
			if(y>500) {
			y=0;
			}
			drch = false;
			izq = false;
			arriba = false;
			abajo = true;
		}else {moverArriba();}
	}
}
