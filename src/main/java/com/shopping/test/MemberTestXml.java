package com.shopping.test;

import com.shopping.mapper.MemberMapperXml;
import com.shopping.model.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MemberTestXml {
    @Autowired
    private MemberMapperXml mxml;

    @Test
    @DisplayName("전체 회원 보기")
    public void SelectAll(){
        List<Member> memberList = mxml.SelectAll();

        for(Member one : memberList){
            System.out.println(one.toString());
        }
    }

    @Test
    @DisplayName("아이디와 일치하는 회원 보기")
    public void SelectOne(){
        String id = "sim";
        Member member = mxml.SelectOne(id);

        if(member == null){
            System.out.println(id + "은(는) 존재하지 않는 회원입니다.");
        }else{
            System.out.println(member.toString());

        }
    }

    @Test
    @DisplayName("회원 추가")
    public void Insert(){
        Member member = this.createMember();
        int cnt = -999;

        cnt = mxml.Insert(member);

        if(cnt == 1){
            System.out.println("추가 성공");
            System.out.println(member.toString());
        }else{
            System.out.println("추가 실패");
        }
    }

    private Member createMember() {
        Member member = new Member();

        member.setId("shin");
        member.setName("신사임당");
        member.setAge(11);
        member.setGender("여자");

        return member;
    }

    @Test
    @DisplayName("회원 정보 수정")
    public void Update(){
        Member member = this.updateMember();

        int cnt = -999;
        cnt = mxml.Update(member);

        if (cnt == 0){
            System.out.println("수정된 행이 없습니다.");
            System.out.println(member.toString());
        }else if(cnt > 0){
            System.out.println("수정 성공");
            System.out.println(member.toString());
        }else{
            System.out.println("수정 실패");
        }
    }

    private Member updateMember() {
        Member member = this.createMember();

//        member.setId("shin");
        member.setName("신승훈");
        member.setAge(99);
        member.setGender("남자");

        return member;
    }

    @Test
    @DisplayName("회원 1명 삭제")
    public void Delete(){
        String id = "shin";
        int cnt = -999;

        cnt = mxml.Delete(id);

        if (cnt == 0){
            System.out.println("삭제된 행이 없습니다.");
        }else if(cnt > 0){
            System.out.println("삭제 성공");
        }else{
            System.out.println("삭제 실패");
        }
    }
}
