package to.richard;

public class MemberList {

    private LinkedList<Member> members;

    public MemberList(){
        this.members = new LinkedList<Member>();
    }

    public MemberList(LinkedList<Member> members){
        this.members = members;
    }

    public boolean add(Member member){
        if(!contains(member)){
            this.members.add(member);
            return true;
        } else
            return false;
    }

    public boolean contains(Member member){
        return this.members.contains(member);
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
