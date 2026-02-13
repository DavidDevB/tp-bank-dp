package services;

import dao.OperationDao;
import java.sql.Date;
import models.Operation;

public class OperationService {

  public Operation createOperation(
    String type,
    double amount,
    int accountId,
    int operationNumber,
    Date operationDate
  ) throws Exception {
    return OperationDao.addOperation(
      type,
      amount,
      accountId,
      operationNumber,
      operationDate
    );
  }
}
