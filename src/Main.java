import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        boolean continueGame = true;

        while (continueGame) {                                                          //en loop som kör programmet så länge continueGame är true
            int randomNumber = random.nextInt(100)+1;                           //Generar ett slumpmässigt heltal och sparar i variabeln "randomNumber"
            System.out.println("Gissa på ett nummer mellan 1 - 100 ");//Printar ut på skärmen och ber användaren välja ett nummer mellan 1-100
           // renamed variable för att följa Javas namnkonventioner. Variabelnamn bör börja med en liten bokstav
            int tries = 0;                                                          //sparar en variabel som heter "Tries" som börjar på 0 som ska ta emot antalen gissningar användaren har gissat
            boolean correctGuess = false;                                           //En boolean som kontrollerar om rätt svar har gissats och isåfall avslutar loopen

            while (!correctGuess) {
                // renamed variable
                int guess = scanner.nextInt();                                       //Scannern sparar användarens input i integern "Guess"
                tries++;                                                            //för var gång som loopen körs om plusas antalet försök på med 1

                if (checkGuess(randomNumber,guess)==0) {                            //kontrollerar om användarens gissning är rätt
                    correctGuess = true;                                           //När användaren har gissat rätt har jag lagt en break här som avslutar inre while loop genom att sätta correctGuess värde till true
                    System.out.println("Det var rätt, Bra gissat du! ");
                    System.out.println("Det tog dig totalt " + tries + " Försök"); //En print som berättar hur många försök det krävdes för användaren att gissa rätt
                }
                else if (checkGuess(guess,randomNumber)==-2) {
                    System.out.println("FEL! Talet är högre än Försök igen.  ");
                } else {
                    System.out.println("FEL! Talet är lägre än försök igen.");
                }
            }
            System.out.println("Vill du spela igen? (Ja/Nej)");
            // renamed variable
            String answer = scanner.next();
            continueGame = playAgain(answer);                                       // Anropar "playAgain" -metoden för att avgöra om spelet ska fortsätta.
        }
    }
    //Förenklade logiken i checkGuess-metoden genom att direkt returnera resultatet istället för att använda en separat variabel.
    public static int checkGuess(int randomNumber, int guess) {
        if (guess == randomNumber) {
            return 0; // Correct guess
        } else if (guess < randomNumber) {
            return -1; // Guess is lower than the random number
        } else {
            return -2; // Guess is higher than the random number
        }
    }
    //Förenklade playAgain-metoden genom att direkt returnera resultatet av jämförelsen istället för att använda en separat variabel.
    public static boolean playAgain(String answer) {
        return answer.equalsIgnoreCase("Ja");
    }
}