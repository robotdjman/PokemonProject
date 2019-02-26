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
	private JButton saveButton;
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
		appLayout.putConstraint(SpringLayout.WEST, pokemonName, 541, SpringLayout.WEST, this);
		pokemonType = new JLabel("pokemontype");
		pokemonNumber = new JLabel("pokemonNumber");
		
		saveButton = new JButton("Save");
		
		numberField = new JTextField("0");
		nameField = new JTextField("My pokename");
		evolveField = new JTextField("false");
		appLayout.putConstraint(SpringLayout.NORTH, evolveField, 6, SpringLayout.SOUTH, numberField);
		attackField = new JTextField("0");
		appLayout.putConstraint(SpringLayout.NORTH, attackField, 6, SpringLayout.SOUTH, evolveField);
		enhancementField = new JTextField("0");
		appLayout.putConstraint(SpringLayout.NORTH, pokemonName, 6, SpringLayout.SOUTH, enhancementField);
		appLayout.putConstraint(SpringLayout.NORTH, enhancementField, 6, SpringLayout.SOUTH, attackField);
		healthField = new JTextField("0");
		appLayout.putConstraint(SpringLayout.WEST, enhancementField, 0, SpringLayout.WEST, healthField);
		appLayout.putConstraint(SpringLayout.EAST, enhancementField, 0, SpringLayout.EAST, healthField);
		appLayout.putConstraint(SpringLayout.WEST, attackField, 0, SpringLayout.WEST, healthField);
		appLayout.putConstraint(SpringLayout.EAST, attackField, 0, SpringLayout.EAST, healthField);
		appLayout.putConstraint(SpringLayout.EAST, evolveField, 0, SpringLayout.EAST, healthField);
		appLayout.putConstraint(SpringLayout.EAST, healthField, -49, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, evolveField, 0, SpringLayout.WEST, healthField);
		appLayout.putConstraint(SpringLayout.NORTH, numberField, 8, SpringLayout.SOUTH, healthField);
		appLayout.putConstraint(SpringLayout.WEST, numberField, 0, SpringLayout.WEST, healthField);
		appLayout.putConstraint(SpringLayout.EAST, numberField, 0, SpringLayout.EAST, healthField);
		appLayout.putConstraint(SpringLayout.NORTH, healthField, 27, SpringLayout.NORTH, this);

		healthLabel = new JLabel("This pokemon's health is");
		appLayout.putConstraint(SpringLayout.WEST, healthField, 29, SpringLayout.EAST, healthLabel);
		appLayout.putConstraint(SpringLayout.NORTH, healthLabel, 32, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.EAST, healthLabel, -127, SpringLayout.EAST, this);
		numberLabel = new JLabel("This pokemon's number is");
		appLayout.putConstraint(SpringLayout.NORTH, numberLabel, 18, SpringLayout.SOUTH, healthLabel);
		appLayout.putConstraint(SpringLayout.EAST, numberLabel, 0, SpringLayout.EAST, healthLabel);
		evolveLabel = new JLabel("This pokemon can evolve");
		appLayout.putConstraint(SpringLayout.NORTH, evolveLabel, 16, SpringLayout.SOUTH, numberLabel);
		appLayout.putConstraint(SpringLayout.EAST, evolveLabel, 0, SpringLayout.EAST, healthLabel);
		attackLabel = new JLabel("This pokemon's attack level is ");
		appLayout.putConstraint(SpringLayout.NORTH, attackLabel, 16, SpringLayout.SOUTH, evolveLabel);
		appLayout.putConstraint(SpringLayout.EAST, attackLabel, -28, SpringLayout.WEST, attackField);
		enhanceLabel = new JLabel("This pokemon's enhancement level is");
		appLayout.putConstraint(SpringLayout.NORTH, enhanceLabel, 16, SpringLayout.SOUTH, attackLabel);
		appLayout.putConstraint(SpringLayout.EAST, enhanceLabel, 0, SpringLayout.EAST, healthLabel);
		nameLabel = new JLabel("My name is");
		appLayout.putConstraint(SpringLayout.NORTH, nameLabel, 11, SpringLayout.SOUTH, enhanceLabel);
		appLayout.putConstraint(SpringLayout.EAST, nameLabel, -127, SpringLayout.EAST, this);
		imageLabel = new JLabel("");
		appLayout.putConstraint(SpringLayout.NORTH, imageLabel, 0, SpringLayout.NORTH, healthLabel);
		appLayout.putConstraint(SpringLayout.WEST, imageLabel, 38, SpringLayout.WEST, this);
		changeButton = new JButton("Click here to change the pokevalues");
		appLayout.putConstraint(SpringLayout.SOUTH, changeButton, 0, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, changeButton, 0, SpringLayout.EAST, this);
		pokedexDropdown = new JComboBox();
		appLayout.putConstraint(SpringLayout.NORTH, pokedexDropdown, 78, SpringLayout.SOUTH, pokemonName);
		appLayout.putConstraint(SpringLayout.EAST, pokedexDropdown, -62, SpringLayout.EAST, this);
		
		nameField = new JTextField("Name");
		setupPanel();
		setupDropdown();
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
		this.add(pokemonName);
		this.add(enhancementField);
		this.add(saveButton);
		
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
			data[0] = attackField.getText();
			data[1] = enhancementField.getText();
			data[2] = healthField.getText();
			data[3] = nameField.getText();
			data[4] = evolveField.getText();
			
			pokeController.updatePokemon(index, data);
		}
	}
	private void changeImageDisplay(String name)
	{
		String path = "/view/images/";
		String defaultName = "Pokeball";
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
		
		saveButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent click)
			{
				pokeController.savePokedex();
			}
		});
	}
	
	public void updateFields(int index)
	{
		String [] data = pokeController.getPokeData(index);
		
		attackField.setText(data[0]);
		enhancementField.setText(data[1]);
		healthField.setText(data[2]);
		nameField.setText(data[3]);
		evolveField.setText(data[4]);
		numberField.setText(data[5]);
	}
}
