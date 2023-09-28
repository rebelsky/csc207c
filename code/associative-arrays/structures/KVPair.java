package structures;

/**
 * An easy way to store key/value pairs.  We assume that other
 * classes will access fields directly.
 */
public class KVPair<K,V> {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The key.
   */
  K key;

  /**
   * The value.
   */
  V value;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create an empty key/value pair.
   */
  public KVPair() {
    this(null, null);
  } // KVPair()

  /**
   * Create a new key/value pair.
   */
  public KVPair(K key, V value) {
    this.key = key;
    this.value = value;
  } // KVPair(K,V)
} // class KVPair
  
