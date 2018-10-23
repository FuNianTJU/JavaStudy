package execShell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 调用linux命令并获取结果
 * @author yan
 *
 */
public class ExecShell {

	public static String execShell(String command){
		String result = null;
		Process ps = null;
		try {
			ps = Runtime.getRuntime().exec(command); 
			BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
			result = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			ps.destroy();
		}
        return result;
	}
}
