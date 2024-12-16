Week-01 
---------------------------------------------------------------------------------------------
#Without Spring, you’d write code like this:
DoctorService doctorService = new DoctorService();
PatientService patientService = new PatientService(doctorService);
---------------------------------------------------------------------------------------------
#With Spring, you simply define these components, and Spring automatically connects them:
@Component
class DoctorService { ... }

@Component
class PatientService {
    @Autowired
    DoctorService doctorService;
}
---------------------------------------------------------------------------------------------
#Here’s how simple the API for booking an appointment could look with Spring Boot:
@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @PostMapping("/book")
    public String bookAppointment(@RequestBody Appointment appointment) {
        // Logic to save appointment in the database
        return "Appointment booked successfully!";
    }
}
---------------------------------------------------------------------------------------------
