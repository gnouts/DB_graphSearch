package project.ee16f008;
import java.io.*;
import java.lang.*;
import java.util.*;
import info.debatty.java.lsh.*;
import org.mapdb.*;

class Graph
{
 public static void main(String args[])
  {
    Hashtable ht = new Hashtable();
    try{

      FileInputStream fstream = new FileInputStream(args[0]);
      DataInputStream in = new DataInputStream(fstream);
      BufferedReader br = new BufferedReader(new InputStreamReader(in));

      FileInputStream fstream2 = new FileInputStream(args[1]);
      DataInputStream in2 = new DataInputStream(fstream2);
      BufferedReader br2 = new BufferedReader(new InputStreamReader(in2));

      String index_S;
      int index_i;
      int nodes_number;
      int edges_number;
      String[] nodes_list = new String[100];
      String[] edges_list = new String[100];
      MinHash minhash = new MinHash(0.1, 5 );

      //###########################
      //    READ DATABASE
      int iteration = 1;
      index_S = br.readLine();
      while ( index_S != null) {
        index_i = Integer.parseInt(index_S.substring(1));
        nodes_number = Integer.parseInt(br.readLine());
        for (int i=0; i<nodes_number; i++){
          nodes_list[i] = br.readLine();
        }
        edges_number = Integer.parseInt(br.readLine());
        for (int i=0; i<edges_number; i++){
          edges_list[i] = br.readLine();
        }

        //##############################
        //    FINGEPRINTING DATABASE
        TreeSet<Integer> fingerprint = new TreeSet<Integer>();
        fingerprint.add(nodes_number);
        for (int node=0; node<nodes_number; node++){
          for (char letter : nodes_list[node].toCharArray()){
            fingerprint.add((int)letter);
          }
        }
        for (int edge=0; edge<edges_number; edge++){
          fingerprint.add((int)edges_list[edge].charAt(0));
          fingerprint.add((int)edges_list[edge].charAt(2));
          fingerprint.add((int)edges_list[edge].charAt(4));
        }

        //##############################
        //    MINHASH DATABASE 

        int[] sig = minhash.signature(fingerprint);
//        System.out.println("Signature "+index_i+" :"+sig);
        //###############################
        //    STORE IN TREE
        ht.put(sig, index_S);

        iteration = 2;
        if(iteration > 1){
          index_S = br.readLine();
        }
     }//END creating database
   
      //################################
      //    READ INPUT QUERY
    String index_S2;
    int index_i2;
    int nodes_number2;
    int edges_number2;
    String[] nodes_list2 = new String[1000];
    String[] edges_list2 = new String[1000];
    int iteration2 = 1;
    index_S2 = br2.readLine();
    while ( index_S2 != null) {
      index_i2 = Integer.parseInt(index_S2.substring(1));
      nodes_number2 = Integer.parseInt(br2.readLine());
      for (int i=0; i<nodes_number2; i++){
        nodes_list2[i] = br2.readLine();
      }
      edges_number2 = Integer.parseInt(br2.readLine());
      for (int i=0; i<edges_number2; i++){
        edges_list2[i] = br2.readLine();
      }
       iteration2 = 2;
      if(iteration2 > 1){
        index_S2 = br2.readLine();
      }
      //###########################
      //    FINGEPRINTING QUERIES
      TreeSet<Integer> fingerprint2 = new TreeSet<Integer>();
      fingerprint2.add(nodes_number2);
      for (int node=0; node<nodes_number2; node++){
        for (char letter : nodes_list2[node].toCharArray()){
          fingerprint2.add((int)letter);
        }
      }
      for (int edge=0; edge<edges_number2; edge++){
        fingerprint2.add((int)edges_list2[edge].charAt(0));
        fingerprint2.add((int)edges_list2[edge].charAt(2));
        fingerprint2.add((int)edges_list2[edge].charAt(4));
      }
      //##########################
      //    MINHASH QUERIES 
      int[] sig2 = minhash.signature(fingerprint2);
      System.out.println("Query "+index_i2+" :"+sig2);

      //###########################
      //    MATCHES
      if( ht.containsKey(sig2) == true ){
        System.out.println(index_i2);
        System.out.println(ht.get(sig2));
      }else{
        System.out.println("0\n");        
      }
    } // end reading query file
    
  //Close the input stream
  in.close();
  in2.close();
} //end try
  catch (Exception e){//Catch exception if any
    System.err.println("Error: " + e.getMessage());
  } //end catch
  } //end main
} //end class