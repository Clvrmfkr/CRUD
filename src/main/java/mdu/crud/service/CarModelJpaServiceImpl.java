package mdu.crud.service;

import mdu.crud.dao.CarModelDAO;
import mdu.crud.model.CarModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service("carModelJpaService")
@Transactional(readOnly=false, value = "jpaTransactionManager")
public class CarModelJpaServiceImpl implements CarModelService {
    @Autowired
    @Qualifier("getCarModelJpaDAO")
    private CarModelDAO carModelDAO;

    public void saveOrUpdate(CarModel item) {
        carModelDAO.saveOrUpdate(item);
    }

    public void delete(int itemId) {
        carModelDAO.delete(itemId);
    }

    public CarModel get(int itemId) {
        return carModelDAO.get(itemId);
    }

    public List<CarModel> list() {
        return carModelDAO.list();
    }
}