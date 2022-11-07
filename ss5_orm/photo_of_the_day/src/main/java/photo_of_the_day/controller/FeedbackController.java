package photo_of_the_day.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import photo_of_the_day.entity.Feedback;
import photo_of_the_day.entity.Photo;
import photo_of_the_day.service.FeedbackService;
import photo_of_the_day.service.PhotoService;

import java.util.List;

@Controller
public class FeedbackController {
    @Autowired
    FeedbackService feedbackService;

    @Autowired
    PhotoService photoService;

    @GetMapping("/home")
    public String getHome() {
        return "home";
    }

    @GetMapping("/showForm")
    public ModelAndView getHome(@RequestParam("photo-src") String src) {
        Photo photo = new Photo(src);
        photoService.save(photo);
        Photo p = photoService.findByPhotoLinkContaining(src);

        Feedback feedback = new Feedback();
        feedback.setPhoto(p);
        System.out.println(feedback.getPhoto().getId());
        System.out.println(feedback.getPhoto().getPhotoLink());
        ModelAndView modelAndView = new ModelAndView("feedback");
        modelAndView.addObject("feedback",feedback);

        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute("feedback") Feedback feedback) {

        feedbackService.save(feedback);
        List<Feedback> feedbacks = feedbackService.findAllByPhoto_Id(feedback.getPhoto().getId());
        Photo p = photoService.findById(feedback.getPhoto().getId());

        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("feedbacks",feedbacks);
        modelAndView.addObject("photo",p);

        return modelAndView;
    }

//    @GetMapping("/like/{id}")
//    public String like(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
//        Feedback feedback = feedbackService.findById(id);
//        feedback.setLike(feedback.getLike()+1);
//
//        redirectAttributes.addFlashAttribute("fbWithLike",feedback);
//        return "redirect:/home";
//    }

}
