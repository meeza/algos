package azeem.graph;

import java.io.*;
import java.util.*;

/**
 * Created by azeem on 19/04/16.

 You are given a tree (a simple connected graph with no cycles). You have to remove as many edges from the tree as possible to obtain a forest with the condition that : Each connected component of the forest should contain an even number of vertices.

 To accomplish this, you will remove some edges from the tree. Find out the number of removed edges.

 Input Format
 The first line of input contains two integers N and M. N is the number of vertices and M is the number of edges.
 The next M lines contain two integers ui and vi which specifies an edge of the tree. (1-based index)

 Output Format
 Print the answer, a single integer.

 Constraints
 2 <= N <= 100.

 Note: The tree in the input will be such that it can always be decomposed into components containing even number of nodes.
 */
public class EvenTree {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nodeCount = scanner.nextInt();
        int edgeCount = scanner.nextInt();


        int[] childrens = new int[nodeCount];


        ArrayList<Integer>[] adjacencyList = new ArrayList[nodeCount];
        for(int i = 0; i<nodeCount; i++){
            adjacencyList[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < edgeCount; i++){
            int child = scanner.nextInt()-1;
            int parent = scanner.nextInt()-1;
            adjacencyList[parent].add(child);
        }

        childrenCount(adjacencyList, childrens, 0);
        int evenCount = 0;
        for (int i = 1; i<nodeCount;i++){
            if(childrens[i] %2 == 0)
                evenCount++;
        }
        System.out.println(evenCount);
    }

//    static int getChildCount(int node){
//        int count = 1;
//        for(int child : adjacencyList[node]){
//            if(adjacencyList[child].size() > 1)
//                count += getChildCount(child);
//            else
//                count += 1;
//        }
//        return count;
//    }

    static int childrenCount(ArrayList<Integer>[] adjacencyList, int[] childrens, int node){
        int totalSize = 0;
        if(adjacencyList[node].size() == 0)
            childrens[node] = 1;
        else if(0 == childrens[node])
        {
            for(int i = 0; i < adjacencyList[node].size() ; i++)
            {
                totalSize += childrenCount(adjacencyList,childrens,adjacencyList[node].get(i));
            }
        }
        childrens[node] = totalSize + 1;
        return childrens[node];
    }
}
