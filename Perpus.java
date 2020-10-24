package perpus;

import java.util.Scanner;

public class Perpus {

    Scanner sc = new Scanner(System.in);
    Node head;
    int size;

    public Perpus() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(int item, String judul, String Author, int stock) {
        if (isEmpty()) {
            head = new Node(null, item, judul, Author, stock, null);
        } else {
            Node newNode = new Node(null, item, judul, Author, stock, head);
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addBroken(int index, int rusak) {
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.rusak = cur.rusak + rusak;
        cur.stock = cur.stock - cur.rusak;
    }

    public void searching(int kode) {
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
            if (cur.data == kode) {
                System.out.println("=================================");
                System.out.println("BOOK FOUND");
                System.out.println("=================================");
                System.out.println("Kode : " + cur.data + "\t");
                System.out.println("Judul : " + cur.judul + "\t");
                System.out.println("Author : " + cur.Author + "\t");
                System.out.println("Stock : " + cur.stock + "\t");
                System.out.println("Rusak : " + cur.rusak + "\t");
                System.out.println("=================================");
            }
        }
    }

    public void searchingbyjudul(String judul) {
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
            if (cur.judul == judul) {
                System.out.println("=================================");
                System.out.println("BOOK FOUND");
                System.out.println("=================================");
                System.out.println("Kode : " + cur.data + "\t");
                System.out.println("Judul : " + cur.judul + "\t");
                System.out.println("Author : " + cur.Author + "\t");
                System.out.println("Stock : " + cur.stock + "\t");
                System.out.println("Rusak : " + cur.rusak + "\t");
                System.out.println("=================================");
            }
        }
    }

    public void searchingbyauthor(String author) {
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
            if (cur.Author == author) {
                System.out.println("=================================");
                System.out.println("BOOK FOUND");
                System.out.println("=================================");
                System.out.println("Kode : " + cur.data + "\t");
                System.out.println("Judul : " + cur.judul + "\t");
                System.out.println("Author : " + cur.Author + "\t");
                System.out.println("Stock : " + cur.stock + "\t");
                System.out.println("Rusak : " + cur.rusak + "\t");
                System.out.println("=================================");
            }
        }
    }

    public void TakeBook(int index, int ambil) {
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.stock = cur.stock - ambil;
    }

    public void print() {
        if (!isEmpty()) {
            
            Node tmp = head;
            while (tmp != null) {
                System.out.println("=================================");
                System.out.println("Kode : " + tmp.data + "\t");
                System.out.println("Judul : " + tmp.judul + "\t");
                System.out.println("Author : " + tmp.Author + "\t");
                System.out.println("Stock : " + tmp.stock + "\t");
                System.out.println("Rusak : " + tmp.rusak + "\t");
                System.out.println("=================================");
                tmp = tmp.next;
            }
            System.out.println("\nBerhasil Diisi");
        } else {
            System.out.println("Linked List Kosong");
        }
    }

    public static void menu() {
        System.out.println("DOUBLE LINKED LIST DENGAN MENU");
        System.out.println("==================================================================================");
        System.out.println("Pilih Menu");
        System.out.println("1. Buku Masuk ");
        System.out.println("2. Buku Keluar ");
        System.out.println("3. Buku Rusak ");
        System.out.println("4. See Book");
        System.out.println("5. Search Book");
        System.out.println("6. Exit");
    }

    public void sorting() {
        Node current = null, index = null;
        Node temp;
        if (head == null) {
            return;
        } else {
            for (current = head; current.next != null; current = current.next) {
                for (index = current.next; index != null; index = index.next) {
                    if (current.data > index.data) {
                        temp = current;
                        current = index;
                        index = temp;
                    }
                }
            }
        }
    }
    public void sortingbyjudul() {
        Node current = null, index = null;
        Node temp;
        if (head == null) {
            return;
        } else {
            for (current = head; current.next != null; current = current.next) {
                for (index = current.next; index != null; index = index.next) {
                    if (current.judul.charAt(0) > index.judul.charAt(0)) {
                        temp = current;
                        current = index;
                        index = temp;
                    }
                }
            }
        }
    }
}



class mainmain {

    public static void main(String[] args) {
        Perpus method = new Perpus();
        method.addFirst(111, "Naruto", "Mashashi kishimoto", 3);
        method.addFirst(112, "Bleach", "Akira Toriyama", 3);
        method.addFirst(107, "Toaru", "Westloy", 11);
        System.out.println("=================WELCOME==================");
        Scanner sc = new Scanner(System.in);
        Scanner sx = new Scanner(System.in);
        String bus = "N";
        for (int i = 0; bus.equalsIgnoreCase("N"); i++) {
            method.menu();
            System.out.println("What System do you want to do");
            int jwb = sc.nextInt();
            switch (jwb) {
                case 1:
                    System.out.println("Masukkan Kode Buku : ");
                    int kode = sc.nextInt();
                    System.out.println("Masukkan Judul Buku : ");
                    String judul = sc.next();
                    System.out.println("Masukkan Author : ");
                    String author = sc.next();
                    System.out.println("Masukkan Stock Buku : ");
                    int stock = sc.nextInt();
                    method.addFirst(kode, judul, author, stock);
                    break;
                case 2:
                    System.out.println("Masukkan Index : ");
                    int index = sc.nextInt();
                    System.out.println("Berapa Buku yang anda ingin ambil ? ");
                    int take = sc.nextInt();
                    method.TakeBook(index, take);
                    break;
                case 3:
                    System.out.println("Masukkan Index : ");
                    int index1 = sc.nextInt();
                    System.out.println("Berapa Buku yang rusak ?");
                    int take1 = sc.nextInt();
                    method.addBroken(index1, take1);
                    break;
                case 4:
                    method.sortingbyjudul();
                    method.print();
                    break;
                case 5:
                    System.out.println("Buku apa yang ingin anda cari ? (Masukkan Kode)");
                    int kode1 = sc.nextInt();
                    method.searching(kode1);
                    break;
                case 6:
                    System.out.println("Buku apa yang ingin anda cari ? (Masukkan Judul)");
                    String judul1 = sc.next();
                    method.searchingbyjudul(judul1);
                    break;
                case 7:
                    System.out.println("Buku apa yang ingin anda cari ? (Masukkan Author)");
                    String authorr = sc.next();
                    method.searchingbyauthor(authorr);
                    break;
                case 9:
                    System.out.println("Arrividerci ! ");
                    bus = "Y";
                    break;
                default:
                    System.out.println("The Input is wrong ");
                    break;
            }
        }
    }
}
