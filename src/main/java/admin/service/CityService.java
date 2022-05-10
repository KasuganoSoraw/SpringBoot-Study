package admin.service;

import admin.bean.City;
import admin.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author WPZ
 * @Date 2022/5/6 10:40
 * @Version 1.0
 */
@Service
public class CityService {

    @Autowired
    CityMapper cityMapper;

    public City getById(Long id) {
        return cityMapper.getById(id);
    }

    public void saveCity(City city) {
        cityMapper.insert(city);
    }
}
