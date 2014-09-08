package pair003;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 素因数分解
 * @author h-kimura, k-kunita
 */
public class PrimeDecomposition {

	// 素数を保持するリスト
	private List<Integer> primeList = new ArrayList<Integer>();
	// 入力した数の因数を保持するリスト
//	private List<Integer> factorList = new ArrayList<Integer>();
	// 素因数分解によってkeyが割った数を保持するMap
	private Map<Integer, Integer> primeResultMap = new HashMap<Integer, Integer>();

	/**
	 * 引数までの数字を素数かどうかを判定してリストに入れる
	 *
	 * @param num
	 *            素因数分解対象の数字
	 */
	public void setPrimeNumberForList(int num) {

		// 指定の数字まで素数かどうかの判定を行う
		for (int i = 2; i <= num / 2; i++) {
			// 素数だったらリストに追加して抜ける
			for (int j = 2; j <= i; j++) {
				if (i == j) {
					this.primeList.add(i);
				} else {
					if (i % j == 0) {
						break;
					}

				}
			}

		}
	}

//	/**
//	 * 素数のうち、因数のみを抜き出してリストに追加
//	 */
//	public void setFactorOfSelectNum(int selectNum) {
//
//		for (int i = 0; i < this.primeList.size(); i++) {
//			if (selectNum % this.primeList.get(i) == 0) {
//				this.factorList.add(this.primeList.get(i));
//			}
//
//		}
//	}

	/**
	 *
	 * 素因数分解をした素数と回数をMapに入れる
	 *
	 * @param num
	 *            素因数分解対象の数字
	 */
	public void setCountCalcResultForMap(int num) {
		// 素因数分解を行う
		while (num > 1) {
			for (int primeNum : this.primeList) {
				// 割った回数を保持する
				int count = 0;
				//余りが出るまで割る
				while (num % primeNum == 0) {
					num = num / primeNum;
					count++;
				}

				if (count != 0) {
					this.primeResultMap.put(primeNum, count);
				}
			}
		}
	}

	public List<Integer> getPrimeList() {
		return this.primeList;
	}

	public Map<Integer, Integer> getPrimeResultMap() {
		return this.primeResultMap;
	}
}
