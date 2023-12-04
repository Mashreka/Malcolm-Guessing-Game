import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        boolean continueGame = true;

        while (continueGame) {                                                          //en loop som kör programmet så länge continueGame är true
            int randomNumber = random.nextInt(100)+1;                           //Generar ett slumpmässigt heltal och sparar i variabeln "randomNumber"
            System.out.println("Gissa på ett nummer mellan 1 - 100 ");                //Printar ut på skärmen och ber användaren välja ett nummer mellan 1-100
            int Tries = 0;                                                           //sparar en variabel som heter "Tries" som börjar på 0 som ska ta emot antalen gissningar användaren har gissat
            boolean correctGuess = false;                                           //En boolean som kontrollerar om rätt svar har gissats och isåfall avslutar loopen

            while (!correctGuess) {
                int Guess = scanner.nextInt();                                       //Scannern sparar användarens input i integern "Guess"
                Tries++;                                                            //för var gång som loopen körs om plusas antalet försök på med 1

                if (checkGuess(randomNumber,Guess)==0) {                            //kontrollerar om användarens gissning är rätt
                    correctGuess = true;                                           //När användaren har gissat rätt har jag lagt en break här som avslutar inre while loop genom att sätta correctGuess värde till true
                    System.out.println("Det var rätt, Bra gissat du! ");
                    System.out.println("Det tog dig totalt " + Tries + " Försök"); //En print som berättar hur många försök det krävdes för användaren att gissa rätt
                }
                else if (checkGuess(Guess,randomNumber)==-2) {
                    System.out.println("FEL! Talet är högre än Försök igen.  ");
                } else {
                    System.out.println("FEL! Talet är lägre än försök igen.");
                }
            }
            System.out.println("Vill du spela igen? (Ja/Nej)");
            String Answer = scanner.next();
            continueGame = playAgain(Answer);                                       // Anropar "playAgain" -metoden för att avgöra om spelet ska fortsätta.
        }
    }

    public static int checkGuess(int randomNumber, int guess){
        int value = 0;

        if (guess == randomNumber){
            value = 0;                                                              // Gissningen är korrekt.
        }
        else if (guess < randomNumber){
            value =-1;                                                              // Gissningen är lägre än det slumpmässiga talet.
        }
        else if (guess > randomNumber) {
            value =-2;                                                              // Gissningen är högre än det slumpmässiga talet.
        }
        return (value);                                                             // Returnerar resultatet av gissningen.
    }
    public static boolean playAgain(String Answer) { //En metod som frågar om användaren vill spela igen
        boolean btn = true;
        if(Answer.equalsIgnoreCase("Nej")){
            return (false);
        }
        return (btn);

    }
}