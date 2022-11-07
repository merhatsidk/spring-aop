package edu.miu.cs545.restApi.repo;

import edu.miu.cs545.restApi.domain.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggerRepo extends JpaRepository<Logger,Logger> {
}
