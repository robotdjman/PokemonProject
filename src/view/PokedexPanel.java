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
	private JLabel pokemonName;
	private JLabel pokemonType;
	private JLabel pokemonNumber;
	
	public PokedexPanel(PokedexController appController)
	{
		super();
		
		appLayout = new SpringLayout();
		this.pokeController = appController;
		pokemonName = new JLabel("pokemon");
		
		pokemonType = new JLabel("pokemontype");
		
		pokemonNumber = new JLabel("pokemonNumber");
		
		
		setupPanel();
		setuplayout();
		setupListeners();
	}
	private void setuplayout()
	{
		appLayout.putConstraint(SpringLayout.NORTH, pokemonName, 91, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, pokemonType, 149, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, pokemonName, -40, SpringLayout.WEST, pokemonType);
		appLayout.putConstraint(SpringLayout.NORTH, pokemonType, 0, SpringLayout.NORTH, pokemonName);
		appLayout.putConstraint(SpringLayout.NORTH, pokemonNumber, 0, SpringLayout.NORTH, pokemonName);
		appLayout.putConstraint(SpringLayout.WEST, pokemonNumber, 37, SpringLayout.EAST, pokemonType);
	}
	private void setupListeners() 
	{
		
	}
	private void setupPanel()
	{
		this.setLayout(appLayout);
		this.setBackground(Color.LIGHT_GRAY);
		this.setPreferredSize(new Dimension(800, 600));
		
		this.add(pokemonName);
		this.add(pokemonType);
		this.add(pokemonNumber);
	}
}
