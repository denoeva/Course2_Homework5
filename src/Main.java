public class Main {
    private static final String REGEX = "^[a-zA-Z0-9_]*$";
    public static void main(String[] args) {
        try {
            checkAuth("java_skypro_go", "D_1hWiKjjP_9", "D_1hWiKjjP_9");
            System.out.println("Данные корректные");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Введены некорректные данные");
        }
    }

    private static void checkAuth(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (!login.matches(REGEX) || login.length() > 20) {
            throw new WrongLoginException();
        }
        if (!password.matches(REGEX) || password.length() > 20 || !password.equals(confirmPassword)) {
            throw new WrongPasswordException();
        }
    }
}