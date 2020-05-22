package com.restserver.resourceserver.utils;
import com.restserver.resourceserver.controller.CourseController;
import com.restserver.resourceserver.controller.MediaController;
import com.restserver.resourceserver.domain.CourseResource;
import com.restserver.resourceserver.enums.ResourceTypeEnum;
import com.restserver.resourceserver.vo.CourseDetailVO;
import org.springframework.http.HttpHeaders;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
public class CourseDetailAddRel {
    public static CourseDetailVO addRel(CourseDetailVO courseDetailVO, HttpHeaders headers) throws Exception {
        courseDetailVO.add(linkTo(methodOn(CourseController.class).getDetail(courseDetailVO.getCourseId(),headers)).withSelfRel());
        courseDetailVO.add(linkTo(methodOn(CourseController.class).courseVOList(courseDetailVO.getCourseType(),headers)).withRel("get_sameType"));
        if(courseDetailVO.getResources()!=null) {
            for (CourseResource resource : courseDetailVO.getResources()) {
                if (resource.getResourceType() == ResourceTypeEnum.DOC.getCode()) {
                    courseDetailVO.add(linkTo(methodOn(MediaController.class).getDoc(resource.getResourceId(), headers,courseDetailVO.getCourseId())).withRel("get_doc" + resource.getResourceName()));
                }
                if (resource.getResourceType() == ResourceTypeEnum.IMAGE.getCode()) {
                    courseDetailVO.add(linkTo(methodOn(MediaController.class).getImage(resource.getResourceId(), headers,courseDetailVO.getCourseId())).withRel("get_image" + resource.getResourceName()));
                }
                if (resource.getResourceType() == ResourceTypeEnum.VIDEO.getCode()) {
                    courseDetailVO.add(linkTo(methodOn(MediaController.class).getVideo(headers, resource.getResourceId(),courseDetailVO.getCourseId())).withRel("get_video" + resource.getResourceName()));
                }
            }
        }
        return courseDetailVO;
    }
}
