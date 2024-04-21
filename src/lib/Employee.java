package lib;

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

	public int getMonthlySalary() {
		return this.monthlySalary;
	}

	public void setAnnualDeductible(int deductible) {
		this.annualDeductible = deductible;
	}

	public int getAnnualDeductible() {
		return this.annualDeductible;
	}

	public void setAdditionalIncome(int income) {
		this.otherMonthlyIncome = income;
	}

	public int getAdditionalIncome() {
		return this.otherMonthlyIncome;
	}

	public PersonalInfo getPersonalInfo() {
		return this.employeeInfo;
	}

	public int getMonthJoined() {
		return monthJoined;
	}

	public int getYearJoined() {
		return yearJoined;
	}

	public void setWorkingInYear(int monthWorkingInYear) {
		this.monthWorkingInYear = monthWorkingInYear;
	}
}
