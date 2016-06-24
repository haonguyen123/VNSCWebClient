/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.apache.sis.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.sis.client.CSW;
import org.apache.sis.client.CSW_Service;
import org.apache.sis.client.FileDownload;



/**
 *
 * @author haonguyen
 */
public class FileClient {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        CSW_Service service = new CSW_Service();
        CSW server = service.getCSWPort();
        byte[] bytes = server.fileDownload("LC81230522014071LGN00_MTL.txt");
        FileOutputStream fos = new FileOutputStream("/home/haonguyen/data/save/LC81230522014071LGN00_MTL.txt");
        fos.write(bytes);
        fos.flush();
        fos.close();
        System.out.println("Download Completed");
    }

}
