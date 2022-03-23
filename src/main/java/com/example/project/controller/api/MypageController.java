package com.example.project.controller.api;

import com.example.project.model.DTO.RegistAddressDTO;
import com.example.project.model.entity.User;
import com.example.project.model.network.Header;
import com.example.project.model.network.request.UserApiRequest;
import com.example.project.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/www.duoback.co.kr")
@Controller
public class MypageController {

    @Autowired
    private HttpSession session;

    @Autowired
    private  OrderService orderService;

    @Autowired
    private UserApiLogicService userApiLogicService;

    @Autowired
    private RegistAddressService registAddressService;

    @Autowired
    private DpointService dpointService;

    @Autowired
    private CouponService couponService;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private GoodsApiLogicService goodsApiLogicService;

    @Autowired
    private RecentService recentService;

    @Autowired
    private ZzimService zzimService;

    @GetMapping("/mypage_qna_write")
    public String mypage_qna_write(Model model) {

        if(session.getAttribute("userid")==null){
            return "pages/www.duoback.co.kr/member/login";
        }
        User user = (User)session.getAttribute("user");
        model.addAttribute("user", userApiLogicService.read(user.getUserIdx()));
        model.addAttribute("dpoint", dpointService.getDpointList(user.getUserIdx()));
        model.addAttribute("coupon", couponService.getCouponList(user.getUserIdx()));
        model.addAttribute("review",reviewService.getReviewList(user.getUserIdx()));
        return "pages/www.duoback.co.kr/mypage/mypage_qna_write";
    }

    @GetMapping("/mypage_zzim")
    public String mypage_zzim(Model model) {
        if(session.getAttribute("userid")==null){
            return "pages/www.duoback.co.kr/member/login";
        }
        User user = (User)session.getAttribute("user");
        model.addAttribute("user", userApiLogicService.read(user.getUserIdx()));
        model.addAttribute("zzimlist" , zzimService.getZzimList(user.getUserIdx()));
        model.addAttribute("dpoint", dpointService.getDpointList(user.getUserIdx()));
        model.addAttribute("coupon", couponService.getCouponList(user.getUserIdx()));
        model.addAttribute("review",reviewService.getReviewList(user.getUserIdx()));
        return "pages/www.duoback.co.kr/mypage/mypage_zzim";
    }

    @GetMapping("/mypage_order")
    public String mypage_order(Model model) {
        if(session.getAttribute("userid")==null){
        return "pages/www.duoback.co.kr/member/login";
    } else {
            User user = (User)session.getAttribute("user");
            model.addAttribute("user", userApiLogicService.read(user.getUserIdx()));
            model.addAttribute("orderList" , orderService.getOrderList(user.getUserIdx()));
            model.addAttribute("dpoint", dpointService.getDpointList(user.getUserIdx()));
            model.addAttribute("coupon", couponService.getCouponList(user.getUserIdx()));
            model.addAttribute("review",reviewService.getReviewList(user.getUserIdx()));
            return "pages/www.duoback.co.kr/mypage/mypage_order";
        }
    }

    @GetMapping("/mypage_cancle")
    public String mypage_cancle(Model model) {if(session.getAttribute("userid")==null){
        return "pages/www.duoback.co.kr/member/login";
    }
        User user = (User)session.getAttribute("user");
        model.addAttribute("user", userApiLogicService.read(user.getUserIdx()));
        model.addAttribute("cancelList",orderService.getCancelList());
        model.addAttribute("dpoint", dpointService.getDpointList(user.getUserIdx()));
        model.addAttribute("coupon", couponService.getCouponList(user.getUserIdx()));
        model.addAttribute("review",reviewService.getReviewList(user.getUserIdx()));
        return "pages/www.duoback.co.kr/mypage/mypage_cancle";
    }

    @GetMapping("/mypage_return")
    public String mypage_return(Model model) {if(session.getAttribute("userid")==null){
        return "pages/www.duoback.co.kr/member/login";
    }
        User user = (User)session.getAttribute("user");
        model.addAttribute("user", userApiLogicService.read(user.getUserIdx()));
        model.addAttribute("returnList" , orderService.getReturnList());
        model.addAttribute("dpoint", dpointService.getDpointList(user.getUserIdx()));
        model.addAttribute("coupon", couponService.getCouponList(user.getUserIdx()));
        model.addAttribute("review",reviewService.getReviewList(user.getUserIdx()));
        return "pages/www.duoback.co.kr/mypage/mypage_return";
    }

    @GetMapping("/mypage_coupon")
    public String mypage_coupon(Model model) {

        if(session.getAttribute("userid")==null){
            return "pages/www.duoback.co.kr/member/login";
        }
        User user = (User)session.getAttribute("user");
        model.addAttribute("user", userApiLogicService.read(user.getUserIdx()));
        model.addAttribute("dpoint", dpointService.getDpointList(user.getUserIdx()));
        model.addAttribute("coupon", couponService.getCouponList(user.getUserIdx()));
        model.addAttribute("review",reviewService.getReviewList(user.getUserIdx()));
        return "pages/www.duoback.co.kr/mypage/mypage_coupon";
    }

    @GetMapping("/mypage_dpoint")
    public String mypage_dpoint(Model model) {

        if(session.getAttribute("userid")==null){
            return "pages/www.duoback.co.kr/member/login";
        }
        User user = (User)session.getAttribute("user");
        model.addAttribute("user", userApiLogicService.read(user.getUserIdx()));
        model.addAttribute("dpoint", dpointService.getDpointList(user.getUserIdx()));
        model.addAttribute("coupon", couponService.getCouponList(user.getUserIdx()));
        model.addAttribute("review",reviewService.getReviewList(user.getUserIdx()));
        return "pages/www.duoback.co.kr/mypage/mypage_dpoint";
    }

    @GetMapping("/mypage_review")
    public String mypage_review(Model model) {

        if(session.getAttribute("userid")==null){
            return "pages/www.duoback.co.kr/member/login";
        }
        User user = (User)session.getAttribute("user");
        model.addAttribute("user", userApiLogicService.read(user.getUserIdx()));
        model.addAttribute("dpoint", dpointService.getDpointList(user.getUserIdx()));
        model.addAttribute("coupon", couponService.getCouponList(user.getUserIdx()));
        model.addAttribute("review",reviewService.getReviewList(user.getUserIdx()));
        return "pages/www.duoback.co.kr/mypage/mypage_review";
    }

    @GetMapping("/mypage_qna")
    public String mypage_qna(Model model) {

        if(session.getAttribute("userid")==null){
            return "pages/www.duoback.co.kr/member/login";
        }
        User user = (User)session.getAttribute("user");
        model.addAttribute("user", userApiLogicService.read(user.getUserIdx()));
        model.addAttribute("dpoint", dpointService.getDpointList(user.getUserIdx()));
        model.addAttribute("coupon", couponService.getCouponList(user.getUserIdx()));
        model.addAttribute("review",reviewService.getReviewList(user.getUserIdx()));
        return "pages/www.duoback.co.kr/mypage/mypage_qna";
    }

    @GetMapping("/mypage_recentGoods")
    public String mypage_recentGoods(Model model) {

        if(session.getAttribute("userid")==null){
            return "pages/www.duoback.co.kr/member/login";
        }
        User user = (User)session.getAttribute("user");
        model.addAttribute("user", userApiLogicService.read(user.getUserIdx()));
        model.addAttribute("dpoint", dpointService.getDpointList(user.getUserIdx()));
        model.addAttribute("recent" , recentService.getRecentList(user.getUserIdx()));
        model.addAttribute("goodslist" , goodsApiLogicService.read(user.getUserIdx()));
        model.addAttribute("coupon", couponService.getCouponList(user.getUserIdx()));
        model.addAttribute("review",reviewService.getReviewList(user.getUserIdx()));
        return "pages/www.duoback.co.kr/mypage/mypage_recentGoods";
    }

    @GetMapping("/mypage_myinfo")
    public String mypage_myinfo(Model model) {
        if(session.getAttribute("userid")==null){
            return "pages/www.duoback.co.kr/member/login";
        }
        User user = (User)session.getAttribute("user");
        model.addAttribute("dpoint", dpointService.getDpointList(user.getUserIdx()));
        model.addAttribute("coupon", couponService.getCouponList(user.getUserIdx()));
        model.addAttribute("review",reviewService.getReviewList(user.getUserIdx()));
        model.addAttribute("user", userApiLogicService.read(user.getUserIdx()));
        return "pages/www.duoback.co.kr/mypage/mypage_myinfo";
    }

    @RequestMapping(value="/mypage_delivery_address", method = {RequestMethod.GET, RequestMethod.POST})
    public String mypage_delivery_address(Model model) {

        if(session.getAttribute("userid")==null){
            return "pages/www.duoback.co.kr/member/login";
        }

        User user = (User)session.getAttribute("user");
        model.addAttribute("addressList",registAddressService.getAddressList(user.getUserIdx()));
        model.addAttribute("user", userApiLogicService.read(user.getUserIdx()));
        model.addAttribute("dpoint", dpointService.getDpointList(user.getUserIdx()));
        model.addAttribute("coupon", couponService.getCouponList(user.getUserIdx()));
        model.addAttribute("review",reviewService.getReviewList(user.getUserIdx()));
        return "pages/www.duoback.co.kr/mypage/mypage_delivery_address";
    }

    @RequestMapping(value="/address/{rgaIdx}", method = {RequestMethod.GET, RequestMethod.POST})
    public String address(Model model, @PathVariable Long rgaIdx) {

        if(session.getAttribute("userid")==null){
            return "pages/www.duoback.co.kr/member/login";
        }
        User user = (User)session.getAttribute("user");
        model.addAttribute("addressList",registAddressService.getAddressList(user.getUserIdx()));
        model.addAttribute("address",registAddressService.read(rgaIdx));
        model.addAttribute("user", userApiLogicService.read(user.getUserIdx()));
        model.addAttribute("dpoint", dpointService.getDpointList(user.getUserIdx()));
        model.addAttribute("coupon", couponService.getCouponList(user.getUserIdx()));
        model.addAttribute("review",reviewService.getReviewList(user.getUserIdx()));
        return "pages/www.duoback.co.kr/mypage/address";
    }


    @PostMapping({"/deleteAdd/{rgaIdx}"})
    public String deleteAdd(@PathVariable(name = "rgaIdx") Long rgaIdx) {
        if(session.getAttribute("userid")==null){
            return "pages/www.duoback.co.kr/member/login";
        }
        registAddressService.delete(rgaIdx);
        return "redirect:/www.duoback.co.kr/mypage_delivery_address";
    }


    @GetMapping("/mypage_withdrawal")
    public String mypage_withdrawal(Model model) {

        if(session.getAttribute("userid")==null){
            return "pages/www.duoback.co.kr/member/login";
        }
        User user = (User)session.getAttribute("user");
        model.addAttribute("dpoint", dpointService.getDpointList(user.getUserIdx()));
        model.addAttribute("coupon", couponService.getCouponList(user.getUserIdx()));
        model.addAttribute("review",reviewService.getReviewList(user.getUserIdx()));
        model.addAttribute("user", userApiLogicService.read(user.getUserIdx()));
        return "pages/www.duoback.co.kr/mypage/mypage_withdrawal";
    }

    @DeleteMapping({"/delete/{userIdx}"})
    public String memberDelete(@PathVariable(name = "userIdx") Long userIdx) {
        if(session.getAttribute("userid")==null){
            return "pages/www.duoback.co.kr/member/login";
        }
        this.userApiLogicService.delete(userIdx);
        session.invalidate();
        return "redirect:/www.duoback.co.kr";
    }

    @PostMapping("/deleteAdd/delete")
    public List<String> deleteSubmit(@RequestBody List<String> arr){
        registAddressService.deleteBoard(arr);
        return arr;
    }

    @RequestMapping(value="/updateAdd/{rgaIdx}", method = {RequestMethod.GET, RequestMethod.POST})
    public String update(@RequestBody RegistAddressDTO registAddressDTO, @PathVariable Long rgaIdx,Model model){
        registAddressService.update(registAddressDTO, rgaIdx);
        User user = (User)session.getAttribute("user");
        model.addAttribute("user", userApiLogicService.read(user.getUserIdx()));
        model.addAttribute("dpoint", dpointService.getDpointList(user.getUserIdx()));
        model.addAttribute("coupon", couponService.getCouponList(user.getUserIdx()));
        model.addAttribute("review",reviewService.getReviewList(user.getUserIdx()));
        return "redirect:/www.duoback.co.kr/mypage_delivery_address";
    }


}
