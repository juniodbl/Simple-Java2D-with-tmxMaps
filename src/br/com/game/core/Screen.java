package br.com.game.core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;

public class Screen extends JFrame
{
	//Declara��o da classe que le o mapa
	MapaTmx mapa;
	
	public Screen(String titulo) 
	{
		super(titulo);
		/*
		 * instaciamos a classe passando o local do mapa
		 * Pode se usar o caminho absoluto do mapa se preferir
		 * 
		 * OBS: DICA MIPORTANTE
		 * dentro do arquivo TMX fica a locali��o da imagen que utilizou para gerar os tiles
		 * recomendo que troque o caminho para o relativo do projeto que est� executando
		 * ou caminho absoluto da imagen no seu pc para 
		 * n�o haver erros de leitura, veja  imagen no Blog para ter uma ideia e baixe 
		 * os arquivos do github.
		 */
		mapa = new MapaTmx("./res/mapas/ola_mapa.tmx");
	}

	@Override
	public void paint( Graphics g )
	{
		// Criamos um contexto gr�fico com a �rea de pintura restrita
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