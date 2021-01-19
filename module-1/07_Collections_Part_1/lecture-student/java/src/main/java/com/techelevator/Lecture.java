package com.techelevator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lecture {

	//1. returnsAnArray(5) -> {1, 2, 3, 4, 5}
	public int[] returnsAnArray(int number) {
		int[] intArray = new int[number];
		for (int i = 0; i < intArray.length; i++){
			intArray[i] = i + 1;
		}
		return intArray;
	}

	//2. returnsAList(5) -> [1, 2, 3, 4, 5] doing the same thing as above but this is using a LIST
	public List<Integer> returnsAList(int number) {
		List<Integer> integerList = new ArrayList<>();
		for(int i = 0; i < number; i++){
			integerList.add(i + 1);
		}

		return integerList;
	}

	//3. returnThirdName(["Frodo","Sam","Merry","Pippin"]) -> "Merry"
	public String returnThirdName(List<String> names) {

		return names.get(2);
	}

	//4. insertAfterFirst(["Luke","Leia"], "Han") -> ["Luke", "Han", "Leia"] make a copy and not change the first list
	public List<String> insertAfterFirst(List<String> names, String name) {
		List<String> result = new ArrayList<>(names);
		result.add(1, name);
		return result;
	}

	//5. onlyOneAnswer(["yes", "no", "maybe"]) -> false (checking the size of the list)
	//   onlyOneAnswer(["no"]) -> true
	public boolean onlyOneAnswer(List<String> answers) {
		return answers.size() == 1; //
	}

	//6. removeLastNumber([1.5, 2.2, 0.9]) -> [1.5, 2.2]
	public List<Double> removeLastNumber(List<Double> numbers) {
		List<Double> result = new ArrayList<>(numbers);
		result.remove(result.size() - 1);
		return result;
	}

	//7. hasACow(["duck","cow","chicken"]) -> true
	//   hasACow(["turkey", "rooster"]) -> false
	public boolean hasACow(List<String> farmAnimals) {

		return farmAnimals.contains("cow");
	}

	//8. yourPlaceInLine(["customer","customer","you","customer"]) -> 3
	public int yourPlaceInLine(List<String> allCustomers) {
		return allCustomers.indexOf("you") + 1;
	}

	//9. trimArray({"a","b","c","d"}) -> {"b","c"} (turn (convert) the array into a list)
	public String[] trimArray(String[] input) {
		//List<String> fixedSizeCopy = Arrays.asList(input); convert array to list
		List<String> copy = new ArrayList<>(Arrays.asList(input));// the arrays.aslist is a fixed array so you have to make a copy in order to add/remove things
		copy.remove(0); //get rid of first element
		copy.remove(copy.size() - 1); // get rid of last element
		String[] result= copy.toArray(new String[0]);//convert list to an array
		return result;
	}

	//10. descendingOrder([3, 4, 2, 9, 4, 8]) -> [9, 8, 4, 4, 3, 2]
	public List<Integer> descendingOrder(List<Integer> numbers) {
		List<Integer> result = new ArrayList<>(numbers);
		Collections.sort(result);//now in ascending order instead of random
		Collections.reverse(result);
		return result;
	}

	//11. countTrues([false,true,true,false,true]) -> 3
	public int countTrues(List<Boolean> answers) {
		int count = 0;
		for(boolean value : answers){//(type of value + new name of value : answers)
			if(value == true){
				count++;
			}
		}
		return count;
	}

	//12. incrementAll([100, 17, 33]) -> [101, 18, 34]
	public List<Integer> incrementAll(List<Integer> numbers) {
		List<Integer> result = new ArrayList<>();
		for(int value : numbers){
			result.add(value + 1);
		}
		return result;
	}

	//13. echo(["Tech","Elevator"]) -> ["Tech","Tech","Elevator","Elevator"]
	public List<String> echo(List<String> words) {
		List<String> word = new ArrayList<>();//use the singular version of the plural List
		for(String value : words){
			word.add(value);
			word.add(value);
		}
		return word;
	}

}
