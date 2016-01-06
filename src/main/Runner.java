/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import model.Game;
import model.controller.InputController;
import printer.Printer;

/**
 * Runner class is intended to be an entry point to application.
 * @author sds
 */
public class Runner {
    /**
     *  in main method we create objects of classes and giving control to created
     *  objects
     * @param args - command line arguments
     */
    public static void main(String[] args) {
        
        Game game = new Game();
        Printer printer = new Printer();
        InputController controller = new InputController( game , printer );
        
        try{
            controller.go();
        }catch(Exception ex){
            System.out.println("User Exit");
        }
        
        
    }
    
}
