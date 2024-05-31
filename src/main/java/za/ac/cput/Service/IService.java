package za.ac.cput.Service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Employee;

import java.util.List;
@Service
public interface IService <Object, PKey> {

    Object create(Object obj);

    Object read(PKey pKey);

    Object update(Object obj);

   //boolean delete(PKey pKey);

}