package za.ac.cput.Service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Manager;

import java.util.List;
@Service
public interface IManagerService extends IService<Manager, Long> {
    List<Manager> getAll();
}
