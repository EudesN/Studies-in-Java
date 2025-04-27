package banco;

import java.text.ParseException;
import java.util.Date;
import java.util.GregorianCalendar;

public class UsoDeDatas {

	public static void main(String[] args) throws ParseException, InterruptedException {
		Date d = new Date();
		System.out.println(d);
		
		int dia = d.getDate();
		int mes = d.getMonth() + 1;
		int ano = d.getYear() + 1900;
		
		System.out.println("Dia: " + dia + " Mes: " + mes + " Ano: " + ano);
		
		Long dataLong = d.getTime();
		
//		System.out.println("GetTime: " + dataLong);
//		
//
//		dataLong = dataLong + 1000000;
//		Date outraData = new Date(dataLong);
//		System.out.println(outraData);

		GregorianCalendar gc = new GregorianCalendar();
		System.out.println(gc);
		gc.set(1974, 10, 14);
		System.out.println(gc);
		long nasc = gc.getTimeInMillis();
		System.out.println(nasc);
//
//	     Date hoje = new Date();
//		 System.out.println(d); 
//		 int dia1 = d.getDate();
//		 int mes1 = d.getMonth();
//		 int ano1 = d.getYear();
//		 int hora = d.getHours();
//		 int minuto = d.getMinutes();
//		 int segundo = d.getSeconds();
//		 System.out.println(dia1);
//		 System.out.println(mes1);
//		 System.out.println(ano1);
//		 
//		 System.out.println(hora);
//		 System.out.println(minuto);
//		 System.out.println(segundo);
//		 
		 GregorianCalendar gc2 = new GregorianCalendar();
		 int d1 = gc2.get(gc.DAY_OF_MONTH);
		 int m1 = gc2.get(gc.MONTH);
		 int a1 = gc2.get(gc.YEAR);
		 int xx = gc2.get(gc.DAY_OF_YEAR);
		 
		 System.out.println("GC2 after Gc?: " + gc2.after(gc));
		 System.out.println("GC2 after Gc?: " + gc2.before(gc));
		 
		 System.out.println(xx);
//
//		 System.out.println("Data via calendario gregoriano");
		//
//		 System.out.println(d1 + "/" + m1 + "/" + a1);
	}
}
