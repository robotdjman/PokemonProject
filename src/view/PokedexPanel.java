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
	
	private ImageIcon pokemonIcon;
	
	private JLabel pokemonName;
	private JLabel pokemonType;
	private JLabel pokemonNumber;
	
	public PokedexPanel(PokedexController appController)
	{
		super();
		
		this.pokemonIcon = new ImageIcon(getClass().getResource("/PokemonProject/src/view/images/Voltorb.png"));
		
		appLayout = new SpringLayout();
		this.pokeController = appController;
		
		pokemonName = new JLabel("pokemon");
		pokemonType = new JLabel("pokemontype");
		pokemonNumber = new JLabel("pokemonNumber");
		
		numberField = new JTextField("0");
		nameField = new JTextField("My pokename");
		evolveField = new JTextField("false");
		attackField = new JTextField("0");
		enhancementField = new JTextField("0");
		healthField = new JTextField("0");

		healthLabel = new JLabel("This pokemon's health is");
		numberLabel = new JLabel("This pokemon's number is");
		evolveLabel = new JLabel("This pokemon can evolve");
		attackLabel = new JLabel("This pokemon's attack level is ");
		enhanceLabel = new JLabel("This pokemon's enhancement level is");
		nameLabel = new JLabel("My name is");
		imageLabel = new JLabel("pokemon goes here");
		changeButton = new JButton("Click here to change the pokevalues");
		pokedexDropdown = new JComboBox(); //stub

		
		setupPanel();
		setuplayout();
		setupListeners();
	}
	private void setuplayout()
	{
		appLayout.putConstraint(SpringLayout.WEST, pokedexDropdown, 33, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, pokedexDropdown, -96, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, healthField, 6, SpringLayout.SOUTH, numberField);
		appLayout.putConstraint(SpringLayout.WEST, healthField, 10, SpringLayout.WEST, numberField);
		appLayout.putConstraint(SpringLayout.SOUTH, evolveField, -118, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, evolveField, -49, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, numberField, -226, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, numberField, -196, SpringLayout.EAST, this);
		
	}
	private void setupPanel()
	{
		this.setLayout(appLayout);
		this.add(pokedexDropdown);
		this.add(healthField);
		this.add(numberField);
		this.add(evolveField);
		this.add(attackField);
		this.add(enhancementField);
		
		this.add(healthLabel);
		this.add(numberLabel);
		this.add(evolveLabel);
		this.add(attackLabel);
		this.add(enhanceLabel);
		this.add(nameLabel);
		this.add(imageLabel);
		this.add(changeButton);
		this.add(pokedexDropdown);
		
		imageLabel.setVerticalTextPosition(JLabel.BOTTOM);
		imageLabel.setHorizontalTextPosition(JLabel.CENTER);
		
	}
	private void setupDropdown()
	{
		DefaultComboBoxModel temp = new DefaultComboBoxModel(pokeController.buildPokedexText());
		pokedexDropdown.setModel(temp);
	}
	
	private void sendDataToController()
	{
		int index = pokedexDropdown.getSelectedIndex();
		
		if(pokeController.isInt(attackField.getText()) && pokeController.isDouble(enhancementField.getText()) && pokeController.isInt(healthField.getText()));
		{
			String [] data =  new String[5];
			
			//Insert code here
			pokeController.updatePokemon(index, data);
		}
	}
	private void changeImageDisplay(String name)
	{
		String path = "/pokemon/view/images/";
		String defaultName = "Umbreon";
		String extension = ".png";
		try
		{
			pokemonIcon = new ImageIcon(getClass().getResource(path + name.toLowerCase() + extension));
		}
		catch (NullPointerException missingFile)
		{
			pokemonIcon = new ImageIcon(getClass().getResource(path + defaultName + extension));
		}
		imageLabel.setIcon(pokemonIcon);
		repaint();
	}
	private void setupListeners()
	{
		changeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click)
			{
				sendDataToController();
				
			}
		});
		
		pokedexDropdown.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent selection)
			{
				String name = pokedexDropdown.getSelectedItem().toString();
				changeImageDisplay(name);
			}
			
		});
	}
}
