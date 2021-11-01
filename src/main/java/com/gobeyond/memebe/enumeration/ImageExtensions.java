package com.gobeyond.memebe.enumeration;

import lombok.Getter;

@Getter
public enum ImageExtensions {
    JPEG(".jpeg"), PNG(".png");

    String extension;

    ImageExtensions(String extension){
        this.extension = extension;
    }
}
