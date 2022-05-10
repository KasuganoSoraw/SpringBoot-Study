package admin.mapper;

import admin.bean.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author WPZ
 * @Date 2022/5/6 10:37
 * @Version 1.0
 */
@Mapper
public interface CityMapper {

    @Select("select * from city where id=#{id}")
    public City getById(Long id);

    public void insert(City city);
}
