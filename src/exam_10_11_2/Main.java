package exam_10_11_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("=== 프로그램 시작 ===");
		Scanner sc = new Scanner(System.in);

		int lastId = 3;
		Article article = new Article(0, "", "", "");
		Article test1 = new Article(1, Utill.getDate(), "테스트 제목1", "테스트 내용1");
		Article test2 = new Article(2, Utill.getDate(), "테스트 제목2", "테스트 내용2");
		Article test3 = new Article(3, Utill.getDate(), "테스트 제목3", "테스트 내용3");
		List<Article> articles = new ArrayList<>();
		articles.add(test1);
		articles.add(test2);
		articles.add(test3);
		while (true) {
			String cmd = sc.nextLine();
			if (cmd.equals("exit")) {
				break;
			}
			if (cmd.equals("article write")) {
				System.out.println("게시글 작성");
				System.out.println("제목: ");
				String title = sc.nextLine();
				System.out.println("내용: ");
				String body = sc.nextLine();
				lastId++;
				article = new Article(lastId, Utill.getDate(), title, body);
				articles.add(article);
				System.out.println("게시글이 작성되었습니다.");
			}

			if (cmd.equals("article list")) {
				for (int i = 0; i < articles.size(); i++) {
					System.out.println("게시글 보기");
					System.out.printf("%d , %s , %s , %s\n", articles.get(i).getId(), articles.get(i).getRegDate(),
							articles.get(i).getTitle(), articles.get(i).getBody());
				}
			} else if (cmd.contains("article list ")) {
				String cmdStr[] = cmd.split(" ");
				for (int i = 0; i < articles.size(); i++) {
					if (cmd.contains(articles.get(i).getTitle())) {
						System.out.println("게시글 보기");
						System.out.printf("%d , %s , %s , %s\n", articles.get(i).getId(), articles.get(i).getRegDate(),
								articles.get(i).getTitle(), articles.get(i).getBody());
					}
				}
			}

			if (cmd.contains("article detail ")) {
				String cmdStr[] = cmd.split(" ");
				for (int i = 0; i < articles.size(); i++) {
					if (Integer.parseInt(cmdStr[2]) == articles.get(i).getId()) {
						System.out.println("게시글 상세보기");
						System.out.printf("번호: %d\n작성 날짜: %s\n제목: %s\n내용: %s\n", articles.get(i).getId(),
								articles.get(i).getRegDate(), articles.get(i).getTitle(), articles.get(i).getBody());
					}
				}
			}
			if (cmd.contains("article modify ")) {
				String cmdStr[] = cmd.split(" ");
				for (int i = 0; i < articles.size(); i++) {
					if (Integer.parseInt(cmdStr[2]) == articles.get(i).getId()) {
						System.out.println("게시글 수정");
						System.out.println("제목: ");
						articles.get(i).setTitle(sc.nextLine());
						System.out.println("내용: ");
						articles.get(i).setBody(sc.nextLine());
						System.out.println("게시글이 수정되었습니다.");
					}

				}
			}
			if (cmd.contains("article delete ")) {
				String cmdStr[] = cmd.split(" ");
				for (int i = 0; i < articles.size(); i++) {
					if (Integer.parseInt(cmdStr[2]) == articles.get(i).getId()) {
						System.out.println("게시글 삭제");
						articles.remove(i);
						System.out.println("게시글이 삭제되었습니다.");
					}

				}
			}

		}
	}
}