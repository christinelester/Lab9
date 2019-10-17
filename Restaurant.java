/** 
 * Class representing a restaurant. Food orders may be added to a restaurant as Tickets and will be
 * stored in some way (how they are stored is up to the subclasses). The order in which Tickets are
 * completed is also dependent on the subclass' implementation of the abstract methods.
 * 
 * @author Stephen
 * @version 2018-10-10
 * 
 * @modified by Em Evans
 * @version 2019-09-27
 * lab 9
 * 
 */
public abstract class Restaurant<T>
{
	/**
	 *Adds an order to the restaurant.
	 *The restaurant will keep track of this order until it can be completed by completeOrder()
	 * @param order
	 * @return true if the order is successfully added. False otherwise.
	 */
	public abstract boolean addOrder(Order<T> order);
	 /**
     * Determines the number of orders that have been added to the restaurant that have not been completed.
     * i.e. the number of unfulfilled meal orders.
     * 
     * @return The number of orders in the restaurant yet to be completed.
     */
	protected abstract int numberRemainingOrder();
	
    /**
     * Gets the order that will next be completed. That is, gets the order that would be returned by completeOrder
     * without actually completing the order.
     * 
     * @return The order that will next be completed by the restaurant. null if there are no more tickets to
     * be completed.
     */
	protected abstract Order<T> checkNextCompletedOrder();
	
    /**
     * Uses the abstract methods numberRemainingOrder() and checkNextCompletedOrder()
     * 
     * Gets the current status of the restaurant. Specifically, we get information about the number of orders
     * remaining in the restaurant, and the description of the order that will next be completed.
     * 
     * It is recommended that you use String.format()
     * 
     * @return If there are no incomplete orders left in the restaurant, return the String:
     *    "No orders left."
     * Else, return a string of the format:
     *    "(number of orders in restaurant order list) orders left. Working on: (the toString() of the next order to be completed)"
     */
	public String getCurrentStatus()
	{
		Order<T> topOrder = checkNextCompletedOrder();
		if(topOrder == null)
		{
			return "No orders left.";
		}
		return String.format("%d orders left. Working on: %s", numberRemainingOrder(), topOrder);
	}
    /**
     * Completes an order by updating the underlying data structure of the restaurant. Each restaurant uses this
     * function to determine the order in which orders are completed. Once a orders has been completed, it should
     * be considered to be removed from the restaurant. A ticket may not be completed twice. A completed tickets
     * symbolizes a meal that has been prepared and delivered to a customer.
     * 
     * @return The next Ticket to be completed.
     *  null if there are no tickets to be completed.
     */
	protected abstract Order<T> completeOrder();
	
    /**
     * Uses the overloaded protected completeOrder method.
     * 
     * Completes an order and calculates the time it took to complete the order. The time to complete an order
     * is the difference between the time the order was completed and the time the order was
     * (i.e. the order's timeOrdered)
     * 
     * @param timeCompleted The time at which the order was completed.
     * @return A string of the format:
     *  "It took (time difference) time units to complete the following order: (toString of completed order)"
     *  if the are no orders to be created, returns:
     *  "No orders remain. Could not complete an Order."
     */
	public String completeOrder(int timeCompleted)
	{
		Order<T> completed = completeOrder();
		if(completed == null)
		{
			return "No orders remain. Could not complete an order.";
		}
		int timeOrdered = completed.getTimeOrdered();
		int timeToFinish = timeCompleted - timeOrdered;
		
		return String.format("It tooks %d time units to complete the following order: %s", timeToFinish, completed.toString());
	}
	
}