
/**
 * The Employee class represents a single employee in the database. 
 *
 * @author Samuel Aguirre
 * @version 11/6/2019
 */
public class Employee implements Comparable
{
    private String firstName;
    private String lastName;
    private char gender;
    private int tenure;
    private char rate;
    private double salary;

    /**
     * Constructor for objects of class Employee
     * 
     * @param first, the frist name of employee; last, the last name of employee; tenure, the tenure of employee
     * @param rate, the rate of employee; salary, employee's salary
     */
    public Employee(String first, String last, char gender, int tenure, char rate, double salary)
    {
        this.firstName = first;
        this.lastName = last;
        this.gender = gender;
        this.tenure = tenure;
        this.rate = rate;
        this.salary = salary;

    }

    /**
     * Two-Arg Constructor for objects of class Employee
     * 
     * @author Samuel Aguirre, ID: 011137110
     * @param first, the frist name of employee; last, the last name of employee
     */
    public Employee(String first, String last){

        this.firstName = first;
        this.lastName = last;
    }

    /**
     * The getFirstName() returns the first name of employee
     * 
     * @author Samuel Aguirre, ID: 011137110
     * @return first name of employee
     */
    public String getFirstName(){

        return firstName; 
    }

    /**
     * The getLastName() returns the last name of employee
     *  
     * @author Samuel Aguirre, ID: 011137110
     * @return last name of the employee
     */
    public String getLastName(){

        return lastName; 
    }

    /**
     * The getGender() returns the gender of employee.
     *  
     * @author Samuel Aguirre, ID: 011137110
     * @return gender of employee.
     */
    public char getGender(){

        return gender; 
    }

    /**
     * The getTenure() returns the tenure of employee. 
     * 
     * @author Samuel Aguirre, ID: 011137110
     * @return tenure of employee
     */
    public int getTenure(){

        return tenure; 
    }

    /**
     * The getRate() returns the rate of employee.
     * 
     * @author Samuel Aguirre, ID: 011137110
     * @return rate of employee
     */
    public char getRate(){

        return rate; 
    }

    /**
     * The getSalary() returns employee's weekly or hourly salary 
     * 
     * @author Samuel Aguirre, ID: 011137110
     * @return  weekly or hourly salary 
     */
    public double getSalary(){

        return salary; 
    }

    /**
     * The setSalary() sets employee salary
     * 
     * @author Samuel Aguirre, ID: 011137110
     * @param newSalary, employee's new salary
     */
    public void setSalary(double newSalary){

        salary = newSalary;
    }

    /**
     * The compareTo() compares two objects, first and last name
     * 
     * @author Samuel Aguirre, ID: 011137110
     * @return lastName.compareTo(buf.getLastName())
     */
    public int compareTo(Object o) {

        Employee buf = (Employee) o;
        return lastName.compareTo(buf.getLastName());
    }
}
