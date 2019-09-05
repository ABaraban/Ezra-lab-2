package lab2;


import support.cse131.ArgsProcessor;

public class NimGame {
    public static void main(String[] args) {
        //Prompting human for # of sticks to start with//
        ArgsProcessor ap = new ArgsProcessor(args);
        int numSticks = ap.nextInt("How many sticks would you like to start with?");


        //Counters//
        int roundCounter = 0;


        
        //while loop//
        while (numSticks > 0) {
            //Getting the computer to pick 1 or 2//
            double compPick = Math.random() + 1;
            int rCompPick = (int) Math.round(compPick);


            //Computer picking first//
            if (rCompPick <= numSticks) {
                System.out.print("Round " + roundCounter + ", " + numSticks + " sticks at start, computer took " + rCompPick + ", so ");
                numSticks = numSticks - rCompPick;
                System.out.print(numSticks + " remain");
                System.out.println();
                roundCounter = roundCounter + 1;
            }
            //human has to pick how many sticks to take//
            if (numSticks > 0) {
                int humTake = ap.nextInt("How many sticks would you like to take");

                //Making sure human does not cheat//
                if (humTake > 2 || humTake == 0) {
                    humTake = ap.nextInt("Stop Cheating!!! Take either 1 or 2 sticks. How many Sticks would you like to take?");
                }
                //Human pick//
                if (humTake <= numSticks) {
                    System.out.print("Round " + roundCounter + ", " + numSticks + " sticks at start, human took " + humTake + ", so ");
                    numSticks = numSticks - humTake;
                    System.out.print(numSticks + " remain");
                    System.out.println();
                    roundCounter = roundCounter + 1;
                }

                //if the human chooses greater than what remains//
                if (humTake > numSticks && numSticks == 0) {
                    numSticks = ap.nextInt("You cannot enter a value greater than the number of sticks remaining?");
                }




            }
        }
        if (roundCounter % 2 == 0 && numSticks == 0) {
            System.out.println("You Won!!!");
        }
        if (roundCounter % 2 == 1 && numSticks == 0) {
            System.out.println("The Computer Won!!!");
        }

    }
}





