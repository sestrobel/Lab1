import java.util.Scanner;
import java.text.DecimalFormat;

public class RetirementCalculator {

	public static void main (String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("How many years will you work?");
		double yearstowork = s.nextDouble();
		
		System.out.println("What will be the percent annual return while working?");
		double annualreturnpre = s.nextDouble();
		
		System.out.println("How many years will you be retired?");
		double yearsretired = s.nextDouble();
		
		System.out.println("What will be the percent annual return after retirement?");
		double annualreturnpost = s.nextDouble();
		
		System.out.println("What is your required monthly income after retirement?");
		double requiredincome = s.nextDouble();
		
		System.out.println("What will your monthly SSI be?");
		double ssi = s.nextDouble();
		
		double monthlyreturnpost = annualreturnpost/1200;
		double monthlyreturnpre = annualreturnpre/1200;
		double monthlyAnnuityNeed = (requiredincome - ssi);
		
		double totalSaved = monthlyAnnuityNeed*((1-(java.lang.Math.pow((1+monthlyreturnpost),yearsretired*-12)))/monthlyreturnpost);
		double saveeachmonth = totalSaved*monthlyreturnpre/(java.lang.Math.pow((1+monthlyreturnpre),yearstowork*12)-1);
		
		DecimalFormat money = new DecimalFormat("$0.00");
		System.out.println("This is how much you have to save monthly: " + money.format(saveeachmonth));
		System.out.println("This is how much you have to save total: " + money.format(totalSaved));
		s.close();
	}
} 
