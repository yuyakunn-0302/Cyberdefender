package cyberdefender;

public class Student extends User {

    // 生徒を作成
    public Student(
            int id,
            String name,
            String password) {

        super(id, name, password);
    }

    // 生徒メニューを表示
    public void showMenu() {

        System.out.println();
        System.out.println("========== 生徒メニュー ==========");
        System.out.println("1. 問題を解く");
        System.out.println("2. 問題・解答履歴を見る");
        System.out.println("3. 自分の成績");
        System.out.println("4. ログアウト");
    }
}