/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package downloadsorter.Filters;

import downloadsorter.model.FileMetaData;
import downloadsorter.model.DirectorySource;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Eric
 */
public class DirectorySourceTest {
    Path sampleDir;
    Path testDir;
    ArrayList<FileMetaData> blankList;
    ArrayList<Path> fromTestDir;
    
    public DirectorySourceTest() {
        sampleDir = Paths.get("Filter test sample data", "sample source");
        testDir = Paths.get("Filter test sample data", "test source");
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        blankList = new ArrayList<>();
        fromTestDir = new ArrayList<>();
        fromTestDir.add(testDir);
        TestFolderCopier freshTestFolder = new TestFolderCopier(sampleDir, testDir);
        try {Files.walkFileTree(sampleDir, freshTestFolder);}
        catch(Exception exc) {System.out.println("Test Folder not copied cleanly: " + exc.getMessage());}
    }
    
    @After
    public void tearDown() {
        TestCleaner cleaner = new TestCleaner();
        try {Files.walkFileTree(testDir, cleaner);}
        catch (Exception e) {System.out.println(e.getMessage());}
    }

    /**
     * Test of getFiles method, of class DirectorySource.
     */
    @Test
    public void testGetFiles() {
        System.out.println("getFiles: List not empty when directory is not empty.");
        DirectorySource instance = new DirectorySource(true, fromTestDir);
        List<FileMetaData> result = instance.process(blankList);
        assertTrue(result.size() > 0);
    }
        
    @Test
    public void testGetFilesMore() {
        System.out.println("getFiles: List files exist");
        DirectorySource instance2 = new DirectorySource(true, fromTestDir);
        List<FileMetaData> result2 = instance2.process(blankList);
        boolean filesExist = result2.stream()
                            .allMatch(p -> Files.exists(p.getPath()));
        assertTrue(filesExist);
        
        result2.stream().forEach(p -> System.out.println(p));
    }
    
}

