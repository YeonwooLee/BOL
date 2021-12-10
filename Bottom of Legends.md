# Bottom of Legends

2021-12-05

> 1. 프로젝트 생성
>
> 2. 임시 메인 화면 구성
>
> 3. 컨트롤러,  main View 생성
>
>    > controller/MemberController.java
>    >
>    > ``` java
>    > package com.yanoos.bottom_of_legend.controller;
>    > 
>    > import org.springframework.stereotype.Controller;
>    > import org.springframework.ui.Model;
>    > import org.springframework.web.bind.annotation.GetMapping;
>    > 
>    > @Controller
>    > public class MemberController {
>    > 
>    >     @GetMapping("main")
>    >     public String main(Model model){
>    >         String memberName = "아무개";
>    >         model.addAttribute("memberName",memberName);
>    >         return "main";
>    >     }
>    > 
>    > }
>    > ```
>    >
>    > main.html
>    >
>    > ``` html
>    > <!DOCTYPE html>
>    > <html xmlns:th="http://www.thymeleaf.org">
>    > <head>
>    >     <meta charset="UTF-8">
>    >     <title>Title</title>
>    > </head>
>    > <body>
>    >     <h1>메인 페이지 입니다</h1>
>    >     <h3 th:text="'안녕하세요 '+${memberName}+'님!'">안녕하세요 member님</h3>
>    > </body>
>    > </html>
>    > ```
>    >
>    > 



2021-12-05

> 1. 회원 관리
>
>    > 데이터: Email, 비밀번호, 닉네임, 경험치, 가입일
>    >
>    > 기능: 회원등록, 조회, 수정, 삭제
>    >
>    > 가상 시나리오: 아직 데이터 저장소가 선정되지 않음
>    >
>    > 
>
> 2. 회원 도메인 생성
>
>    > ```java
>    > package com.yanoos.bottom_of_legend.domain;
>    > 
>    > import java.sql.Date;
>    > 
>    > public class Member {
>    >     private String email; //아이디로 사용
>    >     private String password;
>    >     private String nickName;
>    >     private long exp;
>    >     private Date joinDate;
>    > 
>    >     public String getEmail() {
>    >         return email;
>    >     }
>    > 
>    >     public void setEmail(String email) {
>    >         this.email = email;
>    >     }
>    > 
>    >     public String getPassword() {
>    >         return password;
>    >     }
>    > 
>    >     public void setPassword(String password) {
>    >         this.password = password;
>    >     }
>    > 
>    >     public String getNickName() {
>    >         return nickName;
>    >     }
>    > 
>    >     public void setNickName(String nickName) {
>    >         this.nickName = nickName;
>    >     }
>    > 
>    >     public long getExp() {
>    >         return exp;
>    >     }
>    > 
>    >     public void setExp(long exp) {
>    >         this.exp = exp;
>    >     }
>    > 
>    >     public Date getJoinDate() {
>    >         return joinDate;
>    >     }
>    > 
>    >     public void setJoinDate(Date joinDate) {
>    >         this.joinDate = joinDate;
>    >     }
>    > }
>    > 
>    > ```
>
> 3. 회원 리포지토리 생성
>
>    > 인터페이스
>    >
>    > ``` java
>    > package com.yanoos.bottom_of_legend.repository;
>    > 
>    > import com.yanoos.bottom_of_legend.domain.Member;
>    > 
>    > import java.util.Optional;
>    > 
>    > public interface MemberRepository {
>    >     //회원 저장
>    >     Member save(Member member);
>    > 
>    >     //회원 삭제
>    >     int deleteByEmail(String email);
>    >     int deleteByNickName(String nick);
>    >     int deleteByMemberNum(String mbNum);
>    > 
>    >     //수정
>    >     Member updateNick(String nick);
>    >     Member updatePw(String pw);
>    > 
>    >     //조회
>    >     Optional<Member> findByEmail(String email); //회원 검색
>    >     Optional<Member> findByMemberNum(long memberNum); //회원 검색
>    >     Optional<Member> findByNickName(String nickName); //회원 검색
>    > 
>    > }
>    > 
>    > 
>    > ```
>    >
>    > 
>    >
>    > 메모리 구현체
>    >
>    >  

