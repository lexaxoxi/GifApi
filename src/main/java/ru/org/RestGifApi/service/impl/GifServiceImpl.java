package ru.org.RestGifApi.service.impl;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.org.RestGifApi.client.GifClient;
import ru.org.RestGifApi.dto.GifDTO;
import ru.org.RestGifApi.service.GifService;

@Service
@Data
public class GifServiceImpl implements GifService {

    private final GifClient gifClient;

    private final String API_KEY;

    public GifServiceImpl(GifClient gifClient, @Value("${gif.api_key}") String API_KEY) {
        this.gifClient = gifClient;
        this.API_KEY = API_KEY;
    }

    public ResponseEntity<GifDTO> getGifResponse(String tag) {
        return gifClient.getGif(API_KEY, tag);
    }
}