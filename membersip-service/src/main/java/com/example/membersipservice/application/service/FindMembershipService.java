package com.example.membersipservice.application.service;

import com.example.membersipservice.adapter.out.persistence.MemberShipJpaEntity;
import com.example.membersipservice.adapter.out.persistence.MembershipMapper;
import com.example.membersipservice.application.port.in.FindMembershipCommand;
import com.example.membersipservice.application.port.in.FindMembershipUseCase;
import com.example.membersipservice.application.port.out.FindMembershipPort;
import com.example.membersipservice.domain.Membership;
import common.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class FindMembershipService implements FindMembershipUseCase {

    private final FindMembershipPort findMembershipPort;
    private final MembershipMapper membershipMapper;

    @Override
    public Membership findMembership(FindMembershipCommand command) {
        MemberShipJpaEntity jpaEntity = findMembershipPort.findMembership(
                new Membership.MembershipId(command.getMembershipId())
        );

        return membershipMapper.mapToDomainEntity(jpaEntity);
    }
}
