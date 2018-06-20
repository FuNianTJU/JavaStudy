package enumDemo;

public enum Day {
	MONDAY("星期一"),
	TUESDAY("星期二"),
	WEDNESDAY("星期三"),
	THURSDAY("星期四"),
	FRIDAY("星期五"),
	SATURDAY("星期六"),
	SUNDAY("星期七");//添加自定义方法要用分号结束
	
	private String desc;//枚举描述
	
	/**
	 * 私有构造方法
	 * @param desc
	 */
	private Day(String desc){
		this.desc = desc;
	}
	
	/**
     * 定义方法,返回描述,跟常规类的定义没区别
     * @return
     */
    public String getDesc(){
        return desc;
    }
    
    public static void main(String[] args){
    	for(Day day:Day.values()){
    		System.out.println("name:"+day.name()+
    				",desc:"+day.getDesc());
    	}
    }
	
}
















