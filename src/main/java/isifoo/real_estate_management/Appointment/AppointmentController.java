package isifoo.real_estate_management.Appointment;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/appointment")
@AllArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    @GetMapping("/all")
    public List<Appointment> getAppointments() {
        return appointmentService.getAppointments();
    }

    @GetMapping(value = "/get-client/{id}")
    public Appointment getAppointment(@PathVariable String id) {
        return appointmentService.getAppointment(id);
    }

    @PostMapping(value = "/add")
    public String addAppointment(@RequestBody Appointment appointment) {
        appointmentService.addAppointment(appointment);
        return "Appointment created successfully";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteAppointment(@PathVariable String id) {
        appointmentService.deleteAppointment(id);
        return "Appointment deleted successfully";
    }
}
