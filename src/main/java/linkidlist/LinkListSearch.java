package linkidlist;

public class LinkListSearch extends LinkList {
    public LinkListSearch() {
        super();
    }

    public Link delete(int key) {
        Link previous = first;
        Link tmp = first;
        while (tmp.iData != key) {
            if (tmp.next == null) {
                return null;
            } else {
                previous = tmp;
                tmp = tmp.next;
            }
        }
        if (tmp == previous) {
            first = first.next;
        } else {
            previous.next = tmp.next;
        }
        return tmp;
    }

    public Link find(int key) {
        Link tmp = first;

        while (tmp.iData != key) {
            if (tmp.next == null) {
                return null;
            } else {
                tmp = tmp.next;
            }
        }

        return tmp;
    }
}

class LinkListSearchApp {
    public static void main(String[] args) {
        LinkListSearch linls = new LinkListSearch();
        int key = 33;
        linls.insertFirst(4, 6.4);
        linls.insertFirst(33, 44.7);
        linls.insertFirst(46, 36.4);
        linls.insertFirst(421, 64.444);
        linls.insertFirst(71, 90.48);

        linls.display();

        System.out.println("Поиск key = " +key + "...");
        linls.find(key).display();
        System.out.println("Удаление");
        linls.delete(key).display();
        System.out.println("Вывод");
        linls.display();
    }
}