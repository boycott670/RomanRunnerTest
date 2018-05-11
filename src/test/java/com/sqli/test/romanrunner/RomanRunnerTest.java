package com.sqli.test.romanrunner;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sqli.romanrunner.Circenses;
import com.sqli.romanrunner.CircensesBuilder;

public class RomanRunnerTest
{
  @Test
  public void circensesBuilderTest()
  {
    Circenses circenses = new CircensesBuilder().addCoin()
        .addEmptySlot()
        .addCoin()
        .addObstacle()
        .build();

    String expectedDisplay = new StringBuilder().append("|##|\n") // the final line
        .append("|_ |\n") // the obstacle
        .append("|o |\n") // the second coin
        .append("|  |\n") // empty slot
        .append("|o |\n") // the first coin
        .append("|  |") // the start line is empty as no player is registered
        .toString();

    assertEquals(expectedDisplay, circenses.draw());
  }
}
