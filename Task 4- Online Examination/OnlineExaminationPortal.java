import java.util.Scanner;

class User {
    private String username;
    private String password;
    private String profile;

    public User(String username, String password, String profile) {
        this.username = username;
        this.password = password;
        this.profile = profile;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getProfile() {
        return profile;
    }
}

class Exam {
    private String[] questions;
    private String[] options;
    private int[] answers;

    public Exam() {
        questions = new String[]{
                "Question 1: What is the capital of France?",
                "Question 2: Who wrote the play 'Romeo and Juliet'?",
                "Question 3: What is the chemical symbol for gold?",
                "Question 4: Which planet is known as the Red Planet?",
                "Question 5: Who painted the Mona Lisa?"
        };

        options = new String[]{
                "A. Paris\tB. London\tC. Rome\tD. Berlin",
                "A. William Shakespeare\tB. Oscar Wilde\tC. Jane Austen\tD. Mark Twain",
                "A. Au\tB. Ag\tC. Cu\tD. Hg",
                "A. Mars\tB. Venus\tC. Jupiter\tD. Saturn",
                "A. Leonardo da Vinci\tB. Vincent van Gogh\tC. Pablo Picasso\tD. Michelangelo"
        };

        answers = new int[]{1, 1, 1, 0, 0};
    }

    public void displayQuestions() {
        System.out.println("ONLINE EXAMINATION PORTAL");
        System.out.println("-------------------------");
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            System.out.println(options[i]);
        }
    }

    public int[] getAnswers() {
        return answers;
    }
}

public class OnlineExaminationPortal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User login
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Simulating user authentication
        User user = authenticateUser(username, password);

        if (user != null) {
            System.out.println("Welcome, " + user.getUsername() + "!");
            System.out.println("Profile: " + user.getProfile());

            // Exam
            Exam exam = new Exam();
            exam.displayQuestions();

            // Simulating user selecting answers
            int[] userAnswers = new int[exam.getAnswers().length];
            for (int i = 0; i < userAnswers.length; i++) {
                System.out.print("Enter your answer (A, B, C, D): ");
                String answer = scanner.nextLine().toUpperCase();
                userAnswers[i] = getAnswerIndex(answer);
            }

            // Checking the answers
            int[] correctAnswers = exam.getAnswers();
            int score = calculateScore(userAnswers, correctAnswers);

            System.out.println("Exam Completed!");
            System.out.println("Your score: " + score + " out of " + correctAnswers.length);

            // Update Profile and Password
            System.out.println("Update Profile and Password");
            // TODO: Implement code to update profile and password

            // Closing session and Logout
            System.out.println("Closing session and Logout");
        } else {
            System.out.println("Invalid username or password. Login failed.");
