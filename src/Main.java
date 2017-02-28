import java.util.Scanner;

/**
 * Created by Dorota Marszałek on 2017-02-28.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("------Welcome in NoughtsAndCrosses v1.0 game!------");
        System.out.println();
        Scanner sc = new Scanner(System.in);
        String a1 = " ", b1 = " ", c1 = " ";
        String a2 = " ", b2 = " ", c2 = " ";
        String a3 = " ", b3 = " ", c3 = " ";
        String fieldO, fieldX;
        do{
            do{
                System.out.println("Select the field for O (for example A1):");
                printTable(a1, b1, c1, a2, b2, c2, a3, b3, c3);
                fieldO = sc.next();
            }while(!checkIfFieldCorrect(fieldO, a1, b1, c1, a2, b2, c2, a3, b3, c3));
            if (fieldO.equalsIgnoreCase("A1")) a1 = "O";
            else if (fieldO.equalsIgnoreCase("B1")) b1 = "O";
            else if (fieldO.equalsIgnoreCase("C1")) c1 = "O";
            else if (fieldO.equalsIgnoreCase("A2")) a2 = "O";
            else if (fieldO.equalsIgnoreCase("B2")) b2 = "O";
            else if (fieldO.equalsIgnoreCase("C2")) c2 = "O";
            else if (fieldO.equalsIgnoreCase("A3")) a3 = "O";
            else if (fieldO.equalsIgnoreCase("B3")) b3 = "O";
            else if (fieldO.equalsIgnoreCase("C3")) c3 = "O";
            if (isWinner(a1, b1, c1, a2, b2, c2, a3, b3, c3)){
                break;
            }
            if (checkSumOfCharacterCode(a1, b1, c1, a2, b2, c2, a3, b3, c3)>700){
                break;
            }
            do{
                System.out.println("Select the field for X (for example A1):");
                printTable(a1, b1, c1, a2, b2, c2, a3, b3, c3);
                fieldX = sc.next();
            }while(!checkIfFieldCorrect(fieldX, a1, b1, c1, a2, b2, c2, a3, b3, c3));
            if (fieldX.equals("A1")) a1 = "X";
            else if (fieldX.equalsIgnoreCase("B1")) b1 = "X";
            else if (fieldX.equalsIgnoreCase("C1")) c1 = "X";
            else if (fieldX.equalsIgnoreCase("A2")) a2 = "X";
            else if (fieldX.equalsIgnoreCase("B2")) b2 = "X";
            else if (fieldX.equalsIgnoreCase("C2")) c2 = "X";
            else if (fieldX.equalsIgnoreCase("A3")) a3 = "X";
            else if (fieldX.equalsIgnoreCase("B3")) b3 = "X";
            else if (fieldX.equalsIgnoreCase("C3")) c3 = "X";
            if (isWinner(a1, b1, c1, a2, b2, c2, a3, b3, c3)){
                break;
            }
        }while (endOfTheGame(a1, b1, c1, a2, b2, c2, a3, b3, c3));
        if (isWinner(a1, b1, c1, a2, b2, c2, a3, b3, c3)){
            printTable(a1, b1, c1, a2, b2, c2, a3, b3, c3);
            checkWinner(a1, b1, c1, a2, b2, c2, a3, b3, c3);
        }
        else{
            printTable(a1, b1, c1, a2, b2, c2, a3, b3, c3);
            System.out.println("Nobody wins!");
        }
    }

    public static void printTable(String a1, String b1, String c1, String a2, String b2, String c2, String a3, String b3,
                                  String c3){
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

    public static boolean checkIfFieldCorrect(String field, String a1, String b1, String c1, String a2, String b2, String c2, String a3,
                                               String b3, String c3){
        if ((field.equalsIgnoreCase("A1") && a1.equals(" ")) ||
                (field.equalsIgnoreCase("B1") && b1.equals(" ")) ||
                (field.equalsIgnoreCase("C1") && c1.equals(" ")) ||
                (field.equalsIgnoreCase("A2") && a2.equals(" ")) ||
                (field.equalsIgnoreCase("B2") && b2.equals(" ")) ||
                (field.equalsIgnoreCase("C2") && c2.equals(" ")) ||
                (field.equalsIgnoreCase("A3") && a3.equals(" ")) ||
                (field.equalsIgnoreCase("B3") && b3.equals(" ")) ||
                (field.equalsIgnoreCase("C3") && c3.equals(" "))){
            return true;
        }
        else return false;
    }

    public static int checkSumOfCharacterCode(String a1, String b1, String c1, String a2, String b2, String c2, String a3,
                                              String b3, String c3){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.delete(0, 8);
        stringBuilder.append(a1+b1+c1+a2+b2+c2+a3+b3+c3);
        int sumOfCharacterCode = 0;
        for (int i=0; i<stringBuilder.length(); i++){
            sumOfCharacterCode = sumOfCharacterCode + stringBuilder.charAt(i);
        }
        return sumOfCharacterCode;
    }

    public static boolean isWinner(String a1, String b1, String c1, String a2, String b2, String c2, String a3, String b3, String c3){
        if ((a1.equals(b1) && a1.equals(c1) && (a1.equals("O") || a1.equals("X"))) ||
                (a2.equals(b2) && a2.equals(c2) && (a2.equals("O") || a2.equals("X"))) ||
                (a3.equals(b3) && a3.equals(c3) && (a3.equals("O") || a3.equals("X"))) ||
                (a1.equals(a2) && a1.equals(a3) && (a1.equals("O") || a1.equals("X"))) ||
                (b1.equals(b2) && b1.equals(b3) && (b1.equals("O") || b1.equals("X"))) ||
                (c1.equals(c2) && c1.equals(c3) && (c1.equals("O") || c1.equals("X"))) ||
                (a1.equals(b2) && a1.equals(c3) && (a1.equals("O") || a1.equals("X"))) ||
                (a3.equals(b2) && a3.equals(c1) && (a3.equals("O") || a3.equals("X")))){
            return true;
        }
        else return false;
    }

    public static void checkWinner(String a1, String b1, String c1, String a2, String b2, String c2, String a3, String b3, String c3){
        if ((a1.equals(b1) && a1.equals(c1) && a1.equals("O"))|| (a2.equals(b2) && a2.equals(c2) && a2.equals("O")) ||
                (a3.equals(b3) && a3.equals(c3) && a3.equals("O")) || (a1.equals(a2) && a1.equals(a3) && a1.equals("O")) ||
                (b1.equals(b2) && b1.equals(b3) && b1.equals("O")) || (c1.equals(c2) && c1.equals(c3) && c1.equals("O")) ||
                (a1.equals(b2) && a1.equals(c3) && a1.equals("O")) || (a3.equals(b2) && a3.equals(c1) && a3.equals("O"))){
            System.out.println("1st player WINS! CONGRATULATIONS!");
        }
        else System.out.println("2nd player WINS! CONGRATULATIONS!");
    }

    public static boolean endOfTheGame(String a1, String b1, String c1, String a2, String b2, String c2, String a3, String b3, String c3){
        if (!(a1.equals(" ") && b1.equals(" ") && c1.equals(" ") && a2.equals(" ") && b2.equals(" ") &&
                c2.equals(" ") && a3.equals(" ") && b3.equals(" ") && c3.equals(" "))){
            return true;
        }
        else return false;
    }
}
