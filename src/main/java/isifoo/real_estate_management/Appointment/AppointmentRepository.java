package isifoo.real_estate_management.Appointment;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends MongoRepository<Appointment, Long> {
    Appointment findById(String id);
    void deleteById(String id);
}
