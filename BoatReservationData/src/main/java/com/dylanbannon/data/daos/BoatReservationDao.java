package com.dylanbannon.data.daos;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface BoatReservationDao {

  @SqlUpdate("INSERT INTO example (name) VALUES (:name)")
  void insert(@Bind("name") String name);

  @SqlQuery("SELECT name FROM example")
  List<String> getAll();
}
