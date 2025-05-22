import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import environment.collectables.ArtefactTest;
import environment.DivingOperationTest;

@SelectClasses({
      DiversTestSuite.StructuralTests.class
    , DiversTestSuite.FunctionalTests.class
})
@Suite public class DiversTestSuite {
    @SelectClasses({
        ArtefactStructureTest.class,
		SampleStructureTest.class,
        WasteStructureTest.class,
        ColorStructureTest.class,
        MarkedStructureTest.class,
		ArtefactTestStructureTest.class

        ,

        DiverStructureTest.class,
        InvalidOperationStructureTest.class,
        WrongArtefactStructureTest.class,
        DumperStructureTest.class

        ,

        DivingOperationStructureTest.class
    })
    @Suite public static class StructuralTests {}

    @SelectClasses({
        ArtefactTest.class,
        DivingOperationTest.class
    })
    @Suite public static class FunctionalTests {}
}
