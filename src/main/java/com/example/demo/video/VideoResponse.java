package com.example.demo.video;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

public class VideoResponse {
    @Getter
    @Setter
    public static class VideoPageResponseDTO{
        private int page;
        private List<VideoAllResponseDTO> videoAllResponseDTO;
        private boolean last;

        public VideoPageResponseDTO(int page, List<VideoAllResponseDTO> videoAllResponseDTO, boolean last){
            this.page = page;
            this.videoAllResponseDTO = videoAllResponseDTO;
            this.last = last;
        }
    }


    @Getter
    @Setter
    public static class VideoAllResponseDTO {
        private int videoID;
        private String videoUrl;
        private String videoTitleKorean;
        private String videoTitleEng;
        private String interests;
        private long views;
        private String videoThumbnailUrl;
        private String videoStartTime;
        private String videoEndTime;

        public VideoAllResponseDTO(Video video, VideoInterest videoInterest)
        {
            this.videoID = video.getId();
            this.videoUrl = video.getVideoUrl();
            this.videoTitleKorean = video.getVideoTitleKorean();
            this.videoTitleEng = video.getVideoTitleEng();
            this.interests = videoInterest.getInterest().getCategory();
            this.views = video.getViews();
            this.videoThumbnailUrl = video.getVideoThumbnailUrl();
            this.videoStartTime = video.getVideoStartTime();
            this.videoEndTime = video.getVideoEndTime();
        }
    }

    @Getter
    @Setter
    public static class VideoResponseDTO {
        private int videoID;
        private String url;
        private String interests;
        private long views;
        private String startTime;
        private String endTime;
        private List<SubtitleDTO> subtitles;

        public VideoResponseDTO(Video video, VideoInterest videoInterest, List<Subtitle> subtitles)
        {
            this.videoID = video.getId();
            this.url = video.getVideoUrl();
            this.interests = videoInterest.getInterest().getCategory();
            this.views = video.getViews();
            this.startTime = video.getVideoStartTime();
            this.endTime = video.getVideoEndTime();
            this.subtitles = subtitles.stream()
            .map(SubtitleDTO::new)
            .collect(Collectors.toList());
        }

        @Getter
        @Setter
        public static class SubtitleDTO
        {
            private int subtitleId;
            private String korSubtitleContent;
            private String korSubtitleStartTime;
            private String korSubtitleEndTime;
            private String engSubtitleContent;
            private String engSubtitleStartTime;
            private String engSubtitleEndTime;

            public SubtitleDTO(Subtitle subtitle)
            {
                this.subtitleId = subtitle.getId();
                this.korSubtitleContent = subtitle.getKorSubtitleContent();
                this.korSubtitleStartTime = subtitle.getKorStartTime();
                this.korSubtitleEndTime = subtitle.getKorEndTime();
                this.engSubtitleContent = subtitle.getEngSubtitleContent();
                this.engSubtitleStartTime = subtitle.getEngStartTime();
                this.korSubtitleEndTime = subtitle.getEngEndTime();
            }
        }
    }



}
