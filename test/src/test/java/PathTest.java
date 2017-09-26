import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by lwx on 2017/9/26.
 */
public class PathTest {

    @Test
    public void test1(){
        Path path = Paths.get("e:", "project.properties");
        try {
            Path cpPath = Files.copy(path, Paths.get("e:", "project2.properties"),StandardCopyOption.REPLACE_EXISTING);
            System.out.println(cpPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2(){
        Path path = Paths.get("pom.xml");
        System.out.println(path);
        try {
            Path path1 = Files.copy(path, Paths.get("pom2.xml"), StandardCopyOption.REPLACE_EXISTING);
            System.out.println(path1);
            System.out.println(path1.getRoot());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3(){
        try {
            Path path = Files.walkFileTree(Paths.get("e:", "dir_temp"), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    Files.delete(file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException e) throws IOException {
                    if (e == null) {
                        Files.delete(dir);
                        return FileVisitResult.CONTINUE;
                    } else {
                        // directory iteration failed
                        throw e;
                    }
                }
            });
            System.out.println(path);
        } catch (IOException e) {
            System.out.println(">>>>>>>>>>>>.");
            e.printStackTrace();
        }
    }

    @Test
    public void testPath(){
        System.out.println(Paths.get("e:"));
    }
}
