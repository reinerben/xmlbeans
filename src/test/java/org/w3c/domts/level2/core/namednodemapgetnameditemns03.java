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
import org.w3c.dom.NamedNodeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.w3c.domts.DOMTest.load;


/**
 * The method getNamedItemNS retrieves a node specified by local name and namespace URI.
 * Create a new Element node and add 2 new attribute nodes having the same local name but different
 * namespace names and namespace prefixes to it.  Using the getNamedItemNS retreive the second attribute node.
 * Verify if the attr node has been retreived successfully by checking its nodeName atttribute.
 *
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getNamedItemNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getNamedItemNS</a>
 */
public class namednodemapgetnameditemns03 {
    @Test
    void testRun() throws Throwable {
        String attrName;
        Document doc = load("staffNS", false);
        Element element = doc.createElementNS("http://www.w3.org/DOM/Test", "root");
        Attr newAttr1 = doc.createAttributeNS("http://www.w3.org/DOM/L1", "L1:att");
        element.setAttributeNodeNS(newAttr1);
        Attr newAttr2 = doc.createAttributeNS("http://www.w3.org/DOM/L2", "L2:att");
        element.setAttributeNodeNS(newAttr2);
        NamedNodeMap attributes = element.getAttributes();
        Attr attribute = (Attr) attributes.getNamedItemNS("http://www.w3.org/DOM/L2", "att");
        attrName = attribute.getNodeName();
        assertEquals("L2:att", attrName, "namednodemapgetnameditemns03");
    }

    /**
     * Gets URI that identifies the test
     *
     * @return uri identifier of test
     */
    public String getTargetURI() {
        return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/namednodemapgetnameditemns03";
    }

}
