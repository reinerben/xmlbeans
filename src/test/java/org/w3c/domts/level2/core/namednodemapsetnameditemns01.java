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
import org.w3c.dom.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.w3c.domts.DOMTest.load;


/**
 * The method setNamedItemNS adds a node using its namespaceURI and localName. If a node with
 * that namespace URI and that local name is already present in this map, it is replaced
 * by the new one.
 * Retreive the first element whose localName is address and namespaceURI http://www.nist.gov",
 * and put its attributes into a named node map.  Create a new attribute node and add it to this map.
 * Verify if the attr node was successfully added by checking the nodeName of the retreived atttribute.
 *
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getNamedItemNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getNamedItemNS</a>
 */
public class namednodemapsetnameditemns01 {
    @Test
    void testRun() throws Throwable {
        Document doc = load("staffNS", true);
        NodeList elementList = doc.getElementsByTagNameNS("http://www.nist.gov", "address");
        Node element = elementList.item(0);
        NamedNodeMap attributes = element.getAttributes();
        Attr newAttr1 = doc.createAttributeNS("http://www.w3.org/DOM/L1", "streets");
        Attr newAttribute = ((Element) /*Node */element).setAttributeNodeNS(newAttr1);
        Attr attribute = (Attr) attributes.getNamedItemNS("http://www.w3.org/DOM/L1", "streets");
        String attrName = attribute.getNodeName();
        assertEquals("streets", attrName, "namednodemapsetnameditemns01");
    }

    /**
     * Gets URI that identifies the test
     *
     * @return uri identifier of test
     */
    public String getTargetURI() {
        return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/namednodemapsetnameditemns01";
    }

}
