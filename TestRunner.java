import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Class to provided testing utility. Custom unit testing framework. Used in place
 * of Junit4 due to its incompatibility with Zylabs.
 *
 * @author Stephen
 * @version 2019-02-06
 */
public class TestRunner
{
	/**
	 * The test classes to run. E.g. if you have a class named "Animal", you likely have
	 * a test class named "AnimalTest". You should add "AnimalTest" along with any other
	 * test classes to this array.
	 *
	 * THIS IS ONLY PART OF THIS CLASS THAT YOU SHOULD MODIFY.
	 */
	private static String[] testClasses = {
			"StackRestaurantTest","QueueRestaurantTest","PriorityQueueRestaurantTest"
	};

	/**
	 * Main method. DO NOT MODIFY.
	 *
	 * @param args Program args.
	 */
	public static void main(String[] args)
	{
		for (String className : testClasses)
		{
			// Track if tests pass:
			boolean allPassed = true;
			try {
				// Get an instance of the class from the name:
				Object classInstance = Class.forName(className).newInstance();

				// Get all methods declared (i.e. not inherited) from the class:
				Method[] methods = Class.forName(className).getDeclaredMethods();

				// Run all tests, assuming that there are no helper methods:
				for (Method mth : methods)
		        {
					boolean passed = true;
					Exception error = null;
					// Try to execute the method:
					try {
			            mth.invoke(classInstance);
					}
			        catch(InvocationTargetException e)
			        {
			        	passed = false;
			        	error = e;
			        }
					catch(IllegalAccessException e)
					{
			        	passed = false;
			        	error = e;
					}
					catch(IllegalArgumentException e)
					{
			        	passed = false;
			        	error = e;
					}

					// Report if test passed or not:
					if (passed)
					{
						System.out.println(mth.getName() + " ---- passed");
					}
					else
					{
						System.out.println(mth.getName() + " ---- failed");
						error.printStackTrace(System.out);
						System.out.println("\n");
						allPassed = false;
					}
		        }
			}
			catch (ClassNotFoundException e)
			{
				String errorMessage = String.format("Could not find the class: %s, check the testClasses variable"
						+ "and make sure the name matches exactly.", className);
				System.out.println(errorMessage);
				allPassed = false;
			}
			catch (InstantiationException e)
			{
				e.printStackTrace();
				allPassed = false;
			}
			catch (IllegalAccessException e)
			{
				allPassed = false;
				e.printStackTrace();
			}

			// Report if test passed or not:
			if (allPassed)
			{
				System.out.println(className + " ---- passed");
			}
			else
			{
				System.out.println(className + " ---- failed");
			}
		}
	}
}
