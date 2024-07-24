package hackerton.wakeup.memberInfo.service;

public interface MemberInfoRepository {
    boolean checkNicknameAndTagDuplication(String nickname, String tag);
}
