package records_objectmapper;

import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setEmpId(1);
        employee.setFirstName("Sahil");
        employee.setDesignation("Full Stack Developer");
        employee.setAddress(new Address("41","PHW", "Paderborn"));
        System.out.println(employee);

        EmpRecord empRecord = new EmpRecord(2, 30000.00, new Address("1", "PHW", "Bonn"), "UI UX");
        System.out.println(empRecord);

        // Convert Employee to EmpDTO if we don't want all fields e.g. in REST APIs
        List<Employee> employeeList = List.of(new Employee(), new Employee(), new Employee());
        List<EmpDTORecord> empDTORecordList = employeeList.stream()
                .map(emp -> new EmpDTORecord(emp.getEmpId(), emp.getFirstName()+emp.getLastName(), emp.getSalary()))
                .collect(Collectors.toList());
        //OR
        EmpDTOMapper empDTOMapper = new EmpDTOMapper();
        List<EmpDTORecord> empDTORecordList1 = employeeList.stream()
                .map(empDTOMapper)
                .collect(Collectors.toList());

        //using modelmapper in pom.xml, use MapStruct lib for faster, better performance than modelmapper
        ModelMapper modelMapper = new ModelMapper();
        Employee employee1 = new Employee();
        employee1.setEmpId(3);employee1.setFirstName("sahil");employee1.setLastName("abc");employee1.setSalary(30.00);
        EmpDTOModelMapper empDTOModelMapper = modelMapper.map(employee1, EmpDTOModelMapper.class);
        //EmpDTORecord empDTORecord = modelMapper.map(employee1, EmpDTORecord.class); //since name of fields doesn't match hence exception
        Employee employee2 = modelMapper.map(empDTOModelMapper, Employee.class); //vice versa
        System.out.println(empDTOModelMapper);
        //System.out.println(empDTORecord);
        System.out.println(employee2);

    }
}
