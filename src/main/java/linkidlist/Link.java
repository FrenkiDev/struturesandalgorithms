package linkidlist;

public class Link {
    public int iData;
    public double dData;
    public long lData;
    public Link next;

    public Link(int iData, double dData) {
        this.iData = iData;
        this.dData = dData;
    }

    public Link(long lData) {
        this.lData = lData;
    }

    public void display(){
        System.out.println("iData_" + iData + " dData_" + dData + " lData_" + lData);
    }
}

class LinkList{
    protected Link first;

    public LinkList() {
        first = null;
    }

    public boolean insertFirst(int locIdata, double locDdata){
        try{
            Link links = new Link(locIdata, locDdata);
            links.next = first;
            first = links;
            return true;
        }catch (NullPointerException e){
            return false;
        }

    }

    public Link deleteFirst(){
        try{
            Link tmpLink = first;
            first = tmpLink.next;
            return tmpLink;
        }catch (Exception e){
            return null;
        }
    }

    public boolean isEmpty(){
       if (this.first == null)
           return true;
        return false;
    }

    public void display(){
        Link tmpLinks = first;
        while (tmpLinks != null){
            tmpLinks.display();
            tmpLinks = tmpLinks.next;
        }
    }
}

class LinkApp{
    public static void main(String[] args) {
        LinkList linkLists = new LinkList();

        linkLists.insertFirst(3, 8.2);
        linkLists.insertFirst(1, 4.2);
        linkLists.insertFirst(311, 38.2);
        linkLists.insertFirst(32, 18.2);

        linkLists.display();

        Link links;
        System.out.println("Удаление...");
        while((links = linkLists.deleteFirst()) != null){
            links.display();
        }
    }
}
