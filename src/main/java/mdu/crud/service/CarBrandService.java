package mdu.crud.service;

import mdu.crud.model.CarBrand;
import java.util.List;

public interface CarBrandService {

    void saveOrUpdate(CarBrand item);

    void delete(int itemId);

    CarBrand get(int itemId);

    List<CarBrand> list();
}