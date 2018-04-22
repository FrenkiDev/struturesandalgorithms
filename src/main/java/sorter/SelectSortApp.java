package sorter;

/**
 * Created by FrenkPO on 11.10.2017.
 */
public class SelectSortApp {
    public static void main(String[] args) {
        int maxSize = 100;            // Размер массива
        ArraySel arr;                 // Ссылка на массив
        arr = new ArraySel(maxSize);  // Создание массива
        arr.insert(77);               // Вставка 10 элементов
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);
        arr.display();                // Вывод элементов
        arr.selectionSort();          // Сортировка методом выбора
        arr.display();                // Повторный вывод      }
    }
}

class ArraySel {
    private long[] a;
    private int nElems;

    public ArraySel(int locMax) {
        a = new long[locMax];
        nElems = 0;
    }

    public void insert(long locValuer) {
        a[nElems] = locValuer;
        nElems++;
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public void selectionSort() {
        int in, out, min;

        for (out = 0; out < nElems - 1; out++) {
            min = out;
            for (in = out + 1; in < nElems; in++) {
                if (a[in] < a[min]) {
                    min = in;
                }
                swap(out, min);
            }
        }
    }

    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }

    void sorter(){
        int in, out, min;
        for(out = 0; out < nElems - 1; out++){
            min = out;
            for(in = out + 1; in < nElems; in++){
                if(a[min] >= a[in]){
                    a[min] = a[in];
                }
            }
           swap(min, out);
        }
    }
}