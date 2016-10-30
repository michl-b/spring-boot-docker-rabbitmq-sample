package de.michlb.sample.rabbit.repositories;

import de.michlb.sample.rabbit.domain.MessageLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by admin on 30.10.16.
 */
public interface MessageLogRepository extends JpaRepository<MessageLog, Long> {
}
