package hackerton.wakeup.memberInfo.service;

public interface MemberInfoRepository {
    boolean checkNicknameAndTagDuplication(String nickname, String tag);
    String settingNickname(String nickname, String tag);
}
