package com.spscommerce.devcenter.labelsample;

import com.spscommerce.devcenter.services.label.LabelService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LabelZplTester {
    public static void main(String[] args) {

        String labelUID = "5411";
        String username = "customertest";
        String password = "spstest";

        try {
            InputStream stream = LabelZplTester.class.getResourceAsStream("/ShippingLabel.xml");
            String fileContent = readSampleFromResources(stream);

            LabelService labelApiService = new LabelService(username, password);
            String zpl = labelApiService.GetLabelZpl(fileContent, labelUID);
            System.out.println("\n" + zpl + "\n");
            System.out.println("Test Successful !");

        } catch (Exception exc) {
            exc.printStackTrace();
            System.out.println("Test FAILED !");
        }
    }

    private static String readSampleFromResources(InputStream stream) {

        if (stream == null) {
            System.out.println("\nFile at resources folder not found.\n");
            return null;
        }

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {

            br = new BufferedReader(new InputStreamReader(stream));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }
}
