package br.com.game.core;

import javax.swing.JFrame;

public class Executor 
{
	public static void main( String[] args )
	{
		Screen sc = new Screen("My Game");
		sc.setBounds(0, 0, 800, 600);
		sc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sc.setVisible(true);
	}
}