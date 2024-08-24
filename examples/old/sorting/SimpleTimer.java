/**
 * A simple timer.
 */
public class SimpleTimer {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The time the timer started.
   */
  long start;    

  /**
   * The total elapsed time.
   */
  long elapsed = 0;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new timer.
   */
  public SimpleTimer() {
    this.restart();
  } // Timer()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Determine how much time has elapsed.
   */
  long elapsed() {
    return this.elapsed + System.currentTimeMillis() - this.start;
  } // elapsed()

  /**
   * Stop the timer.
   */
  long stop() {
    this.elapsed = this.elapsed();
    this.start = 0;
    return this.elapsed;
  } // stop()

  /**
   * Restart the timer.
   */
  void restart() {
    start = System.currentTimeMillis();
  } // restart()
} // class SimpleTimer
