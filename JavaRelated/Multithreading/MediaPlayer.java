package Multithreading;

class DecoderThread extends Thread {
    @Override
    public void run() {
        // Decoding logic here
        while (true) {
            // Decode a chunk of data
            System.out.println("Decoding...");
            try {
                Thread.sleep(500); // Simulate decoding time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class RendererThread extends Thread {
    @Override
    public void run() {
        // Rendering logic here
        while (true) {
            // Render a frame
            System.out.println("Rendering...");
            try {
                Thread.sleep(1000); // Simulate rendering time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class UserInterfaceThread extends Thread {
    @Override
    public void run() {
        // User interface logic here
        while (true) {
            // Handle user input and update UI
            System.out.println("Updating UI...");
            try {
                Thread.sleep(300); // Simulate UI update time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class MediaPlayer {
    public static void main(String[] args) {
        DecoderThread decoder = new DecoderThread();
        RendererThread renderer = new RendererThread();
        UserInterfaceThread ui = new UserInterfaceThread();

        decoder.setDaemon(true); // These threads should stop when the main thread stops
        renderer.setDaemon(true);
        ui.setDaemon(true);

        decoder.start();
        renderer.start();
        ui.start();

        try {
            Thread.sleep(10000); // Let the threads run for a while
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread ending.");
    }
}
