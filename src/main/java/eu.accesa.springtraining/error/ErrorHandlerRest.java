package eu.accesa.springtraining.error;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatus.Series;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

public class ErrorHandlerRest implements ResponseErrorHandler {

  private static Logger log = LoggerFactory.getLogger(ErrorHandlerRest.class);

  @Override
  public boolean hasError(ClientHttpResponse response) throws IOException {
    HttpStatus.Series series = response.getStatusCode().series();
    return (Series.CLIENT_ERROR.equals(series)) || Series.SERVER_ERROR.equals(series);
  }

  @Override
  public void handleError(ClientHttpResponse response) throws IOException {
    log.error("Response error {} {}", response.getStatusCode(), response.getStatusText());
  }
}
