package linkidlist;

public class DoublyLinked {
    public long lData;
    public DoublyLinked next;
    public DoublyLinked previos;

    public DoublyLinked(long lData) {
        this.lData = lData;
    }

    public void disPlay(){
        System.out.printf("lData_%d", lData);
    }
}

class DoublyLinkedList{
    private DoublyLinked first;
    private DoublyLinked last;

    public DoublyLinkedList() {
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty(){
        return (first == null);
    }

    public void inseartFirst(long locData){
        DoublyLinked linkNew = new DoublyLinked(locData);

        if(isEmpty()){
            last = linkNew;
        }else{
            first.previos = linkNew;
        }

        linkNew.next = first;
        first = linkNew;
    }

    public void inseartLast(long locData){
        DoublyLinked linkNew = new DoublyLinked(locData);

        if(isEmpty()){
            first = linkNew;
        }else{
            last.next = linkNew;
            linkNew.previos = last;
        }
        last = linkNew;
    }

    public DoublyLinked removeFirst(){
        DoublyLinked tmp = first;
        if(first.next == null)
        last = null;
        else first.next.previos = null;
        first = first.next;
        return tmp;
    }

    public DoublyLinked removeLast(){
        DoublyLinked tmp = last;
        if(first.next == null){
            first = null;
        }else last.previos.next = null;

        last = last.previos;
        return tmp;
    }
}
