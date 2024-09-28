public class Member {
    private final String memberName;
    private static int assignedId = 0;
    private final int memberId;

//Constructor for members
    public Member(String memberName){
        this.memberName = memberName;
        this.memberId = ++assignedId;
    }

//Method to get members
    public String getMemberName(){
        return memberName;
    }
    public int getMemberId(){
        return memberId;
    }

//Overriding toString to print member details
    @Override
    public String toString(){
        return memberName + " is a member with ID: " + memberId;
    }

}
