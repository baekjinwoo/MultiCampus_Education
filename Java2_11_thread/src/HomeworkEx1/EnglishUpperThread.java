package HomeworkEx1;


public class EnglishUpperThread extends Thread{

	 char[] arr={'A','B','C','D','E','F','G','H','I','J','K','L','M','N',
	          'O','P','Q','R','S','T','U','V','W','X','Y','Z'};

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
	
