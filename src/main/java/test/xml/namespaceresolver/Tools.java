package test.xml.namespaceresolver;

import java.io.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Tools {

	public static Document readExampleDocument()
			throws ParserConfigurationException, IOException, SAXException {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory
				.newInstance();
		builderFactory.setNamespaceAware(true);
		DocumentBuilder builder = builderFactory.newDocumentBuilder();

//		String input = readFile(new File("./example/BookList.xml"));
		String input = readFile(new File("D:\\ideaspace2019\\spring-boot-graphql\\src\\main\\java\\test\\xml\\example\\BookList.xml"));
		InputSource inputSource = new InputSource(new StringReader(input));
		return builder.parse(inputSource);
	}

	public static String readFile(File file) throws IOException {
		StringBuffer content = new StringBuffer();

		FileInputStream fileInputStream = new FileInputStream(file);
		InputStreamReader streamReader = new InputStreamReader(fileInputStream,
				"UTF-8");
		int readChars = 0;
		do {
			char[] contentBuffer = new char[1024];
			readChars = streamReader.read(contentBuffer);
			content.append(contentBuffer, 0, readChars);
		} while (readChars == 1024);
		streamReader.close();
		return content.toString();
	}

	public static String putOutAsString(Node node) throws TransformerException {
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer();

		StringWriter writer = new StringWriter();
		Result result = new StreamResult(writer);
		transformer.transform(new DOMSource(node), result);
		return writer.toString();
	}


	public static String putDoc2String(Document document) throws TransformerException {

		TransformerFactory transFactory = TransformerFactory.newInstance();
		Transformer transformer = transFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		DOMSource domSource = new DOMSource(document);

		// xml transform String
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		transformer.transform(domSource, new StreamResult(bos));
		String xmlString = bos.toString();
		System.out.println(xmlString);
		return xmlString;
	}


	public static DocumentBuilderFactory newDocumentBuilderFactory() {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		return dbf;
	}

	public static DocumentBuilder newDocumentBuilder()
			throws ParserConfigurationException {
		return newDocumentBuilderFactory().newDocumentBuilder();
	}


	public static Document parseXMLDocument(String xmlString) {
		if (xmlString == null) {
			throw new IllegalArgumentException();
		}
		try {
			return newDocumentBuilder().parse(
					new InputSource(new StringReader(xmlString)));
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
