package com.dylanbannon.base.config;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

public class BoatReservationConfiguration extends Configuration {
  private boolean bindResources = true;
  private boolean bindFilters = true;
  private boolean bindExtras = true;

  @Valid
  @NotNull
  private DataSourceFactory dataSourceFactory = new DataSourceFactory();

  @JsonProperty("database")
  public DataSourceFactory getDataSourceFactory() {
    return dataSourceFactory;
  }

  @JsonProperty("database")
  public void setDataSourceFactory(DataSourceFactory dataSourceFactory) {
    this.dataSourceFactory = dataSourceFactory;
  }

  @JsonProperty("bindResources")
  public boolean bindResources() {
    return bindResources;
  }

  public void setBindResources(boolean bindResources) {
    this.bindResources = bindResources;
  }

  @JsonProperty("bindFilters")
  public boolean bindFilters() {
    return bindFilters;
  }

  public void setBindFilters(boolean bindFilters) {
    this.bindFilters = bindFilters;
  }

  @JsonProperty("bindExtras")
  public boolean bindExtras() {
    return bindExtras;
  }

  public void setBindExtras(boolean bindExtras) {
    this.bindExtras = bindExtras;
  }
}
