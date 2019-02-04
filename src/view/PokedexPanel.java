package view;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;
import controller.PokedexController;

public class PokedexPanel extends JPanel
{
	private PokedexController pokeController;
	private SpringLayout appLayout;
	
	public PokedexPanel(PokedexController appController)
	{
		super();
		
		appLayout = new SpringLayout();
		this.pokeController = appController;
		
		setupPanel();
		setuplayout();
		setupListeners();
	}
	private void setuplayout()
	{

	}
	private void setupListeners() 
	{
		
	}
	private void setupPanel()
	{
		this.setLayout(appLayout);
		this.setBackground(Color.LIGHT_GRAY);
		this.setPreferredSize(new Dimension(800, 600));
	}
}
