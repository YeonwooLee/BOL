package com.yanoos.bottom_of_legend.repository;

import com.yanoos.bottom_of_legend.domain.Member;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class memoryMemberRepository implements MemberRepository {
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setMemberNum(++sequence);
        store.put(member.getMemberNum(),member);
        return member;
    }


    @Override
    public Optional<Member> findByMemberNum(long memberNum) {
        return Optional.ofNullable(store.get(memberNum));
    }
    @Override
    public Optional<Member> findByEmail(String email) {
        return store.values().stream()
                .filter(member->member.getEmail().equals(email))
                .findAny();
    }


    @Override
    public Optional<Member> findByNickName(String nickName) {
        return store.values().stream()
                .filter(member -> member.getNickName().equals(nickName))
                .findAny();
    }


    @Override
    public int deleteByMemberNum(String mbNum) {
        store.remove(mbNum);
        return 1;
    }

    @Override
    public Member updateNick(String nick) {
        return null;
    }

    @Override
    public Member updatePw(String pw) {
        return null;
    }

}
