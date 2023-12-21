package com.example.membersipservice.application.port.in;

import com.example.membersipservice.domain.Membership;

import java.lang.reflect.Member;

public interface FindMembershipUseCase {

    Membership findMembership(FindMembershipCommand command);
}
