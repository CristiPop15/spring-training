package eu.accesa.springtraining.db;

import eu.accesa.springtraining.model.Price;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

public interface PriceMapper {

  @Insert("INSERT INTO price ( outletId, productId, salesprice, lastupdate, validfrom, currency) " +
      "VALUES (#{price.outletId}, #{price.productId}, #{price.salesPrice}, #{price.lastUpdate}, #{price.validfrom}, #{price.currency})")
  void insertPrice(@Param("price") Price price);

  @Select("SELECT * from price")
  @Options(fetchSize = 1)
  List<Price> getAll();

  @Select("SELECT * from price")
  @ResultType(Price.class)
  void select(PriceHandler priceHandler);
}
