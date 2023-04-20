package um.uamserver.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import um.uamserver.domain.entity.Uam;

public interface UamRepository extends JpaRepository<Uam, Long> {
}
