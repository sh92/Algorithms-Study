import java.io.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		PriorityQueue queue = new HeapPriorityQueue();
		readData(queue);

		while (true) {
			System.out.println(queue.toString());
			int scanValue = scan.nextInt();
			if(scanValue == 6){
				break;
			}
			int key, x;
			switch (scanValue){
				case 1:
					System.out.print("신규 작업명 ( 20 Bytes 이내 ) : ");
					String job = scan.next();

					while(true){
						System.out.print("우선순위 (0~999) : ");
						key = scan.nextInt();
						if(key <0 || key>999){
							System.out.println("우선순위가 범위가 넘어섰습니다");
						}else{
							break;
						}

					}
					Node node = new Node(key,job);
					queue.insert(node);
					break;
				case 2:
					Node max = queue.max();
					System.out.println("**** MAX :"+max.getKey()+", "+max.getValue()+"****");
					break;
				case 3:
					System.out.println("**** 한개의 작업을 처리했습니다. ****");
					queue.extract_max();
					break;
				case 4:
					System.out.print("수정할 노드 x : ");
					x  = scan.nextInt();
					while(true){
						if(x> queue.size()){
							System.out.println("범위가 넘어섰습니다");
						}else{
							break;
						}
						System.out.print("수정할 노드 x : ");
						x  = scan.nextInt();
					}
					System.out.print("수정할 key : ");
					key =  scan.nextInt();
					while(true){
						if(key <0 || key>999){
							System.out.println("범위가 넘어섰습니다");
						}else{
							break;
						}
						System.out.print("우선순위 (0~999) : ");
						key = scan.nextInt();
					}
					queue.increase_key(x-1,key);
					break;
				case 5:

					while(true) {
						System.out.print("삭제할 노드 x 입력 : ");
						x = scan.nextInt();
						if (x < 0 || x > queue.size()) {
							System.out.println("범위를 넘어섰습니다");
							continue;
						}
						break;
					}
					queue.delete(x-1);
					break;
				default:
					System.out.println("**** 잘못된 입력입니다. ****");
			}


		}
	}

	private static void readData(PriorityQueue queue) {
		try {
			BufferedReader in = new BufferedReader(
					new FileReader("data03.txt"));
			String str;
			while ((str = in.readLine()) != null) {
				String[] ar=str.split(",");
				Node node = new Node(Integer.parseInt(ar[0]),ar[1]);
				queue.add(node);
			}
			in.close();
			queue.buildHeap(0,queue.size());
		} catch (IOException e) {
			System.out.println("File Read Error");
		}
	}
}
