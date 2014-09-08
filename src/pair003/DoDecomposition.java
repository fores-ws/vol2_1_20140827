package pair003;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * 素因数分解
 * @author h-kimura, k-kunita
 */
public class DoDecomposition {
	private static int inputNum = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		// 入力した数字のチェックをする
		DoDecomposition.scanInput();
		PrimeDecomposition cal = new PrimeDecomposition();
		// 入力した数字から素因数を抜き出す
		cal.setPrimeNumberForList(inputNum);
//		cal.setFactorOfSelectNum(inputNum);
		// 素因数分解を行う
		cal.setCountCalcResultForMap(inputNum);
		// 結果を表示
		System.out.println("素因数分解の結果は");
		Map<Integer, Integer> primeResultMap = cal.getPrimeResultMap();
		Iterator<Entry<Integer, Integer>> entries = primeResultMap.entrySet().iterator();
		
		while(entries.hasNext()) {
			Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>)entries.next();
			int key = (int)entry.getKey();
			int val = (int)entry.getValue();
			
			System.out.print(key + "^" + val );
			if(entries.hasNext()) {
				System.out.print(" × ");
			}
			
		}
		System.out.println(" です。");

	}

	// 入力チェック
	private static void scanInput() {

		System.out.println("素因数分解対象の数字を入力してください。");
		Scanner scan = new Scanner(System.in);
		try {
			inputNum = scan.nextInt();
			scan.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("数字を入力してください。");
		}
	}

}
