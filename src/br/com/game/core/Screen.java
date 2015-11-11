package br.com.game.core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;

public class Screen extends JFrame
{
	MapaTmx mapa;
	
	public Screen(String titulo) 
	{
		super(titulo);
		mapa = new MapaTmx("./res/mapas/ola_mapa.tmx");
	}

	@Override
	public void paint( Graphics g )
	{
		// Criamos um contexto gráfico com a área de pintura restrita
		// ao interior da janela.
		Graphics2D clip = (Graphics2D) g.create( getInsets().left, 
												 getInsets().top, 
											 	 getWidth() - getInsets().right,
									 	 		 getHeight() - getInsets().bottom);

		// Pintamos o fundo do frame de preto
		clip.setColor(Color.BLACK);
		clip.fill(clip.getClipBounds());

		//desenhamos o mapa
		mapa.desenha(clip);

		//liberamos o contexto grafico
		clip.dispose();
	}
}