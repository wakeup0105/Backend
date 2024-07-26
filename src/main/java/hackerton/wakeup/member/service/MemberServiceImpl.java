package hackerton.wakeup.member.service;

import hackerton.wakeup.email.service.EmailSenderService;
import hackerton.wakeup.email.service.EmailVerifyService;
import hackerton.wakeup.member.entity.Member;
import hackerton.wakeup.member.entity.dto.request.ChangePasswordRequestDTO;
import hackerton.wakeup.member.entity.dto.request.JoinRequestDTO;
import hackerton.wakeup.member.entity.dto.request.LoginRequestDTO;
import hackerton.wakeup.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Primary
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final EmailVerifyService emailVerifyService;
    private final EmailSenderService emailSenderService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean checkEmailDuplication(String email) {
        return memberRepository.existsByEmail(email);
    }

    @Override
    public void joinMember(JoinRequestDTO req) {
//        if (emailVerifyService.verifyCode(req.getEmail(), req.getPassword())) {
//            throw new RuntimeException("유효하지 않은 인증코드");
//        }
        req.setPassword(passwordEncoder.encode(req.getPassword()));
        memberRepository.save(req.toEntity());
    }

    @Override
    public Member loginMember(LoginRequestDTO req) {
        Optional<Member> optionalMember = memberRepository.findByEmail(req.getEmail());

        //이메일에 해당되는 멤버가 없다면 null
        if (optionalMember.isEmpty()) return null;

        Member member = optionalMember.get();

        //비밀번호가 일치하지 않는다면 null
        if (!passwordEncoder.matches(req.getPassword(), member.getPassword())) return null;


        return member;
    }

    @Override
    public void changePassword(ChangePasswordRequestDTO req) {
        Member member = memberRepository.findByEmail(req.getEmail()).get();
        memberRepository.save(Member.builder()
                .id(member.getId())
                .email(member.getEmail())
                .password(passwordEncoder.encode(req.getPassword()))
                .point(member.getPoint())
                .build());
    }

    @Override
    public void sendVerificationEmail(String email) {
        String code = emailVerifyService.generateVerificationCode(email);
        emailSenderService.sendVerificationCode(email, code);
    }

    @Override
    public Optional<Member> getMemberById(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public Optional<Member> getMemberByEmail(String email) {
        return memberRepository.findByEmail(email);
    }
}
