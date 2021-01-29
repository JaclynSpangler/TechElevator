package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WordCountTests {

    @Test
    public void getCount_words(){
        WordCount sut = new WordCount();
        Map<String, Integer> words = sut.getCount(new String[]{"ba", "ba", "black", "sheep"});
        Map<String, Integer> outcome = new HashMap<>();
        outcome.put("ba", 2);
        outcome.put("black", 1);
        outcome.put("sheep", 1);
        Assert.assertEquals(outcome, words);
        }

    @Test
    public void getCount_words_empty_string(){
        WordCount sut = new WordCount();
        Map<String, Integer> words = sut.getCount(new String[]{});
        Map<String, Integer> outcome = new HashMap<>();
        Assert.assertEquals(outcome, words);
    }


        
    }


