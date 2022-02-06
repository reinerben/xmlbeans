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
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.w3c.domts.DOMTest.load;


/**
 * The method getElementsByTagNameNS returns a NodeList of all the Elements with
 * a given local name and namespace URI in the order in which they are encountered
 * in a preorder traversal of the Document tree.
 * Create a new element having a local name="employeeId" belonging to the namespace "test"
 * and append it to this document.  Invoke the getElementsByTagNameNS method on a this
 * Document object with the values of namespaceURI=* and localName="elementId".  This
 * should return a nodeList of 6 item.  Check the length of the nodeList returned.
 *
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core">http://www.w3.org/TR/DOM-Level-2-Core/core</a>
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getElBTNNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getElBTNNS</a>
 */
public class documentgetelementsbytagnameNS02 {
    @Test
    void testRun() throws Throwable {
        Document doc = load("staffNS", true);
        Element docElem = doc.getDocumentElement();
        Element element = doc.createElementNS("test", "employeeId");
        docElem.appendChild(element);
        NodeList childList = doc.getElementsByTagNameNS("*", "employeeId");
        assertEquals(6, childList.getLength(), "documentgetelementsbytagnameNS02");
    }

    /**
     * Gets URI that identifies the test
     *
     * @return uri identifier of test
     */
    public String getTargetURI() {
        return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/documentgetelementsbytagnameNS02";
    }

}
