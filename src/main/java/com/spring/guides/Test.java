package com.spring.guides;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

  public static void main(String[] args) {
    List<String[]> splitUpNames = Arrays.asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long").stream()
        .map(name -> name.split(" "))
        .collect(Collectors.toList());

    for (String[] name: splitUpNames
    ) {
      System.out.println(name[0]+", "+name[1]);
    }
  }

}
