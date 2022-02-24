package Logically;


public class Employee {
    private static int idCount = 0;
    private final int id;
    private String employeeNumber;
    private String name;
    private String title;
    private String department;
    private String phoneNumber;
    private String emailAddress;

    // constructor to add to the id count
    
    public Employee() {
        this.id = ++idCount;
    }
    
    // getter for id
    
    public int getId() {
        return id;
    }
    
    //getter for employee number
    
    public String getEmployeeNumber() {
        return employeeNumber;
    }

    //setter for employee number with regex and throw exception
    
    public void setEmployeeNumber(String employeeNumber) {
        boolean regex = employeeNumber.matches("^E01(0[1-9]|[1-9]{2}|[1-9]0)$");
        if (regex) {
            this.employeeNumber = employeeNumber;
        } else {
            throw new InvalidEmployeeDetailException("Invalid Employee number :" + employeeNumber);
        }
    }

    //getter for name
    
    public String getName() {
        return name;
    }
    
    //setter for name with regex and throw exception

    public void setName(String name) {
        boolean nameReg = name.matches("^[a-zA-Z]{3,10} [a-zA-Z]{3,10}$");
        if (nameReg) {
            this.name = name;
        } else {
            throw new InvalidEmployeeDetailException("Invalid Name: " + name);
        }
    }

    //getter for title

    public String getTitle() {
        return title;
    }

    //setter for title with regex and throw exception
    
    public void setTitle(String title) {
        boolean titReg = title.matches("^(?i)(director|manager|supervisor|trainee|assistant)$");
        if (titReg) {
            this.title = title;
        } else {
            throw new InvalidEmployeeDetailException("Invalid Title: " + title);
        }
    }
    
    //getter 

    public String getDepartment() {
        return department;
    }

    //setter 
    
    public void setDepartment(String department) {
        boolean depReg = department.matches("^(?i)(it|sales|r&d|prod|hr)$");
        if (depReg) {
            this.department = department;
        } else {
            throw new InvalidEmployeeDetailException("Invalid Department: " + department);
        }
    }

    //getter
    
    public String getPhoneNumber() {
        return phoneNumber;
    }

    //setter
    
    public void setPhoneNumber(String phoneNumber) {
        boolean phoReg = phoneNumber.matches("^0[6|7][56790][0-9]{7}$");
        if (phoReg) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new InvalidEmployeeDetailException("Invalid Phone Number: " + phoneNumber);
        }
    }
    
    //getter

    public String getEmailAddress() {
        return emailAddress;
    }
    
    //setter

    public void setEmailAddress(String emailAddress) {
        boolean emaReg = emailAddress.matches("^[a-zA-Z]{1,2}\\.[a-zA-Z0-9_]{3,10}@logicaly.net$");
        if (emaReg) {
            this.emailAddress = emailAddress;
        } else {
            throw new InvalidEmployeeDetailException("Invalid Email: "+emailAddress);
        }
    }
    
    public String toString() {
        return "\n" +
                "employee id " + id + '\n' +
                "employee number " + employeeNumber + '\n' +
                "employee name " + name + '\n' +
                "employee title " + title + '\n' +
                "employee department " + department + '\n' +
                "employee phone number " + phoneNumber + '\n' +
                "employee email " + emailAddress + '\n' +
                '\n';
    }

}

