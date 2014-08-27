package pair003;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 素因数分解
 * @author h-kimura, k-kunita
 */
public class Calclate {

	// 素数を保持するリスト
	private List<Integer> primeList = new ArrayList<Integer>();
	// 素因数分解によってkeyが割った数を保持するMap
	private Map<Integer, Integer> primeResultMap = new HashMap<Integer, Integer>();

	/**
	 * 素数かどうかを判定してarrayリストに入れるメソッド
	 *
	 * @param num
	 *            課題の数字
	 */
	public void setPrimeNumber(int num) {

		// numまで素数かどうかのループを行う
		for (int i = 2; i <= num; i++) {
			// 素数だったらリストに追加してforに戻る
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

	/**
	 *
	 * 素因数分解をして結果の値をマップに配置するメソッド
	 *
	 * @param num
	 *            課題の数字
	 */
	public void setPlaceCalcResult(int num) {

		while (true) {

			for (int i = 0; i < this.primeList.size(); i++) {

			}
		}
	}

	public List<Integer> getPrimeList() {
		return primeList;
	}

	public Map<Integer, Integer> getPrimeResultMap() {
		return primeResultMap;
	}

}
