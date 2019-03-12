package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.io.*;

import model.Eevee;
import model.Meowth;
import model.Pokemon;
import model.Squirtle;
import model.Umbreon;
import model.Voltorb;
import view.PokedexFrame;

public class PokedexController
{
	
	private ArrayList<Pokemon> pokemonList;
	private PokedexFrame appFrame;
	private String saveFile = "backup.pokemon";
	
	public PokedexController()
	{
		pokemonList = new ArrayList<Pokemon>();
		addPokemon();
		appFrame = new PokedexFrame(this);
	}
	public void addPokemon()
	{
		pokemonList.add(new Meowth());
		pokemonList.add(new Squirtle());
		pokemonList.add(new Eevee());
		pokemonList.add(new Voltorb());
		pokemonList.add(new Umbreon());
		
	}
	public void start()
	{
		
	}
	public void updatePokemon(int index, String [] data)
	{
		if(data.length == 5)
		{
			Pokemon current = pokemonList.get(index);
			current.setAttackPoints(Integer.parseInt(data[0]));
			current.setEnhancementModifier(Double.parseDouble(data[1]));
			current.setHealthPoints(Integer.parseInt(data[2]));
			current.setName(data[3]);
			current.setCanEvolve(Boolean.parseBoolean(data[4]));
		}
	}
	
	public String[] buildPokedexText()
	{
		String [] names= new String [pokemonList.size()];
		
		for(int index = 0; index < pokemonList.size(); index++)
		{
			names[index] = pokemonList.get(index).getName();
		}
		return names;
	}
	public boolean isInt(String number)
	{
		boolean isValid = false;
		
		return isValid;
	}
	public boolean isDouble(String number)
	{
		boolean isValid = false;
		
		return isValid;
	}
	public void savePokedex()
	{
		try
		{
			FileOutputStream saveStream = new FileOutputStream(saveFile);
			ObjectOutputStream output = new ObjectOutputStream(saveStream);
			output.writeObject(pokemonList);
			output.close();
			saveStream.close();
		}
		catch(IOException error)
		{
			JOptionPane.showMessageDialog(appFrame, error.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	/*
	private void loadPokedex()
	{
		try
		{
			ArrayList<Pokemon> saved = new ArrayList<Pokemon>();
			FileInputStream inputStream = new FileInputStream(saveFile);
			ObjectInputStream input = new ObjectInputStream(inputStream);
			saved = (ArrayList<pokemon>) input.readObject();
			input.close();
			inputStream.close();
			pokemonList = saved;
		}
		catch(IOException error)
		{
			JOptionPane.showMessageDialog(appFrame, "No Save file ", "Loading Pokemon", JOptionPane.ERROR_MESSAGE);
		}
		catch(ClassNotFoundException pokemonError)
		{
			JOptionPane.showMessageDialog(appFrame, pokemonError.getMessage(), "Type Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	*/
	public String[] getPokeData(int index)
	{
		String[] output = new String[5];
		output[0] = Integer.toString(pokemonList.get(index).getAttackPoints());
		output[1] = Double.toString(pokemonList.get(index).getEnhancementModifier());
		output[2] = Integer.toString(pokemonList.get(index).getHealthPoints());
		output[3] = pokemonList.get(index).getName();
		output[4] = Boolean.toString(pokemonList.get(index).isCanEvolve());
		return output;
		
	}
	public ArrayList<Pokemon> getPokeList()
	{
		return pokemonList;
	}
	public Pokemon findInList(int String)
	{
		Pokemon output = null;
		for(Pokemon poke : pokemonList)
		{
			//poke 
		}
		return output;
	}
}
