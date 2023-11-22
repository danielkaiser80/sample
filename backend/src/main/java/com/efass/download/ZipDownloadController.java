package com.efass.download;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class ZipDownloadController {

    private final DownloadService downloadService;

    public ZipDownloadController(DownloadService downloadService) {
        this.downloadService = downloadService;
    }

    @GetMapping("/download/{reportNames}")
    public void download(HttpServletResponse response, @PathVariable("reportNames") List<String> reportNames) {


        downloadService.downloadZipFile(response, reportNames);
    }
}
