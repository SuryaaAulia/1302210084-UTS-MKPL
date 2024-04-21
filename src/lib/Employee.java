package lib;

import java.time.LocalDate;

public class Employee {

	private PersonalInfo employeeInfo;

	private int yearJoined;
	private int monthJoined;
	private int monthWorkingInYear;

	private int monthlySalary;
	private int otherMonthlyIncome;
	private int annualDeductible;

	public Employee(PersonalInfo employeeInfo, int yearJoined, int monthJoined) {
		this.employeeInfo = employeeInfo;
		this.yearJoined = yearJoined;
		this.monthJoined = monthJoined;
	}

	/**
	 * Fungsi untuk menentukan gaji bulanan pegawai berdasarkan grade kepegawaiannya
	 * (grade 1: 3.000.000 per bulan, grade 2: 5.000.000 per bulan, grade 3:
	 * 7.000.000 per bulan)
	 * Jika pegawai adalah warga negara asing gaji bulanan diperbesar sebanyak 50%
	 */

	public void setMonthlySalary(int grade) {
		if (grade == 1) {
			monthlySalary = 3000000;
		} else if (grade == 2) {
			monthlySalary = 5000000;
		} else if (grade == 3) {
			monthlySalary = 7000000;
		}
		if (employeeInfo.getIsForeigner()) {
			monthlySalary = (int) (monthlySalary * 1.5);
		}
	}

	public void setAnnualDeductible(int deductible) {
		this.annualDeductible = deductible;
	}

	public void setAdditionalIncome(int income) {
		this.otherMonthlyIncome = income;
	}

	public int getAnnualIncomeTax() {

		// Menghitung berapa lama pegawai bekerja dalam setahun ini, jika pegawai sudah
		// bekerja dari tahun sebelumnya maka otomatis dianggap 12 bulan.
		LocalDate date = LocalDate.now();

		if (date.getYear() == yearJoined) {
			monthWorkingInYear = date.getMonthValue() - monthJoined;
		} else {
			monthWorkingInYear = 12;
		}

		return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, monthWorkingInYear, annualDeductible,
				employeeInfo.getSpouseIdNumber().equals(""), employeeInfo.getChildIdNumbers().size());
	}
}
