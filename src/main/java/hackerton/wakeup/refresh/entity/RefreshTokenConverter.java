package hackerton.wakeup.refresh.entity;

import hackerton.wakeup.member.entity.Member;

import java.time.Instant;

public class RefreshTokenConverter {

    public static RefreshToken createTokenConverter(String token, Member member, Instant expires) {
        return RefreshToken.builder()
                .token(token)
                .member(member)
                .expiryTime(expires).build();
    }
}
