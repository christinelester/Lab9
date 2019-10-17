/**
 * THIS CLASS IS PROVIDED TO YOU. DO NOT MODIFY IT.
 *
 * Exception thrown when an Assertion fails. Indicates that the test has failed.
 *
 * @author Stephen
 * @version 2019-02-06
 */
public class AssertException extends Exception
{
	/**
	 * Default serial ID.
	 */
	private static final long serialVersionUID = 1L;

	public AssertException(String description)
	{
		super(description);
	}
}

