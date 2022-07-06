import java.util.*;
import java.util.InputMismatchException;

class ProjMember {
    private String ID;
    private String Name;
    private String Email;
    
    public ProjMember(String ID, String Name, String Email) {
        this.ID = ID;
        this.Name = Name;
        this.Email = Email;
    }
    
    public String GetID() {
        return ID;
    }
    
    public String GetName() {
        return Name;
    }
    
    public String GetEmail() {
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

class ProjTeam {
    private String Team_Name;
    private ArrayList<ProjMember> list;
    
    public ProjTeam(String Team_Name) {
        this.list = list;
        this.Team_Name = Team_Name;
    }
    
    public String GetTeamName() {
        return Team_Name;
    }
    
    public void setTeamName() {
        this.Team_Name = Team_Name;
    }
    
    @Override
    public String toString() {
        return list.toString() + " Team: " + Team_Name;
    }
}

public class Main {
    private static ArrayList<ProjTeam> List = new ArrayList<>(); 
    
    public static void main(String [] argv) {
        ArrayList<ProjMember> list = new ArrayList<>();
        getUserInput(list);
    }
    
    public static void getUserInput(ArrayList<ProjMember> list) {
        Scanner scan = new Scanner(System.in);
        int exit = 0;
        do{
            System.out.println();
	        System.out.println("1 Add member");
	        System.out.println("2 Remove member");
		    System.out.println("3 Add project team");
		    System.out.println("4 Add member to project team");
	     	System.out.println("5 Remove member from project team");
	     	System.out.println("6 Print all teams");
		    System.out.println("7 Quit");
	        System.out.printf("Your selection: ");
	        System.out.println(" ");
	        int Input = scan.nextInt();
	        scan.nextLine();    //clear buffer
	        
            switch(Input) {
              case 1:
              Add(list); //Done
              break;
              
              case 2:
              Remove(list);
              break;
              
              case 3:
              Team(List); //Done
              break;
              
              case 4:
              AddMembertoTeam(list);
              break;

              case 6:
              PrintAll(List);
              break;
              
              case 7:
              System.out.println("Quit");
              System.exit(0);
              break;
            }
            
        }while(exit != 7);
    }
    
    public static void Add(ArrayList<ProjMember> list) { //1) Done
        boolean yes = true;
        boolean check = false;
        Scanner scan = new Scanner(System.in);
        do{
            try{
                System.out.printf("Enter ID: ");
                String ID = scan.nextLine();
                for(ProjMember p : list) {
                    if(ID.equals(p.GetID())) {
                       System.out.println("Same ID");
                       check = true;
                    }
                }
                if(check == true)
                break;
                
                System.out.printf("Enter Name: ");
                String Name = scan.nextLine();
                for(ProjMember p : list) {
                    if(Name.equals(p.GetName())) {
                        System.out.println("Same Name");
                        check = true;
                    }
                }
                if(check == true)
                break;
                
                System.out.printf("Enter Email: ");
                String Email = scan.nextLine();
                for(ProjMember p : list) {
                    if(Email.equals(p.GetEmail())) {
                        System.out.println("Same Email");
                        check = true;
                    }
                }
                if(check == true)
                break;
                
                System.out.printf("Press y to add member? (y/n)");
                String add = scan.nextLine();
                
                if(add.equals("y")) {
                    ProjMember test1 = new ProjMember(ID, Name, Email);
                    list.add(test1);
                    yes = false;
                    System.out.println("ID: " + ID + " Name: " + Name + " Email: " + Email + " has been added to Members");
                }
                else {
                    System.out.println("No Members found");
                     yes = false;
                }
                
            } catch(InputMismatchException error) {
                System.out.println("Wrong key");
                yes = false;
            }
            
        }while(yes == true);
    }
    
    public static void Remove(ArrayList<ProjMember> list) { //2) Cannot do remove member from team(having some error)
        boolean yes = true;
        boolean check = false;
        Scanner scan = new Scanner(System.in);
        System.out.printf("Enter to Remove ID: ");
        String ID = scan.nextLine();
                
        System.out.printf("Press y to Remove member ID (y/n) ");
        String remove = scan.nextLine();
                
        if(remove.equals("y")) {
            for(ProjMember p : list) {
                if(ID.equals(p.GetID())) {
                    list.remove(p);
                    check = true;
                 }
                 else {
                    System.out.println("No Member is remove");
                    check = true;
                 }
             }
         }
         if(yes == true) {
            System.out.println("Invalid Member");
         }
        
    }
    
    public static void Team(ArrayList<ProjTeam> List) { //3) Done
        boolean yes = true;
        boolean check = false;
        Scanner scan = new Scanner(System.in);
        do {
            try {
                 System.out.printf("Enter Team Name: ");
                 String Team_Name = scan.nextLine();
                 for(ProjTeam p : List) {
                     if(Team_Name.equals(p.GetTeamName())) {
                         System.out.println("Same Team Name");
                         check = true;
                     }
                 }
                 if(check == true)
                 break;
                 
                 System.out.printf("Press y to create team (y/n)? ");
                 String add = scan.nextLine();
                 
                 if(add.equals("y")) {
                     ProjTeam test2 = new ProjTeam(Team_Name);
                     List.add(test2);
                     yes = false;
                     System.out.println(Team_Name + " has been created");
                 }
                 else {
                     System.out.println("Team has not been created");
                     yes = false;
                 }
                 
            } catch(InputMismatchException error) {
                System.out.println("Wrong key");
                yes = false;
            }
            
        }while(yes == true);
    }
    
    public static void AddMembertoTeam(ArrayList<ProjMember> list) { //4) error adding member to team
        ArrayList<ProjTeam> List = new ArrayList<>();
        Boolean yes = true;
        Scanner scan = new Scanner(System.in);
        do{
            try{
                System.out.printf("Enter Team Name: ");
                String Team_Name = scan.nextLine();
                
                System.out.printf("Enter ID: ");
                String ID = scan.nextLine();

                System.out.printf("Add Member to Team (y/n)?: ");
                String add = scan.nextLine();

                if(add.equals("y")) {
                  for(ProjTeam p : List) {
                    if(Team_Name.equals(p.GetTeamName())) {
                        System.out.println(Team_Name + " has been added");
                        break;
                    }
                    ProjTeam test1 = new ProjTeam(Team_Name);
                    List.add(test1);
                    yes = false;
                  }
                  for(ProjMember p : list) {
                    if(ID.equals(p.GetID())) {
                        System.out.println("Member has been added to team");
                        break;
                    }
                    ProjMember test2 = new ProjMember(ID,Name,Email);
                    list.add(test2);
                    yes = false;
                  }
                  System.out.println("ID: " + ID + " Team Name: " + Team_Name); 
                   break;    
                }
                else {
                    System.out.println("Error");
                    yes =false;
                }

            }catch(InputMismatchException error) {
                System.out.println("Wrong key");
                yes = false;
            }
        }while(yes == true);
    }
    
       public static void PrintAll(ArrayList<ProjTeam> List) { //6) error reading toString

        for(ProjTeam p : List) {
            System.out.println(p.toString());
        }
     }
    
}