package pair001;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 素因数分解
 * @author r-yamanaka, s-nagatomo
 */
public class Prifac {

	private final static int TWO = 2;
	private final static int THREE = 3;
	private final static int FIVE = 5;

	public static void main(String[] args) {
		/**
		 * <pre>
		 * 1.インプットパラメータが素数かどうか判定する
		 * 2.素数の場合はそのまま返す
		 * 3.素数でない場合は素因数分解を行う
		 * </pre>
		 */
		int x;
		System.out.print("input integer: ");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		try {
			String buf = br.readLine();
			x = Integer.parseInt(buf);
		} catch (Exception e) {
			x = 0;
		}
		boolean isTwoFlag = true;
		boolean isThreeFlag = true;
		boolean isFiveFlag = true;

		int ans = x;
		int countTwo = 0;
		int countThree = 0;
		int countFive = 0;

		// 実際の処理
		while (isTwoFlag) {
			if (ans % TWO != 0) {
				isTwoFlag = false;
			} else {
				countTwo++;
				ans = ans / TWO;
			}
		}
		while (isThreeFlag) {
			if (ans % THREE != 0) {
				isThreeFlag = false;
			} else {
				countThree++;
				ans = ans / THREE;
			}
		}
		while (isFiveFlag) {
			if (ans % FIVE != 0) {
				isFiveFlag = false;
			} else {
				countFive++;
				ans = ans / FIVE;
			}
		}

		System.out.println("output integer: " + TWO + "^" + countTwo + "x"
				+ THREE + "^" + countThree + "x" + FIVE + "^" + countFive + "x"
				+ ans + "^1");
	}
}
