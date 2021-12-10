package com.yanoos.bottom_of_legend.repository;

import com.yanoos.bottom_of_legend.domain.Member;

import java.util.Optional;

public interface MemberRepository {
    //회원 저장
    Member save(Member member);



    //조회
    Optional<Member> findByEmail(String email); //회원 검색
    Optional<Member> findByMemberNum(long memberNum); //회원 검색
    Optional<Member> findByNickName(String nickName); //회원 검색


    //수정
    Member updateNick(String nick);
    Member updatePw(String pw);

    //회원 삭제
    int deleteByMemberNum(String mbNum);

}
