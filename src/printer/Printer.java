/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printer;

import java.util.List;
import java.util.ResourceBundle;

/**
 * Class for output messages for user
 * @author sds
 */
public class Printer {

    private static final String BUNDLE_PATH = "printer.out";
    private static final String BUNDLE_PATH_UK = "printer.out_uk_UK";
    private static final String MESSAGE_INPUT_NUMBER = "message.input.number";
    private static final String MESSAGE_EXIT = "message.out";
    private static final String MESSAGE_TRY_AGAIN = "message.try.again";
    private static final String SET_LESS = "message.set.less";
    private static final String SET_MORE = "message.set.more";
    private static final String HISTORY = "message.history";
    
    
    private ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_PATH_UK);

    public void printInputAndInterval(int min, int max) {
        System.out.format(bundle.getString(MESSAGE_INPUT_NUMBER), min, max);
    }

    public void printForceExit() {
        System.out.println(bundle.getString(MESSAGE_EXIT));
    }

    public void printTryAgain() {
        //TODO: to bundle
        System.out.format(bundle.getString(MESSAGE_TRY_AGAIN));
    }

    public void printLess(int min, int max) {
        //TODO: to bundle
        System.out.format(bundle.getString(SET_LESS), min, max);
    }

    public void printGreater(int min, int max) {
        //TODO: to bundle
        System.out.format(bundle.getString(SET_MORE), min, max);
    }

    public void printGuess(List<Integer> inputHistory) {
        //TODO: to bundle
        System.out.format(bundle.getString(HISTORY), inputHistory);
    }
}
