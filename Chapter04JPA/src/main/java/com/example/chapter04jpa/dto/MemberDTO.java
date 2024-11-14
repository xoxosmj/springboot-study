package com.example.chapter04jpa.dto;

import com.example.chapter04jpa.entity.MemberEntity;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MemberDTO {
    private String id;
    private String pwd;
    private String name;
    // Getters and Setters

    public MemberEntity toEntity() {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setId(this.id);
        memberEntity.setPwd(this.pwd);
        memberEntity.setName(this.name);
        return memberEntity;
    }
}
