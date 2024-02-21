package records_objectmapper;

/*
* 1. All fields are private, static, final
* 2. No default constructor, only all parameterised constructor which we can override but no custom constructor with few fields
* 3. Only getter methods & no setter methods
* 4. Getter methods have direct names e.g. empId, salary & not getEmpId, getSalary
* 5. You can override toSting, hascode, equals method but we get them by default
* 6. You can create functions inside static & non-static
* 7. Cannot create non-static fields
* 8. Cannot extend another class, since all records implicitly extends Record class & java doesn't support multiple inheritance
* 9. Cannot be extended to another class as they are final
* 10. Can implements Interface
*
* */
public record EmpRecord(Integer empId, Double salary, Address address, String designation) {

    private static final String customField = "Emp Id";

    //private String abc = "";

    public Double doubleSalary(){
        return salary.doubleValue();
    }

    public static void printSomething(){
        System.out.println("Static method");
    }

}
