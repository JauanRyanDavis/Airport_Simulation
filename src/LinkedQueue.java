//************************************************************************
//************************************************************************
public class LinkedQueue implements QueueInterface, java.io.Serializable {
	private Node firstNode;
	private Node lastNode;
	//********************************************************************
	public LinkedQueue() {
		firstNode = null;
		lastNode = null;
	}
	//********************************************************************
        //This enqueue method was modified to turn this Linked Queue into a Priority Queue
	public void enqueue(Comparable newEntry) {
		Node newNode = new Node(newEntry, null);
                Node nodeBefore= getNodeBefore(newEntry);
          
		if (isEmpty() || nodeBefore==null){
                        newNode.setNextNode(firstNode);
			firstNode = newNode;
                }        
                
                else if (nodeBefore!=null){
                        Node nodeAfter = nodeBefore.getNextNode();
			newNode.setNextNode(nodeAfter);
			nodeBefore.setNextNode(newNode);
                        
                }
                else
                       
			lastNode.setNextNode(newNode);
                lastNode = newNode;
                
                
	}
	//********************************************************************
        private Node getNodeBefore(Comparable anEntry) {
		Node currentNode = firstNode;
		Node nodeBefore = null;

		while ((currentNode != null) && (anEntry.compareTo(currentNode.getData())>0)){
			nodeBefore = currentNode;
			currentNode = currentNode.getNextNode();
		}
		return nodeBefore;
	}
	//***********************************************************************************************
	//************************************************************************
	public Object dequeue() {
		Object front = null;
		if (!isEmpty()) {
			front = firstNode.getData();
			firstNode = firstNode.getNextNode();
			if (firstNode == null)
				lastNode = null;
		}
		return front;
	}
	//********************************************************************
	public Object getFront() {
		Object front = null;
		if (!isEmpty())
			front = firstNode.getData();
		return front;
	}
	//********************************************************************
	public boolean isEmpty() {
		return firstNode == null;
	}
	//********************************************************************
	public void clear() {
		firstNode = null;
		lastNode = null;
	}
	//********************************************************************
	//********************************************************************
	private class Node {
		private Object data;
		private Node next;

		private Node(Object dataPortion) {
			data = dataPortion;
			next = null;	
		}
		
		private Node(Object dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;	
		}
		
		private Object getData() {
			return data;
		}
		
		private void setData(Object newData) {
			data = newData;
		}
		
		private Node getNextNode() {
			return next;
		}
		
		private void setNextNode(Node nextNode) {
			next = nextNode;
		}
	}
	//********************************************************************
	//********************************************************************
}
//************************************************************************
//************************************************************************
