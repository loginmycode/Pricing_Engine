 #  Pricing Engine 
->  Build on using core java concepts
# How to run this project
	
    Import the project from git hub to any java supported IDE (Eclipse) and run it;
    PriceEngine has main method();
 
 # Important
 
 - For Testing purpose taken few cycles inputs, We can use it for finding price of  1000 or more cycles as for the requirement
 - By UnCommenting SOP you can check the process of execution of the each important line of code;
 
# Purpose of the Pricing Engine
 - Basically the Pricing Engine is created for finding the price of a cycle, of     specific year model, with different Components of with diffrent available types.
  The price will be calculated as for the given inputs by user
 - A user can select cycle components (Parts) from available types of a specific year model;
 - Eg:1
        "frame":"Steel",  
        "handlebar":"Flat_Bars",
        "seating":"Leather",
        "wheels":"Withtube",
        "chainAssemble":"Roller_chain",
        "year":"2017"
 - Eg:2
        "frame":"Steel",
        "handlebar":"Flat_Bars",
        "seating":"Soft",
        "wheels":"TubeLess",
        "chainAssemble":"Roller_chain",
        "year":"2018"
    Eg:3 Components
    

# Version used
    - java 8
# Main Concepts used
    - Multithreading using pool
    - Blocking queue
    - IO(Gson library),
    
# Third-party resources (library/jars)
    ->Gson  library is using  (for Converting file JSON to Java Object)

# Explanation 

    - Pre-defined components are declared in Compnents.json file;
    - Pricing of the Components for different time periods are declared in Components.json file
    -Cycle main components are declared in Cycle.json file;
    -By using multithreading pool and BlockingQue calculating the price of each  cycle;
    - Creating 1000 cycles by using same multithreading and BlockingQue;
    
    key points:
    Multithreading with max 10 threads and blocking Queue features are used in the finding price of cycles.
    
    




Here is my  [Project](http:google.com) projet


