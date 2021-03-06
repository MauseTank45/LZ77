import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Potatoe {

    public static void main(String[] args) throws IOException {
        File file = new File("F:\\IntelliJ IDEA Community Edition 2019.3.3\\Test Faili\\test2.txt");
        Scanner scanner = new Scanner(file);
        String fileContents = "";
        int i = 1;

        while (scanner.hasNext()) {
            fileContents = fileContents.concat(scanner.nextLine().replace(" ", "_"));
            if (scanner.hasNextLine())
                fileContents = fileContents.concat("#");
            i++;
        }
        int[] ar = {100,10,1};
        for (int j : ar) {
            for (i = 0; i < fileContents.length(); i++) {
                System.out.print(i / j % 10);
            }
            System.out.println();
        }

        System.out.println(fileContents);


        int activity;
        final int searchBLen = 7;
        final int lookBLen = 5;
        int searchBEmpty = searchBLen;
        int inputLen = fileContents.length();

        Scanner scanner_input = new Scanner(System.in);
        int lookBStart;
        do {
            System.out.print("Begin from: ");
            lookBStart = Integer.parseInt(scanner_input.nextLine());
        }while( lookBStart < 0 || lookBStart > inputLen);

        while(true) {
            for (int j : ar) {
                System.out.print(" ");
                for (i = lookBStart - (searchBLen - searchBEmpty); i < lookBStart; i++) {
                    System.out.print(i / j % 10);
                }
                System.out.print("   ");
                for (i = lookBStart; i < lookBStart + lookBLen; i++) {
                    System.out.print(i / j % 10);
                }
                System.out.println();
            }


            System.out.print("\"" + fileContents.substring(lookBStart-(searchBLen - searchBEmpty), lookBStart) + "\" ");
            System.out.println("\"" + fileContents.substring(lookBStart, lookBStart+lookBLen) + "\"");
            System.out.print(" ");
            for (i = (searchBLen - searchBEmpty); i > 0; i--)
                System.out.print(i);
            System.out.println("   12345");


            System.out.print("Next: ");
            try{
                activity = Integer.parseInt(scanner_input.nextLine());
            }
            catch (Exception e){
                continue;
            };

            if (activity == 0)
                break;
            else if (activity == 6){
                if (inputLen - lookBLen != lookBStart) lookBStart++;
                if (searchBEmpty > 0)
                    searchBEmpty--;
            }
            else if (activity == 4){
                if (lookBStart > 0)
                    lookBStart--;
                if (lookBStart < searchBLen && searchBEmpty < searchBLen )
                    searchBEmpty++;
            }
        }
    }
}
