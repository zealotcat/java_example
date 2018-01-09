import java.io.File;
import java.util.concurrent.TimeUnit;

public class Ex1_5 {

    public static class FileSearch implements Runnable {

        private String initPath;
        private String fileName;

        public FileSearch(String initPath, String fileName) {
            this.initPath = initPath;
            this.fileName = fileName;
        }

        @Override
        public void run() {
            File file = new File(initPath);
            if (file.isDirectory()) {
                try {
                    TimeUnit.SECONDS.sleep(3);
                    directoryProcess(file);
                } catch (InterruptedException e) {
                    System.out.printf("%s: The search has been interrupted",
                            Thread.currentThread().getName());
                }
            }
        }

        private void directoryProcess(File file) throws InterruptedException {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    if (f.isDirectory())
                        directoryProcess(f);
                    else
                        fileProcess(f);
                }
            }
            if (Thread.interrupted())
                throw new InterruptedException();
        }

        private void fileProcess(File file) throws InterruptedException {
            if (file.getName().equals(fileName)) {
                System.out.printf("%s : %s\n", Thread.currentThread().getName(),
                        file.getAbsolutePath());
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
        }
    }

    public static void main(String[] args) {

        FileSearch fileSearch = new FileSearch("/tmp", "autoexec.bat");
        Thread thread = new Thread(fileSearch);
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();
    }
}