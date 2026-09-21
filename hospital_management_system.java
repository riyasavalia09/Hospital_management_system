import java.util.*;

class Patient
{
    int patientId;
    String name;
	int age;
    String disease;
    String admitDate;
    String dischargeDate;
	String roomType;
    Patient(int patientId, String name,int age, String disease,String admitDate,String dischargeDate,String roomType)
	{
        this.patientId = patientId;
        this.name = name;
		this.age = age;
        this.disease = disease;
		this.admitDate=admitDate;
		this.dischargeDate=dischargeDate;
		this.roomType=roomType;
    }
    void displayDetails()
	{
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
		System.out.println("Age: " + age);
        System.out.println("Disease: " + disease);
		System.out.println("admitDate:" +admitDate);
		System.out.println("dischargeDate:" + dischargeDate);
		System.out.println("roomType:" + roomType);
    }
    double calculateTreatmentBill()
	{
        double baseAmount = 100.0;
        double additionalCharge = 0.0;
		double roomCharge = 0.0;
        switch (disease.toLowerCase()) 
		{
            case "flu":
                additionalCharge = 50.0;
                break;
            case "covid":
                additionalCharge = 200.0;
                break;
            case "injury":
                additionalCharge = 150.0;
                break;
            default:
                additionalCharge = 30.0;
                break;
        }
        if (age > 60) 
		{
            additionalCharge *= 0.8; // 20% discount
        }
		switch (roomType.toLowerCase()) 
        {
			case "general":
				roomCharge = 500.0; // Fixed charge for general room
				break;
			case "special":
				roomCharge = 1000.0; // Fixed charge for special room
				break;
			default:
				roomCharge = 300.0; // Default charge for unknown room type
				break;
        }
        return baseAmount + additionalCharge + roomCharge;
    }
	 void updateDetails(String name, int age, String disease, String admitDate, String dischargeDate, String roomType) 
	 {
        this.name = name;
        this.age = age;
        this.disease = disease;
        this.admitDate = admitDate;
        this.dischargeDate = dischargeDate;
        this.roomType = roomType;
    }
}
class Doctor 
{
	int doctorId;
	String name;
	String specialization;
	boolean isAvailable;
	Doctor(int doctorId, String name, String specialization, boolean isAvailable) 
	{
		this.doctorId = doctorId;
		this.name = name;
		this.specialization = specialization;
		this.isAvailable = isAvailable;
    }
    void displayDetails() 
	{
        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Name: " + name);
        System.out.println("Specialization: " + specialization);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Not Available"));
    }
}
 class HospitalManagementSystem
 {
    public static void main(String[] args)
	{
		Patient[] patients = new Patient[10];
		Doctor[] doctors = new Doctor[10]; // Adjust size as needed
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\nHospital Management System");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Search Patient by ID");
			System.out.println("4. Delete Patient");
			System.out.println("5. Generate Bill");
			System.out.println("6. Update Patient Details");
			System.out.println("7. Add Doctor");
			System.out.println("8. View Doctors");
			System.out.println("9. Assign Doctor to Patient");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume the newline character
            switch (choice)
			{
                case 1:
                    method.addPatient(patients);
                    break;
                case 2:
                    method.viewPatients(patients);
                    break;
                case 3:
                    method.searchPatient(patients);
                    break;
				case 4:
				    method.deletePatient(patients);
					break;
				case 5:
				    method.generateBill(patients);
					break;
				case 6:
                    method.updatePatientDetails(patients);
                    break;
				case 7:
					method.addDoctor(doctors);
					break;
				case 8:
					method.viewDoctors(doctors);
					break;
				case 9:
					method.assignDoctorToPatient(patients, doctors);
					break;
				case 10:
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        } while (choice != 10);
    }     
 }
class method
{
	static int patientCount = 0;
	static void addPatient(Patient[] p1)
	{
		Scanner sc = new Scanner(System.in);
        if (patientCount < p1.length)
			{
            System.out.print("Enter Patient ID: ");
            int id = sc.nextInt();
            sc.nextLine(); // Consume newline
            System.out.print("Enter Patient Name: ");
            String name = sc.nextLine();
			System.out.print("Enter Patient Age: ");
            int age = sc.nextInt();
			sc.nextLine();
            System.out.print("Enter Disease: ");
            String disease = sc.nextLine();
			System.out.print("Enter Admit Date (dd-MM-yyyy): ");
            String admitDate = sc.nextLine();
            System.out.print("Enter Discharge Date (dd-MM-yyyy): ");
            String dischargeDate = sc.nextLine();
            System.out.print("Enter Room Type (General/Special): ");
            String roomType = sc.nextLine();
            p1[patientCount++] = new Patient(id, name,age,disease,admitDate,dischargeDate,roomType);
            System.out.println("Patient added successfully.");
            } 
		else 
		{
            System.out.println("Sorry, the system is full. Can't add more patients.");
        }
    }
     static void viewPatients(Patient[] p2) 
	 {
		Scanner sc = new Scanner(System.in);
        if (patientCount == 0)
			{
            System.out.println("No patients to display.");
            }
		else 
		   {
            System.out.println("\nList of Patients:");
				for (int i = 0; i < patientCount; i++) 
				{
					p2[i].displayDetails();
					System.out.println("----------------------------");
				}
           }
    }
	 static void searchPatient(Patient[] p3)
	 {
	    Scanner sc = new Scanner(System.in);
        System.out.print("Enter Patient ID to search: ");
        int searchId = sc.nextInt();
        boolean found = false;
        for (int i = 0; i < patientCount; i++) 
		{
            if (p3[i].patientId == searchId)
				{
                p3[i].displayDetails();
                found = true;
                break;
                }
        }
        if (!found)
			{
            System.out.println("Patient with ID " + searchId + " not found.");
            }
	}
	static void deletePatient(Patient[] p4)
	{
        Scanner sc = new Scanner(System.in);
			if (patientCount == 0) 
			{
				System.out.println("No patients to delete.");
				return;
			}
        System.out.print("Enter Patient ID to delete: ");
        int deleteId = sc.nextInt();
        boolean found = false;
			for (int i = 0; i < patientCount; i++)
				{
				if (p4[i].patientId == deleteId)
					{
					// Shift the elements to remove the patient
					for (int j = i; j < patientCount - 1; j++)
						{
						p4[j] = p4[j + 1];
						}
					// Set the last patient to null (optional)
					p4[patientCount - 1] = null;
					patientCount--; // Decrease the count of patients
					System.out.println("Patient with ID " + deleteId + " has been deleted.");
					found = true;
					break;
				   }
				}
			if (!found) 
			{
				System.out.println("Patient with ID " + deleteId + " not found.");
			}
    }
    static void generateBill(Patient[] p5)
	{
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter Patient ID to generate the bill: ");
        int patientId = sc.nextInt();
        boolean found = false;
        for (int i = 0; i < patientCount; i++) 
		{
            if (p5[i] != null && p5[i].patientId == patientId) 
			{
                double bill = p5[i].calculateTreatmentBill();
                System.out.println("\nBill for Patient ID " + patientId + ":");
                System.out.println("Total Amount: $" + bill);
                found = true;
                break;
            }
        }
        if (!found) 
		{
            System.out.println("Patient with ID " + patientId + " not found.");
        }
    }
    static void updatePatientDetails(Patient[] p6)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Patient ID to update details: ");
		int patientId = sc.nextInt();
		sc.nextLine(); // Consume newline
		boolean found = false;
		for (int i = 0; i < patientCount; i++)
			{
				if (p6[i] != null && p6[i].patientId == patientId) 
				    {
						System.out.println("Updating details for Patient ID " + patientId);
						System.out.println("Leave a field blank to retain the current value.");
						System.out.print("Enter new Name (" + p6[i].name + "): ");
						String name = sc.nextLine();
						if (!name.isEmpty()) 
						{
							p6[i].name = name;
				        }
						System.out.print("Enter new Age (" + p6[i].age + "): ");
						String ageInput = sc.nextLine();
						if (!ageInput.isEmpty()) 
						{
							int age = Integer.parseInt(ageInput);
							p6[i].age = age;
						}
						System.out.print("Enter new Disease (" + p6[i].disease + "): ");
						String disease = sc.nextLine();
						if (!disease.isEmpty()) 
						{
							p6[i].disease = disease;
						}
						System.out.print("Enter new Admit Date (" + p6[i].admitDate + "): ");
						String admitDate = sc.nextLine();
						if (!admitDate.isEmpty())
						{
							p6[i].admitDate = admitDate;
						}
						System.out.print("Enter new Discharge Date (" + p6[i].dischargeDate + "): ");
						String dischargeDate = sc.nextLine();
						if (!dischargeDate.isEmpty()) 
						{
							p6[i].dischargeDate = dischargeDate;
						}
						System.out.print("Enter new Room Type (" + p6[i].roomType + "): ");
						String roomType = sc.nextLine();
						if (!roomType.isEmpty())
						{
							p6[i].roomType = roomType;
						}
						System.out.println("Patient details updated successfully.");
						found = true;
						break;
					}
			}
		if (!found) 
			{
				System.out.println("Patient with ID " + patientId + " not found.");
			}
	}
    static int doctorCount = 0;
    static void addDoctor(Doctor[] d1) 
	{
        Scanner sc = new Scanner(System.in);
        if (doctorCount < d1.length) 
		{
            System.out.print("Enter Doctor ID: ");
            int id = sc.nextInt();
            sc.nextLine(); // Consume newline
            System.out.print("Enter Doctor Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Specialization: ");
            String specialization = sc.nextLine();
            System.out.print("Is the doctor available? (true/false): ");
            boolean isAvailable = sc.nextBoolean();
            d1[doctorCount++] = new Doctor(id, name, specialization, isAvailable);
            System.out.println("Doctor added successfully.");
        } 
		else 
		{
            System.out.println("Sorry, the system is full. Can't add more doctors.");
        }
    }
    static void viewDoctors(Doctor[] d2) 
	{
        if (doctorCount == 0) 
		{
            System.out.println("No doctors to display.");
        } 
		else 
		{
            System.out.println("\nList of Doctors:");
            for (int i = 0; i < doctorCount; i++) 
			{
                d2[i].displayDetails();
                System.out.println("----------------------------");
            }
        }
    }
    static void assignDoctorToPatient(Patient[] p7, Doctor[] d3) 
	{
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Patient ID: ");
        int patientId = sc.nextInt();
        sc.nextLine(); 
        Patient patient = null;
        for (int i = 0; i < p7.length; i++) 
		{
            if (p7[i] != null && p7[i].patientId == patientId) 
			{
                patient = p7[i];
                break;
            }
        }
        if (patient == null) 
		{
            System.out.println("Patient with ID " + patientId + " not found.");
            return;
        }
        System.out.println("Available doctors:");
        boolean doctorAvailable = false;
        for (int i = 0; i < doctorCount; i++) 
		{
            if (d3[i].isAvailable) 
			{
                System.out.println("Doctor ID: " + d3[i].doctorId + ", Name: " + d3[i].name + ", Specialization: " + d3[i].specialization);
                doctorAvailable = true;
            }
        }
        if (!doctorAvailable) 
		{
            System.out.println("No available doctors at the moment.");
            return;
        }
        System.out.print("Enter Doctor ID to assign: ");
        int doctorId = sc.nextInt();
        Doctor doctor = null;
        for (int i = 0; i < doctorCount; i++) 
		{
            if (d3[i].doctorId == doctorId) 
			{
                doctor = d3[i];
                break;
            }
        }
        if (doctor == null || !doctor.isAvailable) 
		{
            System.out.println("Doctor with ID " + doctorId + " is not available.");
            return;
        }
        doctor.isAvailable = false;
        System.out.println("Doctor " + doctor.name + " has been assigned to Patient " + patient.name + ".");
    }
}