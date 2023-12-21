package com.example.membersipservice.adapter.in.web;

import com.example.membersipservice.application.port.in.RegisterMembershipCommand;
import com.example.membersipservice.application.port.in.RegisterMembershipUseCase;
import com.example.membersipservice.domain.Membership;
import common.WebAdaptor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdaptor
@RestController
@RequiredArgsConstructor
public class RegisterMembershipController {

    private final RegisterMembershipUseCase registerMembershipUseCase;

    @PostMapping("/membership/register")
    public Membership registerMembership(@RequestBody RegisterMembershipRequest request) {

        // usecase 사용
        // request -> command로 변화하여 추상화함
        // why? -> RegisterMembershipRequest 변환 시 뒤에 영향을 미치지 않도록
        RegisterMembershipCommand command = RegisterMembershipCommand.builder()
                .name(request.getName())
                .address(request.getAddress())
                .email(request.getEmail())
                .isCorp(request.isCorp())
                .isValid(true)
                .build();

        return registerMembershipUseCase.registerMembership(command);
    }

}
