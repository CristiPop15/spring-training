package eu.accesa.springtraining.db;

import eu.accesa.springtraining.model.Price;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PriceHandler implements ResultHandler<Price> {

  private Logger log = LoggerFactory.getLogger(PriceHandler.class);

  @Override
  public void handleResult(ResultContext<? extends Price> resultContext) {
    log.info(String.valueOf(resultContext.getResultObject()));
  }
}
