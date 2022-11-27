package HashTableJavaCollections;

import java.util.Hashtable;

public class main {

  public static void main(String[] args) {

 //   Hashtable<Integer, String> table = new Hashtable<>(10);

//    table.put(100, "Spongebob");
//    table.put(123, "Spongebob");
//    table.put(321, "Spongebob");
//    table.put(555, "Spongebob");
//    table.put(777, "Spongebob");
//
////    for (Integer key : table.keySet()){
////      System.out.println(key.hashCode() + "\t" + key + "\t" + table.get(key));
////    }
//
//    for (Integer key : table.keySet()){
//      System.out.println(key.hashCode() % 10 + "\t" + key + "\t" + table.get(key));
//    }

    // ------------------------------------------------------------------
    System.out.println(" ----------------------------- ");

    Hashtable<String, String> table = new Hashtable<>(10);

    table.put("100", "Spongebob");
    table.put("123", "Spongebob");
    table.put("321", "Spongebob");
    table.put("555", "Spongebob");
    table.put("777", "Spongebob");

//    for (String key : table.keySet()){
//      System.out.println(key.hashCode() + "\t" + key + "\t" + table.get(key));
//    }

//    table.remove("777");
//    table.remove("123");

    for (String key : table.keySet()){
      System.out.println(key.hashCode() % 10 + "\t" + key + "\t" + table.get(key));
    }


  }
}

