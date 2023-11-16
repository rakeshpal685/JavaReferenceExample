package com.JavaReference.example.fileIO;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileIO {

  public static void main(String[] args) throws IOException {

    try (BufferedWriter writer = new BufferedWriter(new FileWriter("E:\\output.txt"))) {
      // try (BufferedWriter writer = new BufferedWriter(new FileWriter("E:\\output.txt",true))) {
      writer.write("Hello");
      writer.newLine();
      writer.write("World");
      writer.newLine();
      writer.append("YOYO \n");
      writer.append("POPO");
    }

    try (BufferedReader br = new BufferedReader(new FileReader("E:\\output.txt"))) {
      String line;
      while ((line = br.readLine()) != null) {
        System.out.println(line);
      }
    }

    // From java 11
    //First get the path of the file
    Path path = Path.of("E:\\output.txt");

    //Write to the file, the last argument can be anything
    Files.writeString(path, "Writing using java 11", StandardOpenOption.APPEND);

    //Reading from the file
    String s = Files.readString(path);
    System.out.println(s);
  }
}
