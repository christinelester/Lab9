import java.util.PriorityQueue;

/**
 * @author CS2334, modified by Stephen Thung
 * @version 2018-02-26
 * Lab 7
 * 
 * @modified by Em Evans
 * @version 2019-10-12
 * Lab 9
 * 
 * Restaurant class that stores orders in a PriorityQueue. This class uses the natural ordering of the Orders
 * (as defined by the Order compareTo() function) to determine which order should next be completed. Orders are sorted
 * by their stored timeOrdered, so the earliest order will be removed first. This is different from the
 * QueueRestaurant which will remove the order first inserted, regardless of what its time is.
 * 
 */
public class PriorityQueueRestaurant<T> extends Restaurant<T>
{
    private PriorityQueue<Order<T>> orderList;

    public PriorityQueueRestaurant()
    {
    	//TODO: implement this
    	orderList = new PriorityQueue<>();
    }
    /**
     * Add an order to the restaurant. If there is no more room (number of tickets in the restaurant == maxSize of
     * queueRestaurant), do not add an order and return false.
     * 
     * @param order The Order to be added.
     * @return 
     */
    @Override
    public boolean addOrder(Order<T> order)
    {
    	//TODO: implement this
    	orderList.add(order);
    	return true;
    }
    /**
     * @return The next order to be removed.
     */
    @Override
    protected Order<T> completeOrder()
    {
    	//TODO: implement this
    	//If no orders, return null
    			if (this.numberRemainingOrder() == 0) {
    				return null;
    			}

    			else {
    				Order<T> completed = orderList.peek();
    				orderList.poll();
       				return completed;
    			}
    }
    /**
     * Gets the number of orders stored.
     * @return The number of orders stored in the stack.
     */
    @Override
    protected int numberRemainingOrder()
    {
    	//TODO: implement this
    	return orderList.size();
    }
    /**
     * Get the next order to be completed.
     * @return The order that will next be completed.
     */
    @Override
    public Order<T> checkNextCompletedOrder()
    {
    	//TODO: implement this
		//check that the is at least one order
		if (orderList.size() > 0) {
			//if yes, return the next order to be completed
			return orderList.peek();
		} else
			return null;
    }
}