package edu.miu.cs545.restApi.repo;

import edu.miu.cs545.restApi.domain.ExceptionTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExceptionRepo extends JpaRepository<ExceptionTable,Long> {
}
