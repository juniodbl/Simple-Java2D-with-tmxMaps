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
		for( int l = 0; l < mapa.getLayerCount( ); l++ )
		{
			if( mapa.getLayer( l ) instanceof TileLayer )
			{
				TileLayer layer = ((TileLayer)mapa.getLayer( l ));
				
				for (int y = 0; y < layer.getHeight(); y++) 
				{
					for (int x = 0; x < layer.getWidth(); x++) 
					{
						Tile tile = layer.getTileAt( x , y );
						
						if( tile == null )
						{
							continue;
						}
						
						BufferedImage image = (BufferedImage)tile.getImage( );
						
						clip.drawImage(image,  x*image.getWidth( ), y*image.getHeight(), null );
					}	
				}
			}
		}
	}
}