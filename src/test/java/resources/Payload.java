package resources;

import pojo.AssignSession;
import pojo.CreateUser;
import pojo.Login;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Payload {

	public static Login loginPayload(){

		Login l = new Login();
		l.setUsername("witwises-admin");
		l.setPassword("lLYVRayAHimpt9bJ");

		return l;

	}

	public static CreateUser createUserPayload() {

		CreateUser cu = new CreateUser();

		cu.setFirstName("API");
		cu.setLastName("TESTING");
		cu.setUsername("api30.testing");
		cu.setEmail("api30.testing@email.com");
		cu.setPhoneNumber("+905000000000");
		cu.setLocation("Ankara");
		cu.setAccount("Witwiser");
		cu.setDepartment("Mühendislik");

		List<String> expertises = new ArrayList<>();
		expertises.add("JAVA");
		cu.setExpertises(expertises);

		cu.setRank("A1");
		cu.setGender("MALE");

		List<String> labels= new ArrayList<>();
		labels.add("NEW_USER");
		cu.setLabels(labels);

		return cu;
	}

	public static AssignSession assignSessionPayload(){

		AssignSession as = new AssignSession();

		List<String> candidates = new ArrayList<>();
		candidates.add("1ed9833c-a996-d419-ddff-0302515c806e");
		as.setCandidates(candidates);

		as.setPeriodStartDate(java.time.Clock.systemUTC().instant().plus( 3 , ChronoUnit.HOURS ).toString());
		as.setPeriodEndDate(java.time.Clock.systemUTC().instant().plus( 5 , ChronoUnit.DAYS ).toString());
		as.setInterviewStartDate(null);
		as.setExamType("TEST");
		as.setSessionTemplateId("1ed8b70a-fb1b-35d9-d204-090228958efe");
		as.setInformCandidate(false);
		as.setAssignmentType("USER");
		as.setGroupId(null);

		return as;
	}


}
