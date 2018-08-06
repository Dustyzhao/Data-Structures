/**
 * 利用泛型技术的自定义数组的应用示例
 * @author DUSTY
 */
public class Student {

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("Student(name:%s,score:%d)",name,score);
    }

    public static void main(String[] args){
        Array<Student> arr = new Array<>();
        arr.addLast(new Student("Alice",100));
        arr.addLast(new Student("Bob",60));
        arr.addLast(new Student("Charlie",90));
        System.out.println(arr);
    }
}
