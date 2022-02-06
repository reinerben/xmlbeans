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
import org.w3c.dom.Node;
import org.w3c.dom.Text;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.w3c.domts.DOMTest.load;


/**
 * The "importNode(importedNode,deep)" method for a
 * Document should import the given importedNode into that Document.
 * The importedNode is of type Text.
 * Create a text node with value being the string "this is text data" in
 * a different document.  Invoke method importNode(importedNode,deep) on
 * this document.  Method should return a text node whose value matches
 * the above string. The returned node should belong to this document
 * whose systemId is "staff.dtd"
 *
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode">http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode</a>
 */
public class importNode15 {
    @Test
    void testRun() throws Throwable {
        Document doc = load("staffNS", true);
        Document aNewDoc = load("staffNS", true);
        Text text = aNewDoc.createTextNode("this is text data");
        Node aNode = doc.importNode(text, false);
        // TODO: add this if ever implemented
        // DocumentType docType = ownerDocument.getDoctype();
        // String system = docType.getSystemId();
        // assertURIEquals("systemId", null, null, null, "staffNS.dtd", null, null, null, null, system);
        String value = aNode.getNodeValue();
        assertEquals("this is text data", value, "nodeValue");
    }

    /**
     * Gets URI that identifies the test
     *
     * @return uri identifier of test
     */
    public String getTargetURI() {
        return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/importNode15";
    }

}
