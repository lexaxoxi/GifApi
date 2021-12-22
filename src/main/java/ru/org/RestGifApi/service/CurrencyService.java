package ru.org.RestGifApi.service;

import org.springframework.http.ResponseEntity;
import ru.org.RestGifApi.dto.CurrencyDTO;

public interface CurrencyService {
    ResponseEntity<CurrencyDTO> getCurrency(String date, String base);
}