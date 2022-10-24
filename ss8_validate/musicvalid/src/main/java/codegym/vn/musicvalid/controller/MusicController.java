package codegym.vn.musicvalid.controller;


import codegym.vn.musicvalid.entity.Music;
import codegym.vn.musicvalid.service.MusicService;
import codegym.vn.musicvalid.valid.MusicValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Controller
public class MusicController {

    private Path pathMusic= Paths.get("src\\main\\resources\\static\\music\\");
    private Path  pathPic = Paths.get("src\\main\\resources\\static\\image\\");
    @Autowired
    private MusicService service;

    @GetMapping("/")
    public String showList(Model model, @RequestParam(value = "page") Optional<Integer> page){
        int currentPage = page.orElse(1);
        int pageSize =  2;

        Page<Music> musics = service.getAll( PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("musics",musics );

        int numbers = musics.getNumber();
        int totalItems = musics.getNumberOfElements();
        int totalPages = musics.getTotalPages();

        model.addAttribute("totalItems", totalItems);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("numbers", numbers);
        return "list";
    }

    @GetMapping("/create")
    public String showFormCreate(  Model model) {
        model.addAttribute("music", new Music());
        return "create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute(value = "music") Music music,
                         BindingResult bindingResult ,
                         @RequestParam(value= "filePicAA") MultipartFile PicFile,
                         @RequestParam(value = "filePathAA") MultipartFile MusicFile) {


        if(   PicFile.isEmpty() ){
            FieldError e = new FieldError("music", "filePic",  "File Pic is empty" );
            bindingResult.addError(   e);
        }
        if( MusicFile.isEmpty()   ){
            FieldError e = new FieldError("music", "filePath",  "File Music file is empty" );
            bindingResult.addError(   e);
        }
        MusicValid valid = new MusicValid();
        valid.validate( music, bindingResult);
        if( bindingResult.hasErrors() ){
            return "create";
        }

        try {
            InputStream inputStreamMusic = MusicFile.getInputStream();
//            String fileNameMusic = Music.getOriginalFilename().toLowerCase(). + System.currentTimeMillis();
            String extentionMusic =  MusicFile.getOriginalFilename().substring(MusicFile.getOriginalFilename().lastIndexOf('.') + 1);
            String fileNameMusic =  music.getName() + "-"  + System.currentTimeMillis() + "."+ extentionMusic ;
            Files.copy(inputStreamMusic, pathMusic.resolve( fileNameMusic ), StandardCopyOption.REPLACE_EXISTING);
            music.setFilePath( fileNameMusic );

            InputStream inputStreamPic = PicFile.getInputStream();
            String extentionPic =  PicFile.getOriginalFilename().substring(PicFile.getOriginalFilename().lastIndexOf('.') + 1);

            String fileNamePic =  music.getName() + "-"  + System.currentTimeMillis()  + "."+  extentionPic ;
            Files.copy(inputStreamPic, pathPic.resolve( fileNamePic), StandardCopyOption.REPLACE_EXISTING);
            music.setFilePic(fileNamePic);
        } catch (IOException e) {
            e.printStackTrace();
        }

        service.create(music);
        return "redirect:/";

    }


    @PostMapping("/delete")
    public String delete( @RequestParam(value = "idDelete") String idDelete , Model model)  {
        int id = Integer.parseInt(idDelete);


        Music music = service.findById(id);
      try {
            Files.delete( pathPic.resolve( music.getFilePic()));
            Files.delete( pathMusic.resolve(music.getFilePath()));
            System.out.println("Xoa thanh cong");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Xoa that bai");
        }


        service.delete(id);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String showFormuUpdate(@RequestParam(value = "id") String id,Model model){

        Music music = service.findById( Integer.parseInt(id));
        model.addAttribute("music", music);
        return "update";

    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute(value = "music") Music music,
                         BindingResult bindingResult ,
                         @RequestParam(value= "filePicAA") MultipartFile PicFile,
                         @RequestParam(value = "filePathAA") MultipartFile MusicFile) {

        MusicValid valid = new MusicValid();
        valid.validate( music, bindingResult);
        if( bindingResult.hasErrors() ){
            return "create";
        }

        if( !MusicFile.isEmpty()   ){
            try {
                // xoa file nhac cu
                Files.delete( pathMusic.resolve( music.getFilePath()));
                //  thay doi file nhac moi
                InputStream inputStreamMusic = MusicFile.getInputStream();
                String extentionMusic =  MusicFile.getOriginalFilename().substring(MusicFile.getOriginalFilename().lastIndexOf('.') + 1);
                String fileNameMusic =  music.getName() + "-"  + System.currentTimeMillis() + "."+ extentionMusic ;
                Files.copy(inputStreamMusic, pathMusic.resolve( fileNameMusic ), StandardCopyOption.REPLACE_EXISTING);
                music.setFilePath( fileNameMusic );

            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        if(   !PicFile.isEmpty() ){ //neu co file anh moi phai xoa file cu chon file moi
            try {
                // xoa file anh cu
                Files.delete( pathPic.resolve( music.getFilePic()));
                // thay doi file  moi
                InputStream inputStreamPic = PicFile.getInputStream();
                String extentionPic =  PicFile.getOriginalFilename().substring(PicFile.getOriginalFilename().lastIndexOf('.') + 1);
                String fileNamePic =  music.getName() + "-"  + System.currentTimeMillis()  + "."+  extentionPic ;
                Files.copy(inputStreamPic, pathPic.resolve( fileNamePic), StandardCopyOption.REPLACE_EXISTING);
                music.setFilePic(fileNamePic);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }



        service.update(music);
        return "redirect:/";

    }




}
