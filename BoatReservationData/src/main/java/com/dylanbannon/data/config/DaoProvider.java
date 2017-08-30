package com.dylanbannon.data.config;

import org.skife.jdbi.v2.DBI;

import com.google.common.base.Optional;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class DaoProvider<T> implements Provider<T> {
  private final Class<T> type;
  private Optional<DBI> dbi;

  public DaoProvider(Class<T> type) {
    this.type = type;
    this.dbi = Optional.absent();
  }

  @Inject
  public void setDBI(DBI dbi) {
    this.dbi = Optional.of(dbi);
  }

  public T get() {
    return dbi.get().onDemand(type);
  }
}
