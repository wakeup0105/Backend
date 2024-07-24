package hackerton.wakeup.memberInfo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class MemberInfoId implements Serializable {
    private Long id;
    private Long member;
}
