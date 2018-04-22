package sorter;

/**
 * Created by FrenkPO on 11.10.2017.
 */
public class InsertSortApp {
    public static void main(String[] args) {
        int maxSize = 100;
        ArrayIns arr;
        arr = new ArrayIns(maxSize);

        arr.insert(99);
        arr.insert(939);
        arr.insert(93);
        arr.insert(93);
        arr.insert(93);
        arr.insert(9309000);
        arr.insert(19);
        arr.insert(6);
        arr.insert(6);
        arr.insert(9309);
        arr.insert(9309);
        arr.insert(9309);
        arr.insert(9309);
        arr.insert(9);
        arr.insert(9);

        arr.display();
        arr.insertionSort();
        arr.display();
        arr.noDups();
        arr.display();

        System.out.println(arr.median());
    }
}

class ArrayIns {
    private long[] a;
    private int nElems;

    public ArrayIns(int locMax) {
        a = new long[locMax];
        nElems = 0;
    }

    void insert(long locValue) {
        a[nElems] = locValue;
        nElems++;
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    void insertionSort() {
        int in, out;
        for (out = 1; out < nElems; out++) {
            long temp = a[out];
            in = out;
            while (in > 0 && a[in - 1] >= temp) {
                a[in] = a[in - 1];
                --in;
            }
            a[in] = temp;
        }
    }

    long median() {
        int tmp;
        if (nElems % 2 == 0) {
            tmp = nElems / 2;
            return a[tmp];
        } else {
            tmp = nElems / 2;
            return (a[tmp] + a[tmp + 1]) / 2;
        }
    }

    void noDups() {
        int dups = 1, flag = 0;

        for (int out = 1; out < nElems; out++) {
            if (a[out] == a[out - 1]) {
                if (flag == 0) {//Проверяем был ли сдвиг
                    dups = out;
                    flag = 1;
                }
            } else if (flag == 1) {
                swap(dups, out);
                dups++;//Помечаем место следующей вставки
            }
        }
        nElems -= (nElems - dups);//Уменьшаем массив на количество дубликатов
    }

    void swap(int in, int out) {
        a[in] = a[out];
    }
}
