package edu.miu.cs545.restApi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExceptionTable {
    @Id
    @GeneratedValue
    private Long TransactionId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;
    private String principle;
    private String operation;
    private String exceptionType;
}
