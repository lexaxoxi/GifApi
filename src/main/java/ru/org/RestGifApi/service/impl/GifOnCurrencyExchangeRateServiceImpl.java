package ru.org.RestGifApi.service.impl;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.org.RestGifApi.dto.CurrencyDTO;
import ru.org.RestGifApi.dto.GifDTO;
import ru.org.RestGifApi.exceptions.FalseBaseException;
import ru.org.RestGifApi.service.CurrencyService;
import ru.org.RestGifApi.service.DownloadService;
import ru.org.RestGifApi.service.GifOnCurrencyExchangeRateService;
import ru.org.RestGifApi.service.GifService;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

@Data
@Slf4j(topic = "GifOnCurrencyExchangeRateService")
@Service
public class GifOnCurrencyExchangeRateServiceImpl implements GifOnCurrencyExchangeRateService {
    private final GifService gifService;
    private final CurrencyService currencyService;
    private final DownloadService downloadService;

    public ResponseEntity<byte[]> getGifByCurrency(String base) {
        log.info("Ведется поиcк gif");
        if (isBaseNotValid(base)) {
            log.error("Введен некорректный код валюты");
            throw new FalseBaseException("Код валюты должен состоять из 3х символов");
        }
        log.info("Текущий код валюты: {}", base);
        String todayDate = formatDateFromNow(0);
        String yesterdayDate = formatDateFromNow(1);
        double todayRate = getRateByDateAndBase(todayDate, base);
        double yesterdayRate = getRateByDateAndBase(yesterdayDate, base);
        String tag = (todayRate > yesterdayRate) ? "rich" : "broke";
        log.info("Текущий tag для валюты: {}", tag);
        URI basePathUri = URI.create(getGifUrlByTag(tag));
        return downloadService.getGifByUrl(basePathUri);
    }

    private boolean isBaseNotValid(String base) {
        return base.length() != 3;
    }

    private String formatDateFromNow(int days) {
        LocalDateTime dateTime = LocalDateTime.now().minusDays(days);
        String dateFromNow = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(dateTime);
        log.info("Дата с учетом вычета {} дней : {}",days,dateFromNow);
        return dateFromNow;
    }

    private double getRateByDateAndBase(String date, String base) {
        CurrencyDTO currencyDTO = currencyService.getCurrency(date, base.toUpperCase()).getBody();
        double rate = Objects.requireNonNull(currencyDTO).getRates().get("RUB");
        log.info("Курс рубля на {}: {}",date,rate);
        return rate;
    }

    private String getGifUrlByTag(String tag) {
        GifDTO gifDTO = gifService.getGifResponse(tag).getBody();
        String url = String.valueOf(Objects.requireNonNull(gifDTO).getData().get("image_original_url"));
        log.info("Текущий URL гифки: {}", url);
        return url;
    }
}
