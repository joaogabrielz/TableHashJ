public class main {
  public static void main(String[] args) {
    HashTable<String, Integer> hashTable = new HashTable<>();

    hashTable.add("joao", 1);
    hashTable.add("maria", 5);
    hashTable.add("programador", 10);

    hashTable.add("paula", 5);

    System.out.println("Chave(key) maria, valor: " + hashTable.get("maria"));
    System.out.println("Chave(key) paula, valor: " + hashTable.get("paula").hashCode());



    System.out.println("------");
    System.out.println("Hashtable tamanho: " + hashTable.size());
    System.out.println("Chave(key) joao, valor: " + hashTable.get("joao"));
    System.out.println("removendo joao: " + hashTable.remove("joao"));

    System.out.println("------");
    hashTable.add("joao", 4);
    System.out.println("Chave(key) joao, valor: " + hashTable.get("joao"));
    System.out.println("removendo joao: " + hashTable.remove("joao"));
    System.out.println("Chave(key) joao, valor: " + hashTable.get("joao"));

    System.out.println("Hashtable tamanho: " + hashTable.size());
    System.out.println("Hash table vazia?: " + hashTable.isEmpty());
  }
}
