package to.richard;

import java.io.*;

public class MemberManager {

    private static final String ERR_DUPLICATE = "Error: Member already exists.";
    private static final String DELIM = " ";

    public MemberList loadCurrent(String filePath){
        File file = new File(filePath);
        MemberList memberList = new MemberList();

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
        return memberList;
    }

    public MemberList loadNew(MemberList memberList, String filePath){
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
        return memberList;
    }

    public MemberList loadNewGrades(MemberList memberList, String filePath){
        File file = new File(filePath);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String name;
            while((name = br.readLine()) != null) {
                Member member = new Member(name);
                memberList.add(member);
            }
        } catch(FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch(IOException e) {
            System.err.println(e.getMessage());
        }
        return memberList;
    }
}