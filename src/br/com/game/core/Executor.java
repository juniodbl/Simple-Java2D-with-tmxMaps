package br.com.game.core;

import javax.swing.JFrame;

public class Executor 
{
	public static void main( String[] args )
	{
		//Aqui criamos a tela do nosso "jogo", igual criamos um jframe normal
		Screen sc = new Screen("My Game");
		//neste ponto seria legal colocar o tamanho do mapa caso ele não fosse maior que a sua tela
		sc.setBounds(0, 0, 800, 600);
		sc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sc.setVisible(true);
	}
}