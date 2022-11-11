package com.example.demo2.util;


import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;



@MappedSuperclass // 나 자신을 상속받는 자식클래스에게 -> 멤버를 강제 optional 하지 않음.


@EntityListeners(AuditingEntityListener.class)
@Getter
public class Timestamp {

    @CreatedDate
    private LocalDateTime regDate;

    @LastModifiedDate
    private LocalDateTime modDate;

}
