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
    public boolean addDoctor(Doctor doctor) {
        String query = """
                CREATE (d:Doctor)
                SET d.doctor_id = $doctor_id, d.name = $name, d.phone = $phone, d.speciality = $speciality
                """;
        Map<String, Object> params = Map.of(
            "doctor_id", doctor.getId(),
                "name", doctor.getName(),
                "phone", doctor.getPhone(),
                "speciality", doctor.getSpeciality()
        );
        try (Session session = AppUtils.getSession()) {
            return session.executeWrite(tx -> {
                ResultSummary resultSummary = tx.run(query, params).consume();
                return resultSummary.counters().nodesCreated() > 0;
            });

        }
    }
    public Map<String, Long> getNoOfDoctorsBySpeciality(String departmentName) {
        String query = """
                MATCH (d:Doctor)-[r:BELONG_TO]->(p:Department)
                WHERE p.name = $depName
                RETURN d.speciality as speciality, count(d) AS total
                """;
        Map<String, Object> params = Map.of(
            "depName", departmentName
        );
        try (Session session = AppUtils.getSession()) {
            return session.executeRead(tx -> {
                Result result = tx.run(query, params);
                 return result.stream().collect(Collectors.toMap(
                         r -> r.get("speciality").asString(),
                         r -> r.get("total").asLong()
                 ));
            });

        }
    }
    public Doctor findDoctorById(String doc_id) {
        String query = """
                MATCH (n:Doctor)
                WHERE n.doctor_id = $doc_id
                RETURN n
                """;
        Map<String, Object> params = Map.of(
            "doc_id", doc_id
        );
        try (Session session = AppUtils.getSession()) {
            return session.executeRead(tx -> {
                Result result = tx.run(query, params);
                if (result.hasNext()) {
                    Node node = result.next().get("n").asNode();
                    Doctor doctor = new Doctor();
                    doctor.setId(node.get("doctor_id").asString());
                    doctor.setName(node.get("name").asString());
                    doctor.setPhone(node.get("phone").asString());
                    doctor.setSpeciality(node.get("speciality").asString());
                    return doctor;
                }
                return null;
            });

        }
    }
// CREATE FULLTEXT INDEX specialityFTI FOR (d:Doctor) ON EACH [d.speciality]
    public List<Doctor> listDoctorBySpeciality(String keyword) {
        String query = """
                CALL db.index.fulltext.queryNodes('specialityFTI', $keyword) YIELD node
                RETURN node
                """;
        Map<String, Object> params = Map.of(
            "keyword", keyword
        );
        try (Session session = AppUtils.getSession()) {
            return session.executeRead( tx -> {
                Result result = tx.run(query, params);
                return result.stream().map(
                        record -> {
                            Node node = record.get("node").asNode();
                            return Doctor.builder()
                                    .id(node.get("doctor_id").asString())
                                    .name(node.get("name").asString())
                                    .phone(node.get("phone").asString())
                                    .speciality(node.get("speciality").asString())
                                    .build();
                        }
                ).collect(Collectors.toList());

        });

        }
    }
//MATCH p=()-[r:BE_TREATED]->()
//WHERE id(r) = 1152923703630102577
//REMOVE r.endDate
    public boolean updateDiagnosis(String pat_id, String doc_id, String newDiagnosis) {
        String query = """
                MATCH (p:Patient)-[r:BE_TREATED]->(d:Doctor)
                WHERE p.patient_id = $pat_id and d.doctor_id = $doc_id AND r.endDate IS NULL
                SET r.diagnosis = $newDiagnosis
                """;
        Map<String, Object> params = Map.of(
                "pat_id", pat_id,
                "doc_id", doc_id,
                "newDiagnosis", newDiagnosis
        );
        try (Session session = AppUtils.getSession()) {
            return session.executeWrite(tx -> {
                ResultSummary resultSummary = tx.run(query, params).consume();
                return resultSummary.counters().propertiesSet() > 0;
        });

        }
    }



}


