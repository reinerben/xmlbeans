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
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.w3c.domts.DOMTest.load;


/**
 * The method createDocumentType with valid values for qualifiedName, publicId and
 * systemId should create an empty DocumentType node.
 * <p>
 * Invoke createDocument on this DOMImplementation with a valid qualifiedName and different
 * publicIds and systemIds.  Check if the the DocumentType node was created with its
 * ownerDocument attribute set to null.
 *
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Level-2-Core-DOM-createDocument">http://www.w3.org/TR/DOM-Level-2-Core/core#Level-2-Core-DOM-createDocument</a>
 */
public class domimplementationcreatedocumenttype01 {
    @Test
    @Disabled
    public void testRun() throws Throwable {
        String qualifiedName = "test:root";
        String[] publicIds = { "1234", "test" };
        String[] systemIds = { "", "test" };

        Document doc = load("staffNS", false);
        DOMImplementation domImpl = doc.getImplementation();
        for (String publicId : publicIds) {
            for (String systemId : systemIds) {
                DocumentType newDocType = domImpl.createDocumentType(qualifiedName, publicId, systemId);
                assertNotNull(newDocType, "domimplementationcreatedocumenttype01_newDocType");
                Document ownerDocument = newDocType.getOwnerDocument();
                assertNull(ownerDocument, "domimplementationcreatedocumenttype01_ownerDocument");
            }
        }
    }

    /**
     * Gets URI that identifies the test
     *
     * @return uri identifier of test
     */
    public String getTargetURI() {
        return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/domimplementationcreatedocumenttype01";
    }

}
