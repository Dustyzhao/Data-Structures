import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        System.out.println("The Shawshank Redemption");

        //total words including the similar ones
        ArrayList<String> words = new ArrayList<>();
        FileOperation.readFile("The-Shawshank-Redemption.txt",words);
        System.out.println("Total words: "+ words.size());

        //number of different words
        BSTSet<String> set1 = new BSTSet<>();
        for (String word:words){
            set1.add(word);
            System.out.println("Total different words: "+ set1.getSize());
        }

    }
}
