package main.java.com.vinnis.launchcode.util;

import main.java.com.vinnis.launchcode.AppOutput;
/**
 * User: Vinnis Bryant
 * Date: 05/20/15
 *
 */
public class ScreenOutput implements AppOutput{
    @Override
    public void print(String output) {
        System.out.println(output);
    }
}