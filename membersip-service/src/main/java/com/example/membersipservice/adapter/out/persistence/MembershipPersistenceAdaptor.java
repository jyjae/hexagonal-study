package com.example.membersipservice.adapter.out.persistence;

import com.example.membersipservice.application.port.out.FindMembershipPort;
import com.example.membersipservice.application.port.out.RegisterMembershipPort;
import com.example.membersipservice.domain.Membership;
import common.PersistenceAdaptor;
import lombok.RequiredArgsConstructor;

@PersistenceAdaptor
@RequiredArgsConstructor
public class MembershipPersistenceAdaptor implements RegisterMembershipPort, FindMembershipPort {

    private final SpringDataMembershipRepository membershipRepository;

    @Override
    public MemberShipJpaEntity createMembership(
            Membership.MembershipName name,
            Membership.MembershipEmail email,
            Membership.MembershipAddress address,
            Membership.MembershipIsValid isValid,
            Membership.MembershipIsCrop isCorp
    ) {
       return membershipRepository.save(
                new MemberShipJpaEntity(
                        name.getMembershipName(),
                        email.getMembershipEmail(),
                        address.getMembershipAddress(),
                        isValid.isMembershipIsValid(),
                        isCorp.isMembershipIsCrop()
                ));

    }

    @Override
    public MemberShipJpaEntity findMembership(Membership.MembershipId membershipId) {
        return membershipRepository.findById(Long.valueOf(membershipId.getMembershipId())).orElseThrow();
    }
}
