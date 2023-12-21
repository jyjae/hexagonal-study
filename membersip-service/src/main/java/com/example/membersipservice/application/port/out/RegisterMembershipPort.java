package com.example.membersipservice.application.port.out;

import com.example.membersipservice.adapter.out.persistence.MemberShipJpaEntity;
import com.example.membersipservice.domain.Membership;

public interface RegisterMembershipPort {

    MemberShipJpaEntity createMembership(
            Membership.MembershipName name,
            Membership.MembershipEmail email,
            Membership.MembershipAddress address,
            Membership.MembershipIsValid isValid,
            Membership.MembershipIsCrop isCorp);
}
