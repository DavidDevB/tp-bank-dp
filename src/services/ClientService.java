package services;

import dao.ClientDao;
import java.sql.Date;
import models.Client;
import utils.DBConnection;

public class ClientService {

  public Client createClient(
    String firstName,
    String lastName,
    Date birthDate,
    String email,
    String address
  ) throws Exception {
    ClientDao clientDao = new ClientDao(DBConnection.getConnection());
    clientDao.addClient(firstName, lastName, birthDate, email, address);
    return null;
  }

  public String getClientName(String email) throws Exception {
    ClientDao clientDao = new ClientDao(DBConnection.getConnection());
    return clientDao.getClientName(email);
  }

  public void updateClient(
    String email,
    String newFirstName,
    String newLastName,
    Date newBirthDate,
    String newAddress
  ) throws Exception {
    ClientDao clientDao = new ClientDao(DBConnection.getConnection());
    clientDao.updateClient(
      email,
      newFirstName,
      newLastName,
      newBirthDate,
      newAddress
    );
  }
}
