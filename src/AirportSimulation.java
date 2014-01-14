//Program:     airportsimulation.java
//Course:      COSC210
//Description: Program simulates an airport landing planes based on there amount of fuel left. 
//             As planes arrive they are placed in a priority queue and ordered according to fuel left.
//Author:      Jauan Davis
//Revised:     12/1/12
//Language:    Java
//IDE:         NetBeans 7.2
//****************************************************************************************
//Class: AirportSimulation
//Description: Class simulates an airport for type Planes Objects
public class AirportSimulation {
//Method: main
//Description: Method creates a priority queue that simulates an airport and gives user different action options. 
//             Planes are created with option P, option ENTER increments the simulation time, S shows queue, X exits simulation. 
//             Planes are allowed to land every 2 minutes.
//Parameters:  none
//Returns:     void
//Calls:       getKeyboardInput
//             DecrementAmountofFuel 
//             ShowQueue    
    public static void main(String[] args) {
        KeyboardInputClass keyboardInput= new KeyboardInputClass();
        QueueInterface airport= new LinkedQueue();
        int simulationtime=0;
        int previousplanelandtime=0;
        Planes landing = null;
        System.out.println("Airport simulation program\n"+"--------------------------\n"
                +"ENTER=increment the simulation clock only\n"
                + "P  =generate a new arrival(and increment the clock\n"
                +"S  =show priority queue contents(clock does not change)\n"
                + "X  =exit simulation program\n");
        
        for(;;){
            String action= keyboardInput.getKeyboardInput("Next action:");
            if (action.equalsIgnoreCase("")){
                if(airport.isEmpty()!=true && simulationtime==previousplanelandtime+2){
                    landing= (Planes)airport.dequeue();
                    System.out.println(landing.airline+" flight "+landing.flightnumber+" lands with "
                            +landing.fuelleft+" min of fuel left after waiting "
                            +(simulationtime-landing.arrivaltime)+" min(s)"); 
                    previousplanelandtime=simulationtime; 
                }
                DecrementFuelofWaitingPlanes(airport,simulationtime);
                simulationtime++;
            }//End if
            
            if(action.equalsIgnoreCase("P")){
                Planes arriving= new Planes();
                arriving.arrivaltime=simulationtime;
                System.out.println(arriving);
                airport.enqueue(arriving);
                if(simulationtime==0 ||  simulationtime==previousplanelandtime+2 || simulationtime>previousplanelandtime+2){
                    landing= (Planes)airport.dequeue();
                    System.out.println(landing.airline+" flight "+landing.flightnumber+" lands with "
                            +landing.fuelleft+" min of fuel left after waiting "
                            +(simulationtime-landing.arrivaltime)+" min(s)"); 
                    previousplanelandtime=simulationtime;
                }
                DecrementFuelofWaitingPlanes(airport,simulationtime);
                simulationtime++;
               
            }//End if
            
            if(action.equalsIgnoreCase("S")){
                ShowQueue(airport);
            }
            if(action.equalsIgnoreCase("X")){
                return;
            }//End if
            System.out.println("");
        }//End for loop
        
    }//End main
//******************************************************************************************************
//Method:      DecrementAmountofFuel
//Description: Method decrement amount of fuel of Planes objects in a priority queue.
//Parameters:  QueueInterface queue    Priority queue that holds the Planes objects
//             int time                Time of the simulation
//Returns:     void
//Calls:       none   
 public static void DecrementFuelofWaitingPlanes(QueueInterface queue, int time){
        QueueInterface tempqueue= new LinkedQueue();
        Planes t=null;
        while(queue.isEmpty()!=true){
           t=(Planes)queue.dequeue();
           t.fuelleft--;
           tempqueue.enqueue(t);
        }
  
        while(tempqueue.isEmpty()!=true){
            t=(Planes)tempqueue.dequeue();
            if(t.fuelleft<0){
                System.out.println("\n"+t.airline+" flight "+t.flightnumber
                        +" CRASHES after waiting "+(time-t.arrivaltime)+" minutes");
            }
            else{
                queue.enqueue(t);
            }
        }
    }//End DecrementFuelofWaitingPlanes
 //*******************************************************************************
//Method:      ShowQueue
//Description: Shows the content of a priority queue.
//Parameters:  Queue interface queue   Queue that user wants to display
//Returns:     void
//Calls:       none
 public static void ShowQueue(QueueInterface queue){
      QueueInterface tempqueue= new LinkedQueue();
      Planes n=null;
              while(queue.isEmpty()!=true){
           n=(Planes)queue.dequeue();
            System.out.println(n.airline+" flight "+n.flightnumber+"; Fuel left="
                    +n.fuelleft+"; Arrival time="+n.arrivaltime);
           tempqueue.enqueue(n);
        }
        while(tempqueue.isEmpty()!=true){
            n=(Planes)tempqueue.dequeue();
            queue.enqueue(n);
        }
     
 }
}//End Class
