package words;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Words example: familiar Java implementation.
 */
public class Words1 {
    
    /**
     * Find all the files in the filesystem subtree rooted at folder.
     * @param folder root of subtree, requires folder.isDirectory() == true
     * @return list of all ordinary files (not folders) that have folder as
     *         their ancestor
     */
    public static List<File> allFilesIn(File folder) {
        List<File> files = new ArrayList<File>();
        for (File f: folder.listFiles()) {
            if (f.isDirectory()) {
                files.addAll(allFilesIn(f));
            } else if (f.isFile()) {
                files.add(f);
            }
        }
        return files;
    }
    
    /**
     * Filter a list of files to those that end with suffix.
     * @param files list of files (all non-null)
     * @param suffix string to test
     * @return a new list consisting of only those files whose names end with
     *         suffix
     */
    public static List<File> onlyFilesWithSuffix(List<File> files, String suffix) {
        List<File> result = new ArrayList<File>();
        for (File f : files) {
            if (f.getName().endsWith(suffix)) {
                result.add(f);
            }
        }
        return result;
    }
    
    /**
     * Find all the non-word-character-separated words in files.
     * @param files list of files (all non-null)
     * @return list of words from all the files
     * @throws IOException if an error occurs reading a file
     */
    public static List<String> getWords(List<File> files) throws IOException {
        List<String> words = new ArrayList<String>();
        for (File f : files) {
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String line;
            for (line = reader.readLine(); line != null; line = reader.readLine()) {
                // split on \W (non-word characters, like spaces and punctuation)
                for (String word : line.split("\\W+")) {
                    // split can return empty strings, so omit them
                    if ( ! word.isEmpty()) {
                        words.add(word);
                    }
                }
            }
            reader.close();
        }
        return words;
    }
    
    /**
     * Print the words in Java files in the project.
     * @param args unused
     */
    public static void main(String[] args) throws IOException {
        List<File> allFiles = allFilesIn(new File("."));
        List<File> javaFiles = onlyFilesWithSuffix(allFiles, ".java");
        List<String> words = getWords(javaFiles);
        for (String s : words) { System.out.println(s); }
    }
}
