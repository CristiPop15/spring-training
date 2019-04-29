package eu.accesa.springtraining.model;


import java.util.Date;

public class Price {

  private long id;

  private Double salesPrice;

  private Integer productId;

  private int outletId;

  private Date lastUpdate;

  private Date validfrom;

  private String currency;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Double getSalesPrice() {
    return salesPrice;
  }

  public void setSalesPrice(Double salesPrice) {
    this.salesPrice = salesPrice;
  }

  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }

  public int getOutletId() {
    return outletId;
  }

  public void setOutletId(int outletId) {
    this.outletId = outletId;
  }

  public Date getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(Date lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

  public Date getValidfrom() {
    return validfrom;
  }

  public void setValidfrom(Date validfrom) {
    this.validfrom = validfrom;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  @Override
  public String toString() {
    return "Price{" +
        "id=" + id +
        ", salesPrice=" + salesPrice +
        ", productId=" + productId +
        ", outletId=" + outletId +
        ", lastUpdate=" + lastUpdate +
        ", validfrom=" + validfrom +
        ", currency='" + currency + '\'' +
        '}';
  }
}
