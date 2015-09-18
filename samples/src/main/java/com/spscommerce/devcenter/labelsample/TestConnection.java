package com.spscommerce.devcenter.labelsample;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Vector;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class TestConnection {
    public static void main(String args[]) {
        JSch jsch = new JSch();
        Session session = null;
        try {
            
            //CONNECTING USING PASSWORD AND USERNAME
            session = jsch.getSession("ntu511_if54a@ukr.net", "sftp.spscommerce.net", 10022);
            //session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword("DyAvOlaenu6sh");
            session.connect();
               
            //CONNECTING USING PRIVATE KEY AUTHENTICATION
            //String privatekey;
            //jsch.addIdentity(privatekey);                                   
            //session = jsch.getSession("myusername", "hostname.com", 22);
            
            //CONNECTING TO SFTP
            Channel channel = session.openChannel("sftp");

            channel.connect();

            ChannelSftp sftpChannel = (ChannelSftp) channel;
        
            //GET THE DIRECTORY LIST
            sftpChannel.cd(".");
            Vector filelist = sftpChannel.ls(".");
            
            for (int i = 0; i < filelist.size(); ++i)
            {
                System.out.println(filelist.get(i).toString());
            }
            
            //UPLOAD FILE TO SFTP
            sftpChannel.cd("/testin");//setting directory for uploading
            File f = new File("CLIENT_DIRECTORY");

            try {
                sftpChannel.put(new FileInputStream(f), f.getName());
            } 
            catch (FileNotFoundException e1) {
              // Auto-generated catch block
                e1.printStackTrace();
            }
            System.out.println("Upload complete");
            
            //DOWNLOAD FILE FROM DIRECTORY
            sftpChannel.cd("/testin");//setting directory for downloading
            
            byte[] buffer = new byte[1024];
            BufferedInputStream bis = new BufferedInputStream(sftpChannel.get("FILENAME"));
            File newFile = new File("CLIENT_DIRECTORY");
            OutputStream os = null;
            
            try {
                os = new FileOutputStream(newFile);
            } 
            catch (FileNotFoundException e) {
                // Auto-generated catch block
                e.printStackTrace();
            }
            
           BufferedOutputStream bos = new BufferedOutputStream(os);
           int readCount = 0;
            
            try {
                 while( (readCount = bis.read(buffer)) > 0) {
                       System.out.println("Writing..." );
                       bos.write(buffer, 0, readCount);
                 }
           } 
           catch (IOException e) {
            // Auto-generated catch block
               e.printStackTrace();
           }
           try {
               bis.close();
           } 
           catch (IOException e) {
              // Auto-generated catch block
              e.printStackTrace();
           }
           try {
               bos.close();
           } 
           catch (IOException e) {
              // Auto-generated catch block
              e.printStackTrace();
           }
            sftpChannel.exit();
            session.disconnect();
            System.out.println("Writing complete");
        } 
        catch (JSchException e) {
            e.printStackTrace();  
        } 
        catch (SftpException e) {
            e.printStackTrace();
        }
    }
}
