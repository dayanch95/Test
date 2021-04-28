import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dayanch on 26.04.2021.
 */
public class Sorter {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        List<String> lines = new ArrayList<String>();
        String line;
        while ((line = reader.readLine()) != null){
            if (lines.isEmpty()) {
                line = "<empty";
            }
                lines.add(line);

        }
        reader.close();
        String[] array = lines.toArray(new String[lines.size()]);
        Arrays.sort(array);
        for (String s : array) {
            System.out.println(s);

        }

       }
    }
