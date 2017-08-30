package com.dylanbannon.data.config;

import org.skife.jdbi.v2.DBI;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.hubspot.rosetta.jdbi.RosettaMapperFactory;

import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.db.ManagedDataSource;
import io.dropwizard.jdbi.args.OptionalArgumentFactory;

public class DBIProvider implements Provider<DBI> {

  private DataSourceFactory dataSourceFactory;
  private ManagedDataSource managedDataSource;

  @Inject
  public DBIProvider(DataSourceFactory dataSourceFactory,
                     ManagedDataSource managedDataSource) {
    this.dataSourceFactory = dataSourceFactory;
    this.managedDataSource = managedDataSource;
  }

  public DBI get() {
    final DBI dbi = new DBI(managedDataSource);

    dbi.registerMapper(new RosettaMapperFactory());
    dbi.registerArgumentFactory(new OptionalArgumentFactory(dataSourceFactory.getDriverClass()));

    return dbi;
  }
}
