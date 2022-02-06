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
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.EntityReference;
import org.w3c.dom.Node;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.w3c.domts.DOMTest.assertURIEquals;
import static org.w3c.domts.DOMTest.load;


/**
 * The "importNode(importedNode,deep)" method for a
 * Document should import the given importedNode into that Document.
 * The importedNode is of type Entity_Reference.
 * Only the EntityReference is copied, regardless of deep's value.
 * Create an entity reference whose name is "entRef1" in a different document.
 * Give it value "entRef1Value".
 * Invoke method importNode(importedNode,deep) on this document with importedNode
 * being "entRef1".
 * Method should return a node of type Entity_Reference (whose value is null) that
 * belongs to this document whose systemId is "staff.dtd".
 *
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode">http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode</a>
 */
public class importNode10 {
    @Test
    @Disabled
    public void testRun() throws Throwable {
        Document doc = load("staffNS", true);
        Document aNewDoc = load("staffNS", true);
        EntityReference entRef = aNewDoc.createEntityReference("entRef1");
        entRef.setNodeValue("entRef1Value");
        Node aNode = doc.importNode(entRef, false);
        Document ownerDocument = aNode.getOwnerDocument();
        DocumentType docType = ownerDocument.getDoctype();
        String system = docType.getSystemId();
        assertURIEquals("systemId", "staffNS.dtd", system);
        String name = aNode.getNodeName();
        assertEquals("entRef1", name, "nodeName");
    }

    /**
     * Gets URI that identifies the test
     *
     * @return uri identifier of test
     */
    public String getTargetURI() {
        return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/importNode10";
    }

}
