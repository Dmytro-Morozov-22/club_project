package com.ua.lviv.club;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class MainClub {

	public static void menu() {
		System.out.println("1 - додати учасника клубу");
		System.out.println("2 - додати тваринку до учасника клубу");
		System.out.println("3 - видалити тваринку з учасника клубу");
		System.out.println("4 - видалити учасника з клубу");
		System.out.println("5 - видалити конкретну тваринку зі всіх власників");
		System.out.println("6 - вивести на екран зооклуб");
		System.out.println("7 - вийти з програми");
	}

	static Map<Person, List<Animal>> zooMap = new HashMap<>();

	public static void main(String[] args) {

		int a = 1;

		while (a == 1) {
			menu();
			Scanner sc = new Scanner(System.in);
			switch (sc.next()) {

//1. Додати учасника клубу				
			case "1":
				addClubMember();
				break;

//2. Додати тваринку до учасника клубу
			case "2":
				addAnimal();
				break;

//3. Видалити тваринку з учасника клубу
			case "3":
				removeAnimal();
				break;

//4. Видалити учасника з клубу
			case "4":
				removeClubMember();
				break;

//5. Видалити конкретну тваринку зі всіх власників
			case "5":
				removeSpecialAnimalFromAllPeople();
				break;
//6. Вивести на екран зооклуб			
			case "6":
				displayInfo();
				break;

//7. Вийти з програми			
			case "7":
				exitTheProgram();
				sc.close();
				break;

			default:
				System.err.println("Введіть число від 1 до 7");
				break;

			}// switch
		} // while
	}// main

//1. Додати учасника клубу	
	static void addClubMember() {
		zooMap.put(new Person(getRandPersonName(), getRandRange(18, 70)),
				new ArrayList<>());
		Set<Entry<Person, List<Animal>>> entrySet = zooMap.entrySet();
		for (Entry<Person, List<Animal>> entry : entrySet) {
			String correctYear;
			if (entry.getKey().getAge() % 10 == 1) {
				correctYear = "рік";
			} else if (entry.getKey().getAge() % 10 == 2
					|| entry.getKey().getAge() % 10 == 3
					|| entry.getKey().getAge() % 10 == 4) {
				correctYear = "роки";
			} else {
				correctYear = "років";
			}
			System.out.println(entry.getKey().getName() + " "
					+ entry.getKey().getAge() + " " + correctYear);
		}
	}

//2. Додати тваринку до учасника клубу
	@SuppressWarnings("resource")
	static void addAnimal() {
		if (zooMap.isEmpty()) {
			System.out.println("Додайте спочатку учасника клубу");
		} else {
			Set<Entry<Person, List<Animal>>> entrySet = zooMap.entrySet();
			if (zooMap.size() == 1) {
				Iterator<Entry<Person, List<Animal>>> iterator = entrySet
						.iterator();

				while (iterator.hasNext()) {
					Entry<Person, List<Animal>> next = iterator.next();
					List<Animal> value = next.getValue();
					value.add(new Animal(getRandAnimalKind(),
							getRandAnimalName()));

					Iterator<Animal> itr3 = value.iterator();
					while (itr3.hasNext()) {
						Animal next2 = itr3.next();
						System.out.println(
								"Додано тварину: " + next2.getAnimalKind()
										+ " на імя " + next2.getAnimalName());
					}
				}

			} else {
				System.out.println("Введіть ім'я учасника клубу");
				Scanner sc = new Scanner(System.in);
				String obtainedName = sc.next().toUpperCase();
				int count = 0;

				Iterator<Entry<Person, List<Animal>>> iterator1 = entrySet
						.iterator();

				while (iterator1.hasNext()) {
					Entry<Person, List<Animal>> next = iterator1.next();
					if (next.getKey().getName().toUpperCase()
							.equals(obtainedName)) {

						List<Animal> value = next.getValue();
						value.add(new Animal(getRandAnimalKind(),
								getRandAnimalName()));

						Iterator<Animal> itr3 = value.iterator();
						while (itr3.hasNext()) {
							Animal next2 = itr3.next();
							System.out.println("Додано тварину: "
									+ next2.getAnimalKind() + " на імя "
									+ next2.getAnimalName());
						}

					} else {
						count++;
					}

					if (count == zooMap.size()) {
						System.err
								.println("Немає учасника клубу з таким ім'ям");
					}
				}
			}
		}
	}

//3. Видалити тваринку з учасника клубу
	@SuppressWarnings("resource")
	static void removeAnimal() {
		if (zooMap.isEmpty()) {
			System.out.println("Додайте спочатку учасника клубу");
		} else {
			Set<Entry<Person, List<Animal>>> entrySet = zooMap.entrySet();
			if (zooMap.size() == 1) {
				Iterator<Entry<Person, List<Animal>>> iterator = entrySet
						.iterator();

				while (iterator.hasNext()) {
					Entry<Person, List<Animal>> next = iterator.next();
					List<Animal> value = next.getValue();

					Animal a = value.remove(0);
					System.out.println("Тварину видалено " + a.getAnimalKind()
							+ " " + a.getAnimalName());

				}

			} else {
				System.out.println(
						"Введіть ім'я учасника клубу, щоб видалити тварину");
				Scanner sc = new Scanner(System.in);
				String obtainedName = sc.next().toUpperCase();
				int count = 0;

				Iterator<Entry<Person, List<Animal>>> iterator1 = entrySet
						.iterator();

				while (iterator1.hasNext()) {
					Entry<Person, List<Animal>> next = iterator1.next();
					if (next.getKey().getName().toUpperCase()
							.equals(obtainedName)) {

						List<Animal> value = next.getValue();

						Animal a = value.remove(0);
						System.out.println("Тварину видалено "
								+ a.getAnimalKind() + " " + a.getAnimalName());

					} else {
						count++;
					}

					if (count == zooMap.size()) {
						System.err
								.println("Немає учасника клубу з таким ім'ям");
					}
				}
			}
		}
	}

//4. Видалити учасника клубу	
	@SuppressWarnings("resource")
	static void removeClubMember() {

		if (zooMap.isEmpty()) {
			System.out.println("Додайте спочатку учасника клубу");
		} else {
			Set<Entry<Person, List<Animal>>> entrySet = zooMap.entrySet();
			if (zooMap.size() == 1) {
				Iterator<Entry<Person, List<Animal>>> it1 = entrySet.iterator();
				while (it1.hasNext()) {
					Entry<Person, List<Animal>> next = it1.next();
					System.out.println("Видалено учасника клубу: "
							+ next.getKey().getName());
				}
				zooMap.clear();
			} else {
				System.out.println(
						"Введіть ім'я учасника клубу, щоб видалити учасника клубу");
				Scanner sc = new Scanner(System.in);
				String obtainedName = sc.next().toUpperCase();
				int count = 0;

				Iterator<Entry<Person, List<Animal>>> iterator1 = entrySet
						.iterator();

				while (iterator1.hasNext()) {
					Entry<Person, List<Animal>> next = iterator1.next();
					if (next.getKey().getName().toUpperCase()
							.equals(obtainedName)) {

						iterator1.remove();

						System.out.println("Члена клубу "
								+ next.getKey().getName() + " видалено");
						count--;
					} else {
						count++;
					}

					if (count == zooMap.size()) {
						System.err
								.println("Немає учасника клубу з таким ім'ям");
					}
				}
			}
		}
	}

//5. Видалити конкретну тваринку зі всіх власників	
	@SuppressWarnings("resource")
	static void removeSpecialAnimalFromAllPeople() {
		if (zooMap.isEmpty()) {
			System.out.println("Додайте спочатку учасника клубу");
		} else {
			System.out.println(
					"Введіть вид тварини, яку потрібно видалити для усіх власників");
			Scanner sc = new Scanner(System.in);
			String obtainedAnimal = sc.next();

			Iterator<Entry<Person, List<Animal>>> itr = zooMap.entrySet()
					.iterator();
			int y = 0;
			int count = 0;
			while (itr.hasNext()) {
				Entry<Person, List<Animal>> next = itr.next();
				List<Animal> value = next.getValue();

				if (value.isEmpty()) {
					System.out.println(
							"Додайте спочатку тварину до учасника клубу");
				} else {

					Iterator<Animal> itrValue = value.iterator();

					int t = 0;
					while (itrValue.hasNext()) {

						Animal next2 = itrValue.next();
						if (next2.getAnimalKind()
								.equalsIgnoreCase(obtainedAnimal)) {
							itrValue.remove();
							t++;
							if (y == 0) {
								System.out.println("Видалено: "
										+ next2.getAnimalKind().toUpperCase()
										+ " для усіх учасників клубу");

							}
							y++;
							count--;
						} else {
							count++;
						}

					}

					if (count == value.size() + t) {

						System.out
								.println("Такої тварини немає у членів клубу");
					}

				}

			}
		}
	}

//6. Вивести на екран зооклуб
	static void displayInfo() {

		Iterator<Entry<Person, List<Animal>>> itr = zooMap.entrySet()
				.iterator();
		while (itr.hasNext()) {
			Entry<Person, List<Animal>> next = itr.next();

			String correctYear;
			if (next.getKey().getAge() % 10 == 1) {
				correctYear = "рік";
			} else if (next.getKey().getAge() % 10 == 2
					|| next.getKey().getAge() % 10 == 3
					|| next.getKey().getAge() % 10 == 4) {
				correctYear = "роки";
			} else {
				correctYear = "років";
			}

			List<Animal> value = next.getValue();
			Iterator<Animal> iterator = value.iterator();

			ArrayList<String> arr = new ArrayList<String>();

			while (iterator.hasNext()) {
				Animal next2 = iterator.next();
				arr.add(next2.getAnimalKind().toUpperCase() + " на імя "
						+ next2.getAnimalName());
			}

			System.out.println(next.getKey().getName() + " "
					+ next.getKey().getAge() + " " + correctYear
					+ " має таких тварин як: " + (arr.toString().substring(1,
							arr.toString().length() - 1)));
		}
	}

//7. Вийти з програми
	static void exitTheProgram() {
		System.out.println("Програму завершено!");
		System.exit(0);
	}

//RANDOM METHODS:	
	// Random Person Name
	private static String getRandPersonName() {
		String[] itemList = { "Yakiv", "Borys", "Omeljan", "Markiyan", "Glib",
				"Vsevolod", "Kseniya", "Zoya", "Melaniya", "Roksana",
				"Harytyna" };
		return itemList[getRandRange(0, itemList.length - 1)];
	}// RandPersonName

	// Random Animal Name
	private static String getRandAnimalName() {
		String[] itemList = { "Hera", "Zeus", "Apollo", "Janus", "Venus",
				"Arion", "Shen", "Naga", "Wasabi", "Lemon", "Bosco" };
		return itemList[getRandRange(0, itemList.length - 1)];
	}// RandAnimalName

	// Random Animal Kind
	private static String getRandAnimalKind() {
		String[] itemList = { "папуга", "кіт", "пес", "лисиця", "пацюк",
				"хом'як", "мавпа", "кролик", "курка", "павук", "жаба" };
		return itemList[getRandRange(0, itemList.length - 1)];
	}// RandAnimalKind

	// Random range
	private static int getRandRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException(
					"min value must be smaller than max value");
		}

		Random r = new Random();
		return r.nextInt(max - min + 1) + min;
	}// RandRange

}// zooClub
