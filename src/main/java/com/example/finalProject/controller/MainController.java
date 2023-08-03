package com.example.finalProject.controller;

import com.example.finalProject.models.*;
import com.example.finalProject.reposritory.OffersRepository;
import com.example.finalProject.service.CommentsService;
import com.example.finalProject.service.OffersService;
import com.example.finalProject.service.TypesService;
import com.example.finalProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private OffersRepository offersRepository;

    @Autowired
    private CommentsService commentsService;

    @Autowired
    private OffersService offersService;

    @Autowired
    private TypesService typesService;

    @GetMapping(value="/")
    public String indexPage(){
        return "index";
    }

    @GetMapping(value="/allTypes")
    public String getAllTypes(){
        return "alltypes";
    }

    @GetMapping(value="/addOffer")
    public String addOffer(Model model){
        List<Types> types = typesService.getAllTypes();
        model.addAttribute("types",types);

        return "addOffer";
    }

    @PostMapping(value="/add-basket")
    public String addToBasket(@RequestParam(name = "offerId") Long offerId,
                              @RequestParam(name = "userId") Long userId){
        offersService.addUser(userId, offerId);

        return "redirect:/basket";
    }

    @PostMapping(value="/remove-basket")
    public String removeFromBasket(@RequestParam(name = "offerId") Long offerId,
                                   @RequestParam(name = "userId") Long userId){
        offersService.removeUser(userId, offerId);
        return "redirect:/basket";
    }


    @GetMapping(value="/details/{offersId}")
    public String OfferDetailsUser(@PathVariable(name="offersId") Long offerId, Model model, Authentication authentication) {
        Offers offer = offersService.getOfferById(offerId);
        model.addAttribute("id", offerId);

        List<Comments> commentsList = commentsService.getCommentsByOffer(offer);
        model.addAttribute("comments", commentsList);

        if (authentication != null) {
            User user = (User) authentication.getPrincipal();
//            boolean isAdmin = user.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"));
            boolean isAdmin=false;
            for(Permission p : user.getPermissions()){
                if(p.getAuthority().equals("ROLE_ADMIN")){
                    isAdmin=true;
                    break;
                }
            }
            if (isAdmin) {
                return "detailsOffer";
            } else {
                return "detailsOfferUser";
            }
        } else {
            return "detailsOfferUser";
        }
    }



    @PostMapping(value = "/add-comment")
    public String addComment(Comments comment){
        commentsService.saveOrUpdateComment(comment);
        return "redirect:/details/" + comment.getOffer().getId();
    }

    @GetMapping(value = "/basket")
    public String Basket(Model model){
        User user = userService.getCurrentSessionUser();
        model.addAttribute("user", user);

        List<Offers> offersList = offersService.getAllOffersByUser(user);

        model.addAttribute("offers", offersList);

        return "basket";
    }

    @GetMapping(value="/types/{typeId}")
    public String TypeDetails(@PathVariable(name="typeId") Long id, Model model){
        model.addAttribute("id", id);
        return "detailsType";
    }

    @GetMapping(value="/sign-up-page")
    public String singUpPage(){
        return "signup";
    }

    @GetMapping(value="/sign-in-page")
    public String singInPage(){
        return "signin";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value="/profile")
    public String profilePage(){
        return "profile";
    }

    @GetMapping(value = "/403-page")
    public String accessDenied(){
        return "403";
    }

    @GetMapping(value = "/update-password-page")
    public String updatePasswordPage(){
        return "update-password";
    }

    @PostMapping(value="/to-sign-up")
    public String toSignUp(@RequestParam(name = "user_email") String email,
                           @RequestParam(name = "user_password") String password,
                           @RequestParam(name = "user_repeat_password") String repeatPassword,
                           @RequestParam(name = "user_full_name") String fullName) {
        if (password.equals(repeatPassword)) {
            User user = new User();
            user.setEmail(email);
            user.setFullName(fullName);
            user.setPassword(password);
            User newUser = userService.addUser(user);
            if (newUser != null) {
                return "redirect:/sign-up-page?success";
            } else {
                return "redirect:/sign-up-page?emailerror";
            }
        } else {
            return "redirect:/sign-up-page?passworderror";
        }
    }


    @PostMapping(value="/to-update-password")
    public String toUpdatePassword(@RequestParam(name = "user_old_password") String oldPassword,
                                   @RequestParam(name = "user_new_password") String newPassword,
                                   @RequestParam(name = "user_repeat_new_password") String repeatNewPassword) {
        if(newPassword.equals(repeatNewPassword)){

            User user = userService.updatePassword(newPassword,oldPassword);
            if(user != null){
                return "redirect:/update-password-page?success";
            }else{
                return "redirect:/update-password-page?oldpassworderror";
            }

        }else{
            return "redirect:/update-password-page?passwordmismatch";
        }
    }
}
