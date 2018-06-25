package com.example;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NewAppApplication { //implements CommandLineRunner {
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
/*
	@Autowired
	private StudentController studentController;

	@Autowired
	private SubjectController subjectController;

	@Autowired
	private ExamController examController;
*/
	public static void main(String[] args) {
		SpringApplication.run(NewAppApplication.class, args);
	}
/*
	@Override
	public void run(String... params) throws Exception {
		studentController.readStudents();
		subjectController.readSubjects();
		examController.readExams();

		menu();

	}

	public void menu() {
		showMenu();
		Scanner in = new Scanner(System.in);
		int num = 1;

		while (true) {
			num = in.nextInt();

			if (num == 1) {
				menuStudents();

			} else if (num == 2) {
				menuSubjects();

			} else if (num == 3) {
				menuExams();

			} else if (num == 0) {
				break;
			}

		}

	}

	public void menuStudents() {
		showMenuStudents();
		Scanner in = new Scanner(System.in);
		int num = 1;
		while (true) {
			num = in.nextInt();

			if (num == 1) {
				studentController.getStudents();
				showMenuStudents();

			} else if (num == 2) {
				studentController.addStudent();
				showMenuStudents();

			} else if (num == 3) {
				studentController.getStudent();
				showMenuStudents();

			} else if (num == 0) {
				break;
			}
		}

		studentController.saveStudents();
		menu();
	}

	public void menuSubjects() {
		showMenuSubjects();
		Scanner in = new Scanner(System.in);
		int num = 1;
		while (true) {
			num = in.nextInt();

			if (num == 1) {
				subjectController.getSubjects();
				showMenuSubjects();

			} else if (num == 2) {
				subjectController.addSubject();
				showMenuSubjects();

			} else if (num == 3) {
				subjectController.getSubject();
				showMenuSubjects();

			} else if (num == 0) {
				break;

			}

		}
		subjectController.saveSubjects();
		menu();
	}

	public void menuExams() {
		showMenuExams();

		Scanner in = new Scanner(System.in);
		int num = 1;
		while (true) {
			num = in.nextInt();

			if (num == 1) {
				examController.getExams();
				showMenuExams();

			} else if (num == 2) {
				examController.addExam();
				showMenuExams();
			} else if (num == 0) {
				break;
			}

		}

		examController.saveExams();
		menu();
	}

	private void showMenuExams() {
		System.out.println("");
		System.out.println("1 - Prikaz ispita");
		System.out.println("2 - Dodavanje ispita");
		System.out.println("0 - Natrag");

	}

	private void showMenuSubjects() {
		System.out.println("");
		System.out.println("1 - Prikaz predmeta");
		System.out.println("2 - Dodavanje predmeta");
		System.out.println("3 - Pretraga predmeta");
		System.out.println("0 - Natrag");

	}

	private void showMenuStudents() {
		System.out.println("");
		System.out.println("1 - Prikaz studenata");
		System.out.println("2 - Dodaj studenta");
		System.out.println("3 - Pretraga studenta");
		System.out.println("0 - Natrag");

	}

	private void showMenu() {
		System.out.println("");
		System.out.println("1 - Studenti");
		System.out.println("2 - Predmeti");
		System.out.println("3 - Ispiti");
		System.out.println("0 - Kraj");

	}*/
}
