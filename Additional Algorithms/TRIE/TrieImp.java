package TRIE;
class TrieNode{
    char data;
    TrieNode point[];
    boolean isTerm;
    int noChild;
    TrieNode(char data){
        this.data=data;
        point=new TrieNode[26];
        isTerm=false;
        noChild=0;
    }
}
class Trie{
    TrieNode root;
    Trie(){
        this.root=null;
    }
    //O(l)
    private void insertUtil(TrieNode root,String s,int index){
        if(index==s.length()){
            root.isTerm=true;
            return;
        }
        char ch=s.charAt(index);
        //words are assumbed to be in small letters
        if(root.point[ch-'a']==null){
            root.point[ch-'a']=new TrieNode(ch);
            root.noChild++;
        }
        insertUtil(root.point[ch-'a'], s, index+1);
    }
    void insertWord(String s){
        if(root==null){
            root=new TrieNode('\0');
        }
        s=s.toLowerCase();
        insertUtil(root, s, 0);
    }
    //O(l)
    private boolean utilSearch(TrieNode root,String s,int index){
        if(root==null){
            return false;
        }
        //at index root has character at position(index) index-1
        if(index==s.length()){
            return root.isTerm;
        } 
        return utilSearch(root.point[s.charAt(index)-'a'], s, index+1);
    }
    boolean search(String s){
        return utilSearch(root, s, 0);
    }
    //to remove a word make its last character's node isTerm false
    //O(l)
    //conditions for removal:
        //no other child
        //should not be a terminating node
    private boolean deleteUtil(TrieNode root,String s,int index){
        if(index==s.length()){
            root.isTerm=false;
            if(root.noChild>0){
                return false;
            }
            return true;
        }
        boolean remove=deleteUtil(root.point[s.charAt(index)-'a'], s, index+1);
        if(remove){
            root.point[s.charAt(index)-'a']=null;
            root.noChild--;
        }
        //checking if having child or not and is terminatin or not
        if(root.isTerm || root.noChild>0){
            return false;
        }
        return true;
    }
    void deleteWord(String s){
        if(utilSearch(root, s, 0)){
            deleteUtil(root, s,0);
        }
    }
}
public class TrieImp{
    public static void main(String args[]){
        Trie t1=new Trie();
        t1.insertWord("time");
        t1.insertWord("tim");
        t1.insertWord("dog");
        t1.insertWord("duck");
        t1.insertWord("dove");
        System.out.println(t1.search("time"));        
        System.out.println(t1.search("tim"));
        t1.deleteWord("tim");
        System.out.println(t1.search("tim"));

    }
}