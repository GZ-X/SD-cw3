package sd_prototype;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;


public class FileOperation {
   
    public void write(String[] info)throws IOException
    {
        File file=new File("UserAccount.txt");  //create file
        String infosum="";
        for (int i=0; i<5; i++)  
            infosum+=info[i]+"~";
        try {
        if(!file.exists())
            file.createNewFile();
        }
        catch (Exception e) {
        e.printStackTrace();
        }
        FileOutputStream out=new FileOutputStream(file,true); //create output object     
        StringBuffer sb=new StringBuffer();      
        sb.append(infosum+"\n");             
         out.write(sb.toString().getBytes("gb2312"));         //write StringBuffer to file
        out.close();            //close stream
    }
    
    public String[] read(String account) throws IOException
    {
        File file=new File("UserAccount.txt");
        if(!file.exists()||file.isDirectory())
            throw new FileNotFoundException();
        BufferedReader br=new BufferedReader(new FileReader(file));
        String temp=null;
        StringBuffer sb=new StringBuffer();
        temp=br.readLine();

        String []message = new String[5];     
        while(temp!=null){
            String sbstring = temp.toString();
            int n = sbstring.length();            
            for (int i=0; i<5; i++)
                message[i] = "";

            int k=0;
            for (int i=0; i<n; i++)
            {
                if(sbstring.charAt(i)=='~')  //distinguish each character by '~'
                {
                    //System.out.println("@"+message[k]);
                    k++;
                }
                else 
                {
                    message[k] += sbstring.charAt(i);
                }
            }
            if (message[2].equals(account))  //match the information
            {
                return message;
            }
            temp=br.readLine();
        }
        br.close();
       
        return null;
    }
    
}
