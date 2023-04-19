package Lab6;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.text.html.parser.Element;

public class Lab6 {
    public static void main(String[] args) throws NotVaildAutosarFileException, IOException, EmptyAutosarFileException{       
             try{
             File file1 =new File("C:/Users/CompuCloud/Desktop/lab6new.xml");
             System.out.println(file1.length());
//             IsAnXMLFile(new File("C:/Users/CompuCloud/Desktop/lab6new.xml"));
//             System.out.println(valide);            
//             if(!valide)
//             {
//                 throw new NotVaildAutosarFileException("Not Xml file");
//             }
             boolean empty=(file1.length()==0);
             if(empty)
             {
                 throw new EmptyAutosarFileException("EmptyFile");
             }
             Scanner input=new Scanner(file1);
             String filecontents="";
             while(input.hasNextLine())
             {
                 filecontents=filecontents.concat(input.nextLine()+"\n");
             }
             System.out.println(filecontents.indexOf("<SHORT-NAME>"));
             FileWriter file2=new FileWriter("C:/Users/CompuCloud/Desktop/lab6new_mod.xml");
             }
             catch(IOException e)
             {
                 System.out.println("not Xmr File");
             }
//         try{
//         
//         }
//         catch(Exception e)
//         {
//             
//         }
         
     }

    private static boolean IsAnXMLFile(File file) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
