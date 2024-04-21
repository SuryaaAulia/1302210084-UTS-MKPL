package lib;

import java.time.LocalDate;

public class TaxFunction {

	/**
	 * Fungsi untuk menghitung jumlah pajak penghasilan pegawai yang harus
	 * dibayarkan setahun.
	 * 
	 * Pajak dihitung sebagai 5% dari penghasilan bersih tahunan (gaji dan pemasukan
	 * bulanan lainnya dikalikan jumlah bulan bekerja dikurangi pemotongan)
	 * dikurangi penghasilan tidak kena pajak.
	 * 
	 * Jika pegawai belum menikah dan belum punya anak maka penghasilan tidak kena
	 * pajaknya adalah Rp 54.000.000.
	 * Jika pegawai sudah menikah maka penghasilan tidak kena pajaknya ditambah
	 * sebesar Rp 4.500.000.
	 * Jika pegawai sudah memiliki anak maka penghasilan tidak kena pajaknya
	 * ditambah sebesar Rp 4.500.000 per anak sampai anak ketiga.
	 * int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int
	 * deductible, boolean isMarried, int numberOfChildren
	 */
	public int getAnnualIncomeTax(Employee employee) {
		int monthWorkingInYear = 0;
		// Menghitung berapa lama pegawai bekerja dalam setahun ini, jika pegawai sudah
		// bekerja dari tahun sebelumnya maka otomatis dianggap 12 bulan.
		LocalDate date = LocalDate.now();

		if (date.getYear() == employee.getYearJoined()) {
			monthWorkingInYear = date.getMonthValue() - employee.getMonthJoined();
		} else {
			monthWorkingInYear = 12;
		}
		employee.setWorkingInYear(monthWorkingInYear);
		return TaxFunction.calculateTax(employee);
	}

	public static int calculateTax(Employee employee) {

		int tax = 0;
		int numberOfChildren = 0;

		if (employee.getMonthlySalary() > 12) {
			System.err.println("More than 12 month working per year");
		}

		if (employee.getPersonalInfo().getChildIdNumbers().size() > 3) {
			numberOfChildren = 3;
		}

		if (employee.getPersonalInfo().getSpouseIdNumber() != null) {
			tax = (int) Math.round(
					0.05 * (((employee.getMonthlySalary() + employee.getAdditionalIncome()) * employee.getMonthJoined())
							- employee.getAnnualDeductible()
							- (54000000 + 4500000 + (numberOfChildren * 1500000))));
		} else {
			tax = (int) Math.round(
					0.05 * (((employee.getMonthlySalary() + employee.getAdditionalIncome()) * employee.getMonthJoined())
							- employee.getAnnualDeductible() - 54000000));
		}

		if (tax < 0) {
			return 0;
		} else {
			return tax;
		}

	}
}
