package com.example.switchyard.handle_bpm_exception;

import org.switchyard.annotations.Transformer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;

public class MyTransformer
{
	@Transformer(from = "{urn:com.example.switchyard:handle_bpm_exception:0.0.1-SNAPSHOT}start")
	public String transform(Element from) 
	{
		String fromStr = transfromElementToString(from);
		System.out.println("[MyTransformer] from:\n" + fromStr);
		
		String name = getElementValue(from, "name");
		if (name == null)	name = getElementValue(from, "urn:name"); // Support SOAP UI
		System.out.println("[MyTransformer] name:" + name);
		
		return name;
	}
	
	/**
	 * @param node
	 * @return
	 * @see http
	 *      ://stackoverflow.com/questions/1219596/how-to-i-output-org-w3c-dom
	 *      -element-to-string-format-in-java
	 */
	private String transfromElementToString(Element node)
	{
		Document document = node.getOwnerDocument();
		DOMImplementationLS domImplLS = (DOMImplementationLS) document
				.getImplementation();
		LSSerializer serializer = domImplLS.createLSSerializer();
		String str = serializer.writeToString(node);

		return str;
	}
	
	private String getElementValue(Element parent, String elementName)
	{
		String value = null;
		NodeList nodes = parent.getElementsByTagName(elementName);
		if (nodes.getLength() > 0)
		{
			value = nodes.item(0).getChildNodes().item(0).getNodeValue();
		}
		return value;
	}
	
}


