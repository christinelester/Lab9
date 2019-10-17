/**
 * THIS CLASS IS PROVIDED TO YOU. DO NOT MODIFY IT.
 *
 * Class to provided testing utility. Mimics Junit4's org.junit.Assert. Used in place
 * of Junit4 due to its incompatibility with Zylabs. Provides assertion utility for
 * ints, doubles, and objects (assumes the equals method is overriden).
 *
 * @author Stephen
 * @version 2019-02-07
 */
public class Assert
{
	/**
	 * Asserts that two values are equal. Throws an exception if they are not equal.
	 * If an AssertException is thrown the test has failed. The test or code should
	 * be amended to that no AssertExceptions are thrown.
	 *
	 * Several overrides are given to compare different data types.
	 *
	 * int comparisons are simple.
	 *
	 * @param expected The excepted value.
	 * @param actual The actual value.
	 * @throws AssertException Thrown if the expected value does not match the actual
	 * value.
	 */
	public static void assertEquals(int expected, int actual) throws AssertException
	{
		if (expected != actual)
		{
			String errorMessage = String.format("\n*******************************"
					+ "\n*** Test Results: *************"
					+ "\n*******************************\n"
					+ "Equality Error!\nExpected: %d\nActually: %d\n", expected, actual);
			throw new AssertException(errorMessage);
		}
	}

	/////////////////////
	// Override variants:
	/////////////////////
	/**
	 * Asserts that two values are equal. Throws an exception if they are not equal.
	 * If an AssertException is thrown the test has failed. The test or code should
	 * be amended to that no AssertExceptions are thrown.
	 *
	 * Several overrides are given to compare different data types.
	 *
	 * Floating point values should be tested to be equal within a certain delta
	 * tolerance. Often times floating point arithmetic will lead to some data loss, as
	 * the numbers cannot be perfectly represented due to bit limits (e.g. 1/3 or 0.3333333...).
	 * As such, two numbers may have the same operations done (*2, /4, *5) and should be
	 * equal, but due to losing some data they are not (5.000000000 vs. 5.0000000001). Using
	 * a delta value compares two numbers while accounting for data loss (5.000000000 is within
	 * 0.00001 of 5.0000000001, delta = 0.00001).
	 *
	 * @param expected The excepted value.
	 * @param actual The actual value.
	 * @param delta The allowable difference between the double values.
	 * @throws AssertException Thrown if the expected value does not match the actual value.
	 */
	public static void assertEquals(double expected, double actual, double delta) throws AssertException
	{
		if (Math.abs(expected - actual) > delta)
		{
			String errorMessage = String.format("\n*******************************"
					+ "\n*** Test Results: *************"
					+ "\n*******************************\n"
					+ "Equality Error!\nExpected: %f\nActually: %f\n"
					+ "Should be equal within a range of %f\n", expected, actual, delta);
			throw new AssertException(errorMessage);
		}
	}

	/**
	 * Asserts that two values are equal. Throws an exception if they are not equal.
	 * If an AssertException is thrown the test has failed. The test or code should
	 * be amended to that no AssertExceptions are thrown.
	 *
	 * Several overrides are given to compare different data types.
	 *
	 * This assertion relies on the equality method programmed into the objects.
	 *
	 * @param expected The excepted value.
	 * @param actual The actual value.
	 * @throws AssertException Thrown if the expected value does not match the actual value.
	 */
	public static void assertEquals(Object expected, Object actual) throws AssertException
	{
		if (!expected.equals(actual) || !actual.equals(expected))
		{
			String errorMessage = String.format("\n*******************************"
					+ "\n*** Test Results: *************"
					+ "\n*******************************\n"
					+ "Equality Error!\nExpected: %s\nActually: %s\n",
					expected.toString(), actual.toString());
			throw new AssertException(errorMessage);
		}
	}

	/**
	 * Asserts that two values are equal. Throws an exception if they are not equal.
	 * If an AssertException is thrown the test has failed. The test or code should
	 * be amended to that no AssertExceptions are thrown.
	 *
	 * Several overrides are given to compare different data types.
	 *
	 * boolean comparisons are simple.
	 *
	 * @param expected The excepted value.
	 * @param actual The actual value.
	 * @throws AssertException Thrown if the expected value does not match the actual
	 * value.
	 */
	public static void assertEquals(boolean expected, boolean actual) throws AssertException
	{
		if (expected != actual)
		{
			String errorMessage = String.format("\n*******************************"
					+ "\n*** Test Results: *************"
					+ "\n*******************************\n"
					+ "Equality Error!\nExpected: %s\nActually: %s\n", expected, actual);
			throw new AssertException(errorMessage);
		}
	}

	/**
	 * Asserts that a value is true.
	 *
	 * @param expected The actual value.
	 * @throws AssertException Thrown if the actual value does not equal true;
	 */
	public static void assertTrue(boolean actual) throws AssertException
	{
		assertEquals(true, actual);
	}

	/**
	 * Asserts that a value is false.
	 *
	 * @param expected The actual value.
	 * @throws AssertException Thrown if the actual value does not equal true;
	 */
	public static void assertFalse(boolean actual) throws AssertException
	{
		assertEquals(false, actual);
	}
	
	/**
	 * Asserts that an object is null 
	 * @param obj
	 * @throws AssertException Thrown if object value does not equal null
	 */
	public static void assertNull(Object obj) throws AssertException
	{
		if(obj != null)
		{
			throw new AssertException("test");
		}
	}

	//==================================================================================================================
	// Not equals:
	//==================================================================================================================

	/**
	 * Asserts that two values are not equal. Throws an exception if they are equal.
	 * If an AssertException is thrown the test has failed. The test or code should
	 * be amended to that no AssertExceptions are thrown.
	 *
	 * Several overrides are given to compare different data types.
	 *
	 * int comparisons are simple.
	 *
	 * @param first The first value.
	 * @param second The second value.
	 * @throws AssertException Thrown if the first value matches the second value.
	 */
	public static void assertNotEquals(int first, int second) throws AssertException
	{
		if (first == second)
		{
			String errorMessage = String.format("\n*******************************"
					+ "\n*** Test Results: *************"
					+ "\n*******************************\n"
					+ "Should not be equal!\nFirst value: %d\nSecond Value: %d\n", first, second);
			throw new AssertException(errorMessage);
		}
	}

	/**
	 * Asserts that two values are not equal. Throws an exception if they are equal.
	 * If an AssertException is thrown the test has failed. The test or code should
	 * be amended to that no AssertExceptions are thrown.
	 *
	 * Several overrides are given to compare different data types.
	 *
	 * Compares doubles within range.
	 *
	 * @param first The first value.
	 * @param second The second value.
	 * @param delta The float deviation.
	 * @throws AssertException Thrown if the first value matches the second value.
	 */
	public static void assertNotEquals(double first, double second, double delta) throws AssertException
	{
		if (Math.abs(first - second) < delta)
		{
			String errorMessage = String.format("\n*******************************"
					+ "\n*** Test Results: *************"
					+ "\n*******************************\n"
					+ "Should not be equal!\nFirst value: %f\nSecond value: %f\n"
					+ "Should not be equal within a range of %f\n", first, second, delta);
			throw new AssertException(errorMessage);
		}
	}

	/**
	 * Asserts that two values are not equal. Throws an exception if they are equal.
	 * If an AssertException is thrown the test has failed. The test or code should
	 * be amended to that no AssertExceptions are thrown.
	 *
	 * Several overrides are given to compare different data types.
	 *
	 * This assertion relies on the equality method programmed into the objects.
	 *
	 * @param first The first value.
	 * @param second The second value.
	 * @throws AssertException Thrown if the first value matches the second value.
	 */
	public static void assertNotEquals(Object first, Object second) throws AssertException
	{
		if (first.equals(second) || second.equals(first))
		{
			String errorMessage = String.format("\n*******************************"
					+ "\n*** Test Results: *************"
					+ "\n*******************************\n"
					+ "Should not be equal!\nFirst value: %s\nSecond value: %s\n",
					first.toString(), second.toString());
			throw new AssertException(errorMessage);
		}
	}

	//==================================================================================================================
	// Assert Fail:
	//==================================================================================================================
	/**
	 * Method to cause a test to fail (throws an AssertException). Useful when you need to test a condition that is not
	 * easily represented with an assert statement (e.g. catching an exception).
	 *
	 * @param errorMessage The reason that the assertion failed.
	 * @throws AssertException Always throws this.
	 */
	public static void fail(String errorMessage) throws AssertException
	{
		throw new AssertException(errorMessage);
	}
}

