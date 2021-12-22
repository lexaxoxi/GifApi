package ru.org.RestGifApi.service.impl;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.org.RestGifApi.client.DownloadClient;
import ru.org.RestGifApi.service.DownloadService;

import java.net.URI;

@Service
@Data
public class DownloadServiceImpl implements DownloadService {
    private final DownloadClient downloadClient;

    @Override
    public ResponseEntity<byte[]> getGifByUrl(URI uri) {
        return downloadClient.getGifByUrl(uri);
    }

}
