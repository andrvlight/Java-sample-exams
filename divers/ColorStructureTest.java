import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.MethodOrderer.*;
import check.*;

@TestMethodOrder(OrderAnnotation.class)
public class ColorStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theEnum("environment.marker.Color")
                 .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
                 ;
    }

    @Test @DisabledIf(notApplicable) @Order(1_00)
    public void fieldRED() {
        it.hasField("RED: Color")
          .thatIs(USABLE_WITHOUT_INSTANCE, NOT_MODIFIABLE, VISIBLE_TO_ALL);
    }

    @Test @DisabledIf(notApplicable) @Order(1_01)
    public void fieldGREEN() {
        it.hasField("GREEN: Color")
          .thatIs(USABLE_WITHOUT_INSTANCE, NOT_MODIFIABLE, VISIBLE_TO_ALL);
    }

    @Test @DisabledIf(notApplicable) @Order(1_02)
    public void fieldBLUE() {
        it.hasField("BLUE: Color")
          .thatIs(USABLE_WITHOUT_INSTANCE, NOT_MODIFIABLE, VISIBLE_TO_ALL);
    }

}
