package br.com.game.core;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import tiled.core.Map;
import tiled.core.Tile;
import tiled.core.TileLayer;
import tiled.io.TMXMapReader;

public class MapaTmx 
{
	private Map mapa;
	
	public MapaTmx(String path)
	{
		try
		{
			/*
			 * Esta classe � que fz a leitura do arquivo tmx e j� carrega
			 * todo o mapa para a memoria.  
			 */
			TMXMapReader reader = new TMXMapReader( );
			mapa = reader.readMap(path);	
		}
		catch(Exception e)
		{
			e.printStackTrace( );
		}
	}
	
	public void desenha( Graphics2D clip )
	{
		//aqui fazemos a itera��o em cima das camadas (Layer's)
		for( int l = 0; l < mapa.getLayerCount( ); l++ )
		{
			/*
			 * Aqui � uma parte importante, no tiled pelo que vi, existem dois tipos de layers
			 * o de Tiles(imagens), e o de objetos, n�o fiz implementa��o para desenhar os 
			 * objetos na telas como formas, mas eles s�o importante, como por exemplo 
			 * para definir areas de colis�o.
			 * 
			 * Sua classe � "tiled.core.ObjectGroup"
			 */
			if( mapa.getLayer( l ) instanceof TileLayer )
			{
				TileLayer layer = ((TileLayer)mapa.getLayer( l ));//pega o layer
				
				//iteramos aqui em cima de cada tile do layer e n�o do tamanho em pixel do mesmo
				for (int y = 0; y < layer.getHeight(); y++) 
				{
					for (int x = 0; x < layer.getWidth(); x++) 
					{
						//pegamos uma tile espesifica e verificamos se ela existe
						Tile tile = layer.getTileAt( x , y );
						
						if( tile == null )
						{
							continue;
						}
						
						//pegamos a imagens correspondente daquela tile
						BufferedImage image = (BufferedImage)tile.getImage( );
						
						/*
						 * desenhamos no contexto grafico passado pelo jframe,
						 * a posi��o na tela deve ser em pixels, ent�o fazemos o calculo com 
						 * o numero do tile e seu tamanho. 
						 */
						clip.drawImage(image,  x*image.getWidth( ), y*image.getHeight(), null );
					}	
				}
			}
		}
	}
}