public class AbstractFactoryExample {

    // Abstract Product A
    public interface Button {
        void paint();
    }

    // Abstract Product B
    public interface Checkbox {
        void paint();
    }

    // Concrete Product A1
    public static class WinButton implements Button {
        @Override
        public void paint() {
            System.out.println("Rendering a button in Windows style.");
        }
    }

    // Concrete Product A2
    public static class MacButton implements Button {
        @Override
        public void paint() {
            System.out.println("Rendering a button in MacOS style.");
        }
    }

    // Concrete Product B1
    public static class WinCheckbox implements Checkbox {
        @Override
        public void paint() {
            System.out.println("Rendering a checkbox in Windows style.");
        }
    }

    // Concrete Product B2
    public static class MacCheckbox implements Checkbox {
        @Override
        public void paint() {
            System.out.println("Rendering a checkbox in MacOS style.");
        }
    }

    // Abstract Factory
    public interface GUIFactory {
        Button createButton();
        Checkbox createCheckbox();
    }

    // Concrete Factory 1
    public static class WinFactory implements GUIFactory {
        @Override
        public Button createButton() {
            return new WinButton();
        }

        @Override
        public Checkbox createCheckbox() {
            return new WinCheckbox();
        }
    }

    // Concrete Factory 2
    public static class MacFactory implements GUIFactory {
        @Override
        public Button createButton() {
            return new MacButton();
        }

        @Override
        public Checkbox createCheckbox() {
            return new MacCheckbox();
        }
    }

    // Client Code
    public static class Application {
        private Button button;
        private Checkbox checkbox;

        public Application(GUIFactory factory) {
            button = factory.createButton();
            checkbox = factory.createCheckbox();
        }

        public void paint() {
            button.paint();
            checkbox.paint();
        }
    }

    public static void main(String[] args) {
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();

        if (osName.contains("win")) {
            factory = new WinFactory();
        } else {
            factory = new MacFactory();
        }

        Application app = new Application(factory);
        app.paint();
    }
}
