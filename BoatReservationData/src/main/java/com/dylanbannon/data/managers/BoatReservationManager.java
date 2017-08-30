package com.dylanbannon.data.managers;

import java.util.List;

import com.dylanbannon.data.daos.BoatReservationDao;
import com.google.inject.Inject;

public class BoatReservationManager {

  private final BoatReservationDao exampleDao;

  @Inject
  public BoatReservationManager(BoatReservationDao exampleDao) {
    this.exampleDao = exampleDao;
  }

  public void insert(String name) {
    exampleDao.insert(name);
  }

  public List<String> getAll() {
    return exampleDao.getAll();
  }
}
