package ru.org.RestGifApi.service;

import org.springframework.http.ResponseEntity;

public interface GifOnCurrencyExchangeRateService {
        ResponseEntity<byte[]> getGifByCurrency(String base);
}
