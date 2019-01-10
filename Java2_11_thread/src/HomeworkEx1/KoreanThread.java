package HomeworkEx1;


public class KoreanThread extends Thread{ //synchronized사용 x
	char[] arr={'ㄱ','ㄴ','ㄷ','ㄹ','ㅁ','ㅂ','ㅅ','ㅇ','ㅈ','ㅊ','ㅋ','ㅌ','ㅍ','ㅎ'};
	
	@Override
	public void run(){
		try{
		for(int i=0;i<arr.length;i++){
			Thread.sleep(300);
			System.out.print(arr[i]+"  ");
			}
		}catch(Exception e){ e.printStackTrace(); }
	System.out.println();
	}
}
