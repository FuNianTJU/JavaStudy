package execShell;

import org.junit.Test;

public class ExecShellTest {

	@Test
	public void testExecShell() {
		String command = "du -bs" + "filepath";
		//String result = ExecShell.execShell(command);
		String result = "1024  /data";
		String size = result.substring(0, result.indexOf(' '));
		System.out.println(size);
	}

}
