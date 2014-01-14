
public class QueueTestor {
    public static void main(String[] args) {
        QueueInterface airport= new LinkedQueue();
        
        Planes t= new Planes();
        t.arrivaltime=2;
        System.out.println(t);
        airport.enqueue(t);
        
        Planes p= new Planes();
        p.arrivaltime=3;
        System.out.println(p);
        airport.enqueue(p);
       
        Planes y= new Planes();
        y.arrivaltime=3;
        System.out.println(y);
        airport.enqueue(y);
        
        Planes q= new Planes();
        q.arrivaltime=3;
        System.out.println(q);
        airport.enqueue(q);
        
        System.out.println("");
        System.out.println("");
        
//        while(airport.isEmpty()!=true){
//            System.out.println(airport.dequeue());
//        }
        
        
        
    }//End main
}
