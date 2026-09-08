package cyberdefender;

public class User {

    // ユーザーID
    protected int id;

    // ユーザー名
    protected String name;

    // パスワード
    protected String password;

    // ユーザーを作成
    public User(
            int id,
            String name,
            String password) {

        this.id = id;
        this.name = name;
        this.password = password;
    }

    // IDを取得
    public int getId() {
        return id;
    }

    // 名前を取得
    public String getName() {
        return name;
    }

    // ログイン確認
    public boolean login(
            int id,
            String password) {

        return this.id == id
                && this.password.equals(password);
    }
}