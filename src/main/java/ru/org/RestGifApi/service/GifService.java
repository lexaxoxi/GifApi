package ru.org.RestGifApi.service;

import org.springframework.http.ResponseEntity;
import ru.org.RestGifApi.dto.GifDTO;

public interface GifService {
    ResponseEntity<GifDTO> getGifResponse(String tag);
}
