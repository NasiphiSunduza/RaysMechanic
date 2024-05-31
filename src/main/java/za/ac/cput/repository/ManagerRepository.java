package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Manager;

import java.util.List;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
    List<Manager> findManagerByDepartment(String department);
}

