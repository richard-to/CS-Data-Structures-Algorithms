package to.richard;

public class Member {

    public static final String FRESHMAN = "Fr";
    public static final String SOPHOMORE = "So";
    public static final String JUNIOR = "Jr";
    public static final String SENIOR = "Sr";

    public static final float GPA_BORDER = 3.5f;

    public static final float FR_STAND = 0.0f;
    public static final float SO_STAND = 30.0f;
    public static final float JR_STAND = 60.0f;
    public static final float SR_STAND = 90.0f;

    private float hoursAttempted;
    private float pointsEarned;
    private String name;
    private String standing;
    private float gpa;

    /**
     * Creates new Freshman
     *
     * @param name Name of freshman
     */
    public Member(String name) {
        this(0.0f, 0.0f, FRESHMAN, name);
    }

    /**
     * Creates member with all data
     *
     * GPA calculated.
     *
     * @param hoursAttempted
     * @param pointsEarned
     * @param standing
     * @param name
     */
    public Member(float hoursAttempted, float pointsEarned, String standing, String name) {
        this.hoursAttempted = hoursAttempted;
        this.pointsEarned = pointsEarned;
        this.name = name;
        this.standing = standing;

        calculateGPA();
    }

    /**
     * Updates grades
     *
     * @param hoursAttempted
     * @param pointsEarned
     * @return Member
     */
    public Member updateGrades(Float hoursAttempted, Float pointsEarned){
        this.hoursAttempted += hoursAttempted;
        this.pointsEarned += pointsEarned;
        return this;
    }

    /**
     * Updates standing of member.
     *
     * Standing determined by points earned
     *
     * @return Member
     */
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

    /**
     * Calculates GPA.
     *
     * GPA calculated by points earned by hours attempted
     *
     * If hours attempted is 0, GPA will be 0.
     *
     * @return Member
     */
    public Member calculateGPA()
    {
        if(hoursAttempted == 0.0f){
            gpa = 0.0f;
        } else {
            gpa = pointsEarned / hoursAttempted;
        }
        return this;
    }

    /**
     * Returns calculated GPA
     *
     * @return float GPA
     */
    public float getGPA()
    {
        return gpa;
    }

    /**
     * Checks member is under performing
     *
     * @return boolean
     */
    public boolean isUnderPerforming()
    {
        return (gpa < GPA_BORDER);
    }

    /**
     * Checks if member has the same name
     * @param name
     * @return boolean true|false if name exists in list
     */
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

    /**
     * Sets points earned
     *
     * Also recalculates GPA
     *
     * @param pointsEarned
     */
    public void setPointsEarned(float pointsEarned) {
        this.pointsEarned = pointsEarned;
        calculateGPA();
    }

    public float getHoursAttempted() {
        return hoursAttempted;
    }

    /**
     * Sets hours attempted
     *
     * Also recalculateds GPA
     *
     * @param hoursAttempted
     */
    public void setHoursAttempted(float hoursAttempted) {
        this.hoursAttempted = hoursAttempted;
        calculateGPA();
    }

    /**
     * Prints member in format of single line from file
     *
     * @return String
     */
    public String toString() {
        return this.hoursAttempted + " " + this.pointsEarned +
                " " + this.standing + " " + this.name;
    }

    /**
     * Override equals method for member
     *
     * Equality determined by name
     *
     * @param o
     * @return
     */
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