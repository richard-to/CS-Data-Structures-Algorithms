package to.richard;

public class Member {

    public static final String FRESHMAN = "Fr";
    public static final String SOPHOMORE = "So";
    public static final String JUNIOR = "Jr";
    public static final String SENIOR = "Sr";

    public static final float FR_STAND = 0.0f;
    public static final float SO_STAND = 30.0f;
    public static final float JR_STAND = 60.0f;
    public static final float SR_STAND = 90.0f;

    private float hoursAttempted;
    private float pointsEarned;
    private String name;
    private String standing;

    public Member(String name) {
        this(0.0f, 0.0f, FRESHMAN, name);
    }

    public Member(float hoursAttempted, float pointsEarned, String standing, String name) {
        this.hoursAttempted = hoursAttempted;
        this.pointsEarned = pointsEarned;
        this.name = name;
        this.standing = standing;
    }

    public Member updateGrades(Float hoursAttempted, Float pointsEarned){
        this.hoursAttempted += hoursAttempted;
        this.pointsEarned += pointsEarned;
        return this;
    }

    public Member updateStanding(){
        if(pointsEarned >= SR_STAND)
            standing = SENIOR;
        else if(pointsEarned >= JR_STAND)
            standing = JUNIOR;
        else if(pointsEarned >= SO_STAND)
            standing = SOPHOMORE;
        else
            standing = FRESHMAN;
        return this;
    }

    public boolean isNamed(String name){
        return this.name.equals(name);
    }

    public String getStanding() {
        return standing;
    }

    public void setStanding(String standing) {
        this.standing = standing;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPointsEarned() {
        return pointsEarned;
    }

    public void setPointsEarned(float pointsEarned) {
        this.pointsEarned = pointsEarned;
    }

    public float getHoursAttempted() {
        return hoursAttempted;
    }

    public void setHoursAttempted(float hoursAttempted) {
        this.hoursAttempted = hoursAttempted;
    }

    public String toString() {
        return this.hoursAttempted + " " + this.pointsEarned +
                " " + this.standing + " " + this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Member member = (Member) o;

        if (!name.equals(member.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}