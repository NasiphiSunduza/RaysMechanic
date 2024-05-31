package za.ac.cput.Service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Employee;

import java.util.List;
@Service
public interface IEmployeeService extends IService <Employee, Long>{
    List<Employee> getAll();

}
