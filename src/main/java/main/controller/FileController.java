package main.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import main.model.po.ProjectPublic;
import main.model.po.StudentDetail;
import main.service.ProjectPublicService;
import main.service.StudentDetailService;
import main.service.UserService;
import main.util.CommonReturnType;
import main.util.IpTimeStamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;


@Slf4j
@Api(tags = "文件上传下载路径")
@Controller
@RequestMapping("/file/upload")
public class FileController {


    @Autowired
    private StudentDetailService studentDetailService;

    @Autowired
    private ProjectPublicService projectPublicService;

    @Autowired
    private HttpServletRequest request;

    @Value("${picture.localLocation}")
    private String fileLocation;

    @Autowired
    private IpTimeStamp ipTimeStamp = new IpTimeStamp();

    @ApiOperation("文件上传")
    @ApiImplicitParam(name = "file", value = "文件")
    @PostMapping("/upload")
    @ResponseBody
    public CommonReturnType upload(MultipartFile file)
    {
        String fileName = file.getOriginalFilename();
        File dest = new File(fileName);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return CommonReturnType.ok();
    }


    @ApiOperation("用户头像上传接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "文件"),
            @ApiImplicitParam(name = "id", value = "用户id")
    })
    @PostMapping("/user/{id}")
    @ResponseBody
    public CommonReturnType upload(MultipartFile file, @PathVariable Long id) throws UnknownHostException {
        IpTimeStamp ipTimeStamp = new IpTimeStamp(InetAddress.getLocalHost().getHostAddress());
        log.info(InetAddress.getLocalHost().getHostAddress());
        log.info("用户头像上传" );
        log.info("原文件名： " , file.getOriginalFilename());
        //本地存储的文件名
        String newFileName = ipTimeStamp.getIpTimeRand();
        //文件后缀名
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
        File dest = new File(fileLocation + "user/", newFileName + "." + suffix);

        log.info("转储文件： " + dest.getAbsolutePath());
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }


        StudentDetail sd = new StudentDetail();
        sd.setUserId(id);
        sd.setImagePath("/images/user/" + newFileName + "." + suffix);

        studentDetailService.updateByUserIdSelective(sd);


        return CommonReturnType.ok(sd.getImagePath());
    }

    @ApiOperation("项目头像上传接口")
    @ApiImplicitParam(name = "files", value = "文件， 可以多个")
    @PostMapping("/project/{id}")
    @ResponseBody
    public CommonReturnType uploadProject(MultipartFile[] files, @PathVariable Long id) throws UnknownHostException {
        IpTimeStamp ipTimeStamp = new IpTimeStamp(InetAddress.getLocalHost().getHostAddress());
        log.info(InetAddress.getLocalHost().getHostAddress());
        log.info("项目头像上传" );

        //创建项目文件夹
        File destDir = new File(fileLocation + "project/" + id + "/");
        if(!destDir.exists())
        {
            destDir.mkdir();
        }
        String newFileName = ipTimeStamp.getIpTimeRand();
        StringBuilder fileAllName =  new StringBuilder();
        int i = 0;
        for(MultipartFile file: files)
        {
            //文件后缀名
            String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
            File dest = new File(fileLocation + "project/" + id + "/", newFileName + i + "." + suffix);
            fileAllName.append(fileLocation + "project/" + id + "/" + newFileName + i + "." + suffix);
            fileAllName.append(";");
            try {
                file.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
            i++;

        }

        ProjectPublic projectPublic = new ProjectPublic();
        projectPublic.setId(id);
        projectPublic.setLogoPath(fileAllName.toString());
        projectPublicService.updateSelective(projectPublic);


        return CommonReturnType.ok(projectPublic.getLogoPath());
    }



}
