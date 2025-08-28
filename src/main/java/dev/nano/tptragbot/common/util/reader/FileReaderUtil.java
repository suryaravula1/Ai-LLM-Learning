// This class provides utility methods for reading and parsing different file types in OnboardEase
package dev.nano.tptragbot.common.util.reader;

import org.apache.commons.csv.CSVParser;
import org.springframework.core.io.Resource;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class FileReaderUtil {

    // Reads the contents of a CSV file and returns it as a String for embedding
    public static String readCsvFile(Resource resource) {
        StringBuilder content = new StringBuilder();

        try (Reader reader = new InputStreamReader(resource.getInputStream());
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {

            for (CSVRecord record : csvParser) {
                String recordText = String.join(" ", record);
                content.append(recordText).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read CSV file", e);
        }

        return content.toString();
    }

    /*public static String readExcelFile(Resource resource) {
        StringBuilder content = new StringBuilder();

        try (InputStream is = resource.getInputStream();
             Workbook workbook = new XSSFWorkbook(is)) {

            for (Sheet sheet : workbook) {
                for (Row row : sheet) {
                    for (Cell cell : row) {
                        String text = getCellText(cell);
                        content.append(text).append(" ");
                    }
                    content.append("\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read Excel file", e);
        }

        return content.toString();
    }*/
}
