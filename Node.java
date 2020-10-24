package perpus;
public class Node {
    int data;
    String judul;
    String Author;
    int rusak;
    int stock;
    Node prev;
    Node next;
    
        public Node(Node prev,int data,String judul,String Author,int stock, Node next){
        this.judul = judul;
        this.stock = stock;
        this.Author = Author;
        this.rusak = rusak;
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}
