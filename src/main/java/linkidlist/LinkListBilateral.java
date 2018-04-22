package linkidlist;

public class LinkListBilateral extends LinkList {
    protected Link last;

    public LinkListBilateral() {
        this.last = null;
    }

    @Override
    public boolean insertFirst(int iData, double dData) {
        try {
            Link tmp = new Link(iData, dData);
            if (isEmpty())
                last = tmp;
            tmp.next = first;
            first = tmp;
        } catch (NullPointerException e) {
            return false;
        }
        return true;
    }

    public boolean inseartLast(int iData, double dData) {
        try {
            Link tmp = new Link(iData, dData);
            if (isEmpty())
                first = tmp;
            else
                last.next = tmp;
            last = tmp;
        } catch (NullPointerException e) {
            return false;
        }
        return true;
    }
}

class LinkListBilateralApp {
    public static void main(String[] args) {
        LinkListBilateral linls = new LinkListBilateral();

        linls.insertFirst(4, 6.4);
        linls.insertFirst(33, 44.7);
        linls.insertFirst(46, 36.4);
        linls.insertFirst(421, 64.444);
        linls.insertFirst(71, 90.48);

        linls.display();
        System.out.println("");

        linls.inseartLast(66, 6.4);
        linls.inseartLast(75, 64.4);

        linls.display();
    }
}
