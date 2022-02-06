/*
This Java source file was generated by test-to-java.xsl
and is a derived work from the source document.
The source document contained the following notice:


Copyright (c) 2004 World Wide Web Consortium,
(Massachusetts Institute of Technology, Institut National de
Recherche en Informatique et en Automatique, Keio University). All
Rights Reserved. This program is distributed under the W3C's Software
Intellectual Property License. This program is distributed in the
hope that it will be useful, but WITHOUT ANY WARRANTY; without even
the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
PURPOSE.
See W3C License http://www.w3.org/Consortium/Legal/ for more details.

*/

package org.w3c.domts.level2.core;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.NamedNodeMap;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.w3c.domts.DOMTest.load;


/**
 * An attempt to add remove an entity using removeNamedItemNS should result in
 * a NO_MODIFICATION_ERR or a NOT_FOUND_ERR.
 *
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-1788794630">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-1788794630</a>
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-removeNamedItemNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-removeNamedItemNS</a>
 */
public class hc_entitiesremovenameditemns1 {
    @Test
    @Disabled
    public void testRun() throws Throwable {
        Document doc = load("hc_staff", true);
        DocumentType docType = doc.getDoctype();
        NamedNodeMap entities = docType.getEntities();

        DOMException ex = assertThrows(DOMException.class, () -> entities.removeNamedItemNS("http://www.w3.org/1999/xhtml", "alpha"));
        assertTrue(ex.code == 7 || ex.code == 8, "throw_NO_MOD_OR_NOT_FOUND_ERR");
    }

    /**
     * Gets URI that identifies the test
     *
     * @return uri identifier of test
     */
    public String getTargetURI() {
        return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/hc_entitiesremovenameditemns1";
    }

}
