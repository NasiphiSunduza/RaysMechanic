package za.ac.cput.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Employee;
import za.ac.cput.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService{

    @Autowired
    private EmployeeRepository repo;



    @Override
    public Employee create(Employee obj) {
        return repo.save(obj);
    }

    @Override
    public Employee read(Long l) {
        return repo.findById(l).orElse(null);
    }

    @Override
    public Employee update(Employee obj) {
        return repo.save(obj);
    }

    @Override
    public List<Employee> getAll() {
        return repo.findAll();
    }
}
