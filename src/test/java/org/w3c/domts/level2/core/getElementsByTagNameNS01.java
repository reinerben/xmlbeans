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
import org.w3c.dom.NodeList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.w3c.domts.DOMTest.load;


/**
 * The "getElementsByTagNameNS(namespaceURI,localName)" method for a
 * Document should return a new NodeList of all Elements that have a namespace
 * when local name is specified as ' '.
 * <p>
 * Invoke method getElementsByTagNameNS(namespaceURI,localName) on this document
 * with namespaceURI and localName as " ".
 * Method should return a new NodeList of 37 elements.
 *
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getElBTNNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getElBTNNS</a>
 */

/**
 *
 */

public class getElementsByTagNameNS01 {
    @Test
    void testRun() throws Throwable {
        String namespaceURI = "*";
        String localName = "*";
        Document doc = load("staffNS", false);
        NodeList newList = doc.getElementsByTagNameNS(namespaceURI, localName);

        //Yana: claim is 37, I counted 36
        assertEquals(36, newList.getLength(), "throw_Size");
    }

    /**
     * Gets URI that identifies the test
     *
     * @return uri identifier of test
     */
    public String getTargetURI() {
        return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/getElementsByTagNameNS01";
    }

}
