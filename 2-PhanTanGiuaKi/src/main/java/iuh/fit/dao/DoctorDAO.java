package iuh.fit.dao;

import iuh.fit.model.Doctor;
import iuh.fit.util.AppUtils;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.summary.ResultSummary;
import org.neo4j.driver.types.Node;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DoctorDAO {
    public Doctor findDoctoyById(String doctorID) {
        String query = """
                MATCH (n:Doctor)
                WHERE n.doctor_id = $doctorID
                RETURN n
                """;

        Map<String, Object> params = Map.of(
                "doctorID", doctorID
        );

        try(Session session = AppUtils.getSession()) {
            return session.executeRead(tx -> {
                Result result = tx.run(query, params);
                if (result.hasNext()){
                    Node node = result.next().get("n").asNode();
                    return Doctor.builder()
                            .doctorId(node.get("doctor_id").asString())
                            .name(node.get("name").asString())
                            .phone(node.get("phone").asString())
                            .speciality(node.get("speciality").asString())
                            .departmentId((node.get("dept_id").asString()))
                            .build();
                }
                return null;
            });
        }
    }
    public Map<String, Long> getNoOfDoctorsBySpeciality (String departmentName) {
        String query = """
                MATCH (d:Doctor)-[r:BELONG_TO]->(n:Department)
                WHERE n.name = $departmentName
                RETURN d.speciality AS speciality, count(d) as total
                """;

        Map<String, Object> params = Map.of(
                "departmentName", departmentName
        );

        try(Session session = AppUtils.getSession()) {
            return session.executeRead(tx -> {
                Result result = tx.run(query, params);

                return result.stream().collect(Collectors.toMap(
                        record -> record.get("speciality").asString(),
                        record -> record.get("total").asLong()
                ));
            });
        }
    }
    public boolean addDoctor(Doctor doctor){
        String query = """
                CREATE (d:Doctor)
                SET d.doctor_id = $doctor_id, d.name = $name,
                d.phone = $phone, d.speciality = $speciality
                RETURN d
                """;
        Map<String, Object> params = Map.of(
                "doctor_id", doctor.getDoctorId(),
                "name", doctor.getName(),
                "phone", doctor.getPhone(),
                "speciality", doctor.getSpeciality()
        );
        try(Session session = AppUtils.getSession()) {
            return session.executeWrite(tx -> {
                ResultSummary resultSummary = tx.run(query, params).consume();

                return resultSummary.counters().nodesCreated() > 0;
            });

        }
    }
    //CREATE FULLTEXT INDEX specialityFTI FOR (d:Doctor) ON EACH [d.speciality]
    public List<Doctor> listDoctorsBySpeciality (String keyword) {
        String query = """
                CALL db.index.fulltext.queryNodes('specialityFTI', $keyword) YIELD node
                RETURN node
                """;
        Map<String, Object> params = Map.of(
            "keyword", keyword
        );
        try (Session session = AppUtils.getSession()){
            return session.executeRead(tx -> {
                Result result = tx.run(query, params);
                return result
                        .stream()
                        .map(record -> {
                            Node node = record.get("node").asNode();
                            return Doctor.builder()
                                    .doctorId(node.get("doctor_id").asString())
                                    .name((node.get("name").asString()))
                                    .phone(node.get("phone").asString())
                                    .speciality(node.get("speciality").asString())
                                    .build();
                        })
                        .toList();
            });

        }
    }
    public boolean updateDiagnosis(String patientID, String doctorID, String newDiagnosis) {
        String query = """
                MATCH (p:Patient)-[r:BE_TREATED]->(d:Doctor)
                WHERE p.patient_id = $patientID AND d.doctor_id = $doctorID AND r.endDate IS NULL
                SET r.diagnosis = $newDiagnosis
                """;
        Map<String, Object> params = Map.of(
                "patientID", patientID,
                "doctorID", doctorID,
                "newDiagnosis", newDiagnosis
        );
        try (Session session = AppUtils.getSession()) {
            return session.executeWrite((tx -> {
               ResultSummary resultSummary = tx.run(query, params).consume();

               return  resultSummary.counters().propertiesSet() > 0;
            }));

        }
    }

    //Internal CNTT
}
