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
import org.w3c.dom.NodeList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.w3c.domts.DOMTest.load;


/**
 * The "hasAttributes()" method for a node should
 * return false if the node does not have an attribute.
 * <p>
 * Retrieve the first "name" node and invoke the "hasAttributes()" method.
 * The method should return false since the node does not have an attribute.
 *
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeHasAttrs">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeHasAttrs</a>
 */
public class hasAttributes01 {
    @Test
    void testRun() throws Throwable {
        Document doc = load("staff", false);
        NodeList addrList = doc.getElementsByTagName("name");
        Node addrNode = addrList.item(0);
        boolean state = addrNode.hasAttributes();
        assertFalse(state, "throw_False");
    }

    /**
     * Gets URI that identifies the test
     *
     * @return uri identifier of test
     */
    public String getTargetURI() {
        return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/hasAttributes01";
    }

}
