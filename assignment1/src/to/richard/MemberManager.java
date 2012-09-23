package to.richard;

import java.io.*;

/**
 * MemberManager is a facade type class for
 * the basic operations needed to manage members.
 *
 * Uses a fluid interface through method chaining.
 */
public class MemberManager {

    private static final String ERR_DUPLICATE = "Error: Member already exists.";
    private static final String DELIM = " ";

    private MemberList memberList;

    public MemberManager(){
        memberList = new MemberList();
    }

    /**
     * Loads current members from file.
     *
     * Prints error message if file not found or io exception.
     *
     * @param filePath
     *
     * @return MemberManager
     */
    public MemberManager loadCurrent(String filePath){
        File file = new File(filePath);

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while((line = br.readLine()) != null) {
                String[] data = line.split(DELIM);
                memberList.add(new Member(
                        Float.parseFloat(data[0]),
                        Float.parseFloat(data[1]),
                        data[2],
                        data[3] + " " + data[4]));
            }
        } catch(FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch(IOException e) {
            System.err.println(e.getMessage());
        }
        return this;
    }

    /**
     * Loads new members from file.
     *
     * Prints error message if duplicate member detected.
     * Also prints error message if file not found or io exception.
     *
     * @param filePath
     *
     * @return MemberManager
     */
    public MemberManager loadNew(String filePath){
        File file = new File(filePath);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String name;
            while((name = br.readLine()) != null) {
                Member member = new Member(name);
                if(!memberList.contains(member))
                    memberList.add(member);
                else
                    System.err.println(ERR_DUPLICATE);
            }
        } catch(FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch(IOException e) {
            System.err.println(e.getMessage());
        }
        return this;
    }

    /**
     * Save current members in list to file.
     *
     * If file does not exist, file will be created.
     *
     * Prints error message if io exception.
     *
     * @param filePath Path of file to save.
     *
     * @return MemberManager
     */
    public MemberManager saveList(String filePath){
        try {
            File file = new File(filePath);

            if(!file.exists()){
                file.createNewFile();
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
            bw.write(memberList.toString());
            bw.close();

        } catch(IOException e) {
            System.err.println(e.getMessage());
        }
        return this;
    }

    /**
     * Loads grades from file and updates member grades
     *
     * Prints error message if file not found or io exception
     *
     * @param filePath
     *
     * @return MemberManager
     */
    public MemberManager loadNewGrades(String filePath){
        File file = new File(filePath);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while((line = br.readLine()) != null) {
                String[] data = line.split(DELIM);

                Float hoursAttempted = Float.parseFloat(data[0]);
                Float pointsEarned = Float.parseFloat(data[1]);
                String name = data[2] + " " + data[3];

                Member member = memberList.find(name);
                if(member != null){
                    member.updateGrades(hoursAttempted, pointsEarned);
                }
            }
        } catch(FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch(IOException e) {
            System.err.println(e.getMessage());
        }
        return this;
    }

    /**
     * Updates member standing
     *
     * Only makes sense to call this method after
     * updating grades.
     *
     * @return MemberManager
     */
    public MemberManager updateStandings(){
        memberList.updateStandings();
        return this;
    }

    /**
     * Sorts members by most points earned.
     *
     * @return MemberManager
     */
    public MemberManager sortByPoints(){
        memberList.sort(new MemberSortByPoints());
        return this;
    }

    /**
     * Drops members if their GPA is under 3.5
     *
     * Not ideal, but also prints list of dropped members.
     *
     * @return MemberManager
     */
    public MemberManager dropUnderPerforming(){
        MemberList dropList = memberList.dropUnderPerforming();
        System.out.println(dropList.toString());
        System.out.println();
        return this;
    }

    /**
     * Prints GPA of members in list
     *
     * @return MemberManager
     */
    public MemberManager printGPA(){
        System.out.println(memberList.printGPA());
        System.out.println();
        return this;
    }

    /**
     * Prints list of members as formatted by file
     *
     * @return MemberManager
     */
    public MemberManager print(){
        System.out.println(memberList.toString());
        System.out.println();
        return this;
    }
}