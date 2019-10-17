import java.util.ArrayList;

/** 
 * Implementation of the Restaurant abstract class. Stores and completes tickets based on a queue data structure.
 * Orders are treated in a FIFO manner. That is, the first ticket to be added to the restaurant is
 * the first ticket to be completed. i.e. the QueueRestaurant behaves as one would expect a normal restaurant to.
 * The first order placed is the first order completed (regardless of the timeOrdered).
 * 
 * @author Stephen
 * @version 2018-10-10
 * 
 * @modified by Em Evans
 * @version 2019-30-09
 * Lab7
 * 
 * @modified by Em Evans
 * @version 2019-12-10
 * Lab9
 */
public class QueueRestaurant<T> extends Restaurant<T>{
	
	private static final int ORDER_LIST_SIZE = 10;
	private ArrayList<Order<T>> orderList;
	private int numOrders;
	
	public QueueRestaurant()
	{
		//TODO: implement this
		orderList = new ArrayList<>();
	}
    /**
     * Add an order to the restaurant. If there is no more room (number of tickets in the restaurant == maxSize of
     * queueRestaurant), do not add an order and return false.
     * 
     * @param order The Order to be added.
     * @return If successfully added, true
     * 			else, false 
     * 			(should always be true)
     */
	public boolean addOrder(Order<T> order){
		if(numOrders == ORDER_LIST_SIZE)
		{
			return false;
		}
		orderList.add(order);
		numOrders++;
		return true;
	}
    /**
     * remove and return next Order based on queue data structure
     * 
     * @return completed order
     */
	@Override
	protected Order<T> completeOrder()
	{
		//TODO: implement this
		//If no orders, return null
		if (this.numberRemainingOrder() == 0) {
			return null;
		}
		
	    //Get first submitted order
		else {
			Order<T> completed = orderList.get(0);
		
			//move every index in orderList down one
			/*for (int i = 0; i < numOrders; ++i) {
				Order<T> temp = orderList.get(i+1);
				orderList.set(i, temp);
			}
			*/
			orderList.remove(0);
			--numOrders;
			
			return completed;
			}
		}
    /**
     * Computes the number of orders in the restaurant that have not been completed.
     * 
     * @return the number of orders to complete.
     */
	@Override
	protected int numberRemainingOrder()
	{
		//TODO: implement this
		return numOrders;
	}
    /**
     * @return the next order to be completed (but do not remove it)
     */
	@Override
	protected Order<T> checkNextCompletedOrder()
	{
		//TODO: implement this;
		//check that the is at least one order
				if (numOrders > 0) {
					//if yes, return the next order to be completed
					return orderList.get(0);
				} else
					return null;
	}
}
