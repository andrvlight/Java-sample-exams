package rental.tests;

import java.util.Locale;

import org.junit.jupiter.api.BeforeAll;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
	CarRentalTestSuite.StructuralTests.class,
	CarRentalTestSuite.FunctionalTests.class
})
public class CarRentalTestSuite {
	@Suite
	@SelectClasses({
	      CarStructureTest.class
	    , CarRentalStructureTest.class
	})
	public static class StructuralTests {}

	@Suite
	@SelectClasses({
		  CarTest.class
		, CarRentalTest1.class
		, CarRentalTest2.class
		, CarRentalTest3.class
	})
	public static class FunctionalTests {}

}
