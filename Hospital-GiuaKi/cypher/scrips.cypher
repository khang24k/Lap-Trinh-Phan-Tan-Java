LOAD CSV WITH HEADERS FROM 'file:///hospital/departments.csv' AS row
WITH row WHERE row.id IS NOT NULL
CREATE (d:Department)
SET d.dept_id = row.id, d.name = row.name, d.location = row.location;

LOAD CSV WITH HEADERS FROM 'file:///hospital/doctors.csv' AS row
WITH row WHERE row.ID IS NOT NULL
CREATE (d:Doctor)
SET d.doctor_id = row.ID, d.name = row.Name,
d.phone = row.Phone, d.speciality = row.Speciality,
d.dept_id = row.DepartmentID;

LOAD CSV WITH HEADERS FROM 'file:///hospital/patients.csv' AS row
WITH row WHERE row.ID IS NOT NULL
CREATE (d:Patient)
SET d.patient_id = row.ID, d.name = row.Name,
d.phone = row.Phone, d.gender = row.Gender,
d.dateOfBirth = row.DateOfBirth, d.address = row.Address;

MATCH (d:Doctor), (p:Department)
  WHERE d.dept_id = p.dept_id
MERGE (d)-[r:BELONG_TO]->(p);

LOAD CSV WITH HEADERS FROM 'file:///hospital/treatments.csv' AS row
MATCH (d:Doctor), (p:Patient)
  WHERE row.DoctorID = d.doctor_id AND row.PatientID = p.patient_id
MERGE (d)<-[r:BE_TREATED]-(p)
SET r.startDate = row.StartDate,
r.endDate = row.EndDate,
r.diagnosis = row.Diagnosis;

CREATE CONSTRAINT dep_id
FOR (d:Department) REQUIRE d.dept_id IS UNIQUE;

CREATE CONSTRAINT doc_id
FOR (d:Doctor) REQUIRE d.doctor_id IS UNIQUE;

CREATE CONSTRAINT pat_id
FOR (d:Patient) REQUIRE d.patient_id IS UNIQUE;