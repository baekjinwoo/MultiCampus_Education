package homework01;

import java.util.Scanner;

/*[����10] ���� ���α׷��� �ۼ��Ͻÿ�

(1)Ŭ������ : Sales
   �ʵ�   #article:String   
            #qty :int
            #cost :int
            #cnt :int (static)
            #discount :double(static)
   �޼ҵ� : Sales()             //ǰ��, ����, �ܰ��Է¹޴´�
                        
(2)Ŭ������ : Test10  (Sales�� ��ӹޱ�)
  -amount:int
  +setProcess():void                              //amount = qty * cost
  +getDisplay():void                              //���
  +setDiscount(d:double):void (static)      //���η��� ����

(3)main()�޼��� ����
    public static void main(String[] args){
           Test10  []op = new Test10[2]; 
           //�������� �ϼ��Ͻÿ�
    }

[��/��� ȭ��]
ǰ���� �Է��Ͻÿ�   : �ＺTV
������ �Է��Ͻÿ�   : 1
�ܰ��� �Է��Ͻÿ�   : 1200000

ǰ���� �Է��Ͻÿ�   : ��������
������ �Է��Ͻÿ�   : 2
�ܰ��� �Է��Ͻÿ�   : 1500000

�������� �Է��Ͻÿ� :  0.15        <--- main()���� �Է� �����ÿ�

[[�ǸŰ�]] 
�ＺTV       1020000��
��������   2550000��

�ǸŰǼ� : 3��*/

class Sales{
	protected String article;
	protected int qty;
	protected int cost;
	protected static int cnt;
	protected static double discount;
	Scanner sc = new Scanner(System.in);

	
	Sales(){
		System.out.println("ǰ��: ");
		article = sc.nextLine();
		System.out.println("����: ");
		qty = sc.nextInt();
		System.out.println("�ܰ�: ");
		cost = sc.nextInt();
		cnt += qty; //cnt?

	}
}

public class munjae10 extends Sales{
	private int amount;
		
	public void setProcess(){
		amount = (int) ((super.qty * super.cost )*(1-discount)); //���⼭ (1-discount)
	}
	public void getDisplay(){
		System.out.println(super.article+" "+cost);
	}
	public static void setDiscount(double d){
		Sales.discount= d;
	}

	
	
	
	public static void main(String[] args) {
				Scanner sc2 = new Scanner(System.in);
				munjae10 [] op = new munjae10[2];
				for (int i = 0; i < op.length; i++) {
					op[i] = new munjae10();
					System.out.println();
				}
				
				
				System.out.print("�������� �Է��Ͻÿ�: ");
				munjae10.setDiscount(Double.parseDouble(sc2.nextLine()));
				
				for (munjae10 t : op) {
					t.setProcess();
					t.getDisplay();
				}
				System.out.println("�Ǹ� �Ǽ�: "+ Sales.cnt);
				sc2.close();

	}
}