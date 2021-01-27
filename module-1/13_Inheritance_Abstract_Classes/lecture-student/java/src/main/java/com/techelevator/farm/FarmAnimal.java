package com.techelevator.farm;

import java.math.BigDecimal;

public abstract class FarmAnimal implements Singable{
	private final String name;
	private String nickname;

	public FarmAnimal(String name) {
		this.name = name;
	}

	public final String getName() {
		if(nickname != null){
			return name + " called " + nickname;
		}
		return name;
	}

	public abstract String makeSound();

	public String getArticle() {
		return "a";
	}

	public String getNickname(){
		return nickname;
	}
	public void setNickname(String nickname){
		this.nickname= nickname;
	}

	@Override
	public String toString() {
		return getArticle() + " " + getName();
	}
}