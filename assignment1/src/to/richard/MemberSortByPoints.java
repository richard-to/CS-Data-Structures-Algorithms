package to.richard;

import java.util.Comparator;

/**
 * Comparator class to sort by points earned.
 */
public class MemberSortByPoints implements Comparator<Member> {

    /**
     * Compares members by points earned.
     *
     * @param member1
     * @param member2
     *
     * @return  0 if equal, 1 if member1 greater, -1 if member2 greater
     */
    public int compare(Member member1, Member member2) {
        if(member1.getPointsEarned() > member2.getPointsEarned()){
            return 1;
        } else if(member2.getPointsEarned() > member1.getPointsEarned()) {
            return -1;
        } else {
            return 0;
        }
    }
}
