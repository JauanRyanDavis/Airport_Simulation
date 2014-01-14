public interface QueueInterface {
	
public void enqueue(Comparable newEntry);
	
public Object dequeue();
	
public Object getFront();
	
public boolean isEmpty();
	
public void clear();

}
