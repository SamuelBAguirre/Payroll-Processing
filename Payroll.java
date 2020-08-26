 import java.io.*;
import java.util.Scanner;
/**
 * The PayRoll class builds linear linked lists using employee information.  
 *
 * @author Samuel Aguirre 
 * @version 11/6/2019
 */
public class Payroll
{

    private PrintWriter pw;
    private Scanner fileScan1;
    private Scanner fileScan2;
    private Scanner fileScan3;
    private ObjectList currentEmployees;
    private ObjectList womenEmployees;
    private ObjectList weeklyEmployees;
    private ObjectList increaseSalary;
    private ObjectList sortedEmplyees;
    private ObjectList hireList;
    private ObjectList fireList;

    /**
     * Constructor for objects of class Payroll
     * 
     * @author Samuel Aguirre, ID: 011137110
     * @param fileScan1, passes employee information; pw, PrintWriter used to write to the output file
     * @param fileScan2, passes new employee information; fileScan3, passes the employee to be fired
     */
    public Payroll(Scanner fileScan1, Scanner fileScan2, Scanner fileScan3, PrintWriter pw)
    {
        this.fileScan1 = fileScan1;
        this.fileScan2 = fileScan2;
        this.fileScan3 = fileScan3;
        this.pw = pw;
        this.currentEmployees = new ObjectList();
        this.womenEmployees = new ObjectList();
        this.weeklyEmployees = new ObjectList();
        this.increaseSalary = new ObjectList();
        this.sortedEmplyees = new ObjectList();
        this.hireList = new ObjectList();
        this.fireList = new ObjectList();

    }

    /**
     * The getEmployees() reads in the employee list line by line and inserts it into an employee object, 
     * the object is then inserted at the end of a list, currentEmployee list. 
     * 
     * 
     * @author Samuel Aguirre, ID: 011137110
     */
    public void getEmployees() {
        while(fileScan1.hasNext()) {

            String buf = fileScan1.nextLine();

            String delims = "[ ]+";
            String[] tokens = buf.split(delims);

            String fName = tokens[0];
            String lName = tokens[1];
            char gender = tokens[2].charAt(0);
            int tenure = Integer.parseInt(tokens[3]);
            char rate = tokens[4].charAt(0);
            double salary = Double.parseDouble(tokens[5]);

            Employee employed = new Employee(fName, lName, gender, tenure, rate, salary);
            currentEmployees.addLast(employed);

        }
    }

    /**
     * The getHire() reads in an employee to be hired and inserts it into an employee object, 
     * the object is then inserted at the end of a list, hireList list.
     * 
     * @author Samuel Aguirre, ID: 011137110
     */
    public void getHire() {
        while(fileScan2.hasNext()) {

            String buf = fileScan2.nextLine();

            String delims = "[ ]+";
            String[] tokens = buf.split(delims);

            String fName = tokens[0];
            String lName = tokens[1];
            char gender = tokens[2].charAt(0);
            int tenure = Integer.parseInt(tokens[3]);
            char rate = tokens[4].charAt(0);
            double salary = Double.parseDouble(tokens[5]);

            Employee employed = new Employee(fName, lName, gender, tenure, rate, salary);
            hireList.addLast(employed);

        }
    }

    /**
     * The getFire() reads in an employee to be fired and inserts it into an employee object, 
     * the object is then inserted at the end of a list, fireList list.
     * 
     * @author Samuel Aguirre, ID: 011137110
     */
    public void getFire() {
        while(fileScan3.hasNext()) {

            String buf = fileScan3.nextLine();

            String delims = "[ ]+";
            String[] tokens = buf.split(delims);

            String fName = tokens[0];
            String lName = tokens[1];

            Employee employed = new Employee(fName, lName);
            fireList.addLast(employed);

        }
    }

    /**
     * The header() outputs the header information for the datebase of employees. 
     * 
     * @author Samuel Aguirre, ID: 011137110
     */
    private void header(){

        System.out.println("------------------[PART B - Current PayRoll]------------------");
        pw.println("------------------[PART B - Current PayRoll]------------------");
        String header1 = "[First Name]";
        String header2 = "[Last Name]";
        String header3 = "[Gender]";
        String header4 = "[Tenure]";
        String header5 = "[Rate]";
        String header6 = "[Salary]";
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s\n\n" ,header1, header2, header3 , header4, header5, header6);
        pw.printf("%-15s %-15s %-15s %-15s %-15s %-15s\n\n" ,header1, header2, header3 , header4, header5, header6);

    }

    /**
     * The outputEmployees() visits each node in the currentEmployees list and prints the employee info from each object from the info field 
     * of the node. 
     * 
     * @author Samuel Aguirre, ID: 011137110
     */
    public void outputEmployees(){

        ObjectListNode  p = currentEmployees.getFirstNode();

        header();

        while(p != null){

            Employee buf = (Employee) p.getInfo();

            System.out.println(String.format("%-15s %-15s %-15s %-15d %-15s $%-15.2f", buf.getFirstName(), buf.getLastName(), buf.getGender()
                , buf.getTenure(), buf.getRate(), buf.getSalary()));
            pw.println(String.format("%-15s %-15s %-15s %-15d %-15s $%-15.2f", buf.getFirstName(), buf.getLastName(), buf.getGender()
                , buf.getTenure(), buf.getRate(), buf.getSalary()));
            p = p.getNext();

        }
    }

    /**
     * The numberOfEmplyees() prints out the number of nodes in the currentEmployees list
     * 
     * @author Samuel Aguirre, ID: 011137110
     */
    public void numberOfEmployees(){

        System.out.println();
        pw.println();
        System.out.println("------------------[PART C ]------------------");
        pw.println("------------------[PART C ]------------------");
        System.out.println("[Number of Employees]: " + currentEmployees.size() + "\n");
        pw.println("[Number of Employees]: " + currentEmployees.size() + "\n");
    }

    /**
     * The getWomenEmployees() traverses the currentEmployee list, if the employee is female then the node is added to 
     * the end of the womenEmployee list. The womenEmploee list is then traversed node by node printing the employee information
     * from the info field. 
     * 
     * @author Samuel Aguirre, ID: 011137110
     */
    public void getWomenEmployees(){

        ObjectListNode  p = currentEmployees.getFirstNode();
        while(p != null){
            Employee buf = (Employee) p.getInfo();

            if (buf.getGender() == 'F'){

                womenEmployees.addLast(buf);
            }

            p = p.getNext();
        }

        ObjectListNode  q = womenEmployees.getFirstNode();
        System.out.println();
        pw.println();
        System.out.println("------------------[PART D - Females In PayRoll]------------------");
        pw.println("------------------[PART D - Females In PayRoll]------------------");
        while(q != null){

            Employee buf = (Employee) q.getInfo();

            System.out.printf("[Female Employee]: %-10s %-10s\n",  buf.getFirstName(), buf.getLastName());
            pw.printf("[Female Employee]: %-10s %-10s\n",  buf.getFirstName(), buf.getLastName());
            q = q.getNext();
        }
    }

    /**
     * The getWeeklyEmployees() creates a list of employees with a weekly salary that make more than 35000 a year
     * and have five or more years of tenure.  
     * 
     * @author Samuel Aguirre, ID: 011137110
     */
    public void getWeeklyEmployees(){

        ObjectListNode  p = currentEmployees.getFirstNode();
        while(p != null){
            Employee buf = (Employee) p.getInfo();

            if (buf.getRate() == 'W'){

                weeklyEmployees.addLast(buf);
            }

            p = p.getNext();
        }

        ObjectListNode  q = weeklyEmployees.getFirstNode();
        System.out.println();
        pw.println();
        System.out.println("-[PART E - Employees Who Make More Than $35,000/year And Have Been With The Company For At Least Five Years]-");
        pw.println("-[PART E - Employees Who Make More Than $35,000/year And Have Been With The Company For At Least Five Years]-");
        while(q != null){

            Employee buf = (Employee) q.getInfo();   
            if(buf.getSalary()*52 > 35000 && buf.getTenure() >= 5){

                System.out.printf("[Employee]: %-10s %-10s $%-10.2f\n",  buf.getFirstName(), buf.getLastName(), buf.getSalary());
                pw.printf("[Employee]: %-10s %-10s $%-10.2f\n",  buf.getFirstName(), buf.getLastName(), buf.getSalary());
            }

            q = q.getNext();
        }
    }

    /**
     * The increasePay() gives an increase of weekly and hourly pay to 
     * employees who make a specific amount of salary. 
     * 
     * @author Samuel Aguirre, ID: 011137110
     */
    public void increasePay(){

        ObjectListNode  p = currentEmployees.getFirstNode();
        while(p != null){
            Employee buf = (Employee) p.getInfo();

            if (buf.getRate() == 'W'){

                increaseSalary.addLast(buf);
            }
            if(buf.getRate() == 'H'){

                increaseSalary.addLast(buf);
            }

            p = p.getNext();
        }

        ObjectListNode  q = increaseSalary.getFirstNode();
        System.out.println();
        pw.println();
        System.out.println("------------------[PART F - Increase In Pay]------------------");
        pw.println("------------------[PART F - Increase In Pay]------------------");
        while(q != null){

            Employee buf = (Employee) q.getInfo();   
            if(buf.getRate() == 'H' && buf.getSalary() < 10.0){
                double increaseHourly = 0.75;
                buf.setSalary(buf.getSalary() + increaseHourly);
                System.out.print(String.format("[Employee With A $0.75 Increase In Hourly Pay]: %-10s %-10s $%-10.2f\n",  buf.getLastName(), buf.getFirstName(), buf.getSalary())); 
                pw.print(String.format("[Employee With A $0.75 Increase In Hourly Pay]: %-10s %-10s $%-10.2f\n",  buf.getLastName(), buf.getFirstName(), buf.getSalary())); 
            }
            else if(buf.getRate() == 'W' && buf.getSalary() < 350.0){

                double increaseWeekly = 50.0;
                buf.setSalary(buf.getSalary() + increaseWeekly);
                System.out.print(String.format("[Employee With A $50.0 Increase In Weekly Pay]: %-10s %-10s $%-10.2f\n",  buf.getLastName(), buf.getFirstName(), buf.getSalary())); 
                pw.print(String.format("[Employee With A $50.0 Increase In Weekly Pay]: %-10s %-10s $%-10.2f\n",  buf.getLastName(), buf.getFirstName(), buf.getSalary())); 
            }

            q = q.getNext();
        }

    }

    /**
     * The sortedList() sorts the database of employees by first and last name. And then outputs the sorted 
     * payroll by first and last name, with their salaries as well. 
     * 
     * @author Samuel Aguirre, ID: 011137110
     */
    public void sortedList(){

        ObjectList temp = currentEmployees.copyList();
        ObjectListNode p = temp.getFirstNode();

        while(p != null){
            Employee buf = (Employee) temp.removeFirst();

            sortedEmplyees.insert(buf);

            p = temp.getFirstNode();
        }

        ObjectListNode  q = sortedEmplyees.getFirstNode();
        System.out.println();
        pw.println();
        System.out.println("------------------[PART G - Sorted PayRoll]------------------");
        pw.println("------------------[PART G - Sorted PayRoll]------------------");
        while(q != null){

            Employee buf = (Employee) q.getInfo();

            System.out.print(String.format("[Employee By First/Last Name]: %-10s %-10s $%-10.2f\n", buf.getFirstName(), buf.getLastName(), buf.getSalary()));
            pw.print(String.format("[Employee By First/Last Name]: %-10s %-10s $%-10.2f\n", buf.getFirstName(), buf.getLastName(), buf.getSalary()));
            q = q.getNext();

        }
    }

    /**
     * The getHireList() removes the first node from the hireList list and inserts it into the sortedEmployees list. 
     * Then the objects in the sortedEmployees are then outputed. 
     * 
     * @author Samuel Aguirre, ID: 011137110
     */
    public void getHireList(){

        ObjectListNode p = hireList.getFirstNode();
        while(p != null){
            Employee buf = (Employee) hireList.removeFirst();

            sortedEmplyees.insert(buf);

            p = hireList.getFirstNode();
        }

        ObjectListNode  q = sortedEmplyees.getFirstNode();
        System.out.println();
        pw.println();
        System.out.println("------------------[PART H - Updated PayRoll With Hired Employees]------------------");
        pw.println("------------------[PART H - Updated PayRoll With Hired Employees]------------------");
        while(q != null){

            Employee buf = (Employee) q.getInfo();

            System.out.print(String.format("[Employee By First/Last Name]: %-10s %-10s $%-10.2f\n", buf.getFirstName(), buf.getLastName(), buf.getSalary()));
            pw.print(String.format("[Employee By First/Last Name]: %-10s %-10s $%-10.2f\n", buf.getFirstName(), buf.getLastName(), buf.getSalary()));
            q = q.getNext();

        }

    }

    /**
     * The getFireList() removes the first node from the fireList list and removes the node from the sortedEmployees list. 
     * Then the objects in the sortedEmployees are then outputed. 
     * 
     * @author Samuel Aguirre, ID: 011137110
     */
    public void getFireList(){

        ObjectListNode p = fireList.getFirstNode();

        while(p != null){
            Employee buf = (Employee) fireList.removeFirst();

            sortedEmplyees.remove(buf);

            p = fireList.getFirstNode();
        }

        ObjectListNode  q = sortedEmplyees.getFirstNode();
        System.out.println();
        pw.println();
        System.out.println("------------------[PART J - Updated PayRoll With Fired Employees]------------------");
        pw.println("------------------[PART J - Updated PayRoll With Fired Employees]------------------");
        while(q != null){

            Employee buf = (Employee) q.getInfo();

            System.out.print(String.format("[Employee By First/Last Name]: %-10s %-10s $%-10.2f\n", buf.getFirstName(), buf.getLastName(), buf.getSalary()));
            pw.print(String.format("[Employee By First/Last Name]: %-10s %-10s $%-10.2f\n", buf.getFirstName(), buf.getLastName(), buf.getSalary()));
            q = q.getNext();

        }

    }

}

