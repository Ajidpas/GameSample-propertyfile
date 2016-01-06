/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.io.*;
 /**
 *  Initial class
 *  don't write like this
 */

public class GameInitial {

    public static void main(String[] args) {

        //not better names for variables
        ArrayList <Integer> mas = new ArrayList<Integer>();
        // constants are hardcoded
        Integer x, rand, n = 1, k = 100;
        String iostring = null;

        rand = (int) (Math.random() * k);
        
        System.out.println("rand="+rand);
        System.out.println("Input simbol ot "+n+" do "+k);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        do
        {
            x=0;

            try{
                iostring = br.readLine();
            }
            catch (IOException e){
                System.out.println("poprobuite snova:");
                continue;
            }

            if (iostring.equals("q")) {
                System.out.println("Spasibo za vnimanie. Vuhod");
                break;
            }

            try{
                x=Integer.parseInt(iostring);
            }
            catch (NumberFormatException e){ //too many exception handling
                //System.out.println("Convert exception = " + e);
                //output in translit
                System.out.println("vvedite korrectnoe chislo:");
                continue;
            }

            if (x<n || x>k){
                System.out.println("chislo dolzno but v intervale ot "+n+"do"+k);
                continue;
            }

            boolean contains = false;
            for(int val: mas){
                if (val == x){
                    System.out.println("vvodili yze, massiv vot" + mas);
                    contains = true;
                    break;
                }
            }
            if (!contains) {
                mas.add(x);
                if (x > rand){
                    k=x;
                    System.out.println("Vedite menshe v intervale ot "+n+" do "+k);
                    continue;
                }

                if (x < rand){
                    n=x;
                    System.out.println("Vedite bolshe v intervale ot "+n+" do "+k);
                    continue;
                }

                if (x == rand)
                    System.out.println("Pravilno");
            }
        }
        while (x!=rand);
    }
}

