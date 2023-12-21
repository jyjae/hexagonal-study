package com.example.membersipservice.application.port.in;

import com.example.membersipservice.domain.Membership;
import common.UseCase;

// 밖에서 안으로
public interface RegisterMembershipUseCase {

    Membership registerMembership(RegisterMembershipCommand command);
}
