package to.richard;

import java.util.Comparator;

/**
 * List of members that uses DoubleLinked list internally.
 */
public class MemberList {

    private LinkedList<Member> members;
    private MemberSort memberSort;

    /**
     * Member list constructor
     */
    public MemberList(){
        this.members = new LinkedList<Member>();
        this.memberSort = new MemberSort();
    }

    /**
     * Member list constructor
     *
     * @param members Create with existing linked list
     */
    public MemberList(LinkedList<Member> members){
        this.members = members;
    }

    /**
     * Gets number of members in list
     *
     * @return int number of members in list
     */
    public int size() {
        return this.members.size();
    }

    /**
     * Adds member to list
     *
     * Only adds unique members
     *
     * @param member
     * @return boolean true|false depending if member added
     */
    public boolean add(Member member){
        if(!contains(member)){
            this.members.add(member);
            return true;
        } else
            return false;
    }

    /**
     * Checks if member is in list
     *
     * @param member
     * @return boolean true|false if in member in list
     */
    public boolean contains(Member member){
        return this.members.contains(member);
    }

    /**
     * Finds member in list by name
     *
     * @param name
     * @return Member if exists or null if not exists
     */
    public Member find(String name) {
        LinkedListIter<Member> iter = this.members.iterator();
        while(iter.hasNext()){
            Member member = iter.next();
            if(member.isNamed(name))
                return member;
        }
        return null;
    }

    /**
     * Updates standings for each member in list
     *
     * @return MemberList
     */
    public MemberList updateStandings() {
        LinkedListIter<Member> iter = this.members.iterator();
        while(iter.hasNext()){
            Member member = iter.next();
            member.updateStanding();
        }
        return this;
    }

    /**
     * Sorts member list
     *
     * @param compare Field to sort by via comparator
     * @return MemberList
     */
    public MemberList sort(Comparator<Member> compare) {
        members = memberSort.sort(members, compare);
        return this;
    }

    /**
     * Drops under performing members from list
     *
     * @return MemberList List of dropped members
     */
    public MemberList dropUnderPerforming() {
        MemberList dropList = new MemberList();
        LinkedListIter<Member> iter = this.members.iterator();
        while(iter.hasNext()){
            Member member = iter.next();
            if(member.isUnderPerforming()){
                dropList.add(member);
                this.members.remove(member);

            }
        }
        return dropList;
    }

    /**
     * Prints GPA of members
     *
     * @return String of member GPAs
     */
    public String printGPA() {
        LinkedListIter<Member> iter = this.members.iterator();
        StringBuffer out = new StringBuffer();
        while(iter.hasNext()){
            Member member = iter.next();
            out.append(member.getName())
                .append(": ")
                .append(member.getGPA())
                .append("\n");
        }
        return out.toString().trim();
    }

    /**
     * Prints members as formatted in file
     *
     * @return String members as formatted in file
     */
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
