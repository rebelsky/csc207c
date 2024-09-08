package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * A simple example of interaction.
 */
public class Interact {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    Scanner eyes = new Scanner(System.in);
    pen.print("Enter an integer: ");
    pen.flush();
    String stuff = eyes.nextLine();
    BigInteger i = new BigInteger(stuff);
    pen.printf("square(%s) = %s\n", i.toString(), i.multiply(i).toString());
    pen.print("Enter a bunch of integers separated by spaces: ");
    pen.flush();
    stuff = eyes.nextLine();
    String[] nums = stuff.split(" ");
    for (String num : nums) {
      i = new BigInteger(num);
      pen.printf("square(%s) = %s\n", i.toString(), i.multiply(i).toString());
    } // for
  } // main(String[])
} // class Interact
