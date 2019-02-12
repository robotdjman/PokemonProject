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
	
	private JButton changeButton;
	private JComboBox pokedexDropdown;
	
	private JTextField numberField;
	private JTextField nameField;
	private JTextField evolveField;
	private JTextField attackField;
	private JTextField enhancementField;
	private JTextField healthField;
	
	private JLabel numberLabel;
	private JLabel nameLabel;
	private JLabel evolveLabel;
	private JLabel attackLabel;
	private JLabel enhanceLabel;
	private JLabel healthLabel;
	private JLabel imageLabel;
	
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
		
		numberField = new JTextField("0");
		nameField = new JTextField("My pokename");
		evolveField = new JTextField("false");
		appLayout.putConstraint(SpringLayout.NORTH, evolveField, 123, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.EAST, evolveField, -186, SpringLayout.EAST, this);
		attackField = new JTextField("0");
		enhancementField = new JTextField("0");
		healthField = new JTextField("0");
		appLayout.putConstraint(SpringLayout.SOUTH, numberField, -6, SpringLayout.NORTH, healthField);
		appLayout.putConstraint(SpringLayout.EAST, numberField, 0, SpringLayout.EAST, healthField);
		appLayout.putConstraint(SpringLayout.SOUTH, healthField, -17, SpringLayout.NORTH, evolveField);
		appLayout.putConstraint(SpringLayout.EAST, healthField, -196, SpringLayout.EAST, this);
		
		healthLabel = new JLabel("This pokemon's health is");
		numberLabel = new JLabel("This pokemon's number is");
		
		evolveLabel = new JLabel("This pokemon can evolve");
		attackLabel = new JLabel("This pokemon's attack level is ");
		enhanceLabel = new JLabel("This pokemon's enhancement level is");
		nameLabel = new JLabel("My name is");
		imageLabel = new JLabel("pokemon goes here");
		changeButton = new JButton("Click here to change the pokevalues");
		pokedexDropdown = new JComboBox(); //stub
		appLayout.putConstraint(SpringLayout.WEST, pokedexDropdown, 33, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, pokedexDropdown, -96, SpringLayout.SOUTH, this);
		
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
		this.add(pokedexDropdown);
		this.add(healthField);
		this.add(numberField);
		this.add(evolveField);
		this.add(attackField);
		
	}
	private void setupDropdown()
	{
		DefaultComboBoxModel temp = new DefaultComboBoxModel(pokeController.buildPokedexText());
		pokedexDropdown.setModel(temp);
	}
}
