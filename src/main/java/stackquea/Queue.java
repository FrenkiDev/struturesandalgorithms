package stackquea;

/**
 * Created by FrenkPO on 15.10.2017.
 */
public class Queue {
    private int maxSize;
    private int nItems;
    private int front;
    private int rear;
    private long[] queArr;

    public Queue(int locMaxSize) {
        this.maxSize = locMaxSize;
        this.queArr = new long[maxSize];
        this.nItems = 0;
        this.front = 0;
        this.rear = -1;
    }

    public void insert(long locValue) {
        if (rear == (maxSize - 1))
            rear = -1;
        queArr[++rear] = locValue;
        nItems++;
    }

    public long remove() {
        long tmpRearValue = queArr[front++];
        if (front == (maxSize))
            front = 0;
        nItems--;
        return tmpRearValue;
    }

    public boolean isFull() {
        return (maxSize == maxSize);
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public int getSize() {
        return maxSize;
    }

    public void display() {

        if (isEmpty()) {
            System.out.println("Очередь пустая!");
            return;
        } else if (front == rear) {
            System.out.println("В очереди один элемент : " + queArr[front]);
        }
        int i = 0;
        while (i <= nItems - 1) {
            if (front < rear) {
                System.out.println(queArr[front++]);
            } else {
                if (front == maxSize) {
                    front = 0;
                    System.out.println(queArr[front++]);
                } else {
                    System.out.println(queArr[front++]);
                }
            }
            i++;
        }

    }
}

class QueueNonnItems {
    private int maxSize;
    private int rear;
    private int front;
    private long[] queArr;

    public QueueNonnItems(int locMaxSize) {
        this.maxSize = locMaxSize;
        this.rear = -1;
        this.front = 0;
        this.queArr = new long[maxSize + 1];
    }

    public void insert(long locValue) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queArr[++rear] = locValue;
    }

    public long remove() {
        long tmp = queArr[front++];
        if (front == maxSize) {
            front = 0;
        }
        return tmp;
    }

    public boolean isFull() {
        return ((rear + 2 == front) || (front + maxSize - 2 == rear));
    }

    public boolean isEmpty() {
        return ((rear + 1 == front) || (front + maxSize == rear));
    }

    public int getSize() {
        if (rear >= front) {
            return rear - front + 1;
        } else {
            return (maxSize - front) + (rear + 1);
        }
    }
}

class PriorityQ {
    private long[] querParr;
    private int nElems;
    private int maxSize;

    public PriorityQ(int locMaxSize) {
        this.maxSize = locMaxSize;
        this.nElems = 0;
        this.querParr = new long[maxSize];
    }

    public void insert(long locValue) {
        int i;
        if (nElems == 0) {
            querParr[nElems++] = locValue;
        } else {
            for (i = nElems - 1; i >= 0; i--) {
                if (locValue > querParr[i]) {
                    querParr[i + 1] = querParr[i];
                } else {
                    break;
                }
            }
            querParr[i + 1] = locValue;
            nElems++;
        }
    }
}

class DeqQeue {
    private long[] deqQ;
    private int firsRear, firstFront;
    private int lastRear, lastFront;
    private int nElems, maxSize;

    public DeqQeue(int maxSize) {
        this.maxSize = maxSize;
        this.deqQ = new long[this.maxSize];
        firsRear = -1;
        lastRear = this.maxSize;
        firstFront = 0;
        lastFront = this.maxSize - 1;
    }

    public void insertFirst(long locValue) {
        if (isEmty()) {
            deqQ[++firsRear] = locValue;
            nElems++;
        }
        else if (isFull())
            System.out.println("Qeue full");
        else if (firsRear == lastFront) {
            System.out.println("not insert");
        }
        else {
            deqQ[++firsRear] = locValue;
            nElems++;
        }
    }

    public long removeFirst() {
        if(firstFront != lastRear) {
            long tmpValue = deqQ[firstFront++];
            nElems--;
            return tmpValue;
        }else System.out.println("First DeqQ Empty");
        return 0;
    }

    public void insertLast(long locValue) {

    }

    public long removeLast() {
        long tmpValue = 0;
        return tmpValue;
    }

    public boolean isFull() {
        return nElems == maxSize;
    }

    public boolean isEmty() {
        return nElems == 0;
    }
}
class DeqQ{
    public static void main(String[] args) {
        DeqQeue deq = new DeqQeue(3);

        deq.insertFirst(2);
        deq.insertFirst(3);
        deq.removeFirst();
        deq.insertFirst(1);
    }
}

class QueueApp {
    public static void main(String[] args) {
        Queue queue = new Queue(5);

        queue.insert(1);
        //queue.insert(2);
        queue.insert(3);
        queue.insert(4);

        //queue.remove();
        queue.remove();
        queue.remove();

        // queue.insert(5);
        queue.insert(6);
        queue.remove();
        queue.remove();
        queue.insert(7);
        queue.insert(10);
        queue.isEmpty();
        queue.isFull();

        //System.out.println(queue.getSize());

        queue.display();
        /*for (int i = 0; !queue.isEmpty(); i++){
            System.out.print(queue.remove() + " ");
        }*/
    }
}
