public class AA<K,V> {
  public void foo() {
    KVPair<K,V> kv = new KVPair();
  }
}

class KVPair<K,V> {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  K key;
  V value;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

}
