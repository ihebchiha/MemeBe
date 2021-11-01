package com.gobeyond.memebe.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostMemeRequest {

    private MultipartFile memeFile;
    private String title;
    private String description;

}
