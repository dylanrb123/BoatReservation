package com.dylanbannon.application;

import com.dylanbannon.base.config.BoatReservationConfiguration;
import com.dylanbannon.service.config.BoatReservationServiceModule;
import com.hubspot.dropwizard.guicier.GuiceBundle;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class BoatReservationApplication extends Application<BoatReservationConfiguration> {

  public static void main(String... args) throws Exception {
    new BoatReservationApplication().run(args);
  }

  @Override
  public void initialize(Bootstrap<BoatReservationConfiguration> bootstrap) {
    GuiceBundle<BoatReservationConfiguration> guiceBundle = GuiceBundle.defaultBuilder(BoatReservationConfiguration.class)
        .modules(new BoatReservationServiceModule())
        .build();

    bootstrap.addBundle(guiceBundle);
  }

  @Override
  public void run(BoatReservationConfiguration configuration, Environment environment) throws Exception {
  }
}
