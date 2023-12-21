package com.example.membersipservice.application.service;

import com.example.membersipservice.adapter.out.persistence.MemberShipJpaEntity;
import com.example.membersipservice.adapter.out.persistence.MembershipMapper;
import com.example.membersipservice.application.port.in.RegisterMembershipCommand;
import com.example.membersipservice.application.port.in.RegisterMembershipUseCase;
import com.example.membersipservice.application.port.out.RegisterMembershipPort;
import com.example.membersipservice.domain.Membership;
import common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class RegisterMembershipService implements RegisterMembershipUseCase {

    private final RegisterMembershipPort registerMembershipPort;
    private final MembershipMapper membershipMapper;

    // 안에서 밖으로
    @Override
    public Membership registerMembership(RegisterMembershipCommand command) {
        // biz logic -> DB
        // external system
        // port, adapter
        MemberShipJpaEntity jpaEntity =  registerMembershipPort.createMembership(
                new Membership.MembershipName(command.getName()),
                new Membership.MembershipEmail(command.getEmail()),
                new Membership.MembershipAddress(command.getAddress()),
                new Membership.MembershipIsValid(command.isValid()),
                new Membership.MembershipIsCrop(command.isCorp())
        );

        return membershipMapper.mapToDomainEntity(jpaEntity);
    }
}
