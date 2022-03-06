import java.util.ArrayList;
import java.util.List;

public class CellInARangeOnExcelSheet {
    public List<String> cellsInRange(String s) {
        int rowStart = s.charAt(1) - '0';
        int rowEnd = s.charAt(4) - '0';
        char colStart = s.charAt(0);
        char colEnd = s.charAt(3);
        List<String> str = new ArrayList<>();
        for (char ch = colStart; ch <= colEnd; ch++) {
            for (int i = rowStart; i <= rowEnd; i++) {
                str.add(String.valueOf(ch) + String.valueOf(i));
            }
        }
        return str;
    }
}
