package com.liujunyao.rental.car;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @author liujunyao
 * @version 1.0
 * @date 2020/5/24 下午2:38
 */
public class UserUtil {

  private UserUtil() {}

  /** initial rate limiter for every user. */
  private static final ThreadLocal<RateLimiter> rateLimiterForUser =
      ThreadLocal.withInitial(
          () -> {
            // 1 time per second
            return RateLimiter.create(1);
          });

  /** user logout */
  public static void clearAllInfo() {
    rateLimiterForUser.remove();
  }

  public static RateLimiter rateLimiterForUser() {
    return rateLimiterForUser.get();
  }
}
