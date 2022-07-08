import java.util.InputMismatchException;
import java.util.*;

class Employee {
    
    private String ID;
    private String Name;
    private String Email;
    
    public Employee(String ID, String Name, String Email) {
        this.ID = ID;
        this.Name = Name;
        this.Email = Email;
    }
    
    public String getID() {
        return ID;
    }
    
    public String getName() {
        return Name;
    }
    
    public String getEmail() {
        return Email;
    }
    
    public void setID(String ID) {
        this.ID = ID;
    }
    
    public void setName(String Name) {
        this.Name = Name;
    }
    
    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    public String toString() {
        return "ID: " + ID + " Name: " + Name + " Email: " + Email; 
    }
}


public class Main {
	public static void main(String[] args) {
	   ArrayList<Employee> list = new ArrayList<>();
	   getUserInput(list);
	}
	
	public static void getUserInput(ArrayList<Employee> list) {
	    Scanner scan = new Scanner(System.in);
	    int exit = 0;
	    do {
	        System.out.println("");
	        System.out.println("1) Add Employee");
	        System.out.println("2) View Employee");
	        System.out.println("3) Update Employee");
	        System.out.println("4) Delete Employee");
	        System.out.println("5) View All Employee ");
	        System.out.println("6) Exit");
	        System.out.printf("Choose the selection: ");
	        int Input = scan.nextInt();
	        scan.nextLine();
	        
	        switch(Input) {
	            case 1:
	            Add(list);
	            break;
	            
	            case 2:
	            View(list);
	            break;
	            
	            case 3:
	            Updated(list);
	            break;     
	           
	            case 4:
	            Delete(list);
	            break;
	            
	            case 5:
	            ViewAll(list);
	            break;
	            
	            case 6:
	            System.out.println("Bye");
	            System.exit(0);
	            break;
	            
	            default: 
	            System.out.println("Enter a valid choice");
	            break;
	        }
	        
	    }while(exit != 6);
	}
	
	public static void Add(ArrayList<Employee> list) { 
	    boolean yes = true;
	    boolean check = false;
	    Scanner scan = new Scanner(System.in);
	    
	    do {
	        try {
	            System.out.printf("Enter ID: ");
	            String ID = scan.nextLine();
	            for(Employee e : list) {
	                if(ID.equals(e.getID())) {
	                    System.out.println("Same ID");
	                    check = true;
	                }
	            }
	            if(check == true) 
	            break;
	            
	            System.out.printf("Enter Name: ");
	            String Name = scan.nextLine();
	            for(Employee e : list) {
	                if(Name.equals(e.getName())) {
	                    System.out.println("Same Name");
	                    check = true;
	                }
	            }
	            if(check == true) 
	            break;
	            
	            System.out.printf("Enter Email: ");
	            String Email = scan.nextLine();
	            for(Employee e : list) {
	                if(Email.equals(e.getEmail())) {
	                    System.out.println("Same Email");
	                    check = true;
	                }
	            }
	            if(check == true) 
	            break;
	            
	            System.out.printf("Press y to add Employee: ");
	            String add = scan.nextLine();
	            
	            if(add.equals("y")) {
	                Employee e = new Employee(ID, Name, Email);
	                list.add(e);
	                yes = false;
	                System.out.println(e.toString() + " has added to Employee");
	            } else {
	                
	                System.out.println("Employee not added");
	                yes = false;
	            }
	        } catch(InputMismatchException error ) {
	            System.out.println("Wrong key");
                    yes = false;
	        }
	    }while(yes == true);
	}
	
	public static void View(ArrayList<Employee> list) { 
	    Scanner scan = new Scanner(System.in);
	    System.out.printf("Enter ID: ");
	    String ID = scan.nextLine();
	    boolean yes = false;
	    for(Employee e : list) {
	        if(ID.equals(e.getID())) {
	            System.out.println(e.toString());
	            yes = true;
	        }
	    }
	    if(!yes) {
	        System.out.println("Employee is not present");
	    }
	}
	
	public static void Updated(ArrayList<Employee> list) {
	    Scanner scan = new Scanner(System.in);
	    System.out.printf("Enter ID: ");
	    String ID = scan.nextLine();
	    boolean found = false;
	    for(Employee e : list) {
	        if(ID.equals(e.getID())) {
	            System.out.println("Enter Name: ");
	            String Name = scan.nextLine();
	            
	            System.out.println("Enter Email: ");
	            String Email = scan.nextLine();
	            
	            e.setName(Name);
	            e.setEmail(Email);
	            System.out.println("Updated details of Employee successfully are: ");
                    System.out.println(e);	        
	            found = true;
	        }
	    }
	    if(!found) {
	        System.out.println("Employee is not present");
	    } else {
	        System.out.println("Employee details updated successfully !!");
	    }
	}
	
	public static void Delete(ArrayList<Employee> list) {
	    Scanner scan = new Scanner(System.in);
	    boolean found = false;
	    System.out.printf("Enter ID: ");
	    String ID = scan.nextLine();
	    Employee eDelete = null;
	    for(Employee e : list) {
	        if(ID.equals(e.getID())) {
	            eDelete = e;
	            found = true;
	        }
	    }
	    if(!found) {
	        System.out.println("Employee is not present");
	    }
	    else {
	        list.remove(eDelete);
	        System.out.println("Employee deleted successfully!!");
	    }
	}
	
	public static void ViewAll(ArrayList<Employee> list) {
	    for(Employee e : list) {
	        System.out.println(e);
	    }
	}
}
