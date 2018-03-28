package p0314;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
public class xmlTest {
	public static void main(String[] args) {
		try{
			File fXmlFile = new File("test.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			System.out.println("Root element : "+doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("student");//tag name
			System.out.println("---------------------------------------------glgl12341234");
			for(int temp=0;temp<nList.getLength();temp++) {
				Node nNode = nList.item(temp);
				if(nNode.getNodeType()==Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					System.out.println("hakbun: "+getTagValue("hakbun",eElement));
					System.out.println("name: "+getTagValue("name",eElement));
					System.out.println("address: "+getTagValue("address",eElement));
					System.out.println("mobile: "+getTagValue("mobile",eElement));
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private static String getTagValue(String sTag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		return nValue.getNodeValue();
	}
}
