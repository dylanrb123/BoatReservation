package com.dylanbannon.service.config;

import com.dylanbannon.base.config.BoatReservationConfiguration;
import com.dylanbannon.data.config.BoatReservationDataModule;
import com.dylanbannon.service.resources.BoatReservationResource;
import com.google.inject.Binder;
import com.hubspot.dropwizard.guicier.DropwizardAwareModule;

public class BoatReservationServiceModule extends DropwizardAwareModule<BoatReservationConfiguration> {
  @Override
  public void configure(Binder binder) {
    //TODO not sure why the BoatReservationConfiguration is null in the data module, fix this
    binder.install(new BoatReservationDataModule(getConfiguration().getDataSourceFactory()));

    binder.bind(BoatReservationResource.class);
  }
}
