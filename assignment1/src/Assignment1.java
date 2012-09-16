import to.richard.MemberList;
import to.richard.MemberManager;

public class Assignment1 {

    private static final String UHC_FILE = "UHC.dat";
    private static final String NEW_FILE = "new.dat";
    private static final String GRADES_FILE = "grades.dat";

    public static void main(String[] args) {
        MemberManager manager = new MemberManager();
        manager.loadCurrent(UHC_FILE).print();
        manager.loadNew(NEW_FILE).print();
        manager.loadNewGrades(GRADES_FILE).print();
    }
}