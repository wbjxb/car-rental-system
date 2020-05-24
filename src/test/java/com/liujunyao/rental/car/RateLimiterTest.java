package com.liujunyao.rental.car;

import com.google.common.util.concurrent.RateLimiter;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author liujunyao
 * @version 1.0
 * @date 2020/5/24 下午2:20
 */
public class RateLimiterTest {

  @Test
  void testSmoothBursty() throws InterruptedException {

    RateLimiter r = RateLimiter.create(1);
    for (int i = 0; i < 20; i++) {
      TimeUnit.MILLISECONDS.sleep(500);
      if (r.tryAcquire(1)) {
        System.out.println("get 1 tokens");
      } else {
        System.out.println("no tokens");
      }
    }
    //    while (true) {
    //      System.out.println("get 1 tokens: " + r.acquire() + "s");
    //    }
  }
}
