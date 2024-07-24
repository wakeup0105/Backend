package hackerton.wakeup.memberInfo.service;

public interface MemberInfoService {
    boolean checkNicknameAndTagDuplication(String nickname, String tag);
    String settingNickname(String nickname, String tag);
}
