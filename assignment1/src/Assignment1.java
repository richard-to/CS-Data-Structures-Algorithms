import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import to.richard.MemberManager;

public class Assignment1 {

    private static final String PROMPT = "Press 'Enter' to continue.";
    private static final String HORIZONTAL_RULE = "--------------------------";
    private static final String UHC_FILE = "UHC.dat";
    private static final String NEW_FILE = "new.dat";
    private static final String GRADES_FILE = "grades.dat";
    private static final String SAVE_FILE = "newuhc.dat";

    /**
     * Main application class
     *
     * @param args
     */
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MemberManager manager = new MemberManager();

        try {
            System.out.println("Current Members");
            System.out.println(HORIZONTAL_RULE);
            manager.loadCurrent(UHC_FILE).print();
            System.out.println(PROMPT);
            br.readLine();

            System.out.println("Updated Members List");
            System.out.println(HORIZONTAL_RULE);
            manager.loadNew(NEW_FILE).print();
            System.out.println(PROMPT);
            br.readLine();

            System.out.println("Updated Grades");
            System.out.println(HORIZONTAL_RULE);
            manager.loadNewGrades(GRADES_FILE).print();
            System.out.println(PROMPT);
            br.readLine();

            System.out.println("Members Ranked By Credits Earned");
            System.out.println(HORIZONTAL_RULE);
            manager.sortByPoints().print();
            System.out.println(PROMPT);
            br.readLine();

            System.out.println("Dropped Members List");
            System.out.println(HORIZONTAL_RULE);
            manager.dropUnderPerforming();

            System.out.println("Member GPA List");
            System.out.println(HORIZONTAL_RULE);
            manager.printGPA();
            System.out.println(PROMPT);
            br.readLine();

            System.out.println("Saving member list as uhc.dat...");
            manager.saveList(SAVE_FILE);
            System.out.println("Updated member list saved.");

        } catch(IOException e){
            System.err.println(e.getMessage());
        }
    }
}