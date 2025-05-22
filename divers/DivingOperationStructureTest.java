import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.MethodOrderer.*;
import check.*;

@TestMethodOrder(OrderAnnotation.class)
public class DivingOperationStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("environment.DivingOperation")
                 .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
                 ;
    }

    @Test @DisabledIf(notApplicable) @Order(1_00)
    public void fieldTeams() {
        it.hasField("teams: ArrayList of person.divers.Diver")
          .thatIs(INSTANCE_LEVEL, NOT_MODIFIABLE, VISIBLE_TO_ALL);
    }

    @Test @DisabledIf(notApplicable) @Order(1_01)
    public void fieldAllArtefacts() {
        it.hasField("allArtefacts: ArrayList of environment.collectables.Artefact")
          .thatIs(INSTANCE_LEVEL, NOT_MODIFIABLE, VISIBLE_TO_ALL);
    }

    @Test @DisabledIf(notApplicable) @Order(2_00)
    public void constructor01() {
        it.hasConstructor(withParams("totalTeams: int"))
          .thatIs(VISIBLE_TO_ALL);
    }

    @Test @DisabledIf(notApplicable) @Order(3_00)
    public void methodRegisterArtefacts() {
        it.hasMethod("registerArtefacts", withParams("artefact: vararg of environment.collectables.Artefact"))
          .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_NONE)
          .thatReturnsNothing();
    }

    @Test @DisabledIf(notApplicable) @Order(3_01)
    public void methodRegisterArtefact() {
        it.hasMethod("registerArtefact", withParams("artefact: environment.collectables.Artefact"))
          .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_NONE)
          .thatReturnsNothing();
    }

    @Test @DisabledIf(notApplicable) @Order(3_02)
    public void methodPrepareOperation() {
        it.hasMethod("prepareOperation", withParams("n: int"))
          .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
          .thatReturnsNothing();
    }

    @Test @DisabledIf(notApplicable) @Order(3_03)
    public void methodConductOperation() {
        it.hasMethod("conductOperation", withNoParams())
          .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
          .thatReturns("HashSet of environment.collectables.Artefact");
    }
}
