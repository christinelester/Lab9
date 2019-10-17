import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;

/**
 * 
 * @author CS2334, modified by Stephen Thung
 * @version 2018-02-26
 * Lab 7
 * 
 * @modified by Em Evans
 * @version 2019-10-12
 * Lab9
 * 
 * Class to simulate a restaurant comparison system. A user is able to place orders at a restaurant and
 * give completion times. A user can also check to see what the next order to be completed is. The system by
 * which the restaurant determines which order to complete next is dependent on the implementation (i.e. which
 * subclass of Restaurant it is).
 */
public class Driver
{
    /**
     * Main method for the Restaurant Comparison system.
     * 
     * @param args command-line arguments [not used]
     */
    public static void main(String[] args)
    {
        // Set up the restaurants to compare:
        StackRestaurant<String> stack = new StackRestaurant<String>();
        QueueRestaurant<String> queue = new QueueRestaurant<String>();
        PriorityQueueRestaurant<String> pqueue = new PriorityQueueRestaurant<String>();
        
        // Set up the user input loop:
        boolean done = false;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(!done)
        {
            System.out.println("Please choose a restaurant option:");
            System.out.println("\t1. [enter] an order.");
            System.out.println("\t2. [complete] an order.");
            System.out.println("\t3. [check] the next order to be completed.");
            System.out.println("\t4. [quit]");
            
            try
            {
                String input = reader.readLine();
                if (input.equalsIgnoreCase("quit"))
                {
                    done = true;
                }
                else if (input.equalsIgnoreCase("enter"))
                {
                    System.out.println("Please enter an order description and an order time (comma separated) with "
                            + "the following format:");
                    System.out.println("<description>,<time as an int>");
                    String[] entry = reader.readLine().split(",");
                    // Verify that entry matches expected format:
                    if (entry.length != 2)
                    {
                        System.out.println("Please enter an appropriate order!");
                    }
                    else
                    {
                    	//Use user input to add order to all three restaurants
                        try
                        {
                            Order<String> order = new Order<String>(entry[0], Integer.parseInt(entry[1]));
                            boolean s = stack.addOrder(order);
                            boolean q = queue.addOrder(order);
                            boolean p = pqueue.addOrder(order);
                            if(s) {System.out.println("Order added to StackRestaurant");}
                            if(q) {System.out.println("Order added to QueueRestaurant");}
                            if(p) {System.out.println("Order added to PriorityQueueRestaurant");}
                         
                        }
                        catch (NumberFormatException e)
                        {
                            System.out.println("Please enter an appropriate order!");
                        }
                    }
                }
                else if (input.equalsIgnoreCase("complete"))
                {
                    System.out.println("Please enter the time of completion as an int:");
                    // Verify that entry matches expected format:
                    try
                    {	//Complete the next order from all three restaurants
                    	//Print out description of completed order
                        int timeCompleted = Integer.parseInt(reader.readLine());
                        System.out.println("The completion for the stack restaurant:\n" +
                                stack.completeOrder(timeCompleted) + "\n");
                        System.out.println("The completion for the queue restaurant:\n" +
                                queue.completeOrder(timeCompleted) + "\n");
                        System.out.println("The completion for the priority queue restaurant:\n" +
                                pqueue.completeOrder(timeCompleted) + "\n");
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("Please enter an appropriate completion time!");
                    }
                }
                else if (input.equalsIgnoreCase("check"))
                {
                	//Print description of next order from all three restaurants
                    System.out.println("For the stack restaurant: ");
                    System.out.println(stack.checkNextCompletedOrder().toString());
                    System.out.println("For the queue restaurant: ");
                    System.out.println(queue.checkNextCompletedOrder().toString());
                    System.out.println("For the priority queue restaurant: ");
                    System.out.println(pqueue.checkNextCompletedOrder().toString());
                }
            }
            catch (IOException e)
            {
                // Something bad has happened, quit the program:
                e.printStackTrace();
                done = true;
            }
            catch (EmptyStackException e)
            {
                System.out.println("There were not enough orders in the stack. Try adding more.");
            }
        }
    }
}

