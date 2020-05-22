package com.restserver.resourceserver.controller;

import com.restserver.resourceserver.domain.CourseResource;
import com.restserver.resourceserver.service.CourseResourceService;
import com.restserver.resourceserver.vo.CourseVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.ResourceRegion;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/elearning/course/media")
public class MediaController {
    final long ChunkSize = 1048576L;
    @Autowired
    private CourseResourceService resourceService;

    @Operation(summary = "get video resource",description = "return video",tags = {"video"})
    @ApiResponses(value={
            @ApiResponse(responseCode = "200",description = "get video success",content = @Content(schema = @Schema(implementation = CourseVO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Contact already exists")
    })
    @PreAuthorize("hasAuthority(#courseId)")
    @RequestMapping(path = "/video",method = RequestMethod.GET)
    public ResponseEntity<ResourceRegion> getVideo(@RequestHeader HttpHeaders headers, @Parameter(description="Id of the resource", required=true) @RequestParam("resourceId") String resourceId,@Parameter(description="Id of the course", required=true) @Param("courseId") String courseId) throws Exception{
        CourseResource resource=resourceService.getResourceByResourceId(resourceId);
        String path;
        if(resource.isLocal()){
            path="file:///"+resource.getUrl();
        }
        else{
            path=resource.getUrl();
        }
        UrlResource video=new UrlResource(path);
        ResourceRegion region = resourceRegion(video, headers);
        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT)
                .contentType(MediaTypeFactory.getMediaType(video).orElse(MediaType.APPLICATION_OCTET_STREAM))
                .body(region);
    }

    @Operation(summary = "get document resource",description = "return document",tags = {"document"})
    @ApiResponses(value={
            @ApiResponse(responseCode = "200",description = "get document success",content = @Content(schema = @Schema(implementation = CourseVO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Contact already exists")
    })
    @PreAuthorize("hasAuthority(#courseId)")
    @RequestMapping(value = "/document",method = RequestMethod.GET)
    public ResponseEntity<UrlResource> getDoc(@Parameter(description="Id of the resource", required=true) @RequestParam("resourceId") String resourceId,@RequestHeader HttpHeaders headers,@Parameter(description="Id of the course", required=true)@Param("courseId") String courseId) throws Exception{
        CourseResource resource=resourceService.getResourceByResourceId(resourceId);
        String path;
        if(resource.isLocal()){
            path="file:///"+resource.getUrl();
        }
        else{
            path=resource.getUrl();
        }
        UrlResource doc=new UrlResource(path);
        return ResponseEntity.ok()
                .contentType(MediaTypeFactory.getMediaType(doc).orElse(MediaType.APPLICATION_OCTET_STREAM))
                .body(doc);
    }

    @Operation(summary = "get image resource",description = "return image",tags = {"image"})
    @ApiResponses(value={
            @ApiResponse(responseCode = "200",description = "get image success",content = @Content(schema = @Schema(implementation = CourseVO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Contact already exists")
    })
    @PreAuthorize("hasAuthority(#courseId)")
    @RequestMapping(value = "/image",method = RequestMethod.GET)
    public ResponseEntity<UrlResource> getImage(@Parameter(description="Id of the resource", required=true)@RequestParam("resourceId") String resourceId,@RequestHeader HttpHeaders headers,@Parameter(description="Id of the course", required=true)@Param("courseId") String courseId) throws Exception{
        CourseResource resource=resourceService.getResourceByResourceId(resourceId);
        String path;
        if(resource.isLocal()){
            path="file:///"+resource.getUrl();
        }
        else{
            path=resource.getUrl();
        }
        UrlResource image=new UrlResource(path);
        return ResponseEntity.ok()
                .contentType(MediaTypeFactory.getMediaType(image).orElse(MediaType.APPLICATION_OCTET_STREAM))
                .body(image);
    }


    private ResourceRegion resourceRegion(UrlResource video, HttpHeaders headers) throws Exception {
        long contentLength = video.contentLength();
        HttpRange range;
        if (!headers.getRange().isEmpty()) {
            range = headers.getRange().get(0);
            long start = range.getRangeStart(contentLength);
            long end = range.getRangeEnd(contentLength);
            long size = end - start + 1;
            long rangeLength = ChunkSize>size? size:ChunkSize;
            return new ResourceRegion(video, start, rangeLength);
        } else {
            long rangeLength = ChunkSize>contentLength?contentLength:ChunkSize;
            return new ResourceRegion(video, 0, rangeLength);
        }
    }
}
