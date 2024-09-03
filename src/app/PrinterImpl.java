package app;

public class PrinterImpl implements Printer {

    @Override
    public void print(Message message) {
        if (message.getText() == null && message.getSender() == null) {

            Printer emptyMessageHandler = new Printer() {
                @Override
                public void print(Message message) {
                    System.out.println("Опрацьовується пусте повідомлення від анонімного користувача...");
                }
            };
            emptyMessageHandler.print(message);
        } else if (message.getSender() == null || message.getSender().isEmpty()) {
            System.out.println("Анонімний користувач відправив повідомлення: " + message.getText());
        } else {
            System.out.println("Користувач " + message.getSender() + " відправив повідомлення: " + message.getText());
        }
    }

    public static void main(String[] args) {
        Printer printer = new PrinterImpl();


        Message message1 = new Message("Привіт, світ!", "Іван");
        Message message2 = new Message("Як справи?", null);
        Message message3 = new Message(null, null);

        printer.print(message1);
        printer.print(message2);
        printer.print(message3);
    }
}
