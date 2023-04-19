import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.*;

//Hello ahmed
// Mahmoud Hamdy Mohamed Mostafa 2001300
public class Sorting {
    private static List<Node> sort(NodeList classesNodeList) {
        List<Node> nodes = new ArrayList<Node>();
        for (int i = 0; i < classesNodeList.getLength(); i++) {
            nodes.add(classesNodeList.item(i));
        }
        Collections.sort(nodes, new Comparator<Node>() {
            public int compare(Node o1, Node o2) {
                return ((Element)o1).getElementsByTagName("SHORT-NAME").item(0).getTextContent().compareTo(
                        ((Element)o2).getElementsByTagName("SHORT-NAME").item(0).getTextContent());
            }
        });

        return nodes;
    }
    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException, TransformerException {
        File file = new File("lab.arxml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(file);

        doc.getDocumentElement().normalize();

        System.out.println("Root element:" + doc.getDocumentElement().getNodeName());

        NodeList nList = doc.getElementsByTagName("CONTAINER");

        List<Node> sorted = sort(nList);
        System.out.println(sorted.size());
        for (int i=0; i < sorted.size(); i++) {
            System.out.println(((Element)sorted.get(i)).getElementsByTagName("SHORT-NAME").item(0).getTextContent());
            System.out.println(((Element)sorted.get(i)).getElementsByTagName("LONG-NAME").item(0).getTextContent());
        }
        Document sortedARXML = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element root = sortedARXML.createElement("AUTOSAR");
        sortedARXML.appendChild(root);

        for (int i = 0; i < sorted.size(); i++) {
            Node node = sorted.get(i);
            Node copyNode = sortedARXML.importNode(node, true);
            root.appendChild(copyNode);
        }
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        Result output = new StreamResult(new File("output.arxml"));
        Source input = new DOMSource(sortedARXML);

        transformer.transform(input, output);
    }
}