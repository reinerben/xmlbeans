/*
This Java source file was generated by test-to-java.xsl
and is a derived work from the source document.
The source document contained the following notice:



Copyright (c) 2001-2003 World Wide Web Consortium,
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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.w3c.domts.DOMTest.load;


/**
 * Using the method importNode with deep=true, import the fourth employee element node of this
 * Document.  Verify if the node has been imported correctly by checking
 * if the default attribute present on this node has not been imported
 * and an explicit attribute has been imported.
 *
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core">http://www.w3.org/TR/DOM-Level-2-Core/core</a>
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode">http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode</a>
 * @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=259">http://www.w3.org/Bugs/Public/show_bug.cgi?id=259</a>
 * @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=402">http://www.w3.org/Bugs/Public/show_bug.cgi?id=402</a>
 */
public class documentimportnode14 {
    @Test
    void testRun() throws Throwable {
        DocumentType nullDocType = null;
        String nullNS = null;

        Document doc = load("staffNS", true);
        NodeList childList = doc.getElementsByTagNameNS("*", "employee");
        Node employeeElem = childList.item(3);
        DOMImplementation domImpl = doc.getImplementation();
        Document newDoc = domImpl.createDocument(nullNS, "staff", nullDocType);
        Node imported = newDoc.importNode(employeeElem, true);
        Attr attrNode = ((Element) /*Node */imported).getAttributeNodeNS(nullNS, "defaultAttr");
        assertNull(attrNode, "defaultAttrNotImported");
        String attrValue = ((Element) /*Node */imported).getAttributeNS("http://www.w3.org/2000/xmlns/", "emp");
        assertEquals("http://www.nist.gov", attrValue, "explicitAttrImported");
    }

    /**
     * Gets URI that identifies the test
     *
     * @return uri identifier of test
     */
    public String getTargetURI() {
        return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/documentimportnode14";
    }

}
