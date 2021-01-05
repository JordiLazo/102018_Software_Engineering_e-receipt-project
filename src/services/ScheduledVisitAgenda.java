package services;

import data.HealthCardID;
import exceptions.HealthCardException;

public interface ScheduledVisitAgenda {
    HealthCardID getHealthCardID() throws HealthCardException;
}
