    /*
     *   Java implementation of a Trie data structure with functionality
     *   to insert and search for strings stored in it.
     */

    public class Trie {

        // Alphabet size (# of symbols) we pick 26 for English alphabet
        static final int ALPHABET_SIZE = 26;

        // class for Trie node
        static class TrieNode {
            TrieNode[] children = new TrieNode[ALPHABET_SIZE];
            // isEndOfWord is true if the node represents end of a word i.e. leaf node
            boolean isEndOfWord;

            TrieNode() {
                isEndOfWord = false;

                for (int i = 0; i < ALPHABET_SIZE; i++)
                    children[i] = null;
            }
        }

        static TrieNode root;

        // If not key present, inserts into trie
        // If the key is prefix of Trie node,
        //  marks leaf node
        static void insert(String key) {
            int lvl, idx;
            int n = key.length();
            TrieNode tn = root;

            for (lvl = 0; lvl < n; lvl++) {
                idx = key.charAt(lvl) - 'a';
                if (tn.children[idx] == null)
                    tn.children[idx] = new TrieNode();
                tn = tn.children[idx];
            }
            tn.isEndOfWord = true; //this marks last node as a leaf
        }

        // Returns true if key presents in trie, else false
        static boolean search(String key) {
            int lvl, idx;
            int n = key.length();
            TrieNode tn = root;

            for (lvl = 0; lvl < n; lvl++) {
                idx = key.charAt(lvl) - 'a';
                if (tn.children[idx] == null) return false;
                tn = tn.children[idx];
            }
            return (tn != null && tn.isEndOfWord);
        }

        // Driver
        public static void main(String[] args) {

            // Input keys (use only 'a' through 'z' and lower case)
            String[] keys = {"bank", "book", "bar", "bring", "film", "filter", "simple", "silt", "silver"};
            String[] output = {"Not present in trie", "Present in trie"};

            root = new TrieNode();

            // Construct trie
            int i;
            for (i = 0; i < keys.length; i++) {
                insert(keys[i]);
            }

            // Search for different keys

            if(search("dog"))
                System.out.println("\"dog\" is " + output[1]);
            else System.out.println("\"dog\" is " + output[0]);

            if(search("filter"))
                System.out.println("\"filter\" is " + output[1]);
            else System.out.println("\"filter\" is " + output[0]);

            if(search("flower"))
                System.out.println("\"flower\" is " + output[1]);
            else System.out.println("\"flower\" is " + output[0]);

            if(search("book"))
                System.out.println("\"book\" is " + output[1]);
            else System.out.println("\"book\" is " + output[0]);

            if(search("chunk"))
                System.out.println("\"chunk\" is " + output[1]);
            else System.out.println("\"chunk\" is " + output[0]);
        }
//end of class
    }
