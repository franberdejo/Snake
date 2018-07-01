package Serpiente;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

public class Main {

	public static void main(String[] args) {
		
		// Genero la ventana
		JFrame ventana = new JFrame();
		ventana.setSize(820,520);
		ventana.setBackground(Color.darkGray);
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		ventana.setTitle("Snake by franberdejo");
		Toolkit test = Toolkit.getDefaultToolkit();
		ventana.setIconImage(test.getImage("gallery/images.jpeg"));
		ventana.setResizable(false);
		
		//Arraylist donde se almacenara cada fragmento de la serpiente
		ArrayList<Serpiente> serpiente = new ArrayList<Serpiente>();
		Serpiente fragSerpiente = new Serpiente(380, 220);
		serpiente.add(fragSerpiente);
		
		
		//creo el Panel y lo añado a la ventana
		renderizar render = new renderizar();
		ventana.getContentPane().add(render);
		ventana.revalidate();
		
		//Manzana
		Manzana manzana = new Manzana();
		manzana.setStatus(true);
		
		//inicializo el lector de teclado y lo añado a la ventana
		evento tecla = new evento();
		ventana.addKeyListener(tecla);

		//Accion que se ejecuta cada 100ms
		ActionListener redibujar = new ActionListener() {
			 public void actionPerformed(ActionEvent evt) {
					int x,y,x1,y1,x0,y0;
					
					//Comprueba el estado de la manzana por si necesita redibujarse
					if(manzana.getStatus()) {
						manzana.generaCoor();
						render.setManzana(manzana);
						manzana.setStatus(false);
					}
					//Solo mueve la cabeza
					x=serpiente.get(0).getX();
					y=serpiente.get(0).getY();
					x0=x;
					y0=y;
					//Comprueba que si se ha comido la manzana
					if(manzana.getX()==x && manzana.getY()==y) {
						manzana.setStatus(true);
						Serpiente frag = new Serpiente(serpiente.get(serpiente.size()-1).getX()-10, serpiente.get(serpiente.size()-1).getY()-10);
						serpiente.add(frag);
						
					}
					int tcl = tecla.getTcl();
					switch(tcl) {
					case KeyEvent.VK_UP: serpiente.get(0).moverArriba(); break;
					case KeyEvent.VK_DOWN: serpiente.get(0).moverAbajo(); break;
					case KeyEvent.VK_LEFT: serpiente.get(0).moverIzquierda(); break;
					case KeyEvent.VK_RIGHT: serpiente.get(0).moverDerecha(); break;
					}
					//Para el resto de trozos le asigna la posicion del que va delante
					for(int i=1; i< serpiente.size();i++) {
						x1=serpiente.get(i).getX();
						y1=serpiente.get(i).getY();
						//Comprueba si la serpiente se ha comido a si misma
						if(x0 == x1 && y0 == y1) {
							serpiente.clear();
							Serpiente fragSerpiente = new Serpiente(380, 220);
							serpiente.add(fragSerpiente);
						}else {
							serpiente.get(i).setX(x);
							serpiente.get(i).setY(y);
							x=x1;
							y=y1;
						}
					}
					render.setSerpiente(serpiente);
					render.repaint();
			 }
		};	
		//Temporizador que ejecuta redibujar cada 100ms
		Timer time = new Timer(100, redibujar);
		time.start();
	}

}
//lector de eventos de teclado
class evento implements KeyListener{
	int tcl;
	int tcl1;
	
	//funcion que se encarga de devolver la tecla solo la tecla si es una de las flechas
	int getTcl() {
		if((tcl==KeyEvent.VK_UP) || (tcl==KeyEvent.VK_DOWN) || (tcl == KeyEvent.VK_LEFT) || (tcl==KeyEvent.VK_RIGHT)) {
			tcl1 = tcl;
			return tcl;
			}else {
				return tcl1;
			}
		}
	public void keyPressed(KeyEvent e) {tcl = e.getKeyCode();}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
}
