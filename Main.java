// Student name: Koichi Nakata
// Date: September 18, 2023

import java.io.*;
import java.util.Arrays;

public class Main {

  public static void add(int item, int bag[]) {
    int i = 0;
    // We want to count up to non-zero item in the bag.
    // We need this sequence (i < bag.length && bag[i] != 0) so the short-circiut decision.
    while (i < bag.length && bag[i] != 0) {
      i++;
    }
    // If we count up to the end of the bag, which means no zero in the bag,
    if (i == bag.length) {
      System.out.println("Can not add an item to a full bag.");
    }
    else {
      bag[i] = item;
    }
  }

  public static void remove(int item, int bag[]) {
    boolean found = false;
    boolean empty = true;
    // We want to check an item one by one from the beginning.
    for (int i = 0; i < bag.length; i++) {
      if (bag[i] != 0) {
        empty = false;
        if (bag[i] == item) {
          bag[i] = 0; 
          found = true;
        }
      }
    }
    if (empty) {
      System.out.println("Can not remove an item from an empty bag.");
    }
    else if (!found) {
      System.out.println("Item not found in the bag. Nothing removed.");
    }
  }

  public static void reset(int bag[]) {
    // This is easy, just make all the items in the bag zero.
    for (int i = 0; i < bag.length; i++) {
      bag[i] = 0;
    }
  }

  public static int getFrequency(int item, int bag[]) {
    int count = 0; // Counter variable
    for (int i = 0; i < bag.length; i++) {
      if (bag[i] == item) {
        count++;
      }
    }
    return count;
  }

  public static void display(int bag[]) {
    System.out.print("Bag: ");
    for (int item: bag) {
      // We need to use a double quote otherwise a single quote will be a character data type! Not string.
      System.out.print(item + " ");
    }
    System.out.println();
  }

  // Don't make any changes to the main function
  public static void main(String[] args) {
    int count;
    int[] data = {0, 0, 0, 0, 0};
    display(data);
    remove(1, data);
    add(1, data);
    display(data);
    add(2, data);
    display(data);
    add(3, data);
    display(data);
    add(4, data);
    display(data);
    remove(3, data);
    display(data);
    add(5, data);
    display(data);
    remove(6, data);
    add(6, data);
    display(data);
    add(7, data);
    display(data);
    remove(6, data);
    display(data);
    add(1, data);
    display(data);
    remove(1, data);
    display(data);
    reset(data);
    display(data);
    remove(10, data);
    count = getFrequency(0, data);
    System.out.println("There are " + count + " zeroes.");
  }
}
