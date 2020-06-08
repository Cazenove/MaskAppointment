package com.mask.backend.service;

import com.mask.backend.pojo.Appointment;
import com.mask.backend.pojo.Draw;
import com.mask.backend.resource.AppointmentStartResource;

import java.util.List;

/**
 * @author SilverBay
 */
public interface AdminService {

    boolean lastAppointmentOpening();

    boolean isAppointmentOpening(int id);

    int startAppointment(AppointmentStartResource resource);

    int endAppointment();

    List<Draw> listDraw(int id);

    List<Draw> listAllDraw();

    Appointment getAppointment(int id);

    List<Appointment> listAppointment();

}
