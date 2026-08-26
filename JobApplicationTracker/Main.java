import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<JobApplication> applications = new ArrayList<>(); //Declare array list

        int choice = 0;

        while(choice != 5) { // Display for user
            System.out.println("\n\n=========JOB APPLICATION TRACKER=========");
            System.out.println("1. Add Application");
            System.out.println("2. View Applications");
            System.out.println("3. Remove application(s)");
            System.out.println("4. Statistics");
            System.out.println("5. Exit");
            System.out.println("\nChoose an option: ");

            choice = scan.nextInt();
            scan.nextLine();

        switch(choice) {
            case 1: // Add applications
                System.out.print("Which company are you applying for? ");
                String company = scan.nextLine();

                System.out.print("Which position are you applying for? ");
                String position = scan.nextLine();

                System.out.print("Any notes about this application? ");
                String notes = scan.nextLine();

                System.out.println("\nWhat is the current status?");
                System.out.println("1. Applied");
                System.out.println("2. Interview");
                System.out.println("3. Offer");
                System.out.println("4. Rejected");
                System.out.println("Choose a status: ");
                
                int statusChoice = scan.nextInt();
                scan.nextLine();

                if(statusChoice < 1 || statusChoice > 4) {
                    System.out.println("Invalid status choice.");
                    break;
                }
                Status status;

                switch(statusChoice) {
                    case 1:
                        status = Status.APPLIED;
                        break;

                    case 2:
                        status = Status.INTERVIEW;
                        break;

                    case 3:
                        status = Status.OFFER;
                        break;

                    case 4:
                        status = Status.REJECTED;
                        break;

                    default:
                        System.out.println("Invalid status.");
                        status = Status.APPLIED;
                        break;
                }

                JobApplication application = new JobApplication(company, position, status, notes);

                applications.add(application);

                System.out.println("\nApplication added!");
                break;

            case 2: // View applications
                System.out.println("\n------------------\nAPPLICATIONS\n------------------ ");
                if(applications.isEmpty()) {
                    System.out.println("\nSorry, you have no pending applications.");
                } else {

                for(JobApplication app : applications) { //Retrieve details
                    System.out.println("\nCompany: " + app.getCompany());
                    System.out.println("Position: " + app.getPosition());
                    System.out.println("Status: " + app.getStatus());
                    System.out.println("\nNotes: " + app.getNotes());
                    }
                }
                break;

            case 3: // Application removal
                System.out.println("Remove Application(s)!");
                
                if(applications.isEmpty()) {
                    System.out.println("\nThere are no applications to remove.");
                    break;
                }

                System.out.println("\n===== APPLICATIONS =====");

                for(int i = 0; i < applications.size(); i++) {
                    JobApplication app = applications.get(i);

                    System.out.println((i + 1) + ". " + app.getCompany() + " - " + app.getPosition() + " - " + app.getStatus());
                }
                System.out.print("\nWhich application would you like to remove: ");
                int removeChoice = scan.nextInt();

                if(removeChoice < 1 || removeChoice > applications.size()) { //Error handling
                    System.out.println("Invalid application number.");
                } else {
                    int index = removeChoice - 1;
                    applications.remove(index);

                    System.out.println("\nApplication removed!");
                }
                break;

            case 4: // Statistics
                int applied = 0, interviews = 0, offers = 0, rejected = 0;

                for(JobApplication app: applications) {
                    if(app.getStatus() == Status.APPLIED) {
                        applied++;
                    }
                    else if(app.getStatus() == Status.INTERVIEW) {
                        interviews++;
                    }
                    else if(app.getStatus() == Status.OFFER) {
                        offers++;
                    }
                    else if(app.getStatus() == Status.REJECTED) {
                        rejected++;
                    }
                }
                int total = applications.size();

                System.out.println("\n========== STATISTICS ==========");
                System.out.println("Total applications:  " + total);
                System.out.println("Applied:             " + applied);
                System.out.println("Interviews:          " + interviews);
                System.out.println("Offers:              " + offers);
                System.out.println("Rejected:            " + rejected);

                if(total > 0) {
                    double interviewRate = ((double) interviews / total) * 100;
                    double offerRate = ((double) offers / total ) * 100;

                    System.out.printf("\nInterview rate: %.1f%%%n", interviewRate);
                    System.out.printf("\nOffer rate: %.1f%%%n", offerRate);
                }
                break;

            case 5: // Exit
                System.out.println("\n\nGoodbye!");
                break;

            default:
                System.out.println("\n\nInvalid choice. Please choose 1-5");
                break;
            } 
        }
        scan.close();
    }
}