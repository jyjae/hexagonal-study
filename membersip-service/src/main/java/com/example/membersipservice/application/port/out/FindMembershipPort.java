package com.example.membersipservice.application.port.out;

import com.example.membersipservice.adapter.out.persistence.MemberShipJpaEntity;
import com.example.membersipservice.domain.Membership;

public interface FindMembershipPort {

    public MemberShipJpaEntity findMembership(Membership.MembershipId membershipId);
}
