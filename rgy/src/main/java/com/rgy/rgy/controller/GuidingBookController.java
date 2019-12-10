package com.rgy.rgy.controller;

import com.rgy.rgy.bean.GuidingBook;
import com.rgy.rgy.bean.Material;
import com.rgy.rgy.bean.Result;
import com.rgy.rgy.service.GuidingBookService;
import com.rgy.rgy.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Author：gaoyk
 * @Date: 2019/12/2 16:00
 */

@CrossOrigin
@RestController
@RequestMapping("/guidingbook")
public class GuidingBookController{
    @Autowired
    GuidingBookService guidingBookService;

//    /**
//     * 添加作业指导书信息
//     * @param guidingBook
//     * @return
//     */
//    @PostMapping("/add")
//    public Result add(@RequestBody GuidingBook guidingBook){
//        if(guidingBookService.add(guidingBook)) {
//            return new Result("success", "操作成功");
//        }else{
//            return new Result("error","操作失败");
//        }
//    }

    /**
     * 更新作业指导书信息
     * @param guidingBook
     * @return
     */
    @PostMapping("/update")
    public Result update(@RequestBody GuidingBook guidingBook){
        if (guidingBookService.update(guidingBook)){
            return new Result("success","操作成功");
        }else{
            return new Result("error","操作失败");
        }
    }

    /**
     * 返回所有作业指导书的信息
     * @return
     */
    @GetMapping("/findall")
    public Result findAll(){
        List<GuidingBook> guidingBooks = guidingBookService.findAll();
        if(guidingBooks!=null && !guidingBooks.isEmpty()){
            return new Result("success","返回成功",guidingBooks);
        }else{
            return new Result("error","返回失败");
        }
    }

    /**
     * 根据id进行删除
     * @param guidingBookId
     * @return
     */
    @GetMapping("/delete")
    public Result gdel(@RequestParam Integer guidingBookId){
        if(guidingBookService.delete(guidingBookId)){
            return new Result("success","删除成功");
        }else{
            return new Result("error","删除失败");
        }
    }

    /**
     * 新增
     * @param file
     * @param guidingBookName
     * @return
     */
    @PostMapping("/fileUpload")
    public Result fileUpload(@RequestParam("file") MultipartFile file, @RequestParam String guidingBookName){
        if(file.isEmpty()){
            return new Result("error","上传失败");
        }
        String fileName = file.getOriginalFilename();
        int size = (int) file.getSize();
        System.out.println(fileName + "-->" + size);
        String path = "F:\\热工院项目\\rgy-master\\rgy-master\\src\\main\\resources\\guidingbookfiles" ;
        File dest = new File(path + "/" + fileName);
        String root = dest.getAbsolutePath();
        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest); //保存文件
            if(guidingBookService.add(guidingBookName,root)){
                return new Result("success","上传成功");
            }else{
                return new Result("error","上传失败");
            }
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new Result("error","上传失败");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new Result("error","上传失败");
        }
    }

    /**
     * 模糊查询
     * @param guidingBookName
     * @return
     */
    @GetMapping("/findByName")
    public Result find(@RequestParam(required = false) String guidingBookName){
        List<GuidingBook> guidingBooks = guidingBookService.findByKeywordLike(guidingBookName);
        if (guidingBooks != null && !guidingBooks.isEmpty()){
            return new Result("success","返回成功",guidingBooks);
        }else{
            return new Result("error","返回失败");
        }
    }
}
