/*
This Java source file was generated by test-to-java.xsl
and is a derived work from the source document.
The source document contained the following notice:



Copyright (c) 2001 World Wide Web Consortium,
(Massachusetts Institute of Technology, Institut National de
Recherche en Informatique et en Automatique, Keio University).  All
Rights Reserved.  This program is distributed under the W3C's Software
Intellectual Property License.  This program is distributed in the
hope that it will be useful, but WITHOUT ANY WARRANTY; without even
the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
PURPOSE.

See W3C License http://www.w3.org/Consortium/Legal/ for more details.


*/

package org.w3c.domts.level2.core;


import org.junit.jupiter.api.Test;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.w3c.domts.DOMTest.load;


/**
 * The "getAttributeNS(namespaceURI,localName)" method retrieves an
 * attribute value by local name and NamespaceURI.
 * <p>
 * Retrieve the first "emp:address" element.
 * Create a new attribute with the "createAttributeNS()" method.
 * Add the new attribute with the "setAttributeNS()" method.
 * The value returned by the "getAttributeNS()" method should be the
 * empty string since the attribute does not have a default value.
 *
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElGetAttrNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElGetAttrNS</a>
 */
public class getAttributeNS02 {
    @Test
    void testRun() throws Throwable {
        String namespaceURI = "http://www.nist.gov";
        String localName = "district";
        String qualifiedName = "emp:district";
        Document doc = load("staffNS", true);
        Attr newAttribute = doc.createAttributeNS(namespaceURI, qualifiedName);
        NodeList elementList = doc.getElementsByTagName("emp:address");
        Element testAddr = (Element) elementList.item(0);
        Attr districtAttr = testAddr.setAttributeNodeNS(newAttribute);
        elementList = doc.getElementsByTagName("emp:address");
        testAddr = (Element) elementList.item(0);
        String attrValue = testAddr.getAttributeNS(namespaceURI, localName);
        assertEquals("", attrValue, "throw_Equals");
    }

    /**
     * Gets URI that identifies the test
     *
     * @return uri identifier of test
     */
    public String getTargetURI() {
        return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/getAttributeNS02";
    }

}
