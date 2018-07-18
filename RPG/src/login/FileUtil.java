package login;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
	public static List<String> readFileByLines(String fileName) {  
		//读入文件信息
        File file = new File(fileName); 
        List<String> ls = new ArrayList<String>();
        BufferedReader reader = null;  
        try {  
            reader = new BufferedReader(new FileReader(file));  
            String tempString = null;   
            while ((tempString = reader.readLine()) != null) {  
                ls.add(tempString);
            }  
            reader.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            if (reader != null) {  
                try {  
                    reader.close();  
                } catch (IOException e1) {  
                }  
            }
        }  
        return ls;
    }
	
	public static void appendFile(String fileName, String content) {  
		//把文本添加到文件里
		FileWriter writer = null;  
        try {          
            writer = new FileWriter(fileName, true);     
            writer.write(content+"\n");       
        } catch (IOException e) {     
            e.printStackTrace();     
        } finally {     
            try {     
                if(writer != null){  
                    writer.close();     
                }  
            } catch (IOException e) {     
                e.printStackTrace();     
            }     
        }     
    }  
	
	public static void writeFile(String fileName,List list){
		try {  
	        File file=new File(fileName);
	        if(!file.exists())
	            file.createNewFile();
	        FileOutputStream out=new FileOutputStream(file);        
	        for(int i=0;i<list.size();i++){
	            StringBuffer sb=new StringBuffer();
	            sb.append(list.get(i).toString()+"\n");
	            out.write(sb.toString().getBytes("utf-8"));
	        }        
	        out.close();
		} catch (IOException e) {     
            e.printStackTrace();     
        }
    }
}

