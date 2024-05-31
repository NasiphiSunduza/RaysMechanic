package za.ac.cput.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Manager;
import za.ac.cput.repository.ManagerRepository;

import java.util.List;
@Service
public class ManagerService implements IManagerService{

    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public Manager create(Manager obj) {
        return managerRepository.save(obj);
    }

    @Override
    public Manager read(Long aLong) {
        return managerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Manager update(Manager obj) {
        return managerRepository.save(obj);
    }
    @Override
    public List<Manager> getAll() {
        return managerRepository.findAll();
    }

    public  List<Manager>  findAllEmployeeByDepartment(String department){

        return managerRepository.findManagerByDepartment(department);
    }



}
