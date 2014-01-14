//Class: Planes
//Description: Object that simulate airplanes and contain a airline name, flight number, 
//             amount of fuel, and arrival time to airport.
public class Planes implements Comparable{
   String airline; 
   int flightnumber;
   int fuelleft;
   int arrivaltime;
   
   Planes(){
       int airlinenum= 1 + (int)(Math.random()*(8));
       switch(airlinenum){
           case 1:
               airline="United";
               break;
           case 2:
               airline="Southwest";
               break;
           case 3: 
               airline="Northwest";
               break;
           case 4: 
               airline="Alaska";
               break;
           case 5:
               airline="Continental";
               break;
           case 6: 
               airline="American";
               break;
           case 7: 
               airline="Frontier";
               break;
           case 8:   
               airline="Lufthansa";
               break;
       }//End switch
       
       flightnumber= 1000+(int)(Math.random()*(9999));
       fuelleft= 1+(int)(Math.random()*(20));
   }
   public int compareTo(Object o){
       int comparefuelamount=((Planes)o).fuelleft;
       if(fuelleft==comparefuelamount)
           return 0;
       else if(fuelleft<comparefuelamount)
           return -1;
       else
           return 1;
   }
   
   public String toString(){
       String output= airline+" flight "+flightnumber+" arrived at "+arrivaltime
               +" minutes with "+fuelleft+ " minutes of fuel left";
       return output;
   }

}//End Class
