package utilitarios;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Utils {
    static NumberFormat formandoValores = new DecimalFormat("R$ #,##0.00");

    public static String doubleToString(Double valor){
        return formandoValores.format(valor);
    }
}
