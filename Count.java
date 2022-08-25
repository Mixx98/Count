import java.util.Arrays;
class Count_Over{ // 중복이 있는 카운트
	final int MAX;
	final int COUNT;

	Count_Over(int MAX, int COUNT){ //최대숫자와 자리값 입력
		this.MAX=MAX;
		this.COUNT=COUNT;
	}

	void cal(){
		int[] table = new int[COUNT];
		boolean bl = true;

		while(bl) {
			System.out.println(Arrays.toString(table));
			table[0]++; //1씩 증가
			for(int i=0; i<COUNT; i++) {
				if(table[i]>MAX) {
					try {
						table[i]=0;
						table[i+1]++;
					}
					catch(ArrayIndexOutOfBoundsException e){bl=false;}
				}
			}
		}
	}
}

class Count_NoOver { //중복없는 카운트
	final int MAX;
	final int COUNT;
	boolean bl = true;

	Count_NoOver(int MAX, int COUNT){ //최대숫자와 자리값 입력
		this.MAX=MAX;
		this.COUNT=COUNT;
	}

	int[] set(int[] table) {
		for(int i=0; i<COUNT; i++) { //초기화 4 3 2 1
			table[i]=COUNT-i;
		}
		return table;
	}

	int[] change(int[] table) { //중복이 안되도록 숫자 변경
		for(int i=0; i<COUNT; i++) {
			if(table[i]>MAX) {
				try {
					table[i]=0;
					table[i+1]++;
				}catch(ArrayIndexOutOfBoundsException e){bl=false;}
			}
		}
		for(int j=COUNT-1; j>=0; j--){
			if(table[j]==0){
				try{
					table[j]=table[j+1]+1;
				}catch(ArrayIndexOutOfBoundsException e){}
			}
		}
		return table;
	}

	void cal(){
		int[] table = new int[COUNT];
		table=set(table);

		while(bl){
			System.out.println(Arrays.toString(table));
			table[0]++; //1씩 증가
			table=change(table);
			while(table[0]>MAX){
				table=change(table);
			}
		}
	}
}

public class Count {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("중복있는 카운트");
		Count_Over co = new Count_Over(6,4);
		co.cal();

		System.out.println("\n중복없는 카운트");
		Count_NoOver cn = new Count_NoOver(6,4);
		cn.cal();
	}
}
