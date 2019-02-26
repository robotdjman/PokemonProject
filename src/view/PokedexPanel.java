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
		
		this.pokemonIcon = new ImageIcon(getClass().getResource("/view/images/Pokeball.png"));
		
		appLayout = new SpringLayout();
		this.pokeController = appController;
		
		pokemonName = new JLabel("pokemon");
		pokemonType = new JLabel("pokemontype");
		pokemonNumber = new JLabel("pokemonNumber");
		
		numberField = new JTextField("0");
		nameField = new JTextField("My pokename");
		evolveField = new JTextField("false");
		appLayout.putConstraint(SpringLayout.NORTH, evolveField, 6, SpringLayout.SOUTH, numberField);
		appLayout.putConstraint(SpringLayout.EAST, evolveField, -49, SpringLayout.EAST, this);
		attackField = new JTextField("0");
		enhancementField = new JTextField("0");
		healthField = new JTextField("0");
		appLayout.putConstraint(SpringLayout.NORTH, numberField, 8, SpringLayout.SOUTH, healthField);
		appLayout.putConstraint(SpringLayout.WEST, numberField, 0, SpringLayout.WEST, healthField);
		appLayout.putConstraint(SpringLayout.NORTH, healthField, 27, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.EAST, healthField, -62, SpringLayout.EAST, this);

		healthLabel = new JLabel("This pokemon's health is");
		appLayout.putConstraint(SpringLayout.NORTH, healthLabel, 5, SpringLayout.NORTH, healthField);
		appLayout.putConstraint(SpringLayout.EAST, healthLabel, -46, SpringLayout.WEST, healthField);
		numberLabel = new JLabel("This pokemon's number is");
		appLayout.putConstraint(SpringLayout.NORTH, numberLabel, 5, SpringLayout.NORTH, numberField);
		appLayout.putConstraint(SpringLayout.EAST, numberLabel, 0, SpringLayout.EAST, healthLabel);
		evolveLabel = new JLabel("This pokemon can evolve");
		appLayout.putConstraint(SpringLayout.NORTH, evolveLabel, 5, SpringLayout.NORTH, evolveField);
		appLayout.putConstraint(SpringLayout.EAST, evolveLabel, 0, SpringLayout.EAST, healthLabel);
		attackLabel = new JLabel("This pokemon's attack level is ");
		appLayout.putConstraint(SpringLayout.EAST, attackLabel, 0, SpringLayout.EAST, healthLabel);
		enhanceLabel = new JLabel("This pokemon's enhancement level is");
		appLayout.putConstraint(SpringLayout.NORTH, enhanceLabel, 174, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, attackLabel, -21, SpringLayout.NORTH, enhanceLabel);
		appLayout.putConstraint(SpringLayout.EAST, enhanceLabel, 0, SpringLayout.EAST, healthLabel);
		nameLabel = new JLabel("My name is");
		appLayout.putConstraint(SpringLayout.NORTH, nameLabel, 19, SpringLayout.SOUTH, enhanceLabel);
		appLayout.putConstraint(SpringLayout.EAST, nameLabel, 0, SpringLayout.EAST, healthLabel);
		imageLabel = new JLabel("");
		changeButton = new JButton("Click here to change the pokevalues");
		appLayout.putConstraint(SpringLayout.SOUTH, changeButton, 0, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, changeButton, 0, SpringLayout.EAST, this);
		pokedexDropdown = new JComboBox();

		
		setupPanel();
		setuplayout();
		setupListeners();
	}
	private void setuplayout()
	{
		
	}
	private void setupPanel()
	{
		this.setLayout(appLayout);
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
		

		
		imageLabel.setIcon(pokemonIcon);
		
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
