import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.MethodOrderer.*;
import check.*;

@TestMethodOrder(OrderAnnotation.class)
public class DumperStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("person.Dumper")
                 .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
                 ;
    }

    @Test @DisabledIf(notApplicable) @Order(2_00)
    public void constructor01() {
        it.hasConstructor(withNoParams())
          .thatIs(VISIBLE_TO_ALL);
    }

    @Test @DisabledIf(notApplicable) @Order(3_00)
    public void methodDumpArtefacts() {
        it.hasMethod("dumpArtefacts", withParams("n: int"))
          .thatIs(FULLY_IMPLEMENTED, USABLE_WITHOUT_INSTANCE, VISIBLE_TO_ALL)
          .thatReturns("ArrayList of environment.collectables.Artefact");
    }

}
