package com.anhbui.organizationservice.repository;

import com.anhbui.organizationservice.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization,Long> {
    Organization findByOrganizationCode(String organizationCode);
}
