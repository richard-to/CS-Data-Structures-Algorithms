import to.richard.Member;
import to.richard.MemberList;
import to.richard.MemberReader;

public class Assignment1 {

    private static final String UHC_FILE = "UHC.dat";
    private static final String NEW_FILE = "new.data";
    private static final String GRADES_FILE = "grades.dat";

    public static void main(String[] args) {
        MemberReader reader = new MemberReader();
        MemberList memberList = reader.readCurrent(UHC_FILE);
    }
}