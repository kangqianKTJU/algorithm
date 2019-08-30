package LeetCode.Design;

import java.time.chrono.ChronoLocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 */
public class P208_Trie {
    /** Initialize your data structure here. */
    Node root;
    public P208_Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] chArray = word.toCharArray();
        Node cur =root;
        for(int i = 0; i < chArray.length; i++){
            if(cur.childs.containsKey(chArray[i])){
                Node child = cur.childs.get(chArray[i]);
                cur = child;
            }else{
                Node newNode = new Node(chArray[i]);
                cur.childs.put(chArray[i],newNode);
                cur = newNode;
            }
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] chArray = word.toCharArray();
        Node cur =root;
        for(int i = 0; i < chArray.length; i++){
            if(cur.childs.containsKey(chArray[i])){
                Node child = cur.childs.get(chArray[i]);
                cur = child;
            }else{
               return false;
            }
        }
        return cur.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] chArray = prefix.toCharArray();
        Node cur =root;
        for(int i = 0; i < chArray.length; i++){
            if(cur.childs.containsKey(chArray[i])){
                Node child = cur.childs.get(chArray[i]);
                cur = child;
            }else{
                return false;
            }
        }
        return true;
    }

    class Node{
        Character ch;
        Map<Character, Node> childs = new HashMap<>();
        boolean isWord;
        Node(){

        }
        Node(char ch){
            this(ch, false);
        }
        Node(char ch, boolean isWord){
            this.ch = ch;
            this.isWord = isWord;
        }
    }

    public static void main(String[] args) {
        P208_Trie trie = new P208_Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
    }
}
