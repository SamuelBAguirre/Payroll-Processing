import java.io.*;
import java.util.Scanner;
/**
 * Driver class runs the whole program, contains the main method. 
 *
 * @author Samuel Aguirre
 * @version 11/8/2019
 */
public class Driver
{
     public static void main (String [] args) throws IOException{
       
       PrintWriter pw = new PrintWriter(new FileWriter("csis.txt"));
       Scanner fileScan1 = new Scanner(new File("payfile.txt"));
       Scanner fileScan2 = new Scanner(new File("hirefile.txt"));
       Scanner fileScan3 = new Scanner(new File("firefile.txt"));
       
       Payroll payRoll = new Payroll(fileScan1, fileScan2, fileScan3,  pw);
       
       payRoll.getEmployees();
       
       payRoll.getHire();
       payRoll.getFire();
       
       payRoll.outputEmployees();
       payRoll.numberOfEmployees();
       
       payRoll.getWomenEmployees();
       payRoll.getWeeklyEmployees();
       
       payRoll.increasePay();
       payRoll.sortedList();
       
       payRoll.getHireList();
       payRoll.getFireList();
       
       pw.close();
       fileScan1.close();
       fileScan2.close();
       fileScan3.close();
    }
}
