package com.munzandmore.fn;

public class RecommendFunction {

    public String handleRequest(Traveller t) {
        
        String tip;
        
        if ( t.month.equals("Oct") && t.destination.equals("Munich")) 
                tip = "Visit the Octoberfest! \n";  
        else if ( t.destination.equals("Sydney")) 
                tip = "Take a surfing lesson! \n";
        else if ( t.destination.equals("Casablanca")) 
                tip = "Try a mint tea at the souk! \n";
        else tip = "Have a good coffee somewhere! \n";
        return tip;
    }

}