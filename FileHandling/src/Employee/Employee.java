package Employee;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Employee implements Serializable {

	private int empNo;
	private String empName;
	private int empBasic;

	public Employee(int empNo, String empName, int empBasic) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.empBasic = empBasic;
	}

	@Override
	public String toString() {
		return "EmpNo = " + empNo + ", EmpName = " + empName + ", EmpBasic = " + empBasic;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getEmpBasic() {
		return empBasic;
	}

	public void setEmpBasic(int empBasic) {
		this.empBasic = empBasic;
	}

}
