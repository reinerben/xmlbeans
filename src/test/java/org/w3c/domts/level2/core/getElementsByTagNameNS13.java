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
 * The "getElementsByTagNameNS(namespaceURI,localName)" method returns a NodeList
 * of all descendant Elements with a given local name and namespace URI in the
 * order in which they are encountered in a preorder traversal of this Element tree.
 * Create a NodeList of all the descendant elements
 * using the "http://www.nomatch.com" as the namespaceURI and "address" as the
 * localName.
 * The method should return a NodeList whose length is
 * "0".
 * * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-1938918D">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-1938918D</a>
 */
public class getElementsByTagNameNS13 {
    @Test
    void testRun() throws Throwable {
        Document doc = load("staffNS", false);
        Element docElem = doc.getDocumentElement();
        NodeList elementList = docElem.getElementsByTagNameNS("http://www.nomatch.com", "address");
        assertEquals(0, elementList.getLength(), "matchSize");
    }

    /**
     * Gets URI that identifies the test
     *
     * @return uri identifier of test
     */
    public String getTargetURI() {
        return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/getElementsByTagNameNS13";
    }

}
