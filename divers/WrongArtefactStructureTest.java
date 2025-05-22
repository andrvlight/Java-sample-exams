import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.MethodOrderer.*;
import check.*;

@TestMethodOrder(OrderAnnotation.class)
public class WrongArtefactStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theCheckedException("person.util.WrongArtefact")
                 .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
                 ;
    }

    @Test @DisabledIf(notApplicable) @Order(2_00)
    public void constructor1() {
        it.hasConstructor(withParams("message: String"))
            .thatIs(VISIBLE_TO_ALL)
            .thatCalls(theParent());
    }

}

