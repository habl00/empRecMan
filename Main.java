package Logically;

import java.util.Scanner;

public class Main {
	
	
	    //creating an object scanner
	    private static final Scanner scanner = new Scanner(System.in);
	    
	    //creating an object (employee manager)                     -> calling the constructor 
	    private static final EmployeeManagement employeeManager = new EmployeeManagement();

	    
	    public static void main(String[] args) {

	    	//the start display methods
	    	
	    	int choice;
	        boolean quit = false;
	    	
	        welcome();
	        while (!quit) {

	            operations();

	            while (true) {
	                System.out.println("Enter a number (1-7) :");
	                
	                
	                String inp = scanner.nextLine();
	                
	                try {
	                	
	                    choice = Integer.parseInt(inp);
	                    
	                    if (choice >= 1 && choice <= 7) 
	                    	break;
	                    else 
	                    	System.err.println("Wrong number. Enter a number between (1-7)");
	                } 
	                catch (Exception e) {
	                    System.err.println("Wrong number. Enter a number between (1-7)");
	                }
	            }

	            switch (choice) {
	                case 1:
	                	// lines 102  119
	                    addEmployee();
	                    break;
	                case 2:
	                	// line 173
	                    updateEmployee();
	                    break;
	                case 3:
	                	//line 249
	                    searchEmployee();
	                    break;
	                case 4:
	                    employeeManager.displayRecords();
	                    break;
	                case 5:
	                    deleteEmployee();
	                    break;
	                case 6:
	                    employeeManager.generateFile();
	                    break;
	                case 7:
	                    quit = true;
	                    System.out.println("See you Later!");
	                    break;

	                default:
	                    System.err.println("Enter a valid option (1-7).");

	            }
	        }

	    }

	    //gets executed first regardless the choice
	    
	    private static void welcome() {
	        System.out.println("\n\nWelcome to LOGICALY employees' records manager!");
	    }

	    //gets executed in a loop
	    
	    private static void operations() {
	        System.out.println(
	                "======++Operations Menu++======\n" +
	                        "1. Add a new employee\n" +
	                        "2. Update an employee\n" +
	                        "3. Search an employee\n" +
	                        "4. Display all employees' records\n" +
	                        "5. Delete an employee\n" +
	                        "6. Generate a file\n" +
	                        "7. Exit\n");
	    }


	    
	    // Number 1
	    
	    private static void addEmployee() {
	    	//creating an object from employee class
	        Employee newEmployee = new Employee();
	        
	        //bellow method (line 115)
	        setData(newEmployee);
	        
	        
	        if (employeeManager.addEmployee(newEmployee)) {
	            System.out.println("Employee added successfully.\n");
	        } else {
	            System.out.println("Employee is already in the records");
	        }
	    }

	    //Number 1 
	    // method to create newEployees of Type Employee
	    private static void setData(Employee newEmployee) {
	    	
	        try {
	        	
	            System.out.println("Enter employee number. Starting with 'E01' followed by 2 digits different than 00");
	            
	            String employeeNumber = scanner.nextLine();
	            
	        //newEmployee line102 accesses setter line 35 in Employee class to check the validity of the number with regex 
	            newEmployee.setEmployeeNumber(employeeNumber);
	           
	            //if entered correctly we move on to the next 
	           
	            System.out.println("Enter employee name within two words ");
	            String name = scanner.nextLine();
	            newEmployee.setName(name);
	            
	            //same
	            System.out.println("Enter employee title (Manager, Director, Assistant, Supervisor, Trainee)");
	            String title = scanner.nextLine();
	            newEmployee.setTitle(title);
	            
	            //same
	            System.out.println("Enter employee department (Sales, R&D, IT, PROD, HR)");
	            String department = scanner.nextLine();
	            newEmployee.setDepartment(department);
	            
	            //same
	            System.out.println("Enter employee phone number. Consists of 10 digits. Starting with 06 or 07, followed by 5,7,9 or 0");
	            String phoneNumber = scanner.nextLine();
	            newEmployee.setPhoneNumber(phoneNumber);
	            
	            //same
	            System.out.println("Enter employee email address. Starting with one or two letters, followed by a dot(.) and " +
	                    "3-10 alphabets. Then an underscore and a digit. Lasty add '@logicaly.net'");
	            String emailAddress = scanner.nextLine();
	            newEmployee.setEmailAddress(emailAddress);
	            
	        } 
	        
	        catch (InvalidEmployeeDetailException e) {
	            System.err.println(e.getMessage());
	            //if fails we must do it again
	            setData(newEmployee);
	        }
	    }

	    // Number 2
	    //method to update employee
	    
	    private static void updateEmployee() {
	        System.out.println("Enter employee number. Starting with 'E01' followed by 2 digits different than 00");
	        
	        String employeeNumber = scanner.nextLine();
	        //change existed employees line 64 in EmMan
	        Employee existingEmployee = employeeManager.getEmployee(employeeNumber);

	        if (existingEmployee == null) {
	            System.err.println("Employee not found\n");
	            return;
	        }
	        
	        boolean exit = false;
	        int input;

	        while (!exit) {
	            System.out.println("Which detail do you want to update?");
	            //line 236
	            updateWelcome();

	            while (true) {
	                System.out.println("Enter a number (1-7)");
	                String inp = scanner.nextLine();
	                try {
	                    input = Integer.parseInt(inp);
	                    
	                    //Enter the number and break to the switch line 210
	                    if (input >= 1 && input <= 7) 
	                    	break;
	                    else
	                    	System.err.println("Wrong number. Enter a number between (1-7)");

	                } catch (Exception e) {
	                    System.err.println("Wrong number. Enter a number between (1-7)");
	                }
	            }


	            switch (input) {
	                case 1:
	                    updateEmployeeNumber(existingEmployee);
	                    break;
	                case 2:
	                    updateEmployeeName(existingEmployee);
	                    break;
	                case 3:
	                    updateEmployeeTitle(existingEmployee);
	                    break;
	                case 4:
	                    updateEmployeeDepartment(existingEmployee);
	                    break;
	                case 5:
	                    updateEmployeePhoneNumber(existingEmployee);
	                    break;
	                case 6:
	                    updateEmployeeEmailAddress(existingEmployee);
	                    break;
	                case 7:
	                    exit = true;
	                    System.out.println("Update done\n");
	                    break;
	                default:
	                    System.err.println("Enter a valid option (1-7)");
	            }
	        }

	    }

	    private static void updateWelcome() {
	        System.out.println(
	                        "\n1. Employee Number" +
	                        "\n2. Employee Name" +
	                        "\n3. Employee Title" +
	                        "\n4. Employee Department" +
	                        "\n5. Employee PhoneNumber" +
	                        "\n6. Employee EmailAddress" +
	                        "\n7. Exit");
	    }
	    

	    private static void searchEmployee() {
	        System.out.println("Enter employee number. Starting with 'E01' followed by 2 digits different than 00");
	        String employeeNumber = scanner.nextLine();
	        Employee existingEmployee = employeeManager.getEmployee(employeeNumber);

	        if (existingEmployee == null) {
	            System.err.println("Employee not found\n");
	            return;
	        }

	        System.out.println("employee id : " + existingEmployee.getId() +
	                "\nemployee number :" + existingEmployee.getEmployeeNumber() +
	                "\nemployee name : " + existingEmployee.getName() +
	                "\nemployee title : " + existingEmployee.getTitle() +
	                "\nemployee department : " + existingEmployee.getDepartment() +
	                "\nemployee phone number : " + existingEmployee.getPhoneNumber() +
	                "\nemployee email : " + existingEmployee.getEmailAddress() + "\n");
	    }

	    
	    private static void deleteEmployee() {
	        System.out.println("Enter valid employee number. Starting with 'E01' followed by 2 digits different than 00.");
	        String employeeNumber = scanner.nextLine();
	        Employee existingEmployee = employeeManager.getEmployee(employeeNumber);

	        if (existingEmployee == null) {
	            System.err.println("Employee not found\n");
	            return;
	        }

	        if (employeeManager.deleteEmployee(existingEmployee)) {
	            System.out.println("Employee record deleted \n");
	        } else {
	            System.out.println("There was an error deleting the record");
	        }
	    }

	    private static void updateEmployeeNumber(Employee newEmployee) {
	        try {
	            System.out.println("Enter valid employee number. Starting with 'E01' followed by 2 digits different than 00.");
	            String employeeNumber = scanner.nextLine();
	            boolean t = employeeManager.isEmployeeExists(employeeNumber);
	            if (t) {
	            	// throw exception
	                throw new InvalidEmployeeDetailException();
	            } else {
	                newEmployee.setEmployeeNumber(employeeNumber);
	                System.out.println("Employee number is updated successfully.\n");
	            }
	        } catch (InvalidEmployeeDetailException ex) {
	            System.err.println("Invalid input details");
	            System.out.println("Please enter a different employee number.");
	            //don't exit re do everything
	            updateEmployeeNumber(newEmployee);
	        }
	    }

	    private static void updateEmployeeName(Employee newEmployee) {

	        try {
	            System.out.println("Enter valid employee name within two words.");
	            String name = scanner.nextLine();
	            newEmployee.setName(name);
	            System.out.println("Employee name is updated .\n");
	        } catch (InvalidEmployeeDetailException ex) {
	            System.err.println("Invalid input details");
	            updateEmployeeName(newEmployee);
	        }
	    }


	    private static void updateEmployeeTitle(Employee newEmployee) {
	        try {
	            System.out.println("Enter employee title. (Manager, Director, Assistant, Supervisor, Trainee)");
	            String title = scanner.nextLine();
	            newEmployee.setTitle(title);
	            System.out.println("Employee title is updated.\n");
	        } catch (InvalidEmployeeDetailException ex) {
	            System.err.println("Invalid input details");
	            updateEmployeeTitle(newEmployee);
	        }
	    }


	    private static void updateEmployeeDepartment(Employee newEmployee) {
	        try {
	            System.out.println("Enter valid employee department. (Sales, R&D, IT, PROD, HR)");
	            String department = scanner.nextLine();
	            newEmployee.setDepartment(department);
	            System.out.println("Employee department is updated successfully.\n");
	        } catch (InvalidEmployeeDetailException ex) {
	            System.err.println("Invalid input details");
	            updateEmployeeDepartment(newEmployee);
	        }
	    }


	    private static void updateEmployeePhoneNumber(Employee newEmployee) {
	        try {
	            System.out.println("Enter valid employee phone number. Consists of 10 digits. Starting with 06 or 07, followed by 5,7,9 or 0. ");
	            String phoneNumber = scanner.nextLine();
	            newEmployee.setPhoneNumber(phoneNumber);
	        } catch (InvalidEmployeeDetailException ex) {
	            System.err.println("Invalid input details");
	            updateEmployeePhoneNumber(newEmployee);
	        }
	    }


	    private static void updateEmployeeEmailAddress(Employee newEmployee) {
	        try {
	            System.out.println("Enter valid employee email address. Starting with one or two letters, followed by a dot(.) and " +
	                    "3-10 alphabets, can contain at most one underscore or digit. Lastly add '@logicaly.net'.");
	            String emailAddress = scanner.nextLine();
	            newEmployee.setEmailAddress(emailAddress);
	            System.out.println("Employee email address is updated successfully.");
	        } catch (InvalidEmployeeDetailException ex) {
	            System.err.println(ex.getMessage());
	            updateEmployeeEmailAddress(newEmployee);
	        }
	    }
	
		
		
		
		
	}


