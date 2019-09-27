/*
 * Project Script
 * 
 */
print("STARTING SCRIPT");
//Host
conn = new Mongo("localhost");
//Nombre de la base de datos que vamos a utilizar
db = conn.getDB("ProjectDB");


/*Clean Database if already exists*/
db.dropDatabase();

/*Collection creation*/

db.createCollection("student");
db.createCollection("family");
db.createCollection("course");
db.createCollection("teacher")

print("***********creating students*********");

student1= {
 "_id" : ObjectId("5d7c0696e7ac942af83bef07"),
	"fullName" : "Alvaro Valdivia",
	"gender" : "Male",
	"birthdate" : ISODate("1992-09-16T05:00:00Z"),
	"typeDocument" : "DNI",
	"numberDocument" : "47856688"
	"idFamily" : "1",
}

student2= {
 "_id" : ObjectId("5d81247b19e5a726d811c93e"),
        "fullName" : "Juan Perez",
        "gender" : "male",
        "birthdate" : ISODate("1991-02-02T05:00:00Z"),
        "typeDocument" : "DNI",
        "numberDocument" : "84848444",
	"idFamily" : "2",
}


student3= {

	"_id" : "432dsffa22",
        "fullName" : "Andrea Vasquez",
        "gender" : "female",
        "birthdate" : ISODate("1991-03-22T00:00:00Z"),
        "typeDocument" : "DNI",
        "numberDocument" : "43434343",
	"idFamily" : "3",
}


print("***********creating family*********");

family1= {
	"fullname" : "John Perez",
	"gender" : "male",
	"birthdate" : ISODate("1990-02-23T00:00:00Z"), 
	"typeID" : "DNI",
	"numberDocument" : "47555444",
	"createdAt" : ISODate("2019-01-23T00:00:00Z"), 
	"idFamily" : "2",
}

family2= {
	"fullname" : "Leonardo Valdivia",
	"gender" : "male",
	"birthdate" : ISODate("1981-02-23T00:00:00Z"), 
	"typeID" : "DNI",
	"numberDocument" : "74584563",
	"createdAt" : ISODate("2019-01-22T00:00:00Z"), 
	"idFamily" : "1",
}

family3= {
	"fullname" : "Jose Vasquez",
	"gender" : "male",
	"birthdate" : ISODate("1960-02-23T00:00:00Z"), 
	"typeID" : "DNI",
	"numberDocument" : "78514232",
	"createdAt" : ISODate("2019-01-13T00:00:00Z"), 
	"idFamily" : "3",
}

family4= {
	"fullname" : "Martha Ruiz",
	"gender" : "female",
	"birthdate" : ISODate("1960-02-23T00:00:00Z"), 
	"typeID" : "DNI",
	"numberDocument" : "54526359",
	"createdAt" : ISODate("2019-01-13T00:00:00Z"), 
	"idFamily" : "4",
}

family5= {
	"fullname" : "Tony Mu�oz",
	"gender" : "male",
	"birthdate" : ISODate("1960-02-23T00:00:00Z"), 
	"typeID" : "DNI",
	"numberDocument" : "65132548",
	"createdAt" : ISODate("2019-01-13T00:00:00Z"), 
	"idFamily" : "5",
}

family6= {
	"fullname" : "Efrain Rubin",
	"gender" : "male",
	"birthdate" : ISODate("1991-07-13T00:00:00Z"), 
	"typeID" : "DNI",
	"numberDocument" : "75562451",
	"createdAt" : ISODate("2019-01-13T00:00:00Z"), 
	"idFamily" : "6",
}

print("***********creating course*********");

course1={
	"name" : "History",
	"status" : "open",
	"capmax" : "15",
	"capmin" : "2",
}

course2={
	"name" : "Match",
	"status" : "closed",
	"capmax" : "15",
	"capmin" : "2",
}

course3={
	"name" : "Spanish",
	"status" : "active",
	"capmax" : "15",
	"capmin" : "2",
}

course4={
	"name" : "French",
	"status" : "open",
	"capmax" : "15",
	"capmin" : "2",
}




print("***********creating teacher*********");

/* teacher */

teacher1= {
        "fullName" : "Elena Ruiz",
        "gender" : "female",
        "birthdate" : ISODate("1961-03-22T00:00:00Z"),
        "typeDocument" : "DNI",
        "numberDocument" : "15648572",
	"idCourse" : "2",
	"idFamily" : "4",
  
};

teacher2= {
        "fullName" : "Silvana Mu�oz",
        "gender" : "female",
        "birthdate" : ISODate("1991-09-21T00:00:00Z"),
        "typeDocument" : "DNI",
        "numberDocument" : "54615248",
	"idCourse" : "1",
	"idFamily" : "5",

};

teacher3= {

        "fullName" : "Joseline Rubin",
        "gender" : "female",
        "birthdate" : ISODate("1981-06-15T00:00:00Z"),
        "typeDocument" : "DNI",
        "numberDocument" : "14455153",
	"idCourse" : "3",
	"idFamily" : "6",
};


print("***********saving students*********");
db.student.save(student1);
db.student.save(student2);
db.student.save(student3);

print("***********saving family*********");
db.family.save(family1);
db.family.save(family2);
db.family.save(family3);
db.family.save(family4);
db.family.save(family5);
db.family.save(family6);

print("***********saving courses*********");
db.course.save(course1);
db.course.save(course2);
db.course.save(course3);
db.course.save(course4);

print("***********saving teachers*********");
db.teacher.save(teacher1);
db.teacher.save(teacher2);
db.teacher.save(teacher3);


print("SCRIPT FINISHED");

