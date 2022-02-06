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


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.w3c.dom.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.w3c.domts.DOMTest.assertURIEquals;
import static org.w3c.domts.DOMTest.load;


/**
 * The "importNode(importedNode,deep)" method for a
 * Document should import the given importedNode into that Document.
 * The importedNode is of type Attr.
 * The ownerElement is set to null. Specified flag is set to true.
 * Children is imported.
 * Create a new attribute whose name is "elem:attr1" in a different document.
 * Create a child Text node with value "importedText" for the attribute node above.
 * Invoke method importNode(importedNode,deep) on this document with
 * importedNode being the newly created attribute.
 * Method should return a node whose name matches "elem:attr1" and a child node
 * whose value equals "importedText".
 * The returned node should belong to this document whose systemId is "staff.dtd"
 *
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode">http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode</a>
 */
public class importNode01 {
    @Test
    @Disabled
    public void testRun() throws Throwable {
        Document doc = load("staffNS", true);
        Document aNewDoc = load("staffNS", true);
        Attr newAttr = aNewDoc.createAttribute("elem:attr1");
        Text importedChild = aNewDoc.createTextNode("importedText");
        Node aNode = newAttr.appendChild(importedChild);
        aNode = doc.importNode(newAttr, false);
        Document ownerDocument = aNode.getOwnerDocument();
        DocumentType docType = ownerDocument.getDoctype();
        String system = docType.getSystemId();
        assertNotNull(aNode, "aNode");
        assertURIEquals("systemId", "staffNS.dtd", system);
        Element attrOwnerElement = ((Attr) /*Node */aNode).getOwnerElement();
        assertNull(attrOwnerElement, "ownerElement");
        boolean specified = ((Attr) /*Node */aNode).getSpecified();
        assertTrue(specified, "specified");
        NodeList childList = aNode.getChildNodes();
        assertEquals(1, childList.getLength(), "childList");
        String nodeName = aNode.getNodeName();
        assertEquals("elem:attr1", nodeName, "nodeName");
        Node child = aNode.getFirstChild();
        String childValue = child.getNodeValue();
        assertEquals("importedText", childValue, "childValue");
    }

    /**
     * Gets URI that identifies the test
     *
     * @return uri identifier of test
     */
    public String getTargetURI() {
        return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/importNode01";
    }

}
