package to.richard;

import java.util.Comparator;

public class MemberSortByPoints implements Comparator<Member> {
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
