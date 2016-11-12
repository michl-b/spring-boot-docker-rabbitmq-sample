package de.michlb.sample.rabbit.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Domain Entity for Queue message logging
 *
 * @author Michael Bartsch
 */
@Entity
@Table(name = "MESSAGE_LOG")
@Data
@NoArgsConstructor
public class MessageLog {

    @Id
    @GeneratedValue
    private Long id;

    private String queue;
    private String message;

    private LocalDateTime timestamp = LocalDateTime.now();

    public MessageLog(String queue, String message) {
        this.message = message;
        timestamp = LocalDateTime.now();
    }
}
