package com.example.membersipservice.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataMembershipRepository extends JpaRepository<MemberShipJpaEntity, Long> {
}
