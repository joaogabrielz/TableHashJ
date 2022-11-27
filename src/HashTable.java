import java.util.ArrayList;

public class HashTable<K, V> {

  private class HashNode { // No
    K key;
    V value;

      // Referencia proximo No
      HashNode next;

      // Construtor
      HashNode(K key, V value) {
        this.key = key;
        this.value = value;
      }
  }

  // Hash table:

    // Limiar de carga
    //@SuppressWarnings("FieldCanBeLocal") // Ignorar avisos vindo do compilador
    private static final double loadThreshold = 0.7;

   //bucketArray usado para guardar Array de chaves (caso colisao)
   private ArrayList<HashNode> bucketArray;

   //capacidade atual do ArrayList
    private int numBuckets;

  //Tamanho atual do ArrayList
    private int size;

    //Construtor que inicializa com capacidade, tamanho e chaves Vazias
    public HashTable() {
      bucketArray = new ArrayList<>();
      numBuckets = 10;
      size = 0;

      // Create empty chains
      for (int i = 0; i < numBuckets; i++) {
        bucketArray.add(null);
      }
    }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size() == 0;
  }

  // Retorna o Valor(V) passando a chave(key)
  public V get(K key) {

    // procura a chave(key) passada
    int bucketIndex = getBucketIndex(key);
    HashNode head = bucketArray.get(bucketIndex);


    // procura a chave(key) na lista
    while (head != null) {
      if (head.key.equals(key)) { // se a chave passada parametro = chave do No encontrado 'head'
        return head.value;
      }

      head = head.next;
    }

    // se nao achou a chave(key)
    return null;
  }

  // Implementa HashFunction para achar o indice(index) da chave(key)
  private int getBucketIndex(K key) {
    int hashCode = key.hashCode();
    return hashCode % numBuckets; // 2 %(mod) 10 -> pos 2
  }


  // Adiciona o par Chave(key), Valor(Value) para Hash
  public void add(K key, V value) {

    //Acha o comeco da lista da chave(key) passada param
    int bucketIndex = getBucketIndex(key);
    HashNode head = bucketArray.get(bucketIndex);


    // se a chave(key) ja esta presente
    while (head != null) {
      if (head.key.equals(key)) {
        head.value = value;
        return;
      }

      head = head.next;
    }


    // Insere a chave na lista
    size++;
    head = bucketArray.get(bucketIndex);
    HashNode newNode = new HashNode(key, value);
    newNode.next = head;
    bucketArray.set(bucketIndex, newNode);


    // Se o Fator de CARGA FOR alem do limiar definido, entao o dobro do tamanho da tabela hash
    if ((1.0 * size) / numBuckets >= loadThreshold) {
      ArrayList<HashNode> temp = bucketArray;
      bucketArray = new ArrayList<>();
      numBuckets = 2 * numBuckets;
      size = 0;

      for (int i = 0; i < numBuckets; i++) {
        bucketArray.add(null);
      }

      for (HashNode headNode : temp) {
        while (headNode != null) {
          add(headNode.key, headNode.value);
          headNode = headNode.next;
        }
      }
    }
  }


  // Metodo para remover a chave passada por param
  public V remove(K key) {
    // aplica A funcao Hash para achar o index da chave passada por param
    int bucketIndex = getBucketIndex(key);

    // vai ao topo da lista(cadeia)
    HashNode head = bucketArray.get(bucketIndex);

    // Procura a chave na lista
    HashNode prev = null;

    while (head != null) {
      // Se achou a Chave(key)
      if (head.key.equals(key)) {
        break;
      }

      // Senao convinua andando na lista
      prev = head;
      head = head.next;
    }

    // Se a chave(key) nao esta presente
    if (head == null) {
      return null;
    }

    // Reduz o tamanho
    size--;

    // Remove chave(key)
    if (prev != null) {
      prev.next = head.next;

    } else {
      bucketArray.set(bucketIndex, head.next);
    }

    return head.value;
  }

}
