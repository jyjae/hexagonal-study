package com.example.membersipservice.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

// membership 클래스는 오염이 되면 안되는 클래스이다.
// 고객 정보, 핵심 도메인
// membership 클래스는 gerateMember 메서드를 통해서만 생성이 가능하다.
// 또한 value들은 정해진 public static class를 통해서만 값이 들어가기때문에 membership 클래스는 안전하다.
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Membership {

    @Getter
    private final String membershipId;
    @Getter
    private final String name;
    @Getter
    private final String email;
    @Getter
    private final String address;
    @Getter
    private final boolean isValid;
    @Getter
    private final boolean isCorp;


    public static Membership generateMember(
            MembershipId membershipId,
            MembershipName membershipName,
            MembershipEmail memberShipEmail,
            MembershipAddress membershipAddress,
            MembershipIsValid membershipIsValid,
            MembershipIsCrop membershipIsCrop
            ) {
        return new Membership(
                membershipId.membershipId,
                membershipName.membershipName,
                memberShipEmail.membershipEmail,
                membershipAddress.membershipAddress,
                membershipIsValid.membershipIsValid,
                membershipIsCrop.membershipIsCrop);

    }

    @Value
    public static class MembershipId {

        public MembershipId(String value) {
            this.membershipId = value;
        }

        String membershipId;
    }

    @Value
    public static class MembershipName {

        public MembershipName(String value) {
            this.membershipName = value;
        }

        String membershipName;
    }

    @Value
    public static class MembershipEmail {

        public MembershipEmail(String value) {
            this.membershipEmail = value;
        }

        String membershipEmail;
    }

    @Value
    public static class MembershipAddress {

        public MembershipAddress(String value) {
            this.membershipAddress = value;
        }

        String membershipAddress;
    }

    @Value
    public static class MembershipIsValid {

        public MembershipIsValid(boolean value) {
            this.membershipIsValid = value;
        }

        boolean membershipIsValid;
    }

    @Value
    public static class MembershipIsCrop {

        public MembershipIsCrop(boolean value) {
            this.membershipIsCrop = value;
        }

        boolean membershipIsCrop;
    }

}
