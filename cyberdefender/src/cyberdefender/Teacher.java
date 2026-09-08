package cyberdefender;

public class Teacher extends User {

    // 教師を作成
    public Teacher(
            int id,
            String name,
            String password) {

        super(id, name, password);
    }

    // 教師メニューを表示
    public void showMenu() {

        System.out.println();
        System.out.println("========== 教師メニュー ==========");
        System.out.println("1. 問題登録");
        System.out.println("2. 問題一覧");
        System.out.println("3. 問題更新");
        System.out.println("4. 問題削除");
        System.out.println("5. 問題検索");
        System.out.println("6. 並び替え");
        System.out.println("7. 学習データ");
        System.out.println("8. ログアウト");
    }
}