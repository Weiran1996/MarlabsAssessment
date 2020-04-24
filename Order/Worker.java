package Order;

import java.util.LinkedList;
import java.util.Queue;

public class Worker {

	Queue<Order> list= new LinkedList<>();
	int capacity= 5;

	public void produce() throws InterruptedException {
		int value= 1;
		while (true) {
			synchronized (this) {

				while (list.size() == capacity)
					wait();

				Order newOrder= new Order(value++ , "NEW");
				System.out.println("New Order" + " " + newOrder.num);

				list.add(newOrder);
				notify();

				Thread.sleep(1000);
			}
			if (value == 101) { return; }
		}
	}

	public void consume() throws InterruptedException {
		while (true) {
			synchronized (this) {

				while (list.size() == 0)
					wait();

				Order order= list.poll();
				order.state= "FULFILLED";

				System.out.println("Order Fulfilled" + " " + order.num);
				notify();

				Thread.sleep(1000);
			}
		}
	}
}
