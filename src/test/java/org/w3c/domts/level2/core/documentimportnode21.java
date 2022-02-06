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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.w3c.domts.DOMTest.load;


/**
 * The importNode method imports a node from another document to this document.
 * The returned node has no parent; (parentNode is null). The source node is not
 * altered or removed from the original document but a new copy of the source node
 * is created.
 * Using the method importNode with deep=true, retreive the entity refs present in the
 * second element node whose tagName is address and import these nodes into another document.
 * Verify if the nodes have been imported correctly by checking the nodeNames of the
 * imported nodes, since they are imported into a new document which doesnot have thes defined,
 * the imported nodes should not have any children.
 * Now import the entityRef nodes into the same document and verify if the nodes have been
 * imported correctly by checking the nodeNames of the imported nodes, and by checking the
 * value of the replacement text of the imported nodes.
 *
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core">http://www.w3.org/TR/DOM-Level-2-Core/core</a>
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode">http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode</a>
 */
public class documentimportnode21 {
    @Test
    @Disabled
    public void testRun() throws Throwable {
        DocumentType docTypeNull = null;

        Document doc = load("staffNS", true);
        DOMImplementation domImpl = doc.getImplementation();
        Document docImp = domImpl.createDocument("http://www.w3.org/DOM/Test", "a:b", docTypeNull);
        NodeList addressList = doc.getElementsByTagName("address");
        Element element = (Element) addressList.item(1);
        NodeList addressChildList = element.getChildNodes();
        assertTrue(addressChildList.item(0) instanceof EntityReference, addressChildList.item(0).getClass().getName());
        assertTrue(addressChildList.item(2) instanceof EntityReference, addressChildList.item(2).getClass().getName());
        EntityReference entRef2 = (EntityReference) addressChildList.item(0);
        EntityReference entRef3 = (EntityReference) addressChildList.item(2);
        EntityReference entRefImp2 = (EntityReference) docImp.importNode(entRef2, true);
        EntityReference entRefImp3 = (EntityReference) docImp.importNode(entRef3, false);
        String nodeName2 = entRef2.getNodeName();
        String nodeName3 = entRef3.getNodeName();
        String nodeNameImp2 = entRefImp2.getNodeName();
        String nodeNameImp3 = entRefImp3.getNodeName();
        assertEquals(nodeName2, nodeNameImp2, "documentimportnode21_Ent2NodeName");
        assertEquals(nodeName3, nodeNameImp3, "documentimportnode21_Ent3NodeName");
        entRefImp2 = (EntityReference) doc.importNode(entRef2, true);
        entRefImp3 = (EntityReference) doc.importNode(entRef3, false);
        NodeList nodes = entRefImp2.getChildNodes();
        Node nodeImp2 = nodes.item(0);
        String nodeValueImp2 = nodeImp2.getNodeValue();
        nodes = entRefImp3.getChildNodes();
        Node nodeImp3 = nodes.item(0);
        String nodeValueImp3 = nodeImp3.getNodeValue();
        assertEquals("1900 Dallas Road", nodeValueImp2, "documentimportnode21_Ent2NodeValue");
        assertEquals("Texas", nodeValueImp3, "documentimportnode21_Ent3Nodevalue");
    }

    /**
     * Gets URI that identifies the test
     *
     * @return uri identifier of test
     */
    public String getTargetURI() {
        return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/documentimportnode21";
    }

}
