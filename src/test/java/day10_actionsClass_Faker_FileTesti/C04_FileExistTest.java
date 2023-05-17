package day10_actionsClass_Faker_FileTesti;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileExistTest {
    @Test
    public void test01() {
        String dosyaYolu="src/test/java/day10_actionsClass_Faker_FileTesti/deneme.txt";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));



    }
}

