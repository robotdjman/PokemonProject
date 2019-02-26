package controller;

import java.util.ArrayList;

import model.Meowth;
import model.Pokemon;
import model.Squirtle;
import view.PokedexFrame;

public class PokedexController
{
	
	private ArrayList<Pokemon> pokemonList;
	private PokedexFrame appFrame;
	
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
}
