package com.evarion.gui.actionButtonListeners;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ActionDownloadFromExcel {
    public static void main(String[] args) {
        String excelFilePath = "C://test/test.xlsx"; // Укажите путь к файлу

        try (FileInputStream file = new FileInputStream(new File(excelFilePath))) {

            // Создаем экземпляр Workbook для работы с файлом Excel
            Workbook workbook = new XSSFWorkbook(file);

            // Получаем первый лист
            Sheet sheet = workbook.getSheetAt(0);

            // Проходим по строкам и ячейкам
            for (Row row : sheet) {
                for (Cell cell : row) {
                    // Выводим данные в консоль в зависимости от типа ячейки
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t");
                            break;
                        case BOOLEAN:
                            System.out.print(cell.getBooleanCellValue() + "\t");
                            break;
                        default:
                            System.out.print("Unknown Type\t");
                            break;
                    }
                }
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



