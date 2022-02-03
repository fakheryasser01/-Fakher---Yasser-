package data;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ExcelFileManager {

    private File spreadsheet;
    private Sheet currentSheet;
    private Map<String, Integer> columns;

    public ExcelFileManager(File file) {
	spreadsheet = file;
	columns = new HashMap<String, Integer>();
    }

    public void switchToSheet(String name) {
	try (Workbook workbooks = WorkbookFactory.create(spreadsheet)) {
	    currentSheet = workbooks.getSheet(name);
	    currentSheet.getRow(0).forEach(cell -> {
		columns.put(cell.getStringCellValue(), cell.getColumnIndex());
	    });
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public String getCellData(String column, int row) {
	Row dataRow = currentSheet.getRow(row - 1);
	return getCellDataAsString(dataRow.getCell(columns.get(column)));
    }

    private String getCellDataAsString(Cell cell) {
		String value = null;
	 switch (cell.getCellType())
			{
		case   STRING :value = cell.getStringCellValue();
		break;
		case NUMERIC : value = String.valueOf((int) cell.getNumericCellValue());
		break;
	}
		return value ;
    }
}