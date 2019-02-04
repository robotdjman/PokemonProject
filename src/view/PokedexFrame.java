package view;

import controller.PokedexController;
import javax.swing.JFrame;


public class PokedexFrame extends JFrame
{
	private PokedexPanel pokePanel;
	private PokedexController pokeController;
	
	public PokedexFrame(PokedexController app)
	{
		super();
		this.pokeController = app;
		pokePanel = new PokedexPanel(app);
		
		setupFrame();
	}
	public void setupFrame()
	{
		this.setContentPane(pokePanel);
		this.setTitle("Pokedex");
		this.setSize(800, 600);
		this.setResizable(false);
		this.setVisible(true);
	}
}
