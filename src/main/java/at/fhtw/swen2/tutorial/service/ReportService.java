package at.fhtw.swen2.tutorial.service;

import com.lowagie.text.DocumentException;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ReportService {

    void generatePdfFromHtml(String html) throws IOException, DocumentException;

    String parseThymeleafTemplateTourList();
}
