package controller;

import java.util.ArrayList;

public class PokedexController
{
	
	private ArrayList<Pokemon> pokemonList;
	private PodexFrame appFrame;
	
	public PokedexController()
	{
		pokemonList = new ArrayList<Pokemon>();
		addPokemon();
		appFrame = new PokedexFrame(this);
	}
	public void addPokeon()
	{
		pokemonList.add(new Meowth());
	}
	public void start()
	{
		
	}
}
