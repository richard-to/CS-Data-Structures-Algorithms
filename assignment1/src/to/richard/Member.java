package to.richard;

public class Member {
    private float hoursAttempted;
    private float pointsEarned;
    private String name;
    private String standing;

    public Member(String name) {
        this(0.0f, 0.0f, name, "Fr");
    }

    public Member(float hoursAttempted, float pointsEarned, String name, String standing) {
        this.hoursAttempted = hoursAttempted;
        this.pointsEarned = pointsEarned;
        this.name = name;
        this.standing = standing;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Member member = (Member) o;

        if (Float.compare(member.hoursAttempted, hoursAttempted) != 0) return false;
        if (Float.compare(member.pointsEarned, pointsEarned) != 0) return false;
        if (!name.equals(member.name)) return false;
        if (!standing.equals(member.standing)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (hoursAttempted != +0.0f ? Float.floatToIntBits(hoursAttempted) : 0);
        result = 31 * result + (pointsEarned != +0.0f ? Float.floatToIntBits(pointsEarned) : 0);
        result = 31 * result + name.hashCode();
        result = 31 * result + standing.hashCode();
        return result;
    }
}