/**
 * Lab 9
 *
 * Test suite for the PriorityQueueRestaurant class.
 *
 * @author Em Evans
 * @version 2019-10-14
 *
 */
public class PriorityQueueRestaurantTest {

	private PriorityQueueRestaurant<String> pqueue;
	
	public void initialize() throws AssertException
	{
		pqueue = new PriorityQueueRestaurant<String>();
	}
	/**
	 * test addOrder()
	 * @throws AssertException
	 */
	public void testAddOrder() throws AssertException 
	{
		pqueue = new PriorityQueueRestaurant<String>();
		//TODO: implement this
		Order<String> order = new Order<String>("Sandwich", 5);
		Assert.assertTrue(pqueue.addOrder(order));
		Assert.assertEquals(order,pqueue.completeOrder());
	}
	/**
	 * test completeOrder() using at least three orders
	 * show the ordering specific to priority queue
	 * 
	 * @throws AssertException
	 */
	
	//I keep failing this test
	public void testCompleteOrder() throws AssertException 
	{
		pqueue = new PriorityQueueRestaurant<String>();
		//TODO: implement this
		Assert.assertNull(pqueue.checkNextCompletedOrder());
		Order<String> order1 = new Order<String>("Sandwich", 2);
		Order<String> order2 = new Order<String>("Sandwich", 3);
		Order<String> order3 = new Order<String>("Sandwich", 1);
		pqueue.addOrder(order1);
		pqueue.addOrder(order2);
		pqueue.addOrder(order3);
		Assert.assertEquals(order3, pqueue.completeOrder());
		Assert.assertEquals(order1, pqueue.completeOrder());
		Assert.assertEquals(order2, pqueue.completeOrder());
	}
	/**
	 * test numberRemainingOrder() with at least 2 orders
	 * 
	 * @throws AssertException
	 */
	public void testNumberRemainingOrder() throws AssertException 
	{
		pqueue = new PriorityQueueRestaurant<String>();
		//TODO: implement this
		Order<String> order1 = new Order<String>("Mac", 1);
		Order<String> order2 = new Order<String>("Cheese", 1);
		pqueue.addOrder(order1);
		pqueue.addOrder(order2);
		Assert.assertEquals(2, pqueue.numberRemainingOrder());
		pqueue.completeOrder();
		pqueue.completeOrder();
	}
	/**
	 * test both cases of completeOrder
	 * @throws AssertException
	 */
	public void testCheckNextCompletedOrder() throws AssertException 
	{
		pqueue = new PriorityQueueRestaurant<String>();
		//TODO: implement this
		Assert.assertNull(pqueue.checkNextCompletedOrder());
		Order<String> order = new Order<String>("Sandwich", 5);
		pqueue.addOrder(order);
		Assert.assertEquals(order, pqueue.checkNextCompletedOrder());
		pqueue.completeOrder();
	}
}
