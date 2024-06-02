package tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import object.UserObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.json.Json;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static com.codeborne.pdftest.PDF.containsText;
import static org.hamcrest.MatcherAssert.assertThat;


@DisplayName("Проверка файлов внутри архива")
public class FileParsingTest {

    String scvFile = "csv_example.csv";
    String pdfFile = "pdf_example.pdf";
    String xlsFile = "xls_example.xls";

    private final ClassLoader cl = FileParsingTest.class.getClassLoader();

    public ZipInputStream zipInputStream(String fileName) throws IOException {
        ZipInputStream zip = new ZipInputStream(
                cl.getResourceAsStream("sampleFiles.zip")
        );
        ZipEntry entry;
        while ((entry = zip.getNextEntry()) != null) {
            if (entry.getName().equals(fileName)) {
                return zip;
            }
        }
        throw new IOException("Файл " + fileName + " не найден в sampleFiles.zip");
    }

    @Test
    @DisplayName("Проверка файла csv")
    public void csvFileParsingTest() throws IOException, CsvException {
        try (InputStream inputStream = zipInputStream(scvFile)) {
            CSVReader csvReader = new CSVReader(new InputStreamReader(inputStream));
            List<String[]> data = csvReader.readAll();
            Assertions.assertArrayEquals(new String[]{"1", "1", "1st"},
                    data.get(1));
        }
    }

    @Test
    @DisplayName("Проверка файла xls")
    public void xlsFileParsingTest() throws IOException {
        try (InputStream inputStream = zipInputStream(xlsFile)) {
            XLS xls = new XLS(inputStream);
            String actualValues = xls.excel.getSheetAt(0).getRow(1).getCell(4).getStringCellValue();
            Assertions.assertTrue(actualValues.contains("United States"));
        }
    }

    @Test
    @DisplayName("Проверка файла pdf")
    public void pdfFileParsingTest() throws IOException {
        try (InputStream inputStream = zipInputStream(pdfFile)) {
            PDF pdf = new PDF(inputStream);
            assertThat(pdf,
                    containsText("Sample PDF"));
        }
    }

    @Test
    @DisplayName("Проверка файла json")
    public void jsonFileParsingTest() throws Exception {
        try (InputStream inputStream = cl.getResourceAsStream("jsonFile.json")) {
            ObjectMapper objectMapper = new ObjectMapper();
            UserObject user = objectMapper.readValue(inputStream, UserObject.class);
            Assertions.assertEquals("Антон", user.getFirstname());
            Assertions.assertEquals("Лавей", user.getLastname());
            Assertions.assertEquals("worker", user.getRole());
            Assertions.assertEquals("tester262", user.getLogin());
        }
    }

}

