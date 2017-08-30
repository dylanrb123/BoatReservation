package com.dylanbannon.data.config;

import org.skife.jdbi.v2.DBI;

import com.codahale.metrics.MetricRegistry;
import com.dylanbannon.base.config.BoatReservationConfiguration;
import com.dylanbannon.data.daos.BoatReservationDao;
import com.dylanbannon.data.managers.BoatReservationManager;
import com.google.inject.Binder;
import com.google.inject.Inject;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import com.google.inject.Singleton;
import com.hubspot.dropwizard.guicier.DropwizardAwareModule;

import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.db.ManagedDataSource;
import io.dropwizard.setup.Environment;

public class BoatReservationDataModule extends DropwizardAwareModule<BoatReservationConfiguration> {
  private DataSourceFactory dataSourceFactory;

  @Inject
  public BoatReservationDataModule(DataSourceFactory dataSourceFactory) {
    this.dataSourceFactory = dataSourceFactory;
  }

  @Override
  public void configure(Binder binder) {
    binder.bind(DBI.class).toProvider(DBIProvider.class).in(Scopes.SINGLETON);

    binder.bind(BoatReservationManager.class);
    bindDao(binder, BoatReservationDao.class);
  }

  private static <T> void bindDao(Binder binder, Class<T> klass) {
    binder.bind(klass).toProvider(new DaoProvider<T>(klass)).in(Scopes.SINGLETON);
  }

  @Provides
  @Singleton
  public DataSourceFactory providesDataSourceFactory() {
    return dataSourceFactory;
  }

  @Provides
  @Singleton
  public MetricRegistry provideRegistry(Environment environment) {
    return environment.metrics();
  }

  @Provides
  @Singleton
  public ManagedDataSource providesManagedDataSource(MetricRegistry metricRegistry) {
    return dataSourceFactory.build(metricRegistry, "budgie");
  }
}
