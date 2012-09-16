package to.richard;

import java.io.*;

public class MemberReader {

    private static final String DELIM = " ";

    public MemberList readCurrent(String filePath){
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
}