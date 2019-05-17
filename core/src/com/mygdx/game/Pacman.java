package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;

public class Pacman{
	private ArrayList<Texture> pacman = new ArrayList<Texture>();

	public ArrayList<Texture> getPacman() {
		return pacman;
	}

	public void setPacman(ArrayList<Texture> pacman) {
		this.pacman = pacman;
	}
}