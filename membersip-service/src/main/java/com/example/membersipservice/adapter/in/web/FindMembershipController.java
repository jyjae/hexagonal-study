package com.example.membersipservice.adapter.in.web;

import com.example.membersipservice.application.port.in.FindMembershipCommand;
import com.example.membersipservice.application.port.in.FindMembershipUseCase;
import com.example.membersipservice.application.port.in.RegisterMembershipCommand;
import com.example.membersipservice.application.port.in.RegisterMembershipUseCase;
import com.example.membersipservice.domain.Membership;
import common.WebAdaptor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@WebAdaptor
@RestController
@RequiredArgsConstructor
public class FindMembershipController {

    private final FindMembershipUseCase findMembershipUseCase;

    @GetMapping("/membership/{membershipId}")
    public ResponseEntity<Membership> findMembership(@PathVariable String membershipId) {
        FindMembershipCommand command = FindMembershipCommand.builder()
                .membershipId(membershipId)
                .build();

        return ResponseEntity.ok(findMembershipUseCase.findMembership(command));
    }

}
