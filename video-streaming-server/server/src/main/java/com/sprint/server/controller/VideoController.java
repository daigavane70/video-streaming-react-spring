package com.sprint.server.controller;

import com.sprint.common.response.HttpApiResponse;
import com.sprint.common.response.HttpErrorResponse;
import com.sprint.repository.entity.Video;
import com.sprint.repository.repositories.VideoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/video")
public class VideoController {
    @Autowired
    VideoRepository videoRepository;

    @GetMapping
    HttpApiResponse getAllVideos() {
        List<Video> videos = videoRepository.findAll();
        return new HttpApiResponse(videos);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    HttpApiResponse createVideo(@RequestBody Video video) {
        try {
            log.info("[videoController : createVideo] creating video for payload: {}", video);
            Video newVideo = videoRepository.save(video);
            return new HttpApiResponse(newVideo);
        } catch (Exception e) {
            return new HttpApiResponse(false, null, new HttpErrorResponse(1001, e.getMessage()));
        }
    }

    @GetMapping(value = "/{id}")
    HttpApiResponse getVideoById(@PathVariable long id) {
        try {
            log.info("[videoController : getVideoById] fetching video for id: {}", id);
            Optional<Video> video = videoRepository.findById(id);
            if (!video.isPresent()) {
                log.error("[videoController : getVideoById] video not found for id: {}", id);
                return new HttpApiResponse(false, null, new HttpErrorResponse(1001, "Video not found for id: " + id));
            }
            return new HttpApiResponse(video);
        } catch (Exception e) {
            log.error("[VideoController : getVideoById] unable to fetch video for id: {}", id);
            return new HttpApiResponse(false, null, new HttpErrorResponse(1001, e.getMessage()));
        }
    }

    @PutMapping
    HttpApiResponse updateVideo(@RequestBody Video video) {
        try {
            if (video.getId() == null)
                throw new Exception("Id should not be null");

            log.info("[videoController : updateVideo] updating video for id: {}", video.getId());
            Optional<Video> existingVideo = videoRepository.findById(video.getId());

            if (!existingVideo.isPresent()) {
                log.error("[videoController : updateVideo] video not found for id: {}", video.getId());
                return new HttpApiResponse(false, null,
                        new HttpErrorResponse(1001, "Video not found for id: " + video.getId()));
            }

            videoRepository.save(video);
            return new HttpApiResponse(video);
        } catch (Exception e) {
            log.error("[VideoController : updateVideo] unable to update video for id: {}", video.getId());
            return new HttpApiResponse(false, null, new HttpErrorResponse(1001, e.getMessage()));
        }
    }

    @DeleteMapping(value = "/{id}")
    HttpApiResponse deleteVideo(@PathVariable Long id) {
        try {
            log.info("[videoController : deleteVideo] fetching video to delete for id: {}", id);
            videoRepository.deleteById(id);
            return new HttpApiResponse("Video deleted successfully for id: " + id);
        } catch (Exception e) {
            log.error("[VideoController : deleteVideo] unable to delete video for id: {}", id);
            return new HttpApiResponse(false, null, new HttpErrorResponse(1001, e.getMessage()));
        }
    }
}
