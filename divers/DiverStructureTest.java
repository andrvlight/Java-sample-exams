import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.MethodOrderer.*;
import check.*;

@TestMethodOrder(OrderAnnotation.class)
public class DiverStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("person.divers.Diver")
                 .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
                 ;
    }

    @Test @DisabledIf(notApplicable) @Order(1_00)
    public void fieldArtefacts() {
        it.hasField("artefacts: ArrayList of environment.collectables.Artefact")
          .thatIs(INSTANCE_LEVEL, NOT_MODIFIABLE, VISIBLE_TO_NONE);
    }

    @Test @DisabledIf(notApplicable) @Order(1_01)
    public void fieldTitle() {
        it.hasField("teamId: String")
          .thatIs(INSTANCE_LEVEL, NOT_MODIFIABLE, VISIBLE_TO_NONE);
    }

    @Test @DisabledIf(notApplicable) @Order(1_02)
    public void fieldSpecialityColor() {
        it.hasField("specialityColor: environment.marker.Color")
          .thatIs(INSTANCE_LEVEL, NOT_MODIFIABLE, VISIBLE_TO_NONE);
    }

    @Test @DisabledIf(notApplicable) @Order(2_00)
    public void constructor01() {
        it.hasConstructor(withParams("teamId: String", "color: environment.marker.Color"))
          .thatIs(VISIBLE_TO_ALL);
    }

    @Test @DisabledIf(notApplicable) @Order(2_01)
    public void constructor02() {
        it.hasConstructor(withNoParams())
          .thatIs(VISIBLE_TO_ALL);
    }

    @Test @DisabledIf(notApplicable) @Order(3_00)
    public void methodGetArtefacts() {
        it.hasMethod("getArtefacts", withNoParams())
          .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
          .thatReturns("ArrayList of environment.collectables.Artefact");
    }

    @Test @DisabledIf(notApplicable) @Order(3_01)
    public void methodGetColor() {
        it.hasMethod("getColor", withNoParams())
          .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
          .thatReturns("environment.marker.Color");
    }

    @Test @DisabledIf(notApplicable) @Order(3_02)
    public void methodGetTeamId() {
        it.hasMethod("getTeamId", withNoParams())
          .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
          .thatReturns("String");
    }

    @Test @DisabledIf(notApplicable) @Order(3_03)
    public void methodTagArtefacts() {
        it.hasMethod("tagArtefacts", withParams("toTag: ArrayList of environment.collectables.Artefact"))
          .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
          .thatReturnsNothing();
    }

    @Test @DisabledIf(notApplicable) @Order(3_04)
    public void methodTryToGetArtefact() {
        it.hasMethod("tryToGetArtefact", withParams("artefact: environment.collectables.Artefact"))
          .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
          .thatReturns("boolean");
    }

    @Test @DisabledIf(notApplicable) @Order(3_05)
    public void methodForceInsertArtefact() {
        it.hasMethod("forceInsertArtefact", withParams("artefact: environment.collectables.Artefact"))
          .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
          .thatReturnsNothing();
    }
}
