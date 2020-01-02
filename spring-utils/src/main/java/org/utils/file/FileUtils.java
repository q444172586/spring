package org.utils.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    private static Logger logger = LoggerFactory.getLogger(FileUtils.class);

    public static StringBuffer read(File file) throws IOException{
        if (file != null && file.exists() && file.isFile()) {
            StringBuffer content = new StringBuffer();

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            reader.close();
            return content;
        }
        return null;
    }

    public static List<String> readList(File file) {
        try {
            List<String> content = new ArrayList<String>();

            String encoding = "UTF-8";
            if (file != null && file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
                BufferedReader bufferedReader = new BufferedReader(read);
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    content.add(line);
                }
                read.close();
                return content;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public static void write(String filename, StringBuffer content, String encoding) {
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write(content.toString());
            writer.close();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public static List<File> getFileList(String path, String[] excludes) {
        return getFileList(new File(path), excludes);
    }

    public static List<File> getFileList(File path, String[] excludes) {
        List<File> filelist = new ArrayList<File>();

        File[] files = path.listFiles();

        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    filelist.addAll(getFileList(files[i], excludes));
                } else {
                    boolean isExclude = true;
                    if (excludes != null && excludes.length > 0) {
                        for (String exclude : excludes) {
                            exclude = exclude.trim();
                            String filename = files[i].getName();
                            if (filename.matches(exclude)) {
                                isExclude = false;
                            }
                        }
                    }

                    if (isExclude) {
                        filelist.add(files[i]);
                    }
                }
            }
        }
        return filelist;
    }
}
