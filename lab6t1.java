
package Lab6;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class lab6t1 { 
    public static void main(String[] args) throws ParserConfigurationException{
        try {
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=factory.newDocumentBuilder();
        Document document=builder.parse(new File("C:/Users/CompuCloud/Desktop/lab6new.XML"));
        document.getDocumentElement().normalize();
        NodeList list=document.getElementsByTagName("CONTAINER");
        for(int i=0;i<list.getLength();i++)
        {
            Node shortName=list.item(i);
            if(shortName.getNodeType()==Node.ELEMENT_NODE)
            {
                Element shortNameElement=(Element)shortName;
                System.out.println(shortNameElement.getAttribute("CONTAINER"));
            }
        }
        } catch (SAXException ex) {
            Logger.getLogger(lab6t1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(lab6t1.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
