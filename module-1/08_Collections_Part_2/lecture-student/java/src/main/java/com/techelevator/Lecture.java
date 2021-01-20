package com.techelevator;

import java.lang.reflect.Array;
import java.util.*;

public class Lecture {

    //1. removeDuplicates([1,2,1,1,2,1,2]) -> [1,2] or [2,1]
    public List<Integer> removeDuplicates(List<Integer> input) { //convert it to a set then turn it back to a list to return
       Set<Integer> noDuplicates = new HashSet<>(input); // collections dont need to be converted using toArray or anything like yesterdays HW
       List<Integer> output = new ArrayList<>(noDuplicates);
        return output;
    }

    //2. musicalGroupNames() -> {2="duo",3="trio",4="quartet"}
    public Map<Integer,String> musicalGroupNames() {
        Map<Integer, String> groupNames = new HashMap<>();
        groupNames.put(2, "duo");
        groupNames.put(3, "trio");
        groupNames.put(4, "quartet");
        return groupNames;
        }


    //3. coinValues() -> {"penny"=1,"nickel"=5,"dime"=10,"quarter"=25}
    public Map<String,Integer> coinValues() {
    Map<String, Integer> coins = new HashMap<>();
    coins.put("penny", 1);
    coins.put("nickel", 5);
    coins.put("dime", 10);
    coins.put("quarter", 25);
    return coins;
    }

    //4. describeGroup(3, "violin") -> "violin trio"
    //   describeGroup(0, "trumpet") -> "trumpet group"
    public String describeGroup(int count, String instrument) {
        Map<Integer, String> groups = musicalGroupNames();// get the map we created above
        String result = instrument + " ";// start creating the result string with the instrument name and a space
        if(groups.containsKey(count)){//check if the map contains a key for the specified number of musicians
            result = result + groups.get(count);//if there is a group name concatenate onto the result
        } else {
            result = result + "group";//if there isnt, concatenate the word group onto the result
        }
        return result;
    }

    //5. totalCents({"nickel","quarter","penny","penny"}) -> 32
    public int totalCents(String[] coins) {
        Map<String, Integer> values = coinValues();
        int total = 0;
        for(String coin : coins){
            int value = values.get(coin);
            total += value;
        }

        return total;
    }

    //6. validCoin("dime") -> "valid"
    //   validCoin("token") -> "invalid"
    public String validCoin(String coin) {
        Map<String, Integer> validate = coinValues();
        String result = "invalid";
        if(validate.containsKey(coin)){
            result = "valid";
        }

        return result;
    }

    //7. stateNames({"Ohio"="Columbus","Kentucky"="Frankfort","Indiana"="Indianapolis"})
    //             -> ["Ohio","Kentucky","Indianapolis"]
    public List<String> stateNames(Map<String,String> capitals) {
        Set<String> stateSet = capitals.keySet();
        List<String> onlyState = new ArrayList<>(stateSet);//turned it into a list from a set
        return onlyState;
    }

    //8. availableColors({"red"=true,"blue"=false,"green"=true,"yellow"=true,"gray"=false})
    //                  -> ["red","green","yellow"]
    public List<String> availableColors(Map<String,Boolean> availability) {
        List<String> colors = new ArrayList<>();
        Set<Map.Entry<String, Boolean>> allEntries = availability.entrySet();//Map.Entry represents one pair of entries in the set
        //// dont need the whole line or extra variable but i kept it for ease

        for(Map.Entry<String, Boolean> entry : allEntries){
            if(entry.getValue() == true){
                colors.add(entry.getKey());// have to use a loop because youre looking at both the key and the value
            }
        }

        return colors;
    }
ge
    //9. addBonus({"Player 1"=5000,"Player 2"=2500,"Player 3"=4500}, 500)
    //         -> {"Player 1"=5500,"Player 2"=3000,"Player 3"=5000}//add bonus to every players score
    public void addBonus(Map<String,Integer> scores, int bonus) { //if return type is void then it means they want us to change the map and not return anything
        for(Map.Entry<String, Integer> entry : scores.entrySet()){
            String playerName = entry.getKey();//dont need this line because we are not using the key for this problem
            int score = entry.getValue();
            score += bonus;//not in the map yet
            entry.setValue(score);//adds it back to the map
        }

    }

    //10. Modify and return the given map as follows: for this problem the map may or may not contain the
    //    "a" and "b" keys. If both keys are present, append their 2 string values together and store the
    //    result under the key "ab".
    //    mapAB({"a": "Hi", "b": "There"}) → {"a": "Hi", "ab": "HiThere", "b": "There"}
    //    mapAB({"a": "Hi"}) → {"a": "Hi"}
    //    mapAB({"b": "There"}) → {"b": "There"}

    public Map<String, String> mapAB(Map<String,String> input) {//dont need a loop because we are only worried about the keys a & b
        if(input.containsKey("a") && input.containsKey("b"){
            String combinedValue = input.get("a") + input.get("b"); //inputget means the values,not in themap yet
            input.put("ab", combinedValue);

        }

        return input;
    }

}
