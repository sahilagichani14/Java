package records_objectmapper;

import java.util.function.Function;

public class EmpDTOMapper implements Function<Employee, EmpDTORecord> {
    @Override
    public EmpDTORecord apply(Employee employee) {
        return new EmpDTORecord(
                employee.getEmpId(),
                employee.getFirstName()+employee.getLastName(),
                employee.getSalary()
        );
    }
}
