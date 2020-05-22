package com.restserver.resourceserver.controller;

import com.restserver.resourceserver.domain.Course;
import com.restserver.resourceserver.service.CourseRegisterService;
import com.restserver.resourceserver.service.CourseService;
import com.restserver.resourceserver.service.CourseTypeService;
import com.restserver.resourceserver.utils.CourseDetailAddRel;
import com.restserver.resourceserver.utils.CourseVOAddRel;
import com.restserver.resourceserver.vo.CourseDetailVO;
import com.restserver.resourceserver.vo.CourseList;
import com.restserver.resourceserver.vo.CourseVO;
import com.restserver.resourceserver.vo.ResultVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/elearning/course")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseTypeService typeService;
    @Autowired
    private CourseRegisterService courseRegisterService;
    @Operation(summary = "get course list by typeId",description = "return course list with it's hateoas",tags = {"course"})
    @ApiResponses(value={
            @ApiResponse(responseCode = "200",description = "get course list success",content = @Content(schema = @Schema(implementation = CourseVO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Contact already exists")
})
    @RequestMapping("/list")
    public ResultVO<CourseList> courseVOList(@Parameter(description="Id of the course type", required=true) @RequestParam(value = "typeId") Integer typeId, @RequestHeader HttpHeaders headers) throws Exception {
        List<Course> courseList=courseService.getCourseListByType(typeId);
        List<CourseVO> courseVOList=new ArrayList<>();
        String typeName=typeService.getTypeInfoById(courseList.get(0).getCourseType()).getTypeName();
        for(Course course:courseList){
            CourseVO courseVO=new CourseVO();
            BeanUtils.copyProperties(course,courseVO);
            courseVO.setTypeName(typeName);
            courseVOList.add(courseVO);
        }
        CourseList courseList1=new CourseList(courseVOList);
        courseList1=CourseVOAddRel.addRel(courseList1,headers);
        ResultVO<CourseList> resultVO=new ResultVO<>();
        resultVO.setCode(200);
        resultVO.setMessage("获取课程列表成功");
        resultVO.setData(courseList1);
        return resultVO;
    }

    @Operation(summary = "get course by courseId",description = "return single course with it's hateoas",tags = {"courseDetail"})
    @ApiResponses(value={
            @ApiResponse(responseCode = "200",description = "get course success",content = @Content(schema = @Schema(implementation = CourseVO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Contact already exists")
    })
    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public ResultVO<CourseDetailVO> getDetail(@Parameter(description="Id of the course", required=true) @RequestParam(value = "courseId") String courseId, @RequestHeader HttpHeaders httpHeaders) throws Exception {
        Course course=courseService.getById(courseId);
        CourseDetailVO courseDetailVO= new CourseDetailVO();
        BeanUtils.copyProperties(course,courseDetailVO);
        courseDetailVO.setTypeName(typeService.getTypeInfoById(course.getCourseType()).getTypeName());
        courseDetailVO= CourseDetailAddRel.addRel(courseDetailVO,httpHeaders);
        ResultVO<CourseDetailVO> resultVO=new ResultVO<>();
        resultVO.setCode(200);
        resultVO.setMessage("获取课程详情");
        resultVO.setData(courseDetailVO);
        return resultVO;
    }

    @Operation(summary = "post request of join a class",description = "return message of request commit",tags = {"return_message"})
    @ApiResponses(value={
            @ApiResponse(responseCode = "200",description = "get course success",content = @Content(schema = @Schema(implementation = CourseVO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Contact already exists")
    })
    @RequestMapping(value = "/register")
    public ResultVO<String> register(@Parameter(description="Id of the user", required=true) @RequestParam(value = "userId") String userId,@RequestHeader HttpHeaders headers,@Parameter(description="Id of the course", required=true)@RequestParam(value = "courseId") String courseId){
        int result=courseRegisterService.register(courseId,userId);
        ResultVO<String> resultVO=new ResultVO<>();
        if(result==1){
            resultVO.setMessage("提交成功，请等待管理员审核");
            resultVO.setCode(200);
        }
        else{
            resultVO.setMessage("提交失败，请稍后重试");
            resultVO.setCode(300);
        }
        return resultVO;
    }
}
