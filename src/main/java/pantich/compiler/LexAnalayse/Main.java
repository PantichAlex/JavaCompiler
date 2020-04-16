package pantich.compiler.LexAnalayse;




import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String chain="";
        File file=new File("DecGrammatic.java");
        try(InputStream resourceAsStream = Main.class.getClassLoader().getResourceAsStream("StringConstants/lexems.json")){
            String result= IOUtils.toString(resourceAsStream, StandardCharsets.UTF_8);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ;
        try {
            Scanner sc=new Scanner(file);
            while(sc.hasNext()){

                chain+=sc.nextLine()+"\n";

            }


            CommentDeleter comDeleter=new CommentDeleter();
            SpaceDeleter spaceDeleter=new SpaceDeleter();
            comDeleter.setNext(spaceDeleter);
            comDeleter.handle(chain);
            //System.out.println(comDeleter.getResult());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
