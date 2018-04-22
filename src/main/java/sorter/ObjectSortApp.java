package sorter;

/**
 * Created by FrenkPO on 11.10.2017.
 */
public class ObjectSortApp {
    public static void main(String[] args) {
        int maxSize = 10;
        ArrayInOb arrayInObs = new ArrayInOb(maxSize);

        arrayInObs.insert("p", "p", 2);
        arrayInObs.insert("f", "p", 2);
        arrayInObs.insert("g", "p", 2);
        arrayInObs.insert("ds", "p", 2);
        arrayInObs.insert("a", "p", 2);
        arrayInObs.insert("pasha", "p", 2);

        arrayInObs.display();

        arrayInObs.insertionSort();

        arrayInObs.display();
    }
}

class Person{
    private String lastName;
    private String firstName;
    private int age;

    public Person(String lastName, String firstName, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }
    public void displayPerson(){
        System.out.print("LastName __ " + lastName);
        System.out.print(" FirstName __ " + firstName);
        System.out.println(" Age __ " + age);
    }

    public String getLastName() {
        return lastName;
    }
}

class ArrayInOb{
    private Person[] a;
    private int nElems;

    public ArrayInOb(int locMax) {
        a = new Person[locMax];
        nElems = 0;
    }

    public void insert(String locLast, String locFirst, int locAge){
        a[nElems] = new Person(locLast, locFirst, locAge);
        nElems++;
    }

    public void display(){
        for(int i = 0; i < nElems; i++){
            a[i].displayPerson();
        }
    }

    public void insertionSort(){
        int in, out;

        for(out = 1; out < nElems; out++){
            Person temp = a[out];

            in = out;

            while(in != 0 &&
                    a[in - 1].getLastName().compareTo(temp.getLastName()) > 0){
                a[in] = a[in - 1];
                --in;
            }
            a[in] = temp;
        }
    }
}