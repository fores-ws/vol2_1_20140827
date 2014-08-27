package pair005;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 素因数分解
 * @author s-koide
 */
public class PrimeDecomposition {
	public static void main(String[] args) throws Exception {

		new PrimeDecomposition().execute();

	}

	/**
	 * 素因数分解を実行する。
	 * @throws Exception 例外
	 */
	private void execute() throws Exception {

		System.out.println("素因数分解する数字を入力してください。");
		String numStr = prompt();

		int targetNum = 0;
		List<String> primeList = new ArrayList<String>();

		try {
			targetNum = Integer.parseInt(numStr);
		} catch (Exception e) {
			System.out.println("数値ではありません。");
			return;
		}

		getPrime(targetNum, primeList);

		outputResult(primeList);

	}

	/**
	 * 標準入力から文字列を取得する。
	 * @param targetNum 素因数分解対象の数値
	 * @param result
	 * @return 引数の数値を割り切れる数値を文字列として返却
	 * @throws Exception 例外
	 */
	private void getPrime(int targetNum, List<String> primeList) throws Exception {

		for (int i = 2; i <= targetNum; i++) {
			if (targetNum % i == 0) {
				primeList.add(String.valueOf(i));
				getPrime((targetNum / i), primeList);
				break;
			}
		}
	}

	/**
	 * 素数リストを標準出力する。
	 * @param primeList 素数リスト
	 * @throws Exception 例外
	 */
	private void outputResult(List<String> primeList) throws Exception {

		String temp = "";

		// 累乗数値
		int powerNum = 1;

		// 出力用文字列
		StringBuilder sb = new StringBuilder();

		for (String string : primeList) {
			// 同じ数が続いた場合は累乗表示
			if (temp.equals(string)) {
				powerNum++;
			} else {
				if (temp.equals("")) {
					sb.append(String.format("%s^", string));
				} else {
					sb.append(String.format("%s × %s^", powerNum, string));
				}
				temp = string;
				powerNum = 1;
			}
		}
		sb.append(powerNum);
		System.out.println(sb.toString());
	}

	/**
	 * 標準入力から文字列を取得する。
	 * @return 文字列
	 * @throws Exception 例外
	 */
	private String prompt() throws Exception {

		return new BufferedReader(new InputStreamReader(System.in)).readLine();

	}


}
