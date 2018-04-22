package linkidlist;

public class SortedList {
    private Link first;


    public SortedList() {
        this.first = null;
    }

    public void insert(long locData){
        Link linkNew = new Link(locData);
        Link previos = null;
        Link current = first;

        if(first != null)
        while(current == null && locData > current.lData){
            previos = current;
            current = current.next;
        }

        if(previos == null){
            first = linkNew;
        }else{
            previos.next = linkNew;
        }

        linkNew.next = current;
    }

    public boolean isEmtyl(){
        return (first == null);
    }

    public Link remove(){
        Link linkRemove = first;
        first = first.next;
        return linkRemove;
    }

    public void display(){
        Link cur = first;
        while (cur != null){
            cur.display();
            cur = cur.next;
        }
    }
}

class SortedLinkList{
    public static void main(String[] args) {
        SortedList sortL = new SortedList();

        sortL.insert(123);
        sortL.insert(12);

        sortL.display();
        sortL.remove();

        sortL.insert(122);
        sortL.insert(1223);
        sortL.display();
    }
}
