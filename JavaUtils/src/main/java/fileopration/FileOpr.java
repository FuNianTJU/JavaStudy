package fileopration;

import java.io.File;

import org.apache.commons.io.FileUtils;

/**
 * 获取文件夹大小的方法示例
 * @author yan
 *
 */
public class FileOpr {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
        long size = FileUtils.sizeOf(new File("C:/Users/yan/Desktop/test/"));
        System.out.println("Size: " + size + " bytes");
        
        System.out.println("execTime:"+(System.currentTimeMillis()-start));
    }
}

//FileUtils.sizeOfDirectory
//Size: 5644652988 bytes
//execTime:1580















