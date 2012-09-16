package to.richard;

import java.io.*;

public class MemberManager {

    private static final String ERR_DUPLICATE = "Error: Member already exists.";
    private static final String DELIM = " ";

    private MemberList memberList;

    public MemberManager(){
        memberList = new MemberList();
    }

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

    public MemberManager updateStandings(){
        memberList.updateStandings();
        return this;
    }

    public MemberManager print(){
        System.out.println(memberList.toString());
        return this;
    }
}