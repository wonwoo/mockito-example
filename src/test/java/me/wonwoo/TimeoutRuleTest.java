package me.wonwoo;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

import java.util.concurrent.TimeUnit;

/**
 * Created by wonwoo on 2016. 11. 30..
 */
public class TimeoutRuleTest {


  @Rule
  public Timeout testRule = new Timeout(1000, TimeUnit.MILLISECONDS);

  @Test
  public void testInfiniteLoop() {
    String log = null;
    log += "ran1";
    while (true) {}
  }
}
