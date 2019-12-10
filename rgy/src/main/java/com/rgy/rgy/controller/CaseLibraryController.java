package com.rgy.rgy.controller;
import com.rgy.rgy.bean.CaseLibrary;
import com.rgy.rgy.bean.Result;
import com.rgy.rgy.service.CaseLibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * @Author：xiongxy
 * @Date: 2019/10/28 22:00
 */

@CrossOrigin
@RestController
@RequestMapping("/caseLibrary")
public class CaseLibraryController {
    @Autowired
    CaseLibraryService caseLibraryService;

    /**
     * 查询所有案例信息
     * @return
     */
    @GetMapping("/findall")
    public Result findAll(){
        List<CaseLibrary> caseLibraries = caseLibraryService.findAll();
        if (caseLibraries != null && !caseLibraries.isEmpty()){
            return new Result("success","返回成功",caseLibraries);
        }else{
            return new Result("error","返回失败");
        }
    }

    /**
     * 模糊查询
     * @param keyword
     * @return
     */
    @GetMapping("/findByKeywordLike")
    public Result findByKeywordLike(@RequestParam(required = false) String keyword){
         List<CaseLibrary> caseLibraries =caseLibraryService.findByKeywordLike(keyword);
         if (caseLibraries != null && !caseLibraries.isEmpty()){
             return new Result("success","返回成功",caseLibraries);
         }else{
             return new Result("error","返回失败");
         }
    }

    /**
     * 新增案例信息
     * @param file
     * @param keyword
     * @return
     */
    @PostMapping("/add")
    public Result fileUpload(@RequestParam("file") MultipartFile file, @RequestParam String keyword) {
        if (file.isEmpty()) {
            return new Result("error", "上传失败");
        }
        String fileName = file.getOriginalFilename();
        int size = (int) file.getSize();
        System.out.println(fileName + "-->" + size);
        String path = "F:\\热工院项目\\rgy-master\\rgy-master\\src\\main\\resources\\anlifiles";
        File dest = new File(path + "/" + fileName);
        String root = dest.getAbsolutePath();
        if (!dest.getParentFile().exists()) { //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest); //保存文件
            if (caseLibraryService.add(keyword, root)) {
                return new Result("success", "上传成功");
            } else {
                return new Result("error", "上传失败");
            }
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new Result("error", "上传失败");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new Result("error", "上传失败");
        }
    }
    /**
     * 更新案例信息
     * @param caseLibrary
     * @return
     */
    @PostMapping("/update")
    public Result update(@RequestBody CaseLibrary caseLibrary){
        if ( caseLibraryService.update(caseLibrary)){
            return new Result("success","更新成功");
        }
        else
            return new Result("error","更新失败");

    }


    /**
     * 根据id删除
     * @param caseLibraryID
     * @return
     */
    @GetMapping("/delete")
    public Result delete(@RequestParam Integer caseLibraryID){
        if (caseLibraryService.delete(caseLibraryID)){
            return new Result("success","删除成功");
        }
        else
            return new Result("error","删除失败");
    }


    /**
     * 文件的上传
     * @param file
     * @return
     */
//    @RequestMapping("/fileUpload")
//    @ResponseBody
//    public String fileUpload(@RequestParam("fileName") MultipartFile file){
//        if(file.isEmpty()){
//            return "false";
//        }
//        String fileName = file.getOriginalFilename();
//        int size = (int) file.getSize();
//        System.out.println(fileName + "-->" + size);
//        String path = "F:\\热工院项目\\rgy-master\\rgy-master\\src\\main\\resources\\files" ;
//        File dest = new File(path + "/" + fileName);
//        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
//            dest.getParentFile().mkdir();
//        }
//        try {
//            file.transferTo(dest); //保存文件
//            return "true";
//        } catch (IllegalStateException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return "false";
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return "false";
//        }
//    }

    /**
     * 文件的下载
     * @param response
     * @return
     * @throws UnsupportedEncodingException
     */

    @RequestMapping("/download")
    public String downLoad(HttpServletResponse response) throws UnsupportedEncodingException {
        String filename="2.xlsx";
        String filePath = "E:/test2" ;
        File file = new File(filePath + "/" + filename);
        if(file.exists()){ //判断文件父目录是否存在
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            // response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment;fileName=" +   java.net.URLEncoder.encode(filename,"UTF-8"));
            byte[] buffer = new byte[1024];
            FileInputStream fis = null; //文件输入流
            BufferedInputStream bis = null;

            OutputStream os = null; //输出流
            try {
                os = response.getOutputStream();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                int i = bis.read(buffer);
                while(i != -1){
                    os.write(buffer);
                    i = bis.read(buffer);
                }

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("----------file download---" + filename);
            try {
                bis.close();
                fis.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }
}
