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
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.w3c.domts.DOMTest.load;


/**
 * Returns a NodeList of all the Elements with a given local name and namespace URI in the
 * order in which they are encountered in a preorder traversal of the Document tree.
 * Create a new element node ('root') and append three newly created child nodes (all have
 * local name 'child' and defined in different namespaces).
 * Test 1: invoke getElementsByTagNameNS to retrieve one of the children.
 * Test 2: invoke getElementsByTagNameNS with the value of namespace equals to '*', and
 * verify that the node list has length of 3.
 *
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getElBTNNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getElBTNNS</a>
 * @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=259">http://www.w3.org/Bugs/Public/show_bug.cgi?id=259</a>
 */
public class elementgetelementsbytagnamens04 {
    @Test
    void testRun() throws Throwable {
        String nullNS = null;

        Document doc = load("staffNS", false);
        Element element = doc.createElementNS("http://www.w3.org/DOM", "root");
        Element child1 = doc.createElementNS("http://www.w3.org/DOM/Level1", "dom:child");
        Element child2 = doc.createElementNS(nullNS, "child");
        Element child3 = doc.createElementNS("http://www.w3.org/DOM/Level2", "dom:child");
        Node appendedChild = element.appendChild(child1);
        appendedChild = element.appendChild(child2);
        appendedChild = element.appendChild(child3);
        NodeList elementList = element.getElementsByTagNameNS(nullNS, "child");
        assertEquals(1, elementList.getLength(), "elementgetelementsbytagnamens04_1");
        elementList = element.getElementsByTagNameNS("*", "child");
        assertEquals(3, elementList.getLength(), "elementgetelementsbytagnamens04_2");
    }

    /**
     * Gets URI that identifies the test
     *
     * @return uri identifier of test
     */
    public String getTargetURI() {
        return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/elementgetelementsbytagnamens04";
    }

}
