package net.sourceforge.javaqemu.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class AliveOutputFileModel extends AliveFileModel {

    public AliveOutputFileModel(String qemuPathDir, int type,
            String messages) {
        super(qemuPathDir, type, messages);
    }

    @Override
    public void checks() throws IOException {
        File file = new File(this.getQemuPathDir()
                + UsabilityModel.getFileSeparator()
                + "stdout.txt");
        if (file.exists()) {
            if (file.canRead()) {
                if (isFileUpdated(file)) {
                    InputStreamReader fileReader = null;
                    try {
                        fileReader = new InputStreamReader(new FileInputStream(
                                file.getName()),
                                Charset.forName("UTF-8"));
                    } catch (FileNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } finally {
                        BufferedReader br = new BufferedReader(fileReader);
                        String result;
                        try {
                            result = br.readLine();

                            if (result != null) {
                                StringBuilder results = new StringBuilder(result);
                                String line = br.readLine();
                                while (line != null) {
                                    results.append("\n").append(line);
                                    line = br.readLine();
                                }
                                result = results.toString();

                                System.out.println("Conteudo(saida): \"" + result + "\"");
                                this.getMessages().setText(result);
                            }
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } finally {
                            br.close();
                            fileReader.close();
                        }
                    }
                }
            }
        }
    }

}
