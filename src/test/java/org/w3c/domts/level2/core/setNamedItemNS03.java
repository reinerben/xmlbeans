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
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.w3c.domts.DOMTest.load;


/**
 * The "setNamedItemNS(arg)" method for a
 * NamedNodeMap should add a node using its namespaceURI and localName given that
 * there is no existing node with the same namespaceURI and localName in the map.
 * <p>
 * Create an attr node with namespaceURI "http://www.nist.gov",qualifiedName
 * "prefix:newAttr" and value "newValue".
 * Invoke method setNamedItemNS(arg) on the map of the first "address"
 * element where arg is identified by the namespaceURI and qualifiedName
 * from above.  Method should return the newly added attr node.
 *
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-F68D080">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-F68D080</a>
 */
public class setNamedItemNS03 {
    @Test
    void testRun() throws Throwable {
        String namespaceURI = "http://www.nist.gov";
        String qualifiedName = "prefix:newAttr";
        Document doc = load("staffNS", true);
        Node arg = doc.createAttributeNS(namespaceURI, qualifiedName);
        arg.setNodeValue("newValue");
        NodeList elementList = doc.getElementsByTagName("address");
        Node testAddress = elementList.item(0);
        NamedNodeMap attributes = testAddress.getAttributes();
        Node setNode = attributes.setNamedItemNS(arg);
        Node retnode = attributes.getNamedItemNS(namespaceURI, "newAttr");
        String value = retnode.getNodeValue();
        assertEquals("newValue", value, "throw_Equals");
    }

    /**
     * Gets URI that identifies the test
     *
     * @return uri identifier of test
     */
    public String getTargetURI() {
        return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/setNamedItemNS03";
    }

}
