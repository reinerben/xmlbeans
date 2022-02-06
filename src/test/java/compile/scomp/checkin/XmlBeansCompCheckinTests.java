/*   Copyright 2004 The Apache Software Foundation
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package compile.scomp.checkin;

import compile.scomp.common.mockobj.TestFiler;
import org.apache.xmlbeans.*;
import org.apache.xmlbeans.impl.schema.SchemaTypeSystemImpl;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static common.Common.OUTPUTROOT;
import static compile.scomp.common.CompileTestBase.ERR_XSD;
import static compile.scomp.common.CompileTestBase.FOR_XSD;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

public class XmlBeansCompCheckinTests {
    private final List<XmlError> xm_errors = new ArrayList<>();
    private final XmlOptions xm_opts = new XmlOptions();
    private final List<String> expBinType;
    private final List<String> expSrcType;

    public XmlBeansCompCheckinTests() {
        expBinType = Arrays.asList(
            "org/apache/xmlbeans/metadata/system/apiCompile/atypedb57type.xsb",
            "org/apache/xmlbeans/metadata/system/apiCompile/elname429edoctype.xsb",
            "org/apache/xmlbeans/metadata/system/apiCompile/elnameelement.xsb",
            "org/apache/xmlbeans/metadata/system/apiCompile/index.xsb",
            "org/apache/xmlbeans/metadata/element/http_3A_2F_2Fbaz/elName.xsb",
            "org/apache/xmlbeans/metadata/type/http_3A_2F_2Fbaz/aType.xsb",
            "org/apache/xmlbeans/metadata/namespace/http_3A_2F_2Fbaz/xmlns.xsb",
            "org/apache/xmlbeans/metadata/javaname/baz/ElNameDocument.xsb",
            "org/apache/xmlbeans/metadata/javaname/baz/AType.xsb"
        );

        expSrcType = Arrays.asList(
            "org.apache.xmlbeans.metadata.system.apiCompile.TypeSystemHolder",
            "baz.AType",
            "baz.impl.ATypeImpl",
            "baz.ElNameDocument",
            "baz.impl.ElNameDocumentImpl"
        );

        xm_opts.setErrorListener(xm_errors);
        xm_opts.setSavePrettyPrint();
    }

    @AfterEach
    public void tearDown() throws Exception {
        if (xm_errors.size() > 0)
            xm_errors.clear();
    }

    @Test
    void test_Filer_compilation() throws Exception {
        XmlObject obj1 = XmlObject.Factory.parse(FOR_XSD);
        XmlObject[] schemas = new XmlObject[]{obj1};

        TestFiler f = new TestFiler();
        XmlBeans.compileXmlBeans("apiCompile", null, schemas, null, XmlBeans.getBuiltinTypeSystem(), f, xm_opts);

        assertTrue(f.isCreateBinaryFile(), "Binary File method not invoked");
        assertTrue(f.isCreateSourceFile(), "Source File method not invoked");

        assertNotNull(f.getBinFileVec());
        MatcherAssert.assertThat(f.getBinFileVec(), is(expBinType));

        assertNotNull(f.getSrcFileVec());
        MatcherAssert.assertThat(f.getSrcFileVec(), is(expSrcType));
    }

    /**
     * Verify Partial SOM cannot be saved to file system
     */
    @Test
    void test_sts_noSave() throws Exception
    {
        XmlObject obj3 = XmlObject.Factory.parse(ERR_XSD);
        XmlObject[] schemas3 = new XmlObject[]{obj3};

        SchemaTypeSystem sts;
        ArrayList<XmlError> err = new ArrayList<>();
        XmlOptions opt = new XmlOptions().setErrorListener(err);
        opt.setCompilePartialTypesystem();

        try {
            // since you can't save a partial SOM, don't bother passing in a Filer
            sts = XmlBeans.compileXmlBeans(null,
                    null, schemas3, null,
                    XmlBeans.getBuiltinTypeSystem(), null, opt);
            boolean psom_expError = false;
            // print out the recovered xm_errors
            if (!err.isEmpty()) {
                System.out.println("Schema invalid: partial schema type system recovered");
                for (XmlError xErr : err) {
                    System.out.println(xErr);

                    if ((xErr.getErrorCode().compareTo("src-resolve") == 0) &&
                        (xErr.getMessage().compareTo("type 'bType@http://baz' not found.") == 0))
                        psom_expError = true;
                }
            }
            if (!psom_expError)
                throw new Exception("Error Code was not as Expected");

        } catch (XmlException e) {
            //The above case should be recoverable so
            // spit out debug statement and throw the error
            System.out.println("Schema invalid: couldn't recover from xm_errors");
            if (err.isEmpty())
                System.err.println(e.getMessage());
            else
                for (Object o : err) System.err.println(o);
            throw e;
        }

        assertTrue(((SchemaTypeSystemImpl)sts).isIncomplete(), "Expected partial schema type system");


        // Check using saveToDirectory on Partial SOM
        File tempDir = null;
        try {
            //setUp outputDirectory
            tempDir = new File(OUTPUTROOT, "psom_save");
            tempDir.mkdirs();
            tempDir.deleteOnExit();
            assertEquals(0, tempDir.listFiles().length, "Output Directory Init needed to be empty");

            //This should not Work
            sts.saveToDirectory(tempDir);
            Assertions.fail("Expected IllegalStateException");
        } catch (IllegalStateException e) {
            // ok
            System.out.println("sts.saveToDirectory() threw IllegalStateException as expected");
        }

        //make sure nothing was written
        assertEquals(0, tempDir.listFiles().length, "Partial SOM output dir needed to be empty");

        // Check using save(Filer) on Partial SOM
        TestFiler tf1 = new TestFiler();
        assertThrows(IllegalStateException.class, () -> sts.save(tf1));

        //make sure nothing was written
        assertEquals(0, tf1.getBinFileVec().size(), "Filer -Bin- Partial SOM output dir needed to be empty");
        assertEquals(0, tf1.getSrcFileVec().size(), "Filer -SRC- Partial SOM output dir needed to be empty");

        assertFalse(tf1.isCreateSourceFile(), "Filer Create Source File method should not have been invoked");

        assertFalse(tf1.isCreateBinaryFile(), "Filer Create Binary File method should not have been invoked");

        // Check using filer in partial SOM compilation
        TestFiler tf2 = new TestFiler();

        //reset data
        err.clear();

        //filer methods on partial SOM should not be returned
        XmlBeans.compileXmlBeans(null, null, schemas3, null, XmlBeans.getBuiltinTypeSystem(), tf2, opt);

        assertFalse(err.isEmpty(), "Errors was not empty");
        //make sure nothing was written
        assertEquals(0, tf2.getBinFileVec().size(), "Filer -Bin- Partial SOM output dir needed to be empty");
        assertEquals(0, tf2.getSrcFileVec().size(), "Filer -SRC- Partial SOM output dir needed to be empty");

        assertFalse(tf2.isCreateSourceFile(), "Filer Create Source File method should not have been invoked");

        assertFalse(tf2.isCreateBinaryFile(), "Filer Create Binary File method should not have been invoked");
    }

    /**
     * ensure that entry point properly handles
     * different configs with null values
     */
    @Test
    void test_entrypoint_nullVals() throws Exception {
        XmlObject[] schemas = {XmlObject.Factory.parse(FOR_XSD)};

        XmlBeans.compileXmlBeans(null, null, schemas, null, XmlBeans.getBuiltinTypeSystem(), null, null);

        XmlBeans.compileXmlBeans(null, null, null, null, XmlBeans.getBuiltinTypeSystem(), null, null);

        // svn revision 160341. SchemaTypeLoader is not expected to non null any more. All params can be null
        XmlBeans.compileXmlBeans(null, null, null, null, null, null, null);

        // svn revision 160341. SchemaTypeLoader is not expected to non null any more
        XmlBeans.compileXmlBeans(null, null, schemas, null, null, null, null);
    }
}
