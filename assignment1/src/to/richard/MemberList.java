package to.richard;

public class MemberList {

    private LinkedList<Member> members;

    public MemberList(){
        this.members = new LinkedList<Member>();
    }

    public MemberList(LinkedList<Member> members){
        this.members = members;
    }

    public MemberList add(Member member){
        this.members.add(member);
        return this;
    }

    public String toString(){
        LinkedListIter<Member> iter = this.members.iterator();
        StringBuffer out = new StringBuffer();
        while(iter.hasNext()){
            Member member = iter.next();
            out.append(member).append("\n");
        }
        return out.toString().trim();
    }
}
