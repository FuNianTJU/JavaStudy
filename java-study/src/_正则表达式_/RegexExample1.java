package _正则表达式_;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;


public class RegexExample1 {
	
	/**
	 * 使用正则表达式查找字符串是否包含子串
	 * @author yan
	 *
	 */
	@Test
	public void isMatch(){
		String content = "I am noob from runoob.com.";
		String pattern = ".*runoob.*";
		boolean isMatch = Pattern.matches(pattern, content);
		System.out.println("字符串是否包含'runoob'子串？ "+isMatch);
	}
	
	/**
	 * 从一个给定的字符串中找到数字串
	 */
	@Test
	public void findNumbers(){
		String line = "This order was placed for QT3000! OK?";
		String patternString = "(\\D*)(\\d+)(.*)"; // \D 非数字, \d 数字
		
		//创建 Pattern 对象
		Pattern pattern = Pattern.compile(patternString);
		
		//创建 matcher 对象
		Matcher matcher = pattern.matcher(line);
		if(matcher.find()){
			System.out.println("Found value: " + matcher.group(0) );
	        System.out.println("Found value: " + matcher.group(1) );
	        System.out.println("Found value: " + matcher.group(2) );
	        System.out.println("Found value: " + matcher.group(3) ); 
		} else {
			System.out.println("NO Match");
		}
	}
	
	/**
	 * 对字符串中 'cat' 出现的次数进行计数
	 */
	@Test
	public void RegexMatches(){
		String regex = "\\bcat\\b"; // \b 匹配一个字边界，即字与空格之间的位置
		String input = "cat cat cat cattie cat";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		int count = 0;
		
		while(matcher.find()){
			count++;
			System.out.println("Match number "+count);
			System.out.println("start():"+ matcher.start());
			System.out.println("end():"+ matcher.end());
		}
	}
	
	/**
	 * matches 和 lookingAt 方法都用来尝试匹配一个输入序列模式。
	 * 它们的不同是 matches 要求整个序列都匹配，而lookingAt 不要求。
	 * lookingAt 方法虽然不需要整句都匹配，但是需要从第一个字符开始匹配。
	 * 这两个方法经常在输入字符串的开始使用。
	 */
	@Test
	public void match(){
		String regex = "foo";
		String input = "foooooooooooooo";
		String input2 = "ooooofooooooooo";
		Pattern pattern;
		Matcher matcher;
		Matcher matcher2;
		
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(input);
		matcher2 = pattern.matcher(input2);
		
		System.out.println("Current REGEX is: "+regex);
        System.out.println("Current INPUT is: "+input);
        System.out.println("Current INPUT2 is: "+input2);
 
 
        System.out.println("input lookingAt(): "+matcher.lookingAt());
        System.out.println("input matches(): "+matcher.matches());
        System.out.println("input2 lookingAt(): "+matcher2.lookingAt());
        System.out.println("input2 matches(): "+matcher.matches());
		
	}
	
	/**
	 * 替换匹配正则表达式的文本
	 */
	@Test
	public void replace(){
		String regex = "dog";
		String input = "The dog says meow. All dogs say meow.";
		String replace = "cat";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		input = matcher.replaceAll(replace);
		System.out.println(input);
	}
	
}




































































