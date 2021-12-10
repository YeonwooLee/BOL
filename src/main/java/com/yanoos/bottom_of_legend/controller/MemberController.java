package com.yanoos.bottom_of_legend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    @GetMapping("main") //main 페이지 매핑
    public String main(Model model){
        String memberName = "아무개"; //회원이름
        model.addAttribute("memberName",memberName); //회원이름 addAttr
        return "main"; //templates/main.html으로 포워딩
    }

}
