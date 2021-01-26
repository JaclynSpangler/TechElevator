package com.techelevator.farm;

import java.math.BigDecimal;

public class OldMacdonald {
	public static void main(String[] args) {


		Cow daisy = new Cow();
		Chicken nugget = new Chicken();
		Alpaca peru = new Alpaca();

		Singable[] singables = new Singable[] { daisy, nugget, peru, new Tractor() };


		for (Singable singableThing : singables) {
			String name = singableThing.getName();
			String sound = singableThing.makeSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had " + singableThing.getArticle() + " " + name + ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
			System.out.println();

		}

		Sellable[] merch = new Sellable[]{daisy, nugget, peru, new Egg()};
		BigDecimal total = BigDecimal.ZERO;
		for(Sellable product : merch){
			System.out.println("And you can buy that " + product.getName() + " for only $" + product.getPrice());
			total = total.add(product.getPrice());
		}
		System.out.println("Or buy the whole farm for $" + total);

		Singable eric = new Chicken();
		eric.makeSound();
		((Chicken) eric).layEgg(); //casting eric as a chicken, not recommended but you could

		if(eric instanceof Chicken){
			System.out.println("Eric is a chicken.");
		}
		if(eric instanceof  Singable){
			System.out.println("You can sing about Eric.");
		}
		if(eric instanceof Tractor){
			System.out.println("Eric is a tractor.");
		}

	}
}