/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.controller;

import printer.Printer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import model.Game;

/**
 * An user input controller. Works with user input, cheks input values, and 
 * calls geme method
 * 
 * @author sds
 */
public class InputController {

    public static final String QUIT_STRING = "q";
    
    private Game game;
    private Printer printer;
    private BufferedReader reader;

    /**
     * Initialises object with Game and Printer instances
     * @param game - instance of Game 
     * @param printer - instance of Printer
     */
    public InputController(Game game, Printer printer) {
        this.game = game;
        this.printer = printer;
        reader = new BufferedReader(new InputStreamReader(System.in));
    }
    /**
     * Reads int value from console, bounded by min and max
     * @param min - lower limit
     * @param max - uppers limit
     * @return value from user between min and max
     * @throws ExitExcepriom to intermediate exit
     */
    private int readBoundedValue (int min , int max){
        String inputString = "";
        int result = 0;
        while( true ){
            try{
                inputString = reader.readLine();
            }
            catch (IOException e){
                //TODO: make method in Printer
                System.out.println("poprobuite snova:");
                continue;
            }

            if ( QUIT_STRING.equals(inputString)) {
                printer.printForceExit();
                throw new ExitException();
            }

            try{
                result = Integer.parseInt(inputString);
            }
            catch (NumberFormatException e){
                //System.out.println("Convert exception = " + e);
                //TODO: make method in Printer
                System.out.println("vvedite korrectnoe chislo:");
                continue;
            }

            if ( result  < min || result > max ){
                //TODO: make method in Printer
                System.out.println("chislo dolzno but v intervale ot "+min+"do"+max);
                continue;
            }
            return result;
        }
    }
    /**
     * Main function that controls user Input
    */
    public void go() {
         
         printer.printInputAndInterval( game.getMin(), game.getMax() );
         int tryValue = 0;
         int result = 0;
         do
         {
            
            tryValue = readBoundedValue(game.getMin(), game.getMax() );
            result = game.test(tryValue);
            switch( result ){
                case -1:
                    printer.printGreater(game.getMin(), game.getMax() );
                    break;
                case 1:
                    printer.printLess(game.getMin(), game.getMax());
                    break;
                case 0:
                    printer.printGuess( game.getInputHistory() );
                    break;
            }
            
        }
        while (result!=0);

     }


}
