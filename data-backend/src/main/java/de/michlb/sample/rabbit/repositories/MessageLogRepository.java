package de.michlb.sample.rabbit.repositories;

import de.michlb.sample.rabbit.domain.MessageLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA repository for MessageLog entities
 *
 * @author Michael Bartsch
 */
public interface MessageLogRepository extends JpaRepository<MessageLog, Long> {
}
