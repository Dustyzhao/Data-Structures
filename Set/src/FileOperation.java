import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * 文件的相关操作，用来测试我们的BSTSet
 * @author DUSTY
 */
public class FileOperation {

    /**
     * 读取文件名为filename中的内容，将其包含的所有词汇都放入到words中
     * @param filename
     * @param words
     * @return
     */
    public static boolean readFile(String filename, ArrayList<String> words){

        if (filename == null || words == null){
            System.out.println("filename is null or words is null");
            return false;
        }

        //文件读取
        Scanner scanner = null;

        File file = new File(filename);

        try {

            if (file.exists()){
                FileInputStream fis = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fis),"UTF-8");
                scanner.useLocale(Locale.ENGLISH);
            }else {
                return false;
            }

        } catch (FileNotFoundException e) {
                e.printStackTrace();
        }

        /**
         * 简单分词，不考虑很多文本处理的特殊情况
         */
        if (scanner.hasNextLine()){

            String contents = scanner.useDelimiter("\\A").next();

            int start = firstCharacterIndex(contents,0);

            for (int i = start+1; i < contents.length(); ) {
                if (i == contents.length() || !Character.isLetter(contents.charAt(i))){
                    String word = contents.substring(start, i).toLowerCase();
                    words.add(word);
                    start = firstCharacterIndex(contents, i);
                    i = start + 1;
                }else{
                    i++;
                }

            }
        }
        return true;

    }

    /**
     * 寻找字符串s中从start位置开始的第一个字母字符的位置
     * @param s
     * @param start
     * @return
     */
    private static int firstCharacterIndex(String s, int start) {

        for (int i = start; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))){
                return i ;
            }

        }

        return s.length();
    }
}
