import java.util.Random;
import java.util.Scanner;

/**
 * Created by Dorota Marszałek on 2017-02-28.
 */
public class Main {
    public static String a1 = " ", b1 = " ", c1 = " ";
    public static String a2 = " ", b2 = " ", c2 = " ";
    public static String a3 = " ", b3 = " ", c3 = " ";
    public static String numberOfPlayers;
    public static void main(String[] args) {
        System.out.println("------Welcome in NoughtsAndCrosses v2.0 game!------");
        System.out.println();
        Scanner sc = new Scanner(System.in);
        String fieldO, fieldX = " ";
        do
        {
            System.out.println("Choose number of players (1 or 2):");
            numberOfPlayers = sc.next();
        } while(!checkIfNumberOfPlayersCorrect());
        do
        {
            do
            {
                System.out.println("Select the field for O (for example A1):");
                printTable();
                fieldO = sc.next();
            } while(!checkIfFieldCorrect(fieldO));
            if (fieldO.equalsIgnoreCase("A1")) a1 = "O";
            else if (fieldO.equalsIgnoreCase("B1")) b1 = "O";
            else if (fieldO.equalsIgnoreCase("C1")) c1 = "O";
            else if (fieldO.equalsIgnoreCase("A2")) a2 = "O";
            else if (fieldO.equalsIgnoreCase("B2")) b2 = "O";
            else if (fieldO.equalsIgnoreCase("C2")) c2 = "O";
            else if (fieldO.equalsIgnoreCase("A3")) a3 = "O";
            else if (fieldO.equalsIgnoreCase("B3")) b3 = "O";
            else if (fieldO.equalsIgnoreCase("C3")) c3 = "O";
            if (isWinner())
            {
                if (numberOfPlayers.equals("1"))
                {
                    System.out.println("PLAYER WINS! CONGRATULATIONS!");
                }
                else System.out.println("PLAYER 1 WINS! CONGRATULATIONS!");
                break;
            }
            if (checkSumOfCharacterCode()>700)
            {
                System.out.println("Nobody wins!");
                break;
            }

            if (numberOfPlayers.equals("1"))
            {
                if (checkIfComputerIsCloseToWin())
                {
                    if (a1.equals("X") && b1.equals("X") && c1.equals(" ")) fieldX = "c1";
                    else if (a1.equals("X") && c1.equals("X") && b1.equals(" ")) fieldX = "b1";
                    else if (b1.equals("X") && c1.equals("X") && a1.equals(" ")) fieldX = "a1";
                    else if (a2.equals("X") && b2.equals("X") && c2.equals(" ")) fieldX = "c2";
                    else if (a2.equals("X") && c2.equals("X") && b2.equals(" ")) fieldX = "b2";
                    else if (b2.equals("X") && c2.equals("X") && a2.equals(" ")) fieldX = "a2";
                    else if (a3.equals("X") && b3.equals("X") && c3.equals(" ")) fieldX = "c3";
                    else if (a3.equals("X") && c3.equals("X") && b3.equals(" ")) fieldX = "b3";
                    else if (b3.equals("X") && c3.equals("X") && a3.equals(" ")) fieldX = "a3";
                    else if (a1.equals("X") && a2.equals("X") && a3.equals(" ")) fieldX = "a3";
                    else if (a1.equals("X") && a3.equals("X") && a2.equals(" ")) fieldX = "a2";
                    else if (a2.equals("X") && a3.equals("X") && a1.equals(" ")) fieldX = "a1";
                    else if (b1.equals("X") && b2.equals("X") && b3.equals(" ")) fieldX = "b3";
                    else if (b1.equals("X") && b3.equals("X") && b2.equals(" ")) fieldX = "b2";
                    else if (b2.equals("X") && b3.equals("X") && b1.equals(" ")) fieldX = "b1";
                    else if (c1.equals("X") && c2.equals("X") && c3.equals(" ")) fieldX = "c3";
                    else if (c1.equals("X") && c3.equals("X") && c2.equals(" ")) fieldX = "c2";
                    else if (c2.equals("X") && c3.equals("X") && c1.equals(" ")) fieldX = "c1";
                    else if (a1.equals("X") && b2.equals("X") && c3.equals(" ")) fieldX = "c3";
                    else if (a1.equals("X") && c3.equals("X") && b2.equals(" ")) fieldX = "b2";
                    else if (b2.equals("X") && c3.equals("X") && a1.equals(" ")) fieldX = "a1";
                    else if (a3.equals("X") && b2.equals("X") && c1.equals(" ")) fieldX = "c1";
                    else if (a3.equals("X") && c1.equals("X") && b2.equals(" ")) fieldX = "b2";
                    else if (b2.equals("X") && c1.equals("X") && a3.equals(" ")) fieldX = "a3";
                }
                else
                {
                    if (checkIfPlayerIsCloseToWin())
                    {
                        if (a1.equals("O") && b1.equals("O") && c1.equals(" ")) fieldX = "c1";
                        else if (a1.equals("O") && c1.equals("O") && b1.equals(" ")) fieldX = "b1";
                        else if (b1.equals("O") && c1.equals("O") && a1.equals(" ")) fieldX = "a1";
                        else if (a2.equals("O") && b2.equals("O") && c2.equals(" ")) fieldX = "c2";
                        else if (a2.equals("O") && c2.equals("O") && b2.equals(" ")) fieldX = "b2";
                        else if (b2.equals("O") && c2.equals("O") && a2.equals(" ")) fieldX = "a2";
                        else if (a3.equals("O") && b3.equals("O") && c3.equals(" ")) fieldX = "c3";
                        else if (a3.equals("O") && c3.equals("O") && b3.equals(" ")) fieldX = "b3";
                        else if (b3.equals("O") && c3.equals("O") && a3.equals(" ")) fieldX = "a3";
                        else if (a1.equals("O") && a2.equals("O") && a3.equals(" ")) fieldX = "a3";
                        else if (a1.equals("O") && a3.equals("O") && a2.equals(" ")) fieldX = "a2";
                        else if (a2.equals("O") && a3.equals("O") && a1.equals(" ")) fieldX = "a1";
                        else if (b1.equals("O") && b2.equals("O") && b3.equals(" ")) fieldX = "b3";
                        else if (b1.equals("O") && b3.equals("O") && b2.equals(" ")) fieldX = "b2";
                        else if (b2.equals("O") && b3.equals("O") && b1.equals(" ")) fieldX = "b1";
                        else if (c1.equals("O") && c2.equals("O") && c3.equals(" ")) fieldX = "c3";
                        else if (c1.equals("O") && c3.equals("O") && c2.equals(" ")) fieldX = "c2";
                        else if (c2.equals("O") && c3.equals("O") && c1.equals(" ")) fieldX = "c1";
                        else if (a1.equals("O") && b2.equals("O") && c3.equals(" ")) fieldX = "c3";
                        else if (a1.equals("O") && c3.equals("O") && b2.equals(" ")) fieldX = "b2";
                        else if (b2.equals("O") && c3.equals("O") && a1.equals(" ")) fieldX = "a1";
                        else if (a3.equals("O") && b2.equals("O") && c1.equals(" ")) fieldX = "c1";
                        else if (a3.equals("O") && c1.equals("O") && b2.equals(" ")) fieldX = "b2";
                        else if (b2.equals("O") && c1.equals("O") && a3.equals(" ")) fieldX = "a3";
                    }
                    else
                    {
                        Random r = new Random();
                        String[] table = {"a1", "b1", "c1", "a2", "b2", "c2", "a3", "b3", "c3"};
                        do
                        {
                            fieldX = table[r.nextInt(9)];
                        } while (!checkIfFieldCorrect(fieldX));
                    }
                }
            }
            else
            {
                do{
                    System.out.println("Select the field for X (for example A1):");
                    printTable();
                    fieldX = sc.next();
                }while(!checkIfFieldCorrect(fieldX));
            }
            if (fieldX.equalsIgnoreCase("A1")) a1 = "X";
            else if (fieldX.equalsIgnoreCase("B1")) b1 = "X";
            else if (fieldX.equalsIgnoreCase("C1")) c1 = "X";
            else if (fieldX.equalsIgnoreCase("A2")) a2 = "X";
            else if (fieldX.equalsIgnoreCase("B2")) b2 = "X";
            else if (fieldX.equalsIgnoreCase("C2")) c2 = "X";
            else if (fieldX.equalsIgnoreCase("A3")) a3 = "X";
            else if (fieldX.equalsIgnoreCase("B3")) b3 = "X";
            else if (fieldX.equalsIgnoreCase("C3")) c3 = "X";
            if (isWinner())
            {
                if (numberOfPlayers.equals("1"))
                {
                    System.out.println("COMPUTER WINS!");
                }
                else System.out.println("PLAYER 2 WINS! CONGRATULATIONS!");
                break;
            }
        } while (endOfTheGame());
        sc.close();
        printTable();
    }

    public static boolean checkIfNumberOfPlayersCorrect(){
        if (numberOfPlayers.equals("1") || numberOfPlayers.equals("2"))
        {
            return true;
        }
        else return false;
    }


    public static void printTable()
    {
        System.out.println("    A     B     C  ");
        System.out.println("       |     |     ");
        System.out.println("1   " + a1 + "  |  " + b1 + "  |  " + c1 + "  ");
        System.out.println("  _____|_____|_____");
        System.out.println("       |     |     ");
        System.out.println("2   " + a2 + "  |  " + b2 + "  |  " + c2 + "  ");
        System.out.println("  _____|_____|_____");
        System.out.println("       |     |     ");
        System.out.println("3   " + a3 + "  |  " + b3 + "  |  " + c3 + "  ");
        System.out.println("       |     |     ");
    }

    public static boolean checkIfFieldCorrect(String field)
    {
        if ((field.equalsIgnoreCase("A1") && a1.equals(" ")) ||
                (field.equalsIgnoreCase("B1") && b1.equals(" ")) ||
                (field.equalsIgnoreCase("C1") && c1.equals(" ")) ||
                (field.equalsIgnoreCase("A2") && a2.equals(" ")) ||
                (field.equalsIgnoreCase("B2") && b2.equals(" ")) ||
                (field.equalsIgnoreCase("C2") && c2.equals(" ")) ||
                (field.equalsIgnoreCase("A3") && a3.equals(" ")) ||
                (field.equalsIgnoreCase("B3") && b3.equals(" ")) ||
                (field.equalsIgnoreCase("C3") && c3.equals(" ")))
        {
            return true;
        }
        else return false;
    }

    public static int checkSumOfCharacterCode()
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.delete(0, 8);
        stringBuilder.append(a1+b1+c1+a2+b2+c2+a3+b3+c3);
        int sumOfCharacterCode = 0;
        for (int i=0; i<stringBuilder.length(); i++)
        {
            sumOfCharacterCode = sumOfCharacterCode + stringBuilder.charAt(i);
        }
        return sumOfCharacterCode;
    }

    public static boolean isWinner()
    {
        if ((a1.equals(b1) && a1.equals(c1) && (a1.equals("O") || a1.equals("X"))) ||
                (a2.equals(b2) && a2.equals(c2) && (a2.equals("O") || a2.equals("X"))) ||
                (a3.equals(b3) && a3.equals(c3) && (a3.equals("O") || a3.equals("X"))) ||
                (a1.equals(a2) && a1.equals(a3) && (a1.equals("O") || a1.equals("X"))) ||
                (b1.equals(b2) && b1.equals(b3) && (b1.equals("O") || b1.equals("X"))) ||
                (c1.equals(c2) && c1.equals(c3) && (c1.equals("O") || c1.equals("X"))) ||
                (a1.equals(b2) && a1.equals(c3) && (a1.equals("O") || a1.equals("X"))) ||
                (a3.equals(b2) && a3.equals(c1) && (a3.equals("O") || a3.equals("X"))))
        {
            return true;
        }
        else return false;
    }

    public static boolean checkIfComputerIsCloseToWin()
    {
        if ((a1.equals("X") && b1.equals("X") && c1.equals(" ")) ||
                (a1.equals("X") && c1.equals("X") && b1.equals(" ")) ||
                (b1.equals("X") && c1.equals("X") && a1.equals(" ")) ||
                (a2.equals("X") && b2.equals("X") && c2.equals(" ")) ||
                (a2.equals("X") && c2.equals("X") && b2.equals(" ")) ||
                (b2.equals("X") && c2.equals("X") && a2.equals(" ")) ||
                (a3.equals("X") && b3.equals("X") && c3.equals(" ")) ||
                (a3.equals("X") && c3.equals("X") && b3.equals(" ")) ||
                (b3.equals("X") && c3.equals("X") && a3.equals(" ")) ||
                (a1.equals("X") && a2.equals("X") && a3.equals(" ")) ||
                (a1.equals("X") && a3.equals("X") && a2.equals(" ")) ||
                (a2.equals("X") && a3.equals("X") && a1.equals(" ")) ||
                (b1.equals("X") && b2.equals("X") && b3.equals(" ")) ||
                (b1.equals("X") && b3.equals("X") && b2.equals(" ")) ||
                (b2.equals("X") && b3.equals("X") && b1.equals(" ")) ||
                (c1.equals("X") && c2.equals("X") && c3.equals(" ")) ||
                (c1.equals("X") && c3.equals("X") && c2.equals(" ")) ||
                (c2.equals("X") && c3.equals("X") && c1.equals(" ")) ||
                (a1.equals("X") && b2.equals("X") && c3.equals(" ")) ||
                (a1.equals("X") && c3.equals("X") && b2.equals(" ")) ||
                (b2.equals("X") && c3.equals("X") && a1.equals(" ")) ||
                (a3.equals("X") && b2.equals("X") && c1.equals(" ")) ||
                (a3.equals("X") && c1.equals("X") && b2.equals(" ")) ||
                (b2.equals("X") && c1.equals("X") && a3.equals(" ")))
        {
            return true;
        }
        else return false;
    }

    public static boolean checkIfPlayerIsCloseToWin()
    {
        if ((a1.equals("O") && b1.equals("O") && c1.equals(" ")) ||
                (a1.equals("O") && c1.equals("O") && b1.equals(" ")) ||
                (b1.equals("O") && c1.equals("O") && a1.equals(" ")) ||
                (a2.equals("O") && b2.equals("O") && c2.equals(" ")) ||
                (a2.equals("O") && c2.equals("O") && b2.equals(" ")) ||
                (b2.equals("O") && c2.equals("O") && a2.equals(" ")) ||
                (a3.equals("O") && b3.equals("O") && c3.equals(" ")) ||
                (a3.equals("O") && c3.equals("O") && b3.equals(" ")) ||
                (b3.equals("O") && c3.equals("O") && a3.equals(" ")) ||
                (a1.equals("O") && a2.equals("O") && a3.equals(" ")) ||
                (a1.equals("O") && a3.equals("O") && a2.equals(" ")) ||
                (a2.equals("O") && a3.equals("O") && a1.equals(" ")) ||
                (b1.equals("O") && b2.equals("O") && b3.equals(" ")) ||
                (b1.equals("O") && b3.equals("O") && b2.equals(" ")) ||
                (b2.equals("O") && b3.equals("O") && b1.equals(" ")) ||
                (c1.equals("O") && c2.equals("O") && c3.equals(" ")) ||
                (c1.equals("O") && c3.equals("O") && c2.equals(" ")) ||
                (c2.equals("O") && c3.equals("O") && c1.equals(" ")) ||
                (a1.equals("O") && b2.equals("O") && c3.equals(" ")) ||
                (a1.equals("O") && c3.equals("O") && b2.equals(" ")) ||
                (b2.equals("O") && c3.equals("O") && a1.equals(" ")) ||
                (a3.equals("O") && b2.equals("O") && c1.equals(" ")) ||
                (a3.equals("O") && c1.equals("O") && b2.equals(" ")) ||
                (b2.equals("O") && c1.equals("O") && a3.equals(" ")))
        {
            return true;
        }
        else return false;
    }

    public static boolean endOfTheGame()
    {
        if (!(a1.equals(" ") && b1.equals(" ") && c1.equals(" ") && a2.equals(" ") && b2.equals(" ") &&
                c2.equals(" ") && a3.equals(" ") && b3.equals(" ") && c3.equals(" ")))
        {
            return true;
        }
        else return false;
    }
}