package isifoo.real_estate_management.Appointment;

import com.mongodb.MongoException;
import isifoo.real_estate_management.utils.RegexParser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Service
public class AppointmentService {

    private final AppointmentRepository AppointmentRepository;

    public List<Appointment> getAppointments() {
        try {
            return AppointmentRepository.findAll();
        } catch (MongoException e) {
            throw new RuntimeException("Failed to get Appointment", e);
        }
    }

    public Appointment getAppointment(String id) {
        try {
            return AppointmentRepository.findById(id);
        } catch (MongoException e) {
            throw new RuntimeException("Failed to get Appointment", e);
        }
    }

    public void addAppointment(Appointment appointment) {
        try {
            AppointmentRepository.insert(appointment);
        } catch (MongoException e) {
            throw new RuntimeException("Failed to insert Appointment", e);
        }
    }

    public void deleteAppointment(String id) {
        try {
            AppointmentRepository.deleteById(id);
        } catch (MongoException e) {
            throw new RuntimeException("Failed to delete Appointment", e);
        }
    }
}
