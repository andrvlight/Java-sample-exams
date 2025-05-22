import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.MethodOrderer.*;
import check.*;

@TestMethodOrder(OrderAnnotation.class)
public class ArtefactStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("environment.collectables.Artefact",  withInterface("environment.marker.Marked"))
                 .thatIs(NOT_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
                 ;
    }

    @Test @DisabledIf(notApplicable) @Order(1_00)
    public void fieldLocationData() {
        it.hasField("locationData: String")
          .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_SUBCLASSES);
    }

    @Test @DisabledIf(notApplicable) @Order(1_02)
    public void fieldColor() {
        it.hasField("color: environment.marker.Color")
          .thatIs(INSTANCE_LEVEL, NOT_MODIFIABLE, VISIBLE_TO_SUBCLASSES);
    }

    @Test @DisabledIf(notApplicable) @Order(1_01)
    public void fieldRigidStructure() {
        it.hasField("rigidStructure: boolean")
          .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE);
    }

    @Test @DisabledIf(notApplicable) @Order(2_00)
    public void constructor01() {
        it.hasConstructor(withParams("locationData: String", "color: environment.marker.Color"))
          .thatIs(VISIBLE_TO_ALL);
    }

    @Test @DisabledIf(notApplicable) @Order(3_00)
    public void methodGetColor() {
        it.hasMethod("getColor", withNoParams())
          .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
          .thatReturns("environment.marker.Color");
    }

    @Test @DisabledIf(notApplicable) @Order(3_01)
    public void methodGetLocationData() {
        it.hasMethod("getLocationData", withNoParams())
          .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
          .thatReturns("String");
    }

    @Test @DisabledIf(notApplicable) @Order(3_02)
    public void methodGetRigidStructure() {
        it.hasMethod("getRigidStructure", withNoParams())
          .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
          .thatReturns("boolean");
    }

    @Test @DisabledIf(notApplicable) @Order(3_03)
    public void methodTryToGetArtefact() {
        it.hasMethod("setRigidStructure", withParams("rigidStructure: boolean"))
          .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
          .thatReturnsNothing();
    }

    @Test @DisabledIf(notApplicable) @Order(3_04)
    public void methodExtendLocationData() {
        it.hasMethod("extendLocationData", withParams("newData: String"))
          .thatIs(NOT_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
          .thatReturnsNothing();
    }

    @Test @DisabledIf(notApplicable) @Order(3_05)
    public void methodRetrieve() {
        it.hasMethod("retrieve", withNoParams())
          .thatIs(NOT_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
          .thatReturns("environment.collectables.Artefact");
    }

    @Test @DisabledIf(notApplicable) @Order(3_06)
    public void text() {
        it.has(TEXTUAL_REPRESENTATION);
    }

    @Test @DisabledIf(notApplicable) @Order(3_07)
    public void eq() {
        it.has(EQUALITY_CHECK);
    }
}
