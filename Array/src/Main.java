public class Main {

    public static void main(String[] args) {


        Array<Integer> arr = new Array<Integer>();
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.add(1,100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        System.out.println(arr.get(0));

        arr.set(0,1);
        System.out.println(arr);

        int remove = arr.remove(2);
        System.out.println(remove+"\n"+arr);

        arr.removeFirst();
        System.out.println(remove+"\n"+arr);

        arr.removeLast();
        System.out.println(remove+"\n"+arr);

        arr.removeElement(4);
        System.out.println(arr);
    }
}
