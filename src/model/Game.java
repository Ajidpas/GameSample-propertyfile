/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 * class Game incapsulates main logic of game.
 * create instance of this class and invoke test method with user's inputed value
 * @author sds
 */
public class Game {

    public static int MIN_INITIAL = 0;
    public static int MAX_INITIAL = 100;
    private final List<Integer> inputHistory = new ArrayList<>();
    private int rand;
    private int min = MIN_INITIAL;
    private int max = MAX_INITIAL;

    /**
     * This constructor 4 testing with known value. Used in unit tests
     * @param rand
     */
    public Game(int rand) {
        this.rand = rand;
        System.out.println(this.rand);
    }

    /**
     * Initialises object rand field with random number 
     */
    public Game() {
        rand = (int)( Math.random()*max);
        System.out.println(this.rand);
    }
    /**
     * Main game function
     * @param tryValue - test value beetween 
     * @return 
     * returns 0 - if guessed
     * returns 1 if try value greater then unknown
     * returns -1 if try value less then unknown
     */
    public int test(int tryValue){
        inputHistory.add(min);
        if (tryValue > rand){
             max = tryValue -1 ;
             return 1;       
        } else if (tryValue < rand){
            min = tryValue + 1;
            return -1;
        } else { 
            return 0;
        }

    }
     /**
     * Returns user's input history
     * @return  list of attempts
     */
    public List<Integer> getInputHistory() {
        return inputHistory;
    }

    /**
     * Returns current lower boundary
     * @return current min 
     */
    public int getMin() {
        return min;
    }
    /**
     * Returns current lower boundary
     * @return current min 
     */
    public int getMax() {
        return max;
    }
    
}
